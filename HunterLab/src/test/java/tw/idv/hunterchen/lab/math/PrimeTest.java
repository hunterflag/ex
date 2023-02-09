package tw.idv.hunterchen.lab.math;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith()
public class PrimeTest {
	@Test
	public void isPrime_test() {
		assertFalse(Prime.isPrime(0));
		assertFalse(Prime.isPrime(1));
		assertTrue (Prime.isPrime(2));
		assertTrue (Prime.isPrime(3));
		assertFalse(Prime.isPrime(4));
		assertTrue (Prime.isPrime(5));
		assertFalse(Prime.isPrime(6));
		assertTrue (Prime.isPrime(7));
		assertFalse(Prime.isPrime(8));
		assertFalse(Prime.isPrime(9));
		assertTrue (Prime.isPrime(11));
//		assertTrue (Prime.isPrime());
//		assertFalse(Prime.isPrime());
//		assertTrue (Prime.isPrime());
	}
}
