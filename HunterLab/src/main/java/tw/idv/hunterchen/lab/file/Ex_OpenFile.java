package tw.idv.hunterchen.lab.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_OpenFile {

	public static void main(String[] args) throws IOException {
		String fileName="d:\\temp\\files\\sample.json";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		String jsonStr="";
		String input="";
		if(bufferedReader.ready()) {
			while((input = bufferedReader.readLine()) != null) {
				jsonStr += input.trim();
			}
			DevTool.showMessages(jsonStr);
		}
			
	}

}
