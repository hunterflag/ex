package tw.idv.hunterchen.template.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * 大量測試, 採用參數化單元測試 在測試方法中, 將受測值、預期值也參數化,
 * 
 * @author chenhuanzhang
 *
 */

/*
 * 0.啟用大量參數測試
 */
@RunWith(Parameterized.class)
public class ParameterizedTestFieldsTemplateTest {

	/*
	 * 1.建立測試資料矩陣: 2D 矩陣(mxn) 
	 * m 列：測試資料的筆數 
	 * n 行：測試資料的參數
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
		      {   1, 2,   2 }
			, {   5, 3,  15 }
			, { 121, 4, 484 } 
//			, {   7, 8,  55 } 
		};
		return Arrays.asList(data);
	}

	/*
	 * 2.建立要用在測試方法的 測試參數、預測參數
	 * fields used together with @Parameter must be public
	 * 3.與測試資料的導入關係
	 * @Parameter(n-index): 測試資料矩陣的第n行
	 */
	@Parameter(0)
	public int m1;
	@Parameter(1)
	public int m2;
	@Parameter(2)
	public int result;
	
	/*
	 * 4.測試方法內要使用 測試參數、預測參數
	 */
	@Test
	public void testMultiplyException() {
		MyClass tester = new MyClass();
		assertEquals("Result", result, tester.multiply(m1, m2));
	}

	// class to be tested
	class MyClass {
		public int multiply(int i, int j) {
			return i * j;
		}
	}

}
