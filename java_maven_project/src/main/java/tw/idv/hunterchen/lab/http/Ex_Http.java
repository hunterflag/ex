package tw.idv.hunterchen.lab.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex_Http {
	public static void method() {
		try {
			URL url = new URL("http://tw.yahoo.com");
			HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
			openConnection.setRequestMethod("POST");
			InputStream inputStream = openConnection.getInputStream();
			openConnection.disconnect();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		method();
	}

}
