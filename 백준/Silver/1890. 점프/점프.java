import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static long[][] dp;

	static void input() {
		Scanner sc = new Scanner(System.in);
		// 맵 크기
		N = sc.nextInt();
		// 맵 정보
		map = new int[N][N];

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				map[row][col] = sc.nextInt();
			}
		}
		// 수가 크니까 long형으로 받기
		dp = new long[N][N];
		// 처음 좌표에 1 저장
		dp[0][0] = 1;
		sc.close();
	}

	static void search() {

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				// 다음 좌표까지 점프할 값
				if(dp[row][col] == 0) continue; // 저장된 값이 0이면 굳이 볼필요 없다.(출발점에서 못 오는 곳이므로)
				int jump = map[row][col]; // 점프 뛸 값 저장
				if (jump == 0) break; // 도착점이면 멈추고 다음 탐색
				if (col + jump < N) dp[row][col + jump] += dp[row][col]; // 범위 안이면 점프하고 경로 수 저장
				if (row + jump < N) dp[row + jump][col] += dp[row][col]; // 범위 안이면 점프하고 경로 수 저장
			}
		}

	}

	public static void main(String[] args) {
		input();
		search();
		System.out.println(dp[N - 1][N - 1]);
	}
}