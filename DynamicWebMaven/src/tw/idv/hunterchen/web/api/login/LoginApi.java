package tw.idv.hunterchen.web.api.login;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.hunterchen.utility.DebugTool;

@Controller
@ResponseBody
@RequestMapping("/api/login")
public class LoginApi {
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
	
	@RequestMapping("/verify")
	public String verify() {
		String result="/api/login/verify";
		DebugTool.showMessage(result);
		result="login check pass!";
		
		return result;
	}
	
	@RequestMapping("/query")
	public User query(@Param("id") Integer id) {
		
		User result = new User("tester", "1234");
		DebugTool.showMessage(result.toString());
		return result;
	}
	
}
