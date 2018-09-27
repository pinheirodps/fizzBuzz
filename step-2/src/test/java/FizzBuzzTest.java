import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest {
	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			System.out.println(new FizzBuzz().findByNumber(i));
		}

	}

	private final FizzBuzz buzz = new FizzBuzz();
	// This test was builded step by step to test the number and change to fizz,
	// buzz, fizzBuzz and luck with number contains(3)

	@Test
	public void testReplaceNumberContainsThreeToLuckyOneToTwenty() {
		assertFizzBuzz("1", 1);
		assertFizzBuzz("2", 2);
		assertFizzBuzz("lucky", 3);
		assertFizzBuzz("4", 4);
		assertFizzBuzz("buzz", 5);
		assertFizzBuzz("fizz", 6);
		assertFizzBuzz("7", 7);
		assertFizzBuzz("8", 8);
		assertFizzBuzz("fizz", 9);
		assertFizzBuzz("buzz", 10);
		assertFizzBuzz("11", 11);
		assertFizzBuzz("fizz", 12);
		assertFizzBuzz("lucky", 13);
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
	public void testReplaceNumberContainsThreeToLucky() {
		assertEquals(Integer.toString(3), "lucky", buzz.findByNumber(3));
		// assertEquals(Integer.toString(13), "lucky", buzz.findByNumber(3));

	}

}
