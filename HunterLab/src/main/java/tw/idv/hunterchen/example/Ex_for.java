package tw.idv.hunterchen.example;

public class Ex_for {
	/* for (初始述句; boolean式; 更新述句) {...true執行述句...}
	 * 執行順序
	 * 1. 初始述句
	 * 2. boolean式
	 * 2.1. boolean式為true,
	 * 2.1.1. {...true執行述句...}
	 * 2.1.2. 更新述句
	 * 2.1.3. 回到 2.boolean式
	 * 2.2. boolean式為false, for-loop 結束
	 */

	public static void ex_for_0() {
		for (int i=0; i<=5; System.out.println("lo: "+i)){
//			System.out.println("bf: "+i);
			i++;
//			System.out.println("af: "+i);
		}				
	}

	public static void ex_for_1() {
		for (int i=0; true; System.out.println("lo: "+i)){
			i++;
		}				
	}
	
	public static void main(String[] args) {
		ex_for_0();	//123456
//		ex_for_1();	//123456...跑不完
	}

}
