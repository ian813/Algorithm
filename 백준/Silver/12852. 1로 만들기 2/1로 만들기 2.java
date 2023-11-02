import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		int[] before = new int[N + 1]; //경로 저장

		for (int i = 2; i <= N; i++) {
			// 일단 1 뺀 걸로 저장
			dp[i] = dp[i - 1] + 1;
			before[i] = i - 1;

			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				// 3으로 나누어 떨어질 때 판단
				dp[i] = dp[i / 3] + 1;
				before[i] = i / 3;
			}
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				// 2로 나누어 떨어질 때 판단
				dp[i] = dp[i / 2] + 1;
				before[i] = i / 2;
			}
		}
		System.out.println(dp[N]);

		StringBuilder sb = new StringBuilder();

		while (N > 0) {
			sb.append(N + " ");
			// 이전 경로 탐색하면서 반복
			N = before[N];
		}

		System.out.print(sb);
	}
}