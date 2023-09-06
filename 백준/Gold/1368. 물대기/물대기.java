import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	// 논의 개수
	static int N;
	// 대표자
	static int[] p, well;

	// 물 대는 비용
	static int[][] water;

	// 엣지리스트
	static ArrayList<Edge> edgeList = new ArrayList<>();

	// 엣지 클래스 (비용 순 오름차순 정렬)
	private static class Edge implements Comparable<Edge> {
		int start, end, cost;

		private Edge(int start, int end, int cost) {
			this.start = start;
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

		p = new int[N + 1];
		well = new int[N + 1];

		// makeSet
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		// 우물 파는 비용부터 입력받기
		for (int i = 1; i <= N; i++) {
			well[i] = sc.nextInt();
		}

		// 엣지 정보 입력받아 넣어주기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int curCost = sc.nextInt();
				if (i == j) {
					// 두 수가 같으면 우물 파는 비용을 넣어주고 0이라는 가상 점과 연결
					Edge e = new Edge(0, i, well[i]);

					edgeList.add(e);
				} else if (i < j) {
					// j < i 일 때는 하지말고 i < j일 때만 추가해주자. (중복 제거)
					Edge e = new Edge(i, j, curCost);

					edgeList.add(e);
				}
			}
		}
		// 비용 순 정렬
		Collections.sort(edgeList);

		// 뽑은 엣지 수, 최소 비용
		int pick = 0;
		int minCost = 0;

		for (int i = 0; i < edgeList.size(); i++) {
			// 현재 엣지 가져오기
			Edge cur = edgeList.get(i);

			if (findSet(cur.start) != findSet(cur.end)) {
				// 시작점과 끝점의 부모가 다르면
				// 뽑은 수 카운팅, 비용 누적, 유니온
				pick++;
				minCost += cur.cost;
				union(cur.start, cur.end);
			}

			// 원하는 개수만큼 뽑았으면 멈추기
			if (pick == N)
				break;
		}

		// 출력
		System.out.println(minCost);
	}

	// findSet
	private static int findSet(int x) {
		if (x == p[x])
			return x;
		return p[x] = findSet(p[x]);
	}

	// union
	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}