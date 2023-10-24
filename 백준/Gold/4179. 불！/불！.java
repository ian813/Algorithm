import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int R, C, time;
	static int[][] map;
	static String ans = "IMPOSSIBLE";
	static Point jihoon;

	static Queue<Point> qFire = new ArrayDeque<>();

	// 델타배열 (상하좌우)
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	// 포인트 클래스 (위치와 시간 정보)
	private static class Point {
		int r, c, t;

		private Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 맵 크기
		R = sc.nextInt();
		C = sc.nextInt();

		// 맵 정보 입력받기 (불이 번진 시간으로 채워줄 거임)
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();

			for (int j = 0; j < C; j++) {
				// 지훈이와 불의 시작점 받아주고,
				// 벽과 나머지 구분
				if (str.charAt(j) == 'J') {
					jihoon = new Point(i, j, 0);
					map[i][j] = -1;
				} else if (str.charAt(j) == 'F') {
					qFire.add(new Point(i, j, 0));
				} else if (str.charAt(j) == '#') {
					map[i][j] = -2;
				} else {
					map[i][j] = -1;
				}
			}
		}

		// for (int i = 0; i < R; i++) {
		// 	for (int j = 0; j < C; j++) {
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		bfsFire();

		// 지훈이가 탈출하는데 걸린 시간
		time = Integer.MAX_VALUE;

		// for (int i = 0; i < R; i++) {
		// 	for (int j = 0; j < C; j++) {
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		// 지훈이 움직이기
		bfsJihoon(jihoon.r, jihoon.c);

		if (time == Integer.MAX_VALUE) {
			System.out.println(ans);
		} else {
			System.out.println(time);
		}
	}

	// 움직일 수 없는 곳인지 판단할 메서드
	private static boolean notMove(int r, int c) {
		return (r < 0 || r >= R || c < 0 || c >= C);
	}

	// 불을 번지게할 메서드
	private static void bfsFire() {

		while (!qFire.isEmpty()) {
			Point cur = qFire.poll();

			for (int i = 0; i < 4; i++) {
				// 델타배열로 탐색
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				// 움직일 수 없는 곳이면 넘기기
				if (notMove(nr, nc))
					continue;

				// 벽이면 넘기기
				if (map[nr][nc] == -2)
					continue;

				// 불이 번진 곳인데 현재 시간보다 적은 시간에 번졌으면 넘기기
				if (map[nr][nc] != -1 && map[nr][nc] <= cur.t + 1)
					continue;

				// 그게 아니면 불을 번지게 하고
				map[nr][nc] = cur.t + 1;

				// 큐에 추가
				qFire.add(new Point(nr, nc, cur.t + 1));
			}
		}
	}

	private static void bfsJihoon(int r, int c) {
		Queue<Point> qJihoon = new ArrayDeque<>();

		boolean[][] visited = new boolean[R][C];

		qJihoon.add(new Point(r, c, 0));

		visited[r][c] = true;

		while (!qJihoon.isEmpty()) {
			Point cur = qJihoon.poll();

			// System.out.println("r: " + cur.r + " c: " + cur.c + " t: " + cur.t);

			// 가장자리 도달했으면 1을 더해서 시간 업데이트
			if (cur.r == R - 1 || cur.c == C - 1 || cur.r == 0 || cur.c == 0) {
				time = Math.min(cur.t + 1, time);
			}

			for (int i = 0; i < 4; i++) {
				// 델타배열로 탐색
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				// 움직일 수 없는 곳이면 넘기기
				if (notMove(nr, nc))
					continue;

				// 불이 번진 곳인데 nr, nc로 이동한 시간보다 먼저 불이 번진 곳이면 넘기기
				if (map[nr][nc] != -1 && map[nr][nc] <= cur.t + 1)
					continue;

				// 벽이면 넘기기
				if (map[nr][nc] == -2)
					continue;

				// 방문한 곳이면 넘기기
				if (visited[nr][nc])
					continue;

				// 아니면 방문처리
				visited[nr][nc] = true;

				// 큐에 추가
				qJihoon.add(new Point(nr, nc, cur.t + 1));
			}
		}
	}
}