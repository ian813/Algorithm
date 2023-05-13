import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N; // 건물개수
	static int[] inDegree, time, dp; // 진입차수, 건물 짓는데 걸리는 시간, 건물 짓는데 걸리는 최소 누적 시간
	static ArrayList<Integer>[] adjList; // 연결관계를 나타낼 배열
	static Queue<Integer> queue; // 위상정렬 구현할 큐
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		inDegree = new int[N+1];
		time = new int[N+1];
		dp = new int[N+1];
		adjList = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 시간 정보, 인접 정보 입력받기
		for(int i = 1; i <= N; i++) {
			time[i] = sc.nextInt();
			dp[i] = time[i]; // dp에 건물 짓는 시간 같이 저장
			while(true) {
				int tmp = sc.nextInt();
				if(tmp == -1) break;
				else {
					adjList[tmp].add(i);
					// 진입차수 카운팅
					inDegree[i]++;
				}
			}
		}
		
		sc.close();
	}
	
	static void topologicalSort() {
		queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				queue.add(i); // 진입차수 0인 모든 건물 큐에 넣어주기
			}
		}
		
		while(!queue.isEmpty()) {
			int curBuilding = queue.poll(); // 건물 빼주기
			
			for(int i = 0; i < adjList[curBuilding].size(); i++) { // 해당 건물과 연결된 건물을 찾자.
				int nextBuilding = adjList[curBuilding].get(i); // 다음 건물
				inDegree[nextBuilding]--; // 진입차수 빼주기
				// 문제에서 최소시간을 구하라고 했지만 결국 그 전 건물을 모두 지어야 지을 수 있으므로 최대시간을 구해야한다.
				dp[nextBuilding] = Math.max(dp[nextBuilding], dp[curBuilding]+time[nextBuilding]); // dp값 갱신
				
				if(inDegree[nextBuilding] == 0) {
					// 진입차수가 0이 되면 큐에 넣어주기
					queue.add(nextBuilding);
					
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		input();
		topologicalSort();
		for(int i = 1; i <= N; i++) {
			sb.append(dp[i] + "\n");
		}
		System.out.println(sb);
	}
}