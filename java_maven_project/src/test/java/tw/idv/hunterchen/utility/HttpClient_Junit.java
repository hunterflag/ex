package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HttpClient_Junit {
	Logger logger = Logger.getLogger("dd");
	@Test
	public void isSSL_test() {
		HttpClient httpClient = new HttpClient();
		assertTrue(httpClient.isSSL("https://localhost"));
		assertFalse(httpClient.isSSL("http://localhost"));
		assertTrue(httpClient.isSSL("ftps://localhost"));
		assertFalse(httpClient.isSSL("ftp://localhost"));
		assertFalse(httpClient.isSSL("file://localhost"));
		
	}
	
	@AfterClass
	public static void afterEveryClass() {
		System.out.println("====after.Class====");
	}
	
	@BeforeClass
	public static void beforeEveryClass() {
		System.out.println("====start.Class====");
	}
	
	@Before
	public void beforeEveryTest() {
		System.out.println("====start.test====");
	}
	
	@After
	public void afterEveryTest() {
		System.out.println("====after.test====");
	}
	
}
