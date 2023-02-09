package tw.idv.hunterchen.lab.math;

import lombok.extern.slf4j.Slf4j;
// https://www.baeldung.com/java-generate-prime-numbers
@Slf4j
public class Prime {
	/**
	 * 檢查 number 是否為質數?
	 * @param number
	 * @return
	 */
	
//	public static boolean isPrime(int number) {
//		boolean result = false;
//		if (number > 1) {
//			result = true;
//			while (result) {
//				for (int i=2; i<number; i++) {
//					if (number % i == 0) {
//						result = false;
//					}
//				}
//			}
//		}
//		return result;
//	}
	
	/* 另一種版本 */	
	public static boolean isPrime(int number) {
		if (number <= 1)  return false;
		for (int i=2; i<number; i++) {
			if (number % i == 0) return false;
		}
		return true;
	}

}
