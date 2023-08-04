import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static int data;
	static int start;
	static int V, E; // V : 정점, E : 간선
	static int[][] adjArr;
	static Queue<Node> queue;
	static int ans;
	static boolean[] visited;
	static int[] distArr;
	
	// 정점과 거리 정보(몇 개의 정점을 거쳐서 갔는지)를 담아줄 node클래스 생성
	static class Node {
		int v, w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
	}
	
	static void input() {
		// 데이터 길이와 시작 정점 입력받기
		data = sc.nextInt();
		start = sc.nextInt();
		
		// 정점 최대값
		V = 100;
		// data/2가 간선의 개수
		E = data/2;
		
		// 간선 정보를 나타낼 배열
		adjArr = new int[V+1][V+1];
		
		// 입력받기
		for(int i = 0; i < E; i++) {
			int tmpRow = sc.nextInt();
			int tmpCol = sc.nextInt();
			// 연결되어 있는 방향으로 1 추가
			adjArr[tmpRow][tmpCol] = 1;
		}

	}
	
	// bfs를 통해 탐색해주자.
	private static void bfs(int start, int dist) {
		queue = new LinkedList<>();
		
		// 방문 체크 배열
		visited = new boolean[V+1];
		// 시작지점 방문
		visited[start] = true;
		
		// 각 정점별 거리값을 저장할 배열
		distArr = new int[V+1];
		
		// 큐에 노드 추가
		queue.add(new Node(start, dist));
		
		while(!queue.isEmpty()) {
			// 큐가 빌때까지 실행
			// 큐에서 빼낸 노드를 저장
			Node tmpNode = queue.poll();
			
			for(int col = 1; col <= V; col++) {
				// tmpNode와 연결되어 있고, 방문하지 않은 노드면
				if(adjArr[tmpNode.v][col] == 1 && !visited[col]) {
					// 방문체크하고
					visited[col] = true;
					// 큐에다가 그 노드를 집어넣는데 거리는 +1해서 집어넣는다.
					queue.add(new Node(col, tmpNode.w+1));
					// 거리배열에도 저장해준다.
					// 큐는 나중에 비어있을 것이므로 거리를 따져주려면 따로 저장해줘야 한다.
					distArr[col] = tmpNode.w+1;
				}
			}
			
		}
		int tmpMax = Integer.MIN_VALUE;
		for(int idx = 1; idx <= V; idx++) {
			// 거리의 최댓값 구해주고
			tmpMax = Math.max(tmpMax, distArr[idx]);
		}
		
		ans = Integer.MIN_VALUE;
		
		for(int i = 1; i <= V; i++) {
			// 방문한 점 중 거리의 최댓값인 지점들 중에서
			if(visited[i] && tmpMax == distArr[i]) {
				// 최댓값 갱신
				ans = Math.max(ans, i);
			}
		}
		
	}

	
	public static void main(String[] args) {
		for(int tc = 1; tc <= 10; tc++) {
			// 인풋
			input();
			// 탐색
			bfs(start, 0);
			// 형식에 맞게 담아준 뒤 출력
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
		
	}

}