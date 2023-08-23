import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row, col, num;
	// 맵 정보
	static int[][] map;

	// 대표자 배열
	static int[] parent;

	// 엣지들을 넣어둘 큐
	static PriorityQueue<Edge> edges = new PriorityQueue<>();

	// 방문체크
	static boolean[][] visited;

	// 델타배열 (상하좌우)
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	// 포인트 클래스
	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 엣지 클래스
	// 가중치 순 오름차순 정렬
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 맵의 행 열 크기
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];

		// 맵 정보 입력받기
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방문체크 배열 생성
		visited = new boolean[row][col];

		// 섬 개수 카운팅 (섬마다 번호 붙일 거임)
		num = 0;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (!visited[r][c] && map[r][c] == 1) {
					// 방문 안했고 육지이면
					// 방문 체크하고 BFS 탐색
					visited[r][c] = true;
					BFS(r, c);
				}
			}
		}

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (map[r][c] != 0) {
					// 육지인 곳에서 전부 다리 만들 수 있는지 탐색
					makeBridge(r, c);
				}
			}
		}

		// 엣지 정보 다 넣어줬으니 크루스칼로 찾으면 끝
		// makeset (섬의 개수만큼 생성)
		parent = new int[num + 1];
		makeSet();

		// 답, 뽑아준 엣지 개수
		int ans = 0;
		int pick = 0;

		while (!edges.isEmpty()) {
			Edge tmp = edges.poll();

			if (findSet(tmp.start) != findSet(tmp.end)) {
				// 엣지의 시작점과 끝점의 대표자가 다르면
				// 뽑은 개수 카운팅
				pick++;
				// 유니온
				union(tmp.start, tmp.end);
				// 답 누적
				ans += tmp.weight;
			}

			if (pick == num - 1) {
				// 원하는 만큼 뽑으면 중단
				break;
			}
		}

		if (pick != num - 1 || ans == 0) {
			// 다리가 부족해서 다 연결하지 못했으면 -1 출력
			System.out.println(-1);
		} else {
			// 아니면 답 출력
			System.out.println(ans);
		}
	}

	static void BFS(int r, int c) {
		// 섬 카운팅
		num++;
		// 섬에 번호 붙이기
		map[r][c] = num;

		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(r, c));

		while (!queue.isEmpty()) {
			// 현재 위치
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				// 델타배열 탐색
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				// 탐색 지점이 배열 범위 넘거나 방문한 곳이거나 바다면 넘기기
				if (nr < 0 || nr >= row || nc < 0 || nc >= col)
					continue;
				if (visited[nr][nc] || map[nr][nc] == 0)
					continue;

				// 아니면 방문체크하고 섬에 번호 붙이고 큐에 넣어주기
				visited[nr][nc] = true;
				map[nr][nc] = num;
				queue.add(new Point(nr, nc));
			}
		}
	}

	// 가능한 모든 다리를 만드는 메서드
	static void makeBridge(int r, int c) {
		Point cur = new Point(r, c);

		// 델타배열로 탐색
		for (int i = 0; i < 4; i++) {
			int nr = cur.r + dr[i];
			int nc = cur.c + dc[i];

			// 탐색한 곳이 배열 범위 안이고 바다면 탐색 시작
			while (nr >= 0 && nc >= 0 && nr < row && nc < col && map[nr][nc] == 0) {
				int cnt = 0;

				while (map[nr][nc] == 0) {
					cnt++; // 다리 길이 늘리기
					// 현재 방향으로 탐색
					nr += dr[i];
					nc += dc[i];

					// 배열 범위 넘어가면 카운팅 취소하고 중단
					if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
						cnt = 0;
						break;
					}
				}

				if (cnt >= 2) { // 다리 길이가 2이상일 때 중복된 다리가 아니면 넣어주기
					if (!edges.contains(new Edge(map[nr][nc], map[cur.r][cur.c], cnt))) {
						edges.add(new Edge(map[cur.r][cur.c], map[nr][nc], cnt));
					}
				}
			}
		}
	}

	// makeSet
	static void makeSet() {
		for (int i = 1; i <= num; i++) {
			parent[i] = i;
		}
	}

	// findSet
	static int findSet(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = findSet(parent[x]);
	}

	// union (y를 x대표자로 합치기)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}