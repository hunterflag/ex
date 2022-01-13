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
		logger.setLevel(Level.ALL);		//顯示所有等級的資訊
//		logger.setLevel(Level.INFO);
	  	
		//顯示所有等級的資訊
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL);
//		consoleHandler.setLevel(Level.WARNING);
		//設定Handler為!ConsoleHandler
		logger.addHandler(consoleHandler); 
		
		logger.severe("server級.嚴重資訊");
		logger.warning("warning級.警示資訊");
		logger.info("info級.一般資訊");
		logger.config("config級.設定方面的資訊");
		logger.fine("fine級.細微的資訊");
		logger.finer("finer級.更細微的資訊");
		logger.finest("finest級.最細微的資訊");
		
		return true;
 	}
	
	public void bubbleUp() {
		Logger logP = Logger.getLogger("t.p");
		Logger logC = Logger.getLogger("t.p.c");
		
		logC.info("C bubbleUp To P");
		logP.info("C bubbleUp To P");
		//TODO 上傳是甚麼意思?
	}
		
	public static void main(String[] args) {
		Ex_log log = new Ex_log();
//		log.default_log();
//		log.level_log();
		
		log.bubbleUp();
	}

}
