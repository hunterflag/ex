/*
 * 注意: 
 * try-catch-fianlly{} 有3個執行區塊, 
 * 若有 return, 之後的 code 不會執行, 都是 unreachable code
 * 
 * 曾經混淆的觀點:
 * 原以為 finally{} 只是 try-catch 的終點塊, {} 後面的 code 會繼續做 
 * 殊不知, 也是 method() 的終點塊!
 * 
 * 1.標準控制流
 * start --> try --> catch --> finally --> end
 * 2.有無 return 會改變控制流
 * 無finally、正常		--> try ------------------------> end
 * 無finally、例外		--> try --> catch
 * 有finally、正常		--> try ------------> finally
 * 有finally、例外		--> try --> catch --> finally
 * 
 */

 
package tw.idv.hunterchen.lab.exception.trycatch;

import java.awt.geom.IllegalPathStateException;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EX_TryCatchFianlly {

	public static void main(String[] args) {
		log.trace("==== start....");
		log.debug("==== start....");
		log.warn("==== start....");
		log.error("==== start....");
		log.info("==== start....");
		log.info("==== tryCatchStandardNormal(): "); tryCatchStandardNormal();
		log.info("==== tryCatchStandardException(): "); tryCatchStandardException();
		log.info("==== tryCatchNormal(): " + tryCatchNormal());
		log.info("==== tryCatchException(): " + tryCatchException());
		log.info("==== tryCatchFinallyNormal(): " + tryCatchFinallyNormal());
		log.info("==== tryCatchFinallyException(): " + tryCatchFinallyException());
		log.info("==== end....");
	}
	
 	private static void tryCatchStandardNormal() {
		log.info("1.start{}"); 
		try {
			log.info("2.try{}");
		}
		catch(Exception e) {
			log.error("3.catch{}");
			e.printStackTrace();
			log.info("3.此處也是會執行");
		}
		finally {
			log.info("4.finally{}");
		}
		 log.info("5.end{}....");
	}

 	private static void tryCatchStandardException(){
		log.info("1.start{}");
		try {
			throw new RuntimeException();	// 要放 Exception, 就要處理_
//			log.info("2.try{}");
//			throw new Exception();
//			log.info("發生 Exception 之後的 code 不會執行");
		}
		catch(ArithmeticException e) {
			log.info("3.catch{}");
			e.printStackTrace();
			log.info("3.此處也是會執行");
		}
		finally {
			log.info("4.finally{}");
			
		}
		log.info("5.end{}....");
	}

	private static String tryCatchNormal() {
		log.info("正常結束 start....");
		try {
			log.info("try{}");
//			return "from try{}";	//加了此行 end 就沒機會執行了
		}
		catch(Exception e) {
			log.info("catch{}");
			e.printStackTrace();
			return "from catch{}";	
//			, 但沒有用, 因為真正的 return 是 finally{}
		}
		log.info("end....");
		return "from method()";
	}
	
	private static String tryCatchException() {
		log.info("發生例外 start....");
		try {
			log.info("try{}");
			throw new IOException();
		}
		catch(Exception e) {
			log.info("catch{}");
			e.printStackTrace();
			return "from catch";	//此處會執行
		}
		//以本例來說, 此處不會執行了
//		 log.info("end....");
//		 return "from method()";
	}

	@SuppressWarnings("finally")
	private static String tryCatchFinallyNormal() {
		log.info("發生例外、且有終結 start....");
		try {
			log.info("try{}");
		}
		catch(Exception e) {
			log.info("catch{}");
			e.printStackTrace();
			return "from catch";	
		}
		finally {		 
			log.info("finally{}");
			return "from finally{}";
		}
		//注意: fianlly{} 就是最後了, 之後的 code 不會執行, 都是 unreachable code
		// 原以為 finally{} 只是 try-catch 的終點塊, 
		// 殊不知, 也是 method() 的終點塊!
		// log.info("end....");
		// return "from method()";
	}
	
	@SuppressWarnings("finally")
	private static String tryCatchFinallyException() {
		log.info("發生例外、且有終結 start....");
		try {
			log.info("try{}");
//			return "from try{} befor exception";
			throw new IOException();
//			return "from try{} after exception";
		}
		catch(Exception e) {
			log.info("catch{}");
			e.printStackTrace();
			return "from catch";	//此處雖然會執行, 但沒有用, 因為真正的 return 是 finally{}
		}
		finally {		 
			log.info("finally{}");
			return "from finally{}";
		}
		//注意: fianlly{} 就是最後了, 之後的 code 不會執行, 都是 unreachable code
		// 原以為 finally{} 只是 try-catch 的終點塊, 
		// 殊不知, 也是 method() 的終點塊!
		// log.info("end....");
		// return "from method()";
	}
}
