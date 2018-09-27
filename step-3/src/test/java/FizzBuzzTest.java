import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FizzBuzzTest {

	private final FizzBuzz buzz = new FizzBuzz();
	// This test is to produce a report with  how many times the following were output
	// string

	@Test
	public void replaceIfNumberfoundToFizzBuzzString() {
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
	    public void reportCounter() {
	        FizzBuzz fizzBuzz = new FizzBuzz();
	        String actual = fizzBuzz.report();
	        assertTrue(actual.contains("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz"));
	        
	        assertTrue(actual.contains("fizz: 4"));
	        assertTrue(actual.contains("buzz: 3"));
	        assertTrue(actual.contains("fizzbuzz: 1"));
	        assertTrue(actual.contains("lucky: 2"));
	        assertTrue(actual.contains("integer: 10"));
	    }


}
