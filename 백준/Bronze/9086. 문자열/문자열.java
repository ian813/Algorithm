import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			String str = sc.next();

			sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
		}
		System.out.println(sb);

	}

}