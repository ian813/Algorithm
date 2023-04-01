import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	static int V; //정점 개수
	static int E; //간선 개수
	static int start; // 시작 노드
	static List<Node>[] info; // 노드 정보
	static int[] dist; // 거리 정보를 담을 배열
	static final int INF = Integer.MAX_VALUE;
	static boolean[] visited;
	
	// 도착지점과 가중치를 저장할 노드 클래스 만들기
	static class Node implements Comparable<Node> {
		int ed, w;
		
		public Node(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		info = new ArrayList[V+1];
		dist = new int[V+1];
		
		// dist배열을 모두 INF로 채워넣기
		Arrays.fill(dist, INF);
		
		// info 리스트에 arraylist를 하나씩 새로 생성해주기
		for(int i = 1; i <= V; i++) {
			info[i] = new ArrayList<>();
		}
		
		// 노드 정보 입력받기
		for(int idx = 0; idx < E; idx++) {
			// 시작, 끝, 가중치를 입력받고
			int startNode = sc.nextInt();
			int endNode = sc.nextInt();
			int weight = sc.nextInt();
			
			// 시작점을 인덱스로 해서 끝점과 가중치를 저장해주기
			info[startNode].add(new Node(endNode, weight));
		}
		
		visited = new boolean[V+1];
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		// 시작지점 거리 0으로 초기화
		dist[start] = 0;
		// 큐에 현재 노드 정보 넣어주기
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			// 큐가 빌때까지 진행
			
			Node tmpNode = queue.poll();
			
			// 현재노드와 연결된 노드를 방문했으면 넘어가기
			if(visited[tmpNode.ed]) continue;
			
			// 방문 안했으면 방문체크
			visited[tmpNode.ed] = true;
			
			for(Node nd : info[tmpNode.ed]) {
				if(dist[nd.ed] > dist[tmpNode.ed] + nd.w) {
					dist[nd.ed] = dist[tmpNode.ed] + nd.w;
					queue.add(new Node(nd.ed, dist[nd.ed]));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		input();
		dijkstra(start);
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
	}
}