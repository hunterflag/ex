package tw.idv.hunterchen.enumeration;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import tw.idv.hunterchen.utility.DebugTool;

public class WeekDay_UT {
	@Test
	public void testGetWeekDay() {
		DebugTool.showMessageWithSerialNo(WeekDay.SUN.name());
		DebugTool.showMessageWithSerialNo(WeekDay.SUN.toString());
		assertEquals(WeekDay.SUN.getDay(), "Sunday");
		assertEquals(WeekDay.SUN.name(), 0);
	}
}
