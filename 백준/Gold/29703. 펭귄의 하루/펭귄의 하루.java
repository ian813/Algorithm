import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 델타배열 (상하좌우)
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	// 포인트 클래스 (좌표, 시간, 사냥했는지 체크)
	static class Point {
		int r, c, time;
		boolean check;

		Point(int r, int c, int time, boolean check) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.check = check;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		// 맵 생성
		char[][] map = new char[N][M];

		// 방문체크 (먹이 사냥 전 방문한 곳 체크, 먹이 사냥 후 방문한 곳 체크)
		boolean[][] visitedBefore = new boolean[N][M];
		boolean[][] visitedAfter = new boolean[N][M];

		// 시작점 만들기
		Point start = new Point(0, 0, 0, false);

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'S') {
					// 시작점 제대로 생성
					start = new Point(i, j, 0, false);
				}
			}
		}

		int ans = 0;

		// BFS로 탐색하기 위한 큐
		Queue<Point> queue = new LinkedList<>();

		// 시작점 담아주기
		queue.add(start);
		// 방문체크
		visitedBefore[start.r][start.c] = true;

		x:
		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) // 배열 범위 넘으면 넘기기
					continue;
				if (cur.check && visitedAfter[nr][nc]) { // 사냥했고 사냥 이후 방문한 곳이면 넘기기
					continue;
				}
				if (!cur.check && visitedBefore[nr][nc]) { // 사냥 못 했고 사냥 이전 방문한 곳이면 넘기기
					continue;
				}

				if (map[nr][nc] == 'D') { // 위험지역은 못가니까 넘기기
					continue;
				} else if (map[nr][nc] == 'F') { // 물고기 사냥 가능한 곳이므로 큐에 담아주기
					queue.add(new Point(nr, nc, cur.time + 1, true));
					visitedAfter[nr][nc] = true;
				} else if (map[nr][nc] == 'H') { // 펭귄 집
					if (cur.check) { // 사냥했으면
						// 시간 늘려주고 멈추기
						ans = cur.time + 1;
						break x;
					} else {
						// 사냥 못했으면 큐에 담아주기
						queue.add(new Point(nr, nc, cur.time + 1, cur.check));
						visitedBefore[nr][nc] = true;
					}
				} else {
					// 시작점이거나 안전 구역이면 큐에 담아주기
					queue.add(new Point(nr, nc, cur.time + 1, cur.check));
					if (cur.check) { // 사냥했으면 사냥 이후 방문 체크
						visitedAfter[nr][nc] = true;
					} else { // 사냥 안했으면 사냥 이전 방문 체크
						visitedBefore[nr][nc] = true;
					}
				}
			}
		}

		// 0이면 -1로 바꾸고 아니면 그대로
		ans = (ans == 0) ? -1 : ans;

		// 출력
		System.out.println(ans);
	}
}