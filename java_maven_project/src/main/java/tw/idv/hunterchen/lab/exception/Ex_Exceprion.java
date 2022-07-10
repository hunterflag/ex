package tw.idv.hunterchen.lab.exception;
import java.lang.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ex_Exceprion {
	// 拋出例外 給外層
	public boolean throwException(Exception ex) throws Exception{
		ex = (ex==null) ? new Exception("defaultMessage kkk") : ex;
		log.info("before Exception");
		throw ex ;

		//		log.info("after Exception");	
		/*
		 * a. unreachable
		 * b. 也不必寫 return
		 */
		
	}

	public boolean catchException(Exception ex){
		boolean result = false;
		ex = (ex==null) ? new Exception("defaultMessage") : ex;
		try {
			throw ex;
		}catch(Exception e) {
//			Throwable cause = e.getCause();
//			log.info("cause.message = {}", cause.getMessage());
			
			log.info("message = {}",e.getMessage());
			log.info("Localizedmessage = {}",e.getLocalizedMessage());
			
			result = true;
		}
		log.info("catche result: {}", result);
		// 刪掉就可以, 但
		return result;
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
	 * unreachable code: 走不到的程式碼
	 * dead code: 出不去的程式碼 
	 */
	
	public boolean unReachableCode10(){
//		while(truefalse) {
//			return true;
//		}
		return true;
	}
	
	
	public boolean unReachableCode11(){
//		while(false) {
//			return true;
//		}
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
	/*
	*/
	
	public boolean deadCode(){
		if(true) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		Ex_Exceprion ex = new Ex_Exceprion();
		
		log.info("before Exception");
		ex.catchException(null);
		log.info("after Exception");

		log.info("before Exception");
//		ex.throwException(null);
		log.info("after Exception");
	}

}
