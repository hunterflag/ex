package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenString_Junit {
	@Test
	public void divider_test() {
		//指定長度
		assertEquals("<======>", GenString.divider());
		assertEquals("<>", GenString.divider(-1));
		assertEquals("<>", GenString.divider(0));
		assertEquals("<====>", GenString.divider(6));
		assertEquals("<======>", GenString.divider(8));
		assertEquals("<==========>", GenString.divider(12));
		//指定分隔字串
		assertEquals("hbbbbbbt", GenString.divider("h", "b", "t"));
		assertEquals("habcdabt", GenString.divider("h", "abcd", "t"));
		assertEquals("hhabcdtt", GenString.divider("hh", "abcd", "tt"));
		
		assertEquals("<>", GenString.divider("<", "12345", ">", -1));
		assertEquals("<>", GenString.divider("<", "12345", ">", 0));
		assertEquals("<>", GenString.divider("<", "12345", ">", 1));
		assertEquals("<>", GenString.divider("<", "12345", ">", 2));
		assertEquals("<1>", GenString.divider("<", "12345", ">", 3));
		assertEquals("ab12cd", GenString.divider("ab", "12345", "cd", 6));
		assertEquals("<1234>", GenString.divider("<", "12345", ">", 6));
		assertEquals("<12345>", GenString.divider("<", "12345", ">", 7));
		assertEquals("<=====>", GenString.divider("<", "=", ">", 7));
		assertEquals("<12312>", GenString.divider("<", "123", ">", 7));
		assertEquals("<12121>", GenString.divider("<", "12", ">", 7));
		assertEquals("<======>", GenString.divider("<", "=", ">", 8));
		assertEquals("?======>", GenString.divider("?", "=", ">", 8));
		assertEquals("?======x", GenString.divider("?", "=", "x", 8));
		assertEquals("?++++++x", GenString.divider("?", "+", "x", 8));
		assertEquals("aa++++bb", GenString.divider("aa", "+", "bb", 8));
		assertEquals("aa1212bb", GenString.divider("aa", "12", "bb", 8));
		assertEquals("aa1231bb", GenString.divider("aa", "123", "bb", 8));
		assertEquals("aa12312312312bb", GenString.divider("aa", "123", "bb", 15));
		assertEquals("aa12121212121bb", GenString.divider("aa", "12", "bb", 15));
	}
}
