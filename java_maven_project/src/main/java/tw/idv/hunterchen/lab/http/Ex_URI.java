package tw.idv.hunterchen.lab.http;

import java.net.URI;
import java.net.URISyntaxException;

import tw.idv.hunterchen.utility.ShowTool;

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
		ShowTool.showMessages("0.原始字串\t\t", "toString()\t\t\t", uri.toString());
		ShowTool.showMessages("0.1.協定\t\t", "getSchema()\t\t\t", uri.getScheme());
		ShowTool.showMessages("0.2.//字串\t\t", "getSchemeSpecificPart()\t", uri.getSchemeSpecificPart());
		ShowTool.showMessages("0.2.//字串\t\t", "getRawSchemeSpecificPart()\t", uri.getRawSchemeSpecificPart());
		ShowTool.showMessages("0.2.1.授權\t\t", "getAuthority()\t\t", uri.getAuthority());
		ShowTool.showMessages("0.2.1.授權\t\t", "getRawAuthority()\t\t", uri.getRawAuthority());
		ShowTool.showMessages("0.2.1.1.登入帳密\t", "getUserInfo()\t\t\t", uri.getUserInfo());
		ShowTool.showMessages("0.2.1.1.登入帳密\t", "getRawUserInfo()\t\t", uri.getRawUserInfo());
		ShowTool.showMessages("0.2.1.2.@主機\t", "getHost()\t\t\t", ""+uri.getHost());
		ShowTool.showMessages("0.2.1.3.:埠號\t", "getPort()\t\t\t", ""+uri.getPort());
		ShowTool.showMessages("0.2.2.絕對請求路徑\t", "getPath()\t\t\t", uri.getPath());
		ShowTool.showMessages("0.2.2.絕對請求路徑\t", "getRawPath()\t\t\t", uri.getRawPath());
		ShowTool.showMessages("0.2.3.?查詢字串\t", "getQuery()\t\t\t", uri.getQuery());
		ShowTool.showMessages("0.2.3.?查詢字串\t", "getRawQuery()\t\t\t", uri.getRawQuery());
		ShowTool.showMessages("0.3.#片段\t\t", "getFragment()\t\t\t", uri.getFragment());
		ShowTool.showMessages("0.3.#片段\t\t", "getRawFragment()\t\t", uri.getRawFragment());
		ShowTool.showMessages("1.3.#片段\t\t", "toString()\t\t", uri.toString());
		ShowTool.showMessages("1.3.#片段\t\t", "toASCIIString()\t\t", uri.toASCIIString());
		
//		ShowTool.showAllMethods(uri);
		
	}

}
