package tw.idv.hunterchen.lab.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;

import tw.idv.hunterchen.utility.ShowTool;

public class Ex_Http {
	final static String defaultHttpUrl = "http://tw.yahoo.com";

	public static String httpGet(String httpUrl) {
		httpUrl = (httpUrl==null) ? defaultHttpUrl :httpUrl;
		
		URL url = null;
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = null;
		String responseContext=null;
		
		try {
			//準備連線相關資訊、與參數
			url = new URL(httpUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			//發出請求(建立連線)
			connection.connect();
			//取得回應訊息
			String responseMessage = connection.getResponseMessage();
 			int responseCode = connection.getResponseCode();
			switch (responseCode) {
				case 200:
					inputStream = connection.getInputStream();
					bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
					stringBuffer = new StringBuffer();
					String temp = null;
					while((temp= bufferedReader.readLine()) != null) {
						stringBuffer.append(temp);
						stringBuffer.append("\r\n");
					}
					responseContext = stringBuffer.toString();
					break;
				default:
					ShowTool.showMessages("尚未安排處理", ""+responseCode, responseMessage);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			connection.disconnect();
		}
		return responseContext;
	}
	public static void main(String[] args) {
		ShowTool.showMessages(httpGet("http://www.google.com"));
	}

}
