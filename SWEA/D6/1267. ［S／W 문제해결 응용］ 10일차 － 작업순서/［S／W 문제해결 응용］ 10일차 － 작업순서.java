import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int V, E; // 정점의 개수, 간선의 개수
	static int[][] adjArr; // 인접행렬
	static int[] inDegree; // 진입차수
	static boolean[] visited; // 방문체크
	static Stack<Integer> stack;
	
	static void input() {

		V = sc.nextInt();
		E = sc.nextInt();

		adjArr = new int[V + 1][V + 1];
		inDegree = new int[V + 1];
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int start = sc.nextInt(); // 시작점
			int end = sc.nextInt(); // 끝점
			adjArr[start][end]++; // 인접 정보 받기
			inDegree[end]++; // 진입차수 정보 받기
		}
		// 결과 쌓아둘 스택
		stack = new Stack<>();
	}

	static void topologicalStack(int node) {
		visited[node] = true; // 방문 체크
		
		for(int u = 1; u <= V; u++) {
			// 인접해 있는 노드 중에 방문 안했으면 그 노드로 재귀 호출
			if(adjArr[node][u] == 1 && !visited[u]) topologicalStack(u);
		}
		
		// 작업을 마치면 그 노드를 스택에 저장
		stack.push(node);
	}

	public static void main(String[] args) {
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			input();
			// 진입차수가 0인 곳을 찾아서 출발
			for(int v = 1; v <= V; v++) {
				if(inDegree[v] == 0) topologicalStack(v);
			}
			// 스택이 빌 때까지 뽑아주면서 값을 스트링빌더에 저장
			while(!stack.isEmpty()) {
				int temp = stack.pop();
				
				sb.append(temp + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}