import java.util.Scanner;

public class Main {

	// 주어지는 수
	static int N;
	// 답
	static long ans;
	// 답을 나눠줄 수
	static final int ansMaker = 1000000000;
	// dp배열 (현재 자리수, 끝자리에 들어간 수, 비트)
	static long[][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// 답 초기화
		ans = 0;

		// dp배열 생성
		dp = new long[N + 1][10][1 << 10];

		// 첫행에 경우의 수로 초기화
		// 각 열에 1~9 중 하나씩 쓰였다고 할당
		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}

		// 자릿수만큼 실행
		for (int n = 2; n <= N; n++) {
			for (int k = 0; k <= 9; k++) { // 열 늘리면서 dp에 저장
				for (int v = 0; v < (1 << 10); v++) {
					int cur = v | (1 << k); // 추가하려는 인덱스

					// k에 맞게 dp값을 저장
					if (k == 0)
						dp[n][k][cur] += dp[n - 1][k + 1][v] % ansMaker;
					else if (k == 9)
						dp[n][k][cur] += dp[n - 1][k - 1][v] % ansMaker;
					else
						dp[n][k][cur] += (dp[n - 1][k - 1][v] % ansMaker + dp[n - 1][k + 1][v] % ansMaker);

					dp[n][k][cur] %= ansMaker;
				}
			}
		}

		// 경우의 수 다 더해주기
		for (int k = 0; k <= 9; k++) {
			ans += dp[N][k][(1 << 10) - 1] % ansMaker;
			ans %= ansMaker;
		}

		System.out.println(ans);
	}
}