import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테케 개수
		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		// dp 배열 (중복을 피하기 위해 오름차순으로 나열된 것만 세준다. ex) 1+2+1(x) 1+1+2(o) )
		// dp[i][1] i를 만들 때 1로 끝나는 수식
		// dp[i][2] i를 만들 때 2로 끝나는 수식
		// dp[i][3] i를 만들 때 3로 끝나는 수식
		int[][] dp = new int[10001][4];

		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 1+1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 1+1+1
		dp[3][2] = 1; // 1+2
		dp[3][3] = 1; // 3

		// dp[i][1] -> i-1에 있는 1로 끝나는 수식에 +1을 붙여주면 되므로
		// dp[i - 1][1]과 같다. (오름차순으로 나열한 것만 셀 것이므로 dp[i - 1][2]에 +1을 붙여주면 ... +2+1이 되므로 안된다.)
		// dp[i][3] -> i-3에 있는 모든 1, 2, 3으로 끝나는 수식에 +3을 붙여주면 되므로
		// dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]과 같다.
		for (int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}

		// 테스트케이스만큼 입력받아서 저장
		while (testCase-- > 0) {
			int cur = sc.nextInt();

			sb.append(dp[cur][1] + dp[cur][2] + dp[cur][3]).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}