package tw.idv.hunterchen.sample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoMath {
	int intNum = 100/40;
	public static void main(String[] args) {
		log.info("{}", Math.ceil(100/40));			// int 相除 100/20 = 2, 再轉 double
		log.info("{}", Math.ceil(100.0/40));		// float 相除, 100.0/20 = 100.0/40.0 = 2.5 
		log.info("{}", Math.ceil(100/40.0));
		log.info("{}", Math.ceil(100.0/40.0));
		log.info("{}", Math.ceil((double)100/40));	// 100轉double
		log.info("{}", (int) Math.ceil(100/40));
		
//		log.info(""+100-40);
		log.info(100-40+"");
		log.info(""+100/40);
		log.info(100/40+"");
		
		log.info(100/40+"");
//		log.info(100.0/40 + "");
		log.info((double)100/40 + "");

	}

}
