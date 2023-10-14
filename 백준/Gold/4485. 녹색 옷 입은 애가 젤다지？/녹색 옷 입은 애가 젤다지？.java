import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	// 맵 크기, 맵 정보
	static int size;
	static int[][] map;

	// 델타배열(상하좌우)
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	// 포인트 클래스 (위치와 총 비용 저장) 총 비용으로 오름차순 정렬
	private static class Point implements Comparable<Point> {
		int r, c, totalCost;

		private Point(int r, int c, int totalCost) {
			this.r = r;
			this.c = c;
			this.totalCost = totalCost;
		}

		@Override
		public int compareTo(Point o) {
			return this.totalCost - o.totalCost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		// 테케 개수
		int tc = 1;

		while (true) {
			// 맵 크기와 맵 정보 입력받기
			// 단 맵 크기가 0이면 종료
			size = sc.nextInt();

			if (size == 0)
				break;

			// 맵 정보 입력받기
			map = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 최소 비용 저장할 배열
			int[][] minCost = new int[size][size];

			// 최소 비용 초기화
			for (int[] row : minCost) {
				Arrays.fill(row, 987654321);
			}

			PriorityQueue<Point> queue = new PriorityQueue<>();

			// 출발점 큐에 담아주기
			queue.add(new Point(0, 0, map[0][0]));

			while (!queue.isEmpty()) {
				// 큐가 빌 때까지 실행
				// 현재점 담아주기
				Point cur = queue.poll();

				for (int i = 0; i < 4; i++) {
					// 델타배열로 탐색
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					// 배열 범위 넘어가면 넘기기
					if (nr < 0 || nc < 0 || nr >= size || nc >= size) {
						continue;
					}

					if (cur.totalCost + map[nr][nc] < minCost[nr][nc]) {
						// 최솟값이 갱신될 때만 큐에 담아주기
						minCost[nr][nc] = cur.totalCost + map[nr][nc];
						queue.add(new Point(nr, nc, minCost[nr][nc]));
					}
				}
			}

			// 최소비용 담아주기
			sb.append("Problem " + tc++ + ": " + minCost[size - 1][size - 1]).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}