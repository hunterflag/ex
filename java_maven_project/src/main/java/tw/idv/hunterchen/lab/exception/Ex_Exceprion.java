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
	public boolean unReachableCode1(){
		while(true) {
			return true;
		}
		return true;
	}
	public boolean unReachableCode2(){
		return true;
		return false;
	}
	// 拋出例外 給外層;用try-catch 自行處理
	// test1x() 都是相同結果, 但 test11() 在語法上不被接受!
	public boolean unReachableCode3(){
		try {
			throw new Exception();
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	*/
	
	public boolean deadCode(){
		if(true) {
			return true;
		}
		return true;
	}
	
	public static void main(String[] args) {

	}

}
