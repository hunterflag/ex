package tw.idv.hunterchen.lab.variable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ex_Scope {
	static String name = "className";
	
	public static void main(String[] args) {
		log.info("剛開始 name={}", name);
		String name = "localName";
		log.info("local優先 name={}", name);
		if(true){
//			String name = "innerName";
			log.info("name={}", name);
			name = "innerName";
			log.info("雖在內層name={}", name);
		}
		log.info("name={}", name);
	}
}
