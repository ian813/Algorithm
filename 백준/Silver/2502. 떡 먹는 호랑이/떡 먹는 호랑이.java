import java.util.Scanner;

public class Main {

	private static int[] dp;
	private static int day, ricecake, A, B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 떡 먹은 날, 떡 개수
		day = sc.nextInt();
		ricecake = sc.nextInt();

		dp = new int[day + 1];

		dp[day] = ricecake;

		A = 1;
		B = 1;

		while (true) {
			fibonacci(A, B);

			if (dp[day - 1] + dp[day - 2] == ricecake) {
				break;
			}

			if (B < ricecake) {
				B++;
			} else {
				A++;
				B = A;
			}
		}

		System.out.println(A);
		System.out.println(B);
	}

	private static void fibonacci(int A, int B) {
		dp[1] = A;
		dp[2] = B;

		for (int i = 3; i < day; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
	}
}