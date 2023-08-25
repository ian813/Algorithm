import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	/**
	 * N : 컴퓨터 개수
	 * p : 대표자 배열
	 * conect : 연결 정보
	 * edges : edge정보를 담고 있는 우선순위큐
	 */
	static int N;
	static int[] p;
	static char[][] connect;

	static PriorityQueue<Edge> edges = new PriorityQueue<>();

	// 엣지 클래스 (비용 순 정렬)
	private static class Edge implements Comparable<Edge> {
		int st, end, cost;

		public Edge(int st, int end, int cost) {
			this.st = st;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		connect = new char[N + 1][N + 1];

		// 연결 정보 입력받기
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= N; j++) {
				connect[i][j] = str.charAt(j - 1);
			}
		}

		// 총 비용
		int totalCost = 0;

		// 엣지 정보 추가
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cost = 0;

				// 0이면 넘기고  소문자 대문자 구분해서 비용 업데이트
				if (connect[i][j] == '0')
					continue;
				else if (connect[i][j] <= 'Z') {
					cost = connect[i][j] - 'A' + 27;
				} else {
					cost = connect[i][j] - 'a' + 1;
				}

				// 총 비용 누적
				totalCost += cost;

				// Edge 만들어서 큐에 넣어주기
				Edge e = new Edge(i, j, cost);

				edges.add(e);
			}
		}
		// makeSet
		p = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		// 간선 뽑은 개수, 연결 최소 비용
		int pick = 0;
		int minCost = 0;

		// 큐가 빌 때까지 실행
		while (!edges.isEmpty()) {
			Edge cur = edges.poll();

			// 출발점과 끝점의 대표자가 다르면
			if (findSet(cur.st) != findSet(cur.end)) {
				pick++; // 뽑은 개수 카운팅
				union(cur.st, cur.end); // union
				minCost += cur.cost; // 비용 누적
			}

			// 다 뽑았으면 멈추기
			if (pick == N - 1)
				break;
		}

		// 연결이 안되면 -1 출력
		if (pick != N - 1) {
			System.out.println(-1);
		} else {
			// 연결되면 총비용해서 연결비용 뺴서 기부 최대 비용 구해서 출력
			System.out.println(totalCost - minCost);
		}
	}

	// findSet
	static int findSet(int x) {
		if (x == p[x])
			return x;
		return p[x] = findSet(p[x]);
	}

	// union
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}