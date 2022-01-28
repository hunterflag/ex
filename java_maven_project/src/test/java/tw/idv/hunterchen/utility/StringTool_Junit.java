package tw.idv.hunterchen.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTool_Junit {
	@Test
	public void divider_test() {
		//指定長度
		assertEquals("<======>", StringTool.genDivider());
		assertEquals("<>", StringTool.genDivider(-1));
		assertEquals("<>", StringTool.genDivider(0));
		assertEquals("<====>", StringTool.genDivider(6));
		assertEquals("<======>", StringTool.genDivider(8));
		assertEquals("<==========>", StringTool.genDivider(12));
		//指定分隔字串
		assertEquals("hbbbbbbt", StringTool.genDivider("h", "b", "t"));
		assertEquals("habcdabt", StringTool.genDivider("h", "abcd", "t"));
		assertEquals("hhabcdtt", StringTool.genDivider("hh", "abcd", "tt"));
		
		assertEquals("<>", StringTool.genDivider("<", "12345", ">", -1));
		assertEquals("<>", StringTool.genDivider("<", "12345", ">", 0));
		assertEquals("<>", StringTool.genDivider("<", "12345", ">", 1));
		assertEquals("<>", StringTool.genDivider("<", "12345", ">", 2));
		assertEquals("<1>", StringTool.genDivider("<", "12345", ">", 3));
		assertEquals("ab12cd", StringTool.genDivider("ab", "12345", "cd", 6));
		assertEquals("<1234>", StringTool.genDivider("<", "12345", ">", 6));
		assertEquals("<12345>", StringTool.genDivider("<", "12345", ">", 7));
		assertEquals("<=====>", StringTool.genDivider("<", "=", ">", 7));
		assertEquals("<12312>", StringTool.genDivider("<", "123", ">", 7));
		assertEquals("<12121>", StringTool.genDivider("<", "12", ">", 7));
		assertEquals("<======>", StringTool.genDivider("<", "=", ">", 8));
		assertEquals("?======>", StringTool.genDivider("?", "=", ">", 8));
		assertEquals("?======x", StringTool.genDivider("?", "=", "x", 8));
		assertEquals("?++++++x", StringTool.genDivider("?", "+", "x", 8));
		assertEquals("aa++++bb", StringTool.genDivider("aa", "+", "bb", 8));
		assertEquals("aa1212bb", StringTool.genDivider("aa", "12", "bb", 8));
		assertEquals("aa1231bb", StringTool.genDivider("aa", "123", "bb", 8));
		assertEquals("aa12312312312bb", StringTool.genDivider("aa", "123", "bb", 15));
		assertEquals("aa12121212121bb", StringTool.genDivider("aa", "12", "bb", 15));
		
		ShowTool.showMessages(StringTool.genDivider("+MBH+", 10));
		assertEquals("+MBHMBHMB+", StringTool.genDivider("+MBH+", 10));
		assertEquals("+MBH+", StringTool.genDivider("+MBH+"));
	}
}
