import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest {
	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			System.out.println(new FizzBuzz().findByNumber(i));
		}
	}

	private final FizzBuzz buzz = new FizzBuzz();
	// This test was builded step by step to test the number and change to FizzBuzz
	// string

	@Test
	public void replaceIfNumberfoundToFizzBuzzString() {
		assertFizzBuzz("1", 1);
		assertFizzBuzz("2", 2);
		assertFizzBuzz("fizz", 3);
		assertFizzBuzz("4", 4);
		assertFizzBuzz("buzz", 5);
		assertFizzBuzz("fizz", 6);
		assertFizzBuzz("7", 7);
		assertFizzBuzz("8", 8);
		assertFizzBuzz("fizz", 9);
		assertFizzBuzz("buzz", 10);
		assertFizzBuzz("11", 11);
		assertFizzBuzz("fizz", 12);
		assertFizzBuzz("13", 13);
		assertFizzBuzz("14", 14);
		assertFizzBuzz("fizzbuzz", 15);
		assertFizzBuzz("16", 16);
		assertFizzBuzz("17", 17);
		assertFizzBuzz("fizz", 18);
		assertFizzBuzz("19", 19);
		assertFizzBuzz("buzz", 20);

	}

	private void assertFizzBuzz(String expected, int n) {
		assertEquals(Integer.toString(n), expected, buzz.findByNumber(n));
	}

	@Test
	public void testWithNumberIsDividableBy3() {
		assertEquals(Integer.toString(3), "fizz", buzz.findByNumber(3));

	}

	@Test
	public void testWithNumberIsDividableBy5() {
		assertEquals(Integer.toString(5), "buzz", buzz.findByNumber(5));

	}

	@Test
	public void testWithNumberIsDividableBy15() {
		assertEquals(Integer.toString(15), "fizzbuzz", buzz.findByNumber(15));

	}

}
