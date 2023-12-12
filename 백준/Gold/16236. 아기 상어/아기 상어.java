import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	private static int size, body, minTime;
	private static int[][] map;
	private static Point start;

	// 델타배열 (상좌우하) -> 우선권 잘 고려해서 탐색 (상좌 탐색하고 안되면 같은 높이 먼저 탐색하는 게 좋으니까 우측, 그 다음 아래쪽)
	private static final int[] dr = {-1, 0, 0, 1};
	private static final int[] dc = {0, -1, 1, 0};

	// 위치 정보를 담을 포인트 클래스 ( + 경과시간, 잡아먹은 물고기 수, 방문체크, 맵 정보)
	private static class Point implements Comparable<Point> {
		int r, c, time;

		private Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			// 시간 순 오름차순 정렬
			if (this.time > o.time) {
				return 1;
			} else if (this.time < o.time) {
				return -1;
			}

			// 시간이 같으면 row 순 오름차순 정렬 (위쪽 물고기가 우선권)
			if (this.r > o.r) {
				return 1;
			} else if (this.r < o.r) {
				return -1;
			}

			// row까지 같으면 col 순 정렬 (왼쪽 물고기가 우선권)
			return this.c - o.c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 맵 크기
		size = sc.nextInt();

		// 맵 정보 입력받기
		map = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 9) {
					// 시작점 위치 저장하고 빈칸으로 만들기
					start = new Point(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		// 경과 시간
		minTime = 0;

		// 초기 아기상어 몸 크기
		body = 2;

		// 먹은 물고기 수
		int cnt = 0;

		while (true) {
			// 먹이를 먹었으면 계속 탐색 진행
			PriorityQueue<Point> queue = new PriorityQueue<>();

			// 방문 체크할 배열
			boolean[][] visited = new boolean[size][size];

			// 시작점 방문 체크
			visited[start.r][start.c] = true;

			// 시작점 추가
			queue.add(start);

			// 안 먹은 상태로 변경
			boolean check = false;

			while (!queue.isEmpty()) {
				// 현재 위치 저장
				Point cur = queue.poll();

				// 먹을 수 있으면 먹기
				if (map[cur.r][cur.c] != 0 && map[cur.r][cur.c] < body) {
					// 물고기 제거하고 먹은 숫자 카운팅, 경과 시간 업데이트, 먹었는지 체크
					map[cur.r][cur.c] = 0;
					cnt++;
					minTime += cur.time;
					check = true;
					// 시작점 업데이트하고 리턴
					start = new Point(cur.r, cur.c, 0);
					break;
				}

				for (int i = 0; i < 4; i++) {
					// 델타배열로 탐색
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (!canMove(nr, nc) || visited[nr][nc]) {
						// 못 가는 곳이거나 방문한 곳이면 넘기기
						continue;
					}

					queue.add(new Point(nr, nc, cur.time + 1));
					visited[nr][nc] = true;
				}
			}

			if (!check) {
				// 큐가 비워질 때까지 먹이를 먹은적이 없다면, 더 이상 먹은 물고기가 없으므로 탈출
				break;
			}

			if (body == cnt) {
				// 몸 크기만큼 먹었으면 크기 늘려주고 먹은 개수 초기화
				body++;
				cnt = 0;
			}
		}

		// 시간 출력
		System.out.println(minTime);
	}

	// 탐색 가능한지 판단할 메서드
	private static boolean canMove(int r, int c) {
		// 범위 초과하거나 몸 크기보다 큰 물고기 있으면 탐색 못함
		return r >= 0 && r < size && c >= 0 && c < size && map[r][c] <= body;
	}
}