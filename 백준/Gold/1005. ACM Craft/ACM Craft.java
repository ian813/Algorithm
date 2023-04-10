
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();
	
	static int building, rule, minTime, targetBuilding; // 빌딩 수, 규칙 수, 최소시간
	static int[] time, inDegree; // 건설 시간, 진입차수
	static int[][] adjList; // 인접 정보를 담을 배열(각 인덱스에 리스트가 들어있음)
	static int[] dp; // dp를 써서 메모이제이션 해줄 배열
	
	static void input() {
		building = sc.nextInt();
		rule = sc.nextInt();
		
		time = new int[building+1];
		dp = new int[building+1];
		
		for(int idx = 1; idx <= building; idx++) {
			time[idx] = sc.nextInt();
			dp[idx] = time[idx];
		}
		
		adjList = new int[building+1][building+1];
		inDegree = new int[building+1];
		
		for(int rl = 0; rl < rule; rl++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			inDegree[end]++; // 진입차수 구해주기
			adjList[start][end]++; // 시작점에 해당하는 인덱스에 끝 점을 담아주기 (인접 정보)
		}
		
		targetBuilding = sc.nextInt();
		
	}
	
	// 위상정렬을 이용해서 구해보자.
	static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		// 진입차수가 0인 모든 점들 넣어주기
		for(int idx = 1; idx <= building; idx++) {
			if(inDegree[idx] == 0) {
				queue.add(idx);
			}
		}
		
		while(!queue.isEmpty()) { // 큐가 빌 때까지 진행
			int tempBuilding = queue.poll();
			// 뽑힌 건물에 그 건물의 건설시간을 더해서 저장 
			int tmpTime = 0;
			for(int i = 1; i <= building; i++) {
				if(adjList[i][tempBuilding] == 1) {
					// tempBuilding으로 진입하는 건물 중에 시간이 가장 오래 걸린걸 구해준다.
					tmpTime = Math.max(dp[i], tmpTime);
				}
			}
			// 구한 시간에 현재 빌딩의 건설 시간을 더해서 저장해준다.
//			dp[tempBuilding] = tmpTime + time[tempBuilding];
			dp[tempBuilding] += tmpTime;
			
			// 타깃빌딩의 시간을 구하면 멈춰준다.
			if(tempBuilding == targetBuilding) {
				break;
			}
			
			for(int i = 1; i <= building; i++) {
				// 해당 점의 인접 점으로 간 다음 그 점의 진입차수를 감소시켜준다.
				if(adjList[tempBuilding][i] == 1) {
					inDegree[i]--;					
					if(inDegree[i] == 0) {
						// 그 점의 진입차수가 0이 되면 큐에 추가
						queue.add(i);
					}
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) {
			input();
			topologicalSort();
			sb.append(dp[targetBuilding]).append("\n");
		}
		System.out.println(sb);
	}
}
