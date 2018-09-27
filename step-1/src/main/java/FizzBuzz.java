import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class FizzBuzz {

	private Collection<CaseFunction> cases = Arrays.asList(new CaseFunction(3, "fizz"), new CaseFunction(5, "buzz"));

	public String findByNumber(int number) {
		// CaseFunction caseFunction = new CaseFunction(3, "fizz");
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
		return cases.stream().map(replacer -> replacer.message(number))// the rules for number divisible for 3,5,15 % 0
				.filter(Optional::isPresent).map(optional -> optional.get())
				.reduce((a, b) -> a + b) // concate the fizz+buzz = fizzbuzz																										
				.orElse(Integer.toString(number));

	}

}