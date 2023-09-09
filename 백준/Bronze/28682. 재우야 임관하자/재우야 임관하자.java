import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print("swimming" + " ");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			if (input.equals("bowling")) {
				System.out.print("soccer" + " ");
			} else if (input.equals("soccer")) {
				System.out.print("bowling" + " ");
			}
		}
	}
}
