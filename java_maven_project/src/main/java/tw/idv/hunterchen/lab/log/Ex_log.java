package tw.idv.hunterchen.lab.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex_log {

	/*
	 * 要使用的 logger 名稱
	 * 1.一定要指定
	 * 2.指定的logger名稱存在嗎?
	 * 2.a.不存在時, 會自動建立1個
	 * 2.b.存在時, 直接使用 (ie.同名logger只會存在1個)
	 * 
	 * 1.慣用以該類別名名稱當作 loggerName
	 *  
	 *	 
	 */
	//XXX 1.LoggerName有前後代的順序關係?
	//XXX 2.
	private boolean default_log() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.warning("沒有提供執行時的自變數！");
		return true;
	}
	
	public boolean level_log() {
		Logger logger = Logger.getLogger("LoggingDemo");
		//顯示所有等級的資訊
		logger.setLevel(Level.ALL);
		ConsoleHandler consoleHandler = new ConsoleHandler();
	  	//顯示所有等級的資訊
		consoleHandler.setLevel(Level.ALL);
		//設定Handler為!ConsoleHandler
		logger.addHandler(consoleHandler); 
		
		logger.severe("嚴重資訊");
		logger.warning("警示資訊");
		logger.info("一般資訊");
		logger.config("設定方面的資訊");
		logger.fine("細微的資訊");
		logger.finer("更細微的資訊");
		logger.finest("最細微的資訊");
		
		return true;
 	}
		
	public static void main(String[] args) {
		Ex_log log = new Ex_log();
		log.default_log();
		log.level_log();
	}

}
