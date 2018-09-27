import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FizzBuzz {

	private Collection<CaseFunction> cases = Arrays.asList(new CaseFunction(3, "fizz"), new CaseFunction(5, "buzz"));

	private static final String NUMBER = "\\d+";
	private static final String BREAK_LINE = "\n";

	public Map<Object, Object> reportByGroup = new HashMap<>();

	public String report() {
		for (int i = 1; i <= 20; i++) {
			reportByGroup.put(i,findByNumber(i));//this step is to populate the map with different types to use in the future and group them
		}

		List<String> result = new ArrayList<>();//create a new list to use the parallelStream 
		for (Object value : reportByGroup.values()) {
			result.add((String) value);
		}

		Map<String, Long> countMap = result.parallelStream()
				.collect(Collectors.groupingBy(s -> s.matches(NUMBER) ? "integer" : s, Collectors.counting())); // here we are group them by type {lucky=2, integer=10, fizzbuzz=1, fizz=4, buzz=3}

		// preparing the final reports
		String fizzbuzz = result.parallelStream().collect(Collectors.joining(" ")); //getting the numbers and luck, buzz, fizz and fizzbuzz
		String counts = countMap.entrySet().parallelStream().map(e -> e.getKey() + ": " + e.getValue())
				.collect(Collectors.joining(BREAK_LINE));//formating string to the final result with break lines

		System.out.println(fizzbuzz + BREAK_LINE + counts);
		return fizzbuzz + "\n" + counts;
	}

	public String findByNumber(int number) {
		return cases.stream().map(replacer -> replacer.message(number))// get message if number % cases value ==0
				.filter(Optional::isPresent).map(optional -> optional.get())
				.reduce((a, b) -> a + b)
				// verify if the numbers contains number 3 and replace to lucky
				.map(s -> Integer.toString(number).contains("3") ? "lucky" : s.toString())
				.orElse(Integer.toString(number).contains("3") ? "lucky" : Integer.toString(number));
	}

}