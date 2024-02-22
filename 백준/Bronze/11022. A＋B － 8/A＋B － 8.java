import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		String ans = "Case #";

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			int C = A + B;

			sb.append(ans)
				.append(tc)
				.append(": ")
				.append(A)
				.append(" + ")
				.append(B)
				.append(" = ")
				.append(C)
				.append("\n");
		}

		System.out.println(sb);
	}
}