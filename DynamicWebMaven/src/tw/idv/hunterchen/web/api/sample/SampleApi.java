package tw.idv.hunterchen.web.api.sample;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.hunterchen.utility.DebugTool;

@Controller
@ResponseBody
@RequestMapping("/api/sample")
public class SampleApi {
	
	@RequestMapping("/string")
	public String verify() {
		String result="/api/sample/string";
		DebugTool.showMessage(result);
		result="login check pass!";
		
		return result;
	}
	
	@RequestMapping("/json")
	public User query(@Param("id") Integer id) {
		id = (id!=null ? id : -1);
		User result = new User("tester", "1234");
		DebugTool.showMessage(id.toString());
		DebugTool.showMessage(result.toString());
		return result;
	}
	
	class User{
		private String account;
		private String password;
		
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public User(String account, String password) {
			super();
			this.account = account;
			this.password = password;
		}
		@Override
		public String toString() {
			return "User [account=" + account + ", password=" + password + "]";
		}	
	}
}
