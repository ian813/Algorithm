import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();

		// target의 최댓값 : 100000
		int[] dp = new int[100001];

		// 2, 4, 5값은 미리 계산해서 넣어주기 (초기값 세팅)
		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;

		for (int i = 6; i <= target; i++) {
			// 목표 값까지 실행
			if (dp[i - 2] == 0 && dp[i - 5] == 0) {
				// i-2, i-5 값이 0이면 넘기기
				continue;
			}
			if (dp[i - 2] == 0) {
				// i-2만 0이면 i-5 경우의 수에 +1
				dp[i] = dp[i - 5] + 1;
				continue;
			}
			if (dp[i - 5] == 0) {
				// i-5만 0이면 i-2 경우의 수에 +1
				dp[i] = dp[i - 2] + 1;
				continue;
			}
			// 둘 다 0이 아니면 최솟값 +1
			dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
		}

		// 출력 (0이면 불가능한 경우이므로 -1 출력, 아니면 원래 경우의 수 출력)
		System.out.println((dp[target] == 0) ? -1 : dp[target]);
	}
}