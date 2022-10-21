package tw.idv.hunterchen.utility;

import java.net.URI;

public class HttpClient {
	public boolean isSSL(String url) {
		boolean result=false;
		if (url!=null) {
			int pos = url.indexOf("://");
			String protocol = url.substring(0, pos);
			
			switch (protocol) {
				case "http":
					result=false; break;
				case "https":
					result=true; break;
				case "ftp":
					result=false; break;
				case "ftps":
					result=true; break;
				default:
					result=false; break;
			}
		}
		return result;		
	}
	public boolean isSSL(URI uri) {
		boolean result=true;
		
		return result;
	}

}
