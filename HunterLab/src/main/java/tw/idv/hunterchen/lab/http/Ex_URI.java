package tw.idv.hunterchen.lab.http;

import java.net.URI;
import java.net.URISyntaxException;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_URI {

	public static void main(String[] args) throws URISyntaxException {
		String uriStr = "";
		uriStr = "https://hunter:pass@www.google.com:80/login?id=123&name=fff#newFragment";
		uriStr = "urn:isbn:096139210x";
		uriStr = "mailto://flaghuntertester@gmail.com";
		uriStr = "https://docs.oracle.com:1234/javase/1.3/docs/guide/collections/designfaq.html?id=123&name=fff#28";
		uriStr = "https://hun%20ter:pass%20word@docs.oracle.com:1234/javase/1.3/docs/%20guide/collections/中文/designfaq.html?id=%20123&name=fff#2%208";
		
		URI uri = new URI(uriStr);
//		ShowTool.showAllFields(uri);
		DevTool.showMessages("0.原始字串\t\t", "toString()\t\t\t", uri.toString());
		DevTool.showMessages("0.1.協定\t\t", "getSchema()\t\t\t", uri.getScheme());
		DevTool.showMessages("0.2.//字串\t\t", "getSchemeSpecificPart()\t", uri.getSchemeSpecificPart());
		DevTool.showMessages("0.2.//字串\t\t", "getRawSchemeSpecificPart()\t", uri.getRawSchemeSpecificPart());
		DevTool.showMessages("0.2.1.授權\t\t", "getAuthority()\t\t", uri.getAuthority());
		DevTool.showMessages("0.2.1.授權\t\t", "getRawAuthority()\t\t", uri.getRawAuthority());
		DevTool.showMessages("0.2.1.1.登入帳密\t", "getUserInfo()\t\t\t", uri.getUserInfo());
		DevTool.showMessages("0.2.1.1.登入帳密\t", "getRawUserInfo()\t\t", uri.getRawUserInfo());
		DevTool.showMessages("0.2.1.2.@主機\t", "getHost()\t\t\t", ""+uri.getHost());
		DevTool.showMessages("0.2.1.3.:埠號\t", "getPort()\t\t\t", ""+uri.getPort());
		DevTool.showMessages("0.2.2.絕對請求路徑\t", "getPath()\t\t\t", uri.getPath());
		DevTool.showMessages("0.2.2.絕對請求路徑\t", "getRawPath()\t\t\t", uri.getRawPath());
		DevTool.showMessages("0.2.3.?查詢字串\t", "getQuery()\t\t\t", uri.getQuery());
		DevTool.showMessages("0.2.3.?查詢字串\t", "getRawQuery()\t\t\t", uri.getRawQuery());
		DevTool.showMessages("0.3.#片段\t\t", "getFragment()\t\t\t", uri.getFragment());
		DevTool.showMessages("0.3.#片段\t\t", "getRawFragment()\t\t", uri.getRawFragment());
		DevTool.showMessages("1.3.#片段\t\t", "toString()\t\t", uri.toString());
		DevTool.showMessages("1.3.#片段\t\t", "toASCIIString()\t\t", uri.toASCIIString());
		
//		ShowTool.showAllMethods(uri);
		
	}

}
