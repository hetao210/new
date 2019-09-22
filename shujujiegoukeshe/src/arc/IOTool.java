package arc;
import java.util.Scanner;
	 
public class IOTool {
	 
		public static String getInput() {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			return input;
		}
	 
		public static void print(String s) {
			System.out.println(s);
		}
}
