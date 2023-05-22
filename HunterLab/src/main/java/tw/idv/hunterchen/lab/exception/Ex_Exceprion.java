package tw.idv.hunterchen.lab.exception;
import java.lang.*;

public class Ex_Exceprion {
	// 拋出例外 給外層
	public boolean test00() throws Exception{
		throw new Exception();
	}
	public boolean test12(){
		try {
			throw new Exception();
		}catch(Exception ex) {
			return false;
		}
		// 刪掉就可以, 但
	}
	public boolean test10(){
		boolean result = false;
		try {
			throw new Exception();
		}catch(Exception ex) {
			result =  false;
		}
		result =  true;
		return result;
	}
	/*
	 * unreachable code: 走不到的程式碼 (Error)
	 * dead code: 出不去的程式碼 (Warn)
	 * 
	 */
	
	public boolean unReachableCode(){
		boolean cond=true;
		while(cond) {
			return true;	
		}
		return true;		// 執行時才會發現 unreachable; 編輯時有可能
	}

	public boolean unReachableCode10(){
//		while(true) {
//			return true;	
//		}
		return true;		// 不會走到此
	}

	public boolean unReachableCode11(){
//		while(false) {
//			return true;	// 不會走到此
////		}
		return true;
	}

	public boolean unReachableCode2(){
//		return true;
		return false;	// 第 2 個 return 一定走不到
	}
	// 拋出例外 給外層;用try-catch 自行處理
	// test1x() 都是相同結果, 但 test11() 在語法上不被接受!
	public boolean unReachableCode3(){
		try {
//			throw new Exception();
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	/*
	*/
	
	public static boolean deadCode(){
		if(false) {
			return true;
		}
//		if(true) {
//			return true;
//		}
		return true;	// 不是 unreachable
	}
	
	public static void main(String[] args) {
		deadCode();
	}

}
