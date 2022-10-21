package tw.idv.hunterchen.lab.json;

import com.alibaba.fastjson.JSONObject;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_Fastjson {
	public static void main(String args[]) {
		Ex_Fastjson exObj= new Ex_Fastjson();
		
		String jsonString = 
				"{"
					+ "'name':'Hunter',"
					+ "'age':16,"
					+ "'address':{"
						+ "'city':'Taipei',"
						+ "'district':'DaAn'}"
					+ "}";
		
		//建立 JSON
		JSONObject jsonObj = JSONObject.parseObject(jsonString);
		DevTool.showMessages("jsonString", jsonString);
		DevTool.showMessages("jsonObj.toString()", jsonObj.toString());
		DevTool.showMessages("jsonObj.toJSONString()", jsonObj.toJSONString());
		DevTool.showMessages("jsonObj.getString(\"name\")", jsonObj.getString("name"));
		DevTool.showMessages("jsonObj.getString(\"age\")", jsonObj.getString("age"));
		DevTool.showMessages("jsonObj.getString(\"age\")", ""+jsonObj.getInteger("age"));
		DevTool.showMessages("jsonObj.toJSONString(\"not exist key\")", jsonObj.getString("address.district"));
		DevTool.showMessages("jsonObj.toJSONString()", jsonObj.getString("address.district"));
	}
}
