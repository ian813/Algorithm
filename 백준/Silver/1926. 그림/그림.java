import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 가로, 세로, 그림 정보, 최대넓이
	static int row, col, maxArea;
	static int[][] picture;
	// 델타배열(상하좌우)
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	static boolean[][] visited;

	// 포인트 클래스
	private static class Point {
		int r, c;

		private Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();

		// 그림 정보 입력받기
		picture = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				picture[i][j] = sc.nextInt();
			}
		}

		// 방문체크
		visited = new boolean[row][col];

		int cnt = 0; // 그림 개수 카운팅

		maxArea = 0; // 최대 넓이 초기화

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (picture[i][j] == 1 && !visited[i][j]) {
					// 그림이고, 방문 안했으면
					// 방문체크하고 bfs 탐색
					// 그림 개수 카운팅
					visited[i][j] = true;
					bfs(i, j, 0);
					cnt++;
				}
			}
		}

		// 그림개수와 최대넓이 담아주고 출력
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n").append(maxArea);

		System.out.println(sb);
	}

	private static void bfs(int r, int c, int area) {
		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(r, c));
		area++;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				// 탐색점이 배열을 넘어가거나 방문했거나 그림이 아니면 넘기기
				if (nr < 0 || nc < 0 || nr >= row || nc >= col)
					continue;
				if (visited[nr][nc] || picture[nr][nc] == 0)
					continue;

				// 방문체크하고 큐에 넣어주기, 넓이도 카운팅
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc));
				area++;
			}
		}

		// 최대넓이 업데이트
		maxArea = Math.max(area, maxArea);
	}
}