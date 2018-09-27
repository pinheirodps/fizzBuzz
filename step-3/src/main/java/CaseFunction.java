import java.util.Optional;

import org.junit.internal.builders.IgnoredBuilder;

public class CaseFunction {
	// this class was created to hold two values that going to help us to remove the
	// ifs, allowing a cleaner code
	private final int value;
	private final String message;

	public CaseFunction(int value, String string) {
		this.value = value;
		this.message = string;
	}

	// before the refactoring
	// public int getValue() {
	// return value;
	// }
	//
	// public String getMessage() {
	// return message;
	// }

	// this code will be repeated my times
	// replacer = new ImproveReplacer(5, "buzz");
	// if(number == replacer.getValue()) {
	// System.out.println(number);
	// System.out.println("buzz");
	// return replacer.getText();
	// }
	// this method was created to void duplicated code
	// public Optional<String> textFor(int n) {
	// return Optional.of(message).map(num -> {
	// if (num.toString().contains("3"))
	// return "lucky";
	// return message;
	// }).filter(ignored -> n % value == 0);
	// }
	//
	// this method was created to void duplicated code
	// public Optional<String> textFor(int n) {
	// return Optional.of(message)
	// .filter(ignored -> n % value == 0)
	// .filter(s -> s.toString().contains("3"))
	// ;
	// }

	// before the last refactor
	// public Optional<String> message(int number) {
	// // TODO Auto-generated method stub
	// if (number % value == 0) {
	// return Optional.of(message);
	// }
	// return Optional.empty();
	// }

	// to improve the last code we can use a trick to get rid of the remaining if
	// statement

	public Optional<String> message(int number) {
		return Optional.of(message).filter(m -> number % value == 0);
	}

}
