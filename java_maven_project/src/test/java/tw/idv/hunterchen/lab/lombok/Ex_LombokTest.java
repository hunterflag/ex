package tw.idv.hunterchen.lab.lombok;

import java.util.Date;

import org.junit.Test;

import tw.idv.hunterchen.utility.DevTool;

public class Ex_LombokTest {
	@Test
	public void test() {
		Ex_Lombok ex_Lombok = new Ex_Lombok();
		
		DevTool.showMessages(ex_Lombok.toString());
		ex_Lombok.setId(100);
		DevTool.showMessages(ex_Lombok.toString());

		ex_Lombok = new Ex_Lombok(101, "newTag", new Date());
		DevTool.showMessages(ex_Lombok.toString());
		ex_Lombok.setId(100);
		DevTool.showMessages(ex_Lombok.toString());
		ex_Lombok.sayHi();
	}
}
