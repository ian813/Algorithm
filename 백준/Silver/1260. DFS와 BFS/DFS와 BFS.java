import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N; // 정점 개수
	static int M; // 간선 개수
	static int V; // 탐색 시작 번호
	
	static int[][] mInfo; // 간선의 정보
	
	static boolean[] visit;
	
	// 인풋메서드
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// N, M, V
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		// 정점의 개수만큼 (인덱스를 정점에 맞춰서 생성) 배열 생성
		mInfo = new int[N+1][N+1];
		
		// 연결된 곳 정보 담아주기
		for(int m = 0; m < M; m++) {
			int tmpRow = sc.nextInt();
			int tmpCol = sc.nextInt();
			
			mInfo[tmpRow][tmpCol] = 1;
			mInfo[tmpCol][tmpRow] = 1;
			
		}
		
		// 정점개수만큼 방문 체크해줄 배열 생성
		visit = new boolean[N+1];
	}
	
	// 깊이우선탐색
	static void dfs(int i) {
		// 들어온 점 방문 체크
		visit[i] = true;
		// 들어온 점 바로 출력
		System.out.print(i + " ");
		
		for(int j = 1; j <= N; j++) {
			// i와 연결된 간선 탐색, 앞쪽부터 탐색하므로
			// 노드 번호가 작은 것부터 탐색
			// 방문 안한 노드면 재귀 호출
			if(mInfo[i][j] == 1 && visit[j] == false) {
				dfs(j);
			}
		}
	}
	
	// 너비우선탐색
	static void bfs(int i) {
		// 큐 생성
		Queue<Integer> q = new LinkedList<>();
		
		// 큐에 시작점 집어넣기
		q.offer(i);
		// 방문했으므로 체크
		visit[i] = true;
		
		while(!q.isEmpty()) {
			// 큐가 빌 때까지 실행 (for문을 돌고 오면 계속 새로운 값이 받아져 있으므로
			// 				그 값들까지 다 쓸 때까지 진행)
			// 큐에는 노드가 작은 순서부터 쌓였으므로
			// 작은 노드부터 다시 실행된다.
			// 큐에서 뺴온 값을 임시로 저장해주고
			int tmp = q.poll();
			// 출력
			System.out.print(tmp + " ");
			for(int j = 1; j <= N; j++) {
				// 연결되어 있는 노드 중에서
				// 방문하지 않은 곳을 모두 찾아주자.
				if(mInfo[tmp][j] == 1 && visit[j] == false) {
					// 연결되어 있는 점이 있고 그 점을 아직 방문 안 했으면
					// 큐에 연결되어 있는 점을 넣어주고
					q.offer(j);
					// 방문 체크를 해준다.
					visit[j] = true;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		input();
		// 깊이우선탐색
		dfs(V);
		System.out.println();
		// 방문 체크 초기화
		visit = new boolean[N+1];
		// 너비우선탐색
		bfs(V);
		
	}
}