import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int[] dy = { 1, -1, 0, 0 };
	static final int[] dx = { 0, 0, 1, -1 };
	static int n;
	static int m;
	static int[][] board; // 입력값 담을 보드 배열
	static int[][] dp; // 누적 경우의 수를 담을 배열 dp[a][b] == a, b 좌표에서 도착지로 갈 수 있는 경우의 수

	static void input() {
		m = sc.nextInt();
		n = sc.nextInt();
		board = new int[m][n];
		dp = new int[m][n];
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				board[y][x] = sc.nextInt();
				dp[y][x] = -1; //실제 경우의 수가 0인 경우와 구분할 수 있게 -1로 초기화
			}
		}
	}

	static int searchRoute(int y, int x) {
		if (y == m - 1 && x == n - 1) { // 도착지에서 도착지로 갈 수 있는 경우의 수는 1이다.
			return 1;
		}
		if (dp[y][x] != -1) { // 방문한 좌표라면
			return dp[y][x]; // 그대로 누적값을 리턴
		}
		if (dp[y][x] == -1) { // 방문해본 적 없는 곳이면
			dp[y][x] = 0; // 경우의 수를 0으로 바꿔주고
			for(int i = 0 ; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= m || nx >= n) { // 범위를 넘어가면 X
					continue;
				}
				if(board[y][x] > board[ny][nx]) { // 한방향씩 확인해서 내리막길이면
					dp[y][x] += searchRoute(ny, nx);
					// 내가 지금 있는 곳의 경우의 수에 넘어갈 곳의 경우의 수를 더해준다.
				}
			}
		}
		return dp[y][x]; // y, x에서 도착지로 갈 수 있는 경우의 수를 리턴
	}

	public static void main(String[] args) {
		input();
		System.out.println(searchRoute(0, 0));
	}
}