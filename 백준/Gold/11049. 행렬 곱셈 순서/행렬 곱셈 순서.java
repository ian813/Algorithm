import java.util.Scanner;

public class Main {

	// 행렬 개수
	static int N;
	static int[][] matrix;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		matrix = new int[N][2];

		// 행렬 정보 입력받기
		for (int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			matrix[i][0] = r;
			matrix[i][1] = c;
		}

		sc.close();

		// dp 배열
		// dp[i][j] = i번째 행렬부터 j번째 행렬까지의 곱셈연산의 최소 횟수
		// 따라서 dp[i][j] = dp[i][k] + dp[k+1][j] + (k와 k+1 을 곱한 곱셈연산) 중 최솟값 (i < k < j) ... (1)
		dp = new int[N][N];

		// 대각선엔 0입력받고 (같은 행렬끼리 곱할 수 없으므로)
		// 나머지는 최댓값으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					dp[i][j] = 0;
				else
					dp[i][j] = Integer.MAX_VALUE;
			}
		}

		// 하나 차이 나는 곳에는 바로 연산한 값들로 채워넣어주기
		for (int i = 0; i < N - 1; i++) {
			dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1];
		}

		// gap = 1인 곳은 바로 위 for문에서 계산했으므로 2부터 N보다 작을 때까지 계산
		for (int gap = 2; gap < N; gap++) {
			for (int i = 0; i + gap < N; i++) {
				// i+gap이 N을 넘어가지 않게 반복
				int j = i + gap;

				// i < k < j에 대해서 (1)의 식 실행
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1]);
				}
			}
		}

		// 1번째 행렬부터 N번쨰 행렬까지의 곱셈연산의 최소 횟수 출력
		System.out.println(dp[0][N - 1]);
	}
}