package tw.idv.hunterchen.lab.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EX_InetAddress {
	public String getip() {
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.error("ip取得異常");
			e.printStackTrace();
		}
		
		return ip;
	}

	public static void main(String[] args) {
		EX_InetAddress ex = new EX_InetAddress();
		log.info("本機 ip 為: {}", ex.getip());
		try {
			InetAddress[] addresses = InetAddress.getAllByName("localhost");
			for (InetAddress inetAddress : addresses ) {
				log.info("本機 ip 為: {}, {}, {}"
						, inetAddress.getHostAddress()
						, inetAddress.getHostName()
						, inetAddress.getCanonicalHostName()
						);
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		log.info("本機 ip 為: {}", InetAddress.getLoopbackAddress().getHostAddress());
	}

}
