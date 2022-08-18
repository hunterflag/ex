package tw.idv.hunterchen.lab.time;

import java.sql.Timestamp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ex_Timestamp {
	public static void main(String[] args) throws InterruptedException  {
		long cts1, cts2;
		cts1 = System.currentTimeMillis();
		log.info("currentTimeMillis : {} ", cts1);
		Thread.sleep(1000);
		cts2 = System.currentTimeMillis();
		long delta = cts2 - cts1; 
		log.info("currentTimeMillis : {} ", cts2);
		log.info("delta = {} ", delta);
		
		Timestamp timestamp = new Timestamp(cts2);
		log.info("timestamp : {} ", timestamp.toString()); // 2022-07-25 14:30:04.448
		log.info("timestamp : {} ", timestamp.getDate()); // 2022-07-25 14:30:04.448
		
		
	}
}
