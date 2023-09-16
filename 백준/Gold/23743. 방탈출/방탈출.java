import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	// 방 번호, 워프 개수
	static int room, warp;
	// 엣지 정보
	static PriorityQueue<Edge> queue = new PriorityQueue<>();

	// 부모 정보
	static int[] p;

	// 엣지 클래스 (시간 순 오름차순 정렬)
	private static class Edge implements Comparable<Edge> {
		int start, end, time;

		private Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}

		@Override
		public int compareTo(Edge o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		room = Integer.parseInt(st.nextToken());
		warp = Integer.parseInt(st.nextToken());

		// 엣지 정보 입력받으며 우선순위큐에 넣기, 자동으로 정렬됨
		for (int i = 0; i < warp; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			Edge e = new Edge(start, end, time);

			queue.add(e);
		}

		st = new StringTokenizer(br.readLine());

		// 비상탈출구를 0번째 방과 연결된 엣지라고 생각
		// 즉, i번쨰 방에 설치된 비상탈출구는 0과 i번쨰 방을 잇는 워프라고 생각
		for (int i = 1; i <= room; i++) {
			int start = 0;
			int end = i;
			int time = Integer.parseInt(st.nextToken());

			Edge e = new Edge(start, end, time);

			queue.add(e);
		}

		p = new int[room + 1];

		// 대표자
		for (int i = 1; i <= room; i++) {
			p[i] = i;
		}

		// 뽑은 수, 최소 시간
		int pick = 0;
		int minTime = 0;

		// 큐가 빌 떄까지 반복
		while (!queue.isEmpty()) {
			Edge cur = queue.poll();

			// 두 방의 대표자가 다르면
			if (findSet(cur.start) != findSet(cur.end)) {
				// 뽑아주고, 시간 누적, 유니온
				pick++;
				minTime += cur.time;
				union(cur.start, cur.end);
			}

			// 원하는 만큼 뽑았으면 멈추기
			// 비상탈출구도 설치해야하므로 하나 더 뽑기
			if (pick == room)
				break;
		}

		System.out.println(minTime);
	}

	// findSet
	private static int findSet(int x) {
		if (x == p[x])
			return x;
		return p[x] = findSet(p[x]);
	}

	// union (y 대표자를 x 대표자로 합치기)
	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}