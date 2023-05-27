import java.util.Scanner;

public class Main {
	static int N, M, ans; // 정점과 간선의 개수, 연결요소 개수
	static boolean[] visited; // 정점 방문체크
	static int[][] graph; // 그래프 정보
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N+1];

		graph = new int[N+1][N+1];
		
		// 그래프 정보 입력받기
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		sc.close();
		// 연결 요소 개수 값 초기화
		ans = 0;
		
		// 모든 정점을 돌면서
		for(int idx = 1; idx <= N; idx++) {
			if(!visited[idx]) { // 방문 안한 곳이면
				DFS(idx); // 재귀로 탐색
				ans++; // 빠져나오면 연결요소 개수 카운팅
			}
		}
		System.out.println(ans);
	}
	
	static void DFS(int idx) {
		// 방문한 곳 나오면 리턴
		if(visited[idx]) return;
		
		visited[idx] = true; // 방문 체크
		for(int i = 1; i <= N; i++) { // 모든 정점을 돌면서
			if(graph[idx][i] == 1) { // 연결된 곳 발견하면
				DFS(i); // 재귀로 탐색
			}
		}
	}
}