package brs;

import java.util.Scanner;


/**
 * <p>STP-2 lab 3.
 * <p>Realizes the "command" pattern.
 * <p>Works as a console application, accepting a series of commands, processing them and displaying the result of the command.
 * <p>Acceptable commands:
 * <ul>
 * <li> "w" - moves the point forward
 * <li> "s" - moves the point backward
 * <li> "a" - moves the point left
 * <li> "d" - moves the point right
 * <li> "h" - shows the history of commands
 * <li> "z" - reverts the last command
 * </ul>
 * @author roman-bessmertnyi
 */
public class Main {
	static String input;
	static String[] output;
	
	static CommandablePoint mainPoint = new CommandablePoint();
	
	/**
	 * The main interface of the application.
	 * Accepts console input, transfers it to the CommandablePoint.handleInput method.
	 * Gets a string array as output, displays it into console.
	 * Use "break" to close the application.
	 * @param args standard main args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			input = in.next();
			output = mainPoint.handleInput(input);
			for (String s  : output) {
				System.out.println(s);
			}
			if (input == "break") {
				in.close();
				break;
			}
		}
	}
}
