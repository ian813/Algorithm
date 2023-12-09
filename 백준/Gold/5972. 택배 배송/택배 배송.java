import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	// 그래프 정보를 담을 리스트
	private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	// 거리 정보 (비용)
	private static int[] dist;

	// 초기화할 거리 최댓값
	private static final int INF = Integer.MAX_VALUE;

	// 끝점과 비용을 담은 Node 클래스 (비용순 오름차순 정렬)
	private static class Node implements Comparable<Node> {
		int end, cost;

		private Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 노드 개수, 간선 개수
		int N = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());

		// 노드 개수만큼 어레이리스트 추가
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		// 그래프 정보 담아주기
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			// 시작점, 끝점, 비용
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// 양방향 길이므로 양쪽 다 등록
			graph.get(start).add(new Node(end, cost));
			graph.get(end).add(new Node(start, cost));
		}

		dist = new int[N + 1];

		// 모든 비용 INF로 초기화
		Arrays.fill(dist, INF);

		// 시작점과 목표점 넣어주기
		dijkstra(1, N);

		// 목표점 비용 출력
		System.out.println(dist[N]);
	}

	private static void dijkstra(int start, int target) {
		// 비용 순 오름차순 정렬
		PriorityQueue<Node> pq = new PriorityQueue<>();

		// 시작점 비용 초기화
		dist[start] = 0;

		// 시작점 넣어주기
		pq.add(new Node(start, dist[start]));

		while (!pq.isEmpty()) {
			// 큐가 빌때까지 실행
			// 현재 점 뽑아주기
			Node cur = pq.poll();

			if (cur.end == target) {
				// 만약 타깃에 도착하면 그대로 리턴
				return;
			}

			if (dist[cur.end] < cur.cost) {
				// 꺼낸 노드가 현재 최소 비용을 가진 노드여야 한다.
				// 즉, 해당 노드의 비용이 현재 dist 배열에 기록된 비용보다 크면 넘김
				continue;
			}

			for (Node next : graph.get(cur.end)) {
				// 현재 노드와 연결된 노드들만 고려

				if (dist[next.end] > dist[cur.end] + next.cost) {
					// 다음 노드의 dist배열에 기록된 비용과 현재 노드의 dist배열에 기록된 비용 + 다음 노드로 가는데 드는 비용 비교
					// 초기화 및 큐에 넣어주기
					dist[next.end] = dist[cur.end] + next.cost;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}
	}
}