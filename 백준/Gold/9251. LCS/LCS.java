import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열 2개 입력받기
		String str1 = sc.next();
		String str2 = sc.next();

		// dp를 이용해서 LCS 구해주자.
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		int max = 0;

		for (int i = 1; i <= str1.length(); i++) {
			char cur = str1.charAt(i - 1);

			for (int j = 1; j <= str2.length(); j++) {
				if (cur == str2.charAt(j - 1)) {
					// 같은 문자 만났을 때
					// 대각선 위가 존재하면 대각선 위에서 하나 플러스
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					// 같지 않으면 위 왼쪽 값 중 최댓값으로 업뎃
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				// 최댓값 업데이트
				max = Math.max(max, dp[i][j]);
			}
		}
		// 최댓값 출력
		System.out.println(max);
	}
}