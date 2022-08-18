package tw.idv.hunterchen.lab.log.child;

import java.util.logging.Logger;

import tw.idv.hunterchen.lab.log.Ex_log;

public class Ex_childLog extends Ex_log{

	public static void main(String[] args) {
//		Logger logger = Logger.getLogger(Ex_log.class.getName());
		Logger logger = Logger.getLogger("ddd");
		try{
			System.out.println(args[0]);
		}catch(ArrayIndexOutOfBoundsException e){
			logger.warning("沒有提供執行時的自變數！");
		}        
		
	}

}
