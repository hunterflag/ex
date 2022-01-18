package tw.idv.hunterchen.lab.json;

import org.json.JSONObject;

public class Ex_Json {
	static String jsonString = "{"
			+ "name" + ":" + "Hunter" 
			+ "," + "age" + ":" + "18" 
			+ "}";
	public static void main(String args[]) {
		//1.建立
		//1.a.法
		JSONObject jsonObject = new JSONObject(jsonString);
		System.out.println(jsonObject);
		
		//以key取value
		System.out.println(jsonObject.get("name"));
		
	}

}
