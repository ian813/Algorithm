import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	// 델타배열 (하 우 우하 방향)
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};

	static int[][] dp, map;

	private static class Point {
		int r, c;

		private Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 맵 크기
		N = sc.nextInt();
		M = sc.nextInt();

		// 맵 정보
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// dp 맵
		dp = new int[N + 1][M + 1];

		dp[1][1] = map[1][1];

		move(1, 1);

		System.out.println(dp[N][M]);
	}

	private static void move(int r, int c) {
		// 큐에 넣어주기
		Queue<Point> queue = new ArrayDeque<>();

		// 큐에 시작점 추가
		queue.add(new Point(r, c));

		// 방문 체크
		boolean[][] visited = new boolean[N + 1][M + 1];

		// 큐가 빌 때까지 실행
		while (!queue.isEmpty()) {

			// 현재 점 뽑아주기
			Point cur = queue.poll();

			for (int i = 0; i < 3; i++) {
				// 델타배열로 탐색
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				// 배열 범위 넘어가면 넘기기
				if (nr < 1 || nc < 1 || nr > N || nc > M) {
					continue;
				}

				if (!visited[nr][nc]) {
					// 방문 안 한 곳이면 방문 체크하고
					visited[nr][nc] = true;
					// dp 업데이트하고 포인트 추가
					dp[nr][nc] = dp[cur.r][cur.c] + map[nr][nc];
					queue.add(new Point(nr, nc));
				} else if (dp[nr][nc] < dp[cur.r][cur.c] + map[nr][nc]) {
					// 방문했지만 더 크면 업데이트하고 탐색 점 넣어주기
					dp[nr][nc] = dp[cur.r][cur.c] + map[nr][nc];
					queue.add(new Point(nr, nc));
				}

			}
		}
	}
}