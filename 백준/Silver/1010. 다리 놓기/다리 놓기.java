import java.util.Scanner;

public class Main {

	static int[][] dp = new int[30][30]; // 최댓값이 29

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테케만큼 반복
		int testCase = sc.nextInt();

		// mCn 의 경우의 수를 구해주면 된다. (mCn = m-1Cn-1 + m-1Cn)
		int[][] dp = new int[30][30]; // 최대 29

		// mCm = 1, mC0 = 1 (m == n, n == 0)
		for (int i = 0; i < 30; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}

		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				// mCn = m-1Cn-1 + m-1Cn
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			// n, m개 사이트
			int n = sc.nextInt();
			int m = sc.nextInt();

			sb.append(dp[m][n]).append("\n");
		}
		// 출력
		System.out.println(sb);
	}

}