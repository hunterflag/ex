package tw.idv.hunterchen.lab.json;

import com.alibaba.fastjson.JSONObject;

import tw.idv.hunterchen.utility.ShowTool;

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
		ShowTool.showMessages("jsonString", jsonString);
		ShowTool.showMessages("jsonObj.toString()", jsonObj.toString());
		ShowTool.showMessages("jsonObj.toJSONString()", jsonObj.toJSONString());
		ShowTool.showMessages("jsonObj.getString(\"name\")", jsonObj.getString("name"));
		ShowTool.showMessages("jsonObj.getString(\"age\")", jsonObj.getString("age"));
		ShowTool.showMessages("jsonObj.getString(\"age\")", ""+jsonObj.getInteger("age"));
		ShowTool.showMessages("jsonObj.toJSONString(\"not exist key\")", jsonObj.getString("address.district"));
		ShowTool.showMessages("jsonObj.toJSONString()", jsonObj.getString("address.district"));
	}
}
