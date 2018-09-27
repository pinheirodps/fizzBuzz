import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class FizzBuzz {

	private Collection<CaseFunction> cases = Arrays.asList(new CaseFunction(3, "fizz"), new CaseFunction(5, "buzz"));

	public String findByNumber(int number) {
		// before the refactoring
		// if(number == caseFunction.getValue()) {
		// System.out.println(number);
		// System.out.println("fizz");
		// return caseFunction.getMessage();
		// }
		// caseFunction = new CaseFunction(5, "buzz");
		// if(number == caseFunction.getValue()) {
		// System.out.println(number);
		// System.out.println("buzz");
		// return caseFunction.getMessage();
		// }
		// after refactoring with a new method and to improve the performance with
		// stream java 8

		// first test
		// CaseFunction caseFunction = new CaseFunction(3, "lucky");
		//
		// if (number == caseFunction.getValue()) {
		// return caseFunction.getMessage();
		// }
		// caseFunction = new CaseFunction(5, "buzz");
		// if (number == caseFunction.getValue()) {
		// return caseFunction.getMessage();
		// }
		// StringBuilder result = new StringBuilder();
		//
		// for (CaseFunction caseFunction : cases) {
		// improving the test
		// if (number == caseFunction.getValue()) {
		// return caseFunction.getMessage();
		// }

		// Optional<String> result = caseFunction.message(number);
		// if (result.isPresent()) {
		// return result.get();
		// }
		// Optional<String> replacement = caseFunction.message(number);
		// if (replacement.isPresent()) {
		// result.append(replacement.get());
		// }
		//
		// }
		// if (result.length()>0) {
		// if(String.valueOf(number).contains("3")) {
		// return "lucky";
		// }
		//
		// return result.toString();
		// }
		//
		// if(String.valueOf(number).contains("3")) {
		// return "lucky";
		// }
		// It is a easy way to replace the number contains("3") to lucky
		return cases.stream().map(replacer -> replacer.message(number))// get message if number % cases value ==0
				.filter(Optional::isPresent).map(optional -> optional.get())
				.reduce((a, b) -> a + b)
				// verify if the numbers contains number 3 and replace to lucky
				.map(s -> Integer.toString(number).contains("3") ? "lucky" : s.toString())
				.orElse(Integer.toString(number).contains("3") ? "lucky" : Integer.toString(number));

	}

}