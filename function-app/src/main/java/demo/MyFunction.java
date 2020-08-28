package demo;

public class MyFunction {

	public String handleRequest(String input) {
		String name = (input == null || input.isEmpty()) ? "world"  : input;
		return "Hello from MyFunction, " + name + "!";
	}

}
