import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	// 건물과 도로의 수
	static int building, road;
	static int[] p; // 대표자

	static ArrayList<Edge> edgeList; // 엣지리스트

	// 엣지클래스 (시작점, 끝점, 경사도 정보)
	static class Edge implements Comparable<Edge> {
		int start, end, slope;

		Edge(int start, int end, int slope) {
			this.start = start;
			this.end = end;
			this.slope = slope;
		}

		@Override
		public int compareTo(Edge o) {
			return this.slope - o.slope;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		building = Integer.parseInt(st.nextToken());
		road = Integer.parseInt(st.nextToken());

		edgeList = new ArrayList<>();

		// 엣지 정보 입력받기 (road+1개의 도로가 주어짐)
		for (int i = 0; i <= road; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int slope = Integer.parseInt(st.nextToken());

			Edge e = new Edge(start, end, slope);

			edgeList.add(e);
		}

		p = new int[building + 1];

		// makeSet
		for (int i = 0; i <= building; i++) {
			p[i] = i;
		}

		// 도로 뽑은 개수 카운트할 pick, 오르막이 몇 개인지 카운트 할 slopeCnt
		int pick = 0;
		int slopeCnt = 0;
		// 경사도로 정렬
		Collections.sort(edgeList);
		for (int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);

			if (findSet(e.start) != findSet(e.end)) { // 대표자가 다르면
				pick++; // 도로를 뽑고
				union(e.start, e.end); // 유니온
				if (e.slope == 0) // 뽑은 도로가 오르막이면 카운트
					slopeCnt++;
			}

			if (pick == building) // 원하는 만큼 뽑았으면 멈추기
				break;
		}
		// 최대비용 구하기
		int maxCost = slopeCnt * slopeCnt;

		// 뽑은 개수, 오르막 카운트 초기화
		pick = 0;
		slopeCnt = 0;
		// 이번엔 역순으로 정렬
		Collections.sort(edgeList, Collections.reverseOrder());

		// makeSet (다시 대표자 초기화)
		for (int i = 0; i <= building; i++) {
			p[i] = i;
		}

		// 위와 같은 방법으로 구하기
		for (int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);

			if (findSet(e.start) != findSet(e.end)) {
				pick++;
				union(e.start, e.end);
				if (e.slope == 0)
					slopeCnt++;
			}

			if (pick == building)
				break;
		}
		// 최소비용 구하기
		int minCost = slopeCnt * slopeCnt;

		// 결과 출력
		System.out.println(maxCost - minCost);
	}

	// findSet
	static int findSet(int x) {
		if (x == p[x])
			return x;
		return p[x] = findSet(p[x]);
	}

	// union
	static void union(int x, int y) {
		p[findSet(x)] = findSet(y);
	}
}