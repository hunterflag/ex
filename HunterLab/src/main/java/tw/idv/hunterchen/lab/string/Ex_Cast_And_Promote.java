package tw.idv.hunterchen.lab.string;

public class Ex_Cast_And_Promote {

	public static void main(String[] args) {
		// + operator 
		/* promotion rule
		 * 數值 => 字串
		 * 數值(整數 => 浮點) => 字串
		 */
		System.out.printf("%s%n", "0 + 10 + 200 + 3000 + \"string\"");
		System.out.printf("%s%n", 0 + 10 + 200 + 3000 + "string");
		System.out.printf("%s%n", "string" + 0 + 10 + 200 + 3000);
		System.out.printf("%s%n", 0 + "string" + 10 + 200 + 3000);
		System.out.printf("%s%n", 0 + 10 + "string" + 200 + 3000);
		System.out.printf("%s%n", 0 + 10 + 200 + "string" + 3000);
		System.out.printf("%s%n", 0 + 10 + 200 + 3000 + "string");
		System.out.printf("%s%n", 0 + 10.0 + 200 + 3000 + "string" );
		System.out.printf("%s%n", 0.0 + 10 + 200 + 3000 + "string" );

		// null, empty string
		System.out.printf("%s%n", "string".isEmpty() );
		
	}

}
