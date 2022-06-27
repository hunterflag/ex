package tw.idv.hunterchen.lab.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EX_net {
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
		EX_net ex_net = new EX_net();
		log.info("本機 ip 為: {}", ex_net.getip());
	}

}
