import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static final int INF = 987654321;

	// 그래프 정보
	private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	// 최소시간 정보 (각 마을에서 target까지 가는 최단시간)
	private static int[][] goTime;

	// target에서 각 마을까지 가는 최단시간
	private static int[] backTime;

	// 왕복 시간
	private static int[] minTime;

	// Node 클래스, 시작점, 시간 (시간 순 오름차순 정렬)
	private static class Node implements Comparable<Node> {
		int end, time;

		private Node(int end, int time) {
			this.end = end;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 도시 개수, 도로 개수, 타깃 마을
		int city = Integer.parseInt(st.nextToken());
		int road = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		// 도시 개수만큼 어레이리스트 생성
		for (int i = 0; i <= city; i++) {
			graph.add(new ArrayList<>());
		}

		// 시작점 끝점 시간 정보 입력받아서 저장
		for (int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			// 단방향이므로 한쪽만 저장
			graph.get(start).add(new Node(end, time));
		}

		goTime = new int[city + 1][city + 1];
		backTime = new int[city + 1];
		minTime = new int[city + 1];

		// 최댓값으로 채워넣기
		for (int i = 0; i <= city; i++) {
			for (int j = 0; j <= city; j++) {
				goTime[i][j] = INF;
			}
		}

		Arrays.fill(backTime, INF);

		// 각 마을에서 타깃까지 가는 시간 학생별로 구해주기
		for (int i = 1; i <= city; i++) {
			goDijkstra(i, target, goTime);
		}

		// 타깃에서 각 마을로 돌아오는 시간 구해주기
		backDijkstra(target, backTime);

		// 최대로 걸리는 학생의 시간
		int maxTime = 0;

		// 왕복시간 합치면서 최대시간 업데이트
		for (int i = 1; i <= city; i++) {
			minTime[i] = goTime[i][target] + backTime[i];

			maxTime = Math.max(maxTime, minTime[i]);
		}

		// 최대 시간 출력
		System.out.println(maxTime);
	}

	private static void goDijkstra(int start, int target, int[][] arr) {
		// 비용 순 오름차순 정렬
		PriorityQueue<Node> queue = new PriorityQueue<>();

		// 시작점 비용 초기화
		arr[start][start] = 0;

		// 시작점 넣어주기
		queue.add(new Node(start, arr[start][start]));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.end == target) {
				// 타깃 만나면 리턴
				return;
			}

			if (arr[start][cur.end] < cur.time) {
				// 꺼낸 노드가 현재 최소 시간을 가진 노드여야 한다.
				// 즉, 해당 노드의 시간이 현재 arr 배열에 기록된 비용보다 크면 넘김
				continue;
			}

			for (Node next : graph.get(cur.end)) {
				if (arr[start][next.end] > arr[start][cur.end] + next.time) {
					// 연결된 점의 시간 초기화
					arr[start][next.end] = arr[start][cur.end] + next.time;

					// 초기화될 때만 넣어주기
					queue.add(new Node(next.end, arr[start][next.end]));
				}
			}

		}
	}

	// 	goDijkstra랑 똑같은 메커니즘
	private static void backDijkstra(int start, int[] arr) {
		PriorityQueue<Node> queue = new PriorityQueue<>();

		backTime[start] = 0;

		queue.add(new Node(start, backTime[start]));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (arr[cur.end] < cur.time) {
				continue;
			}

			for (Node next : graph.get(cur.end)) {
				if (arr[next.end] > arr[cur.end] + next.time) {
					arr[next.end] = arr[cur.end] + next.time;

					queue.add(new Node(next.end, arr[next.end]));
				}
			}
		}
	}
}