import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static List<Integer>[] adjList;
	static int[] inDegree;
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		// 인접 리스트
		adjList = new ArrayList[N+1];
		
		for(int idx = 1; idx <= N; idx++) {
			adjList[idx] = new ArrayList<>();
		}
		
		// 진입차수
		inDegree = new int[N+1];
		
		// 선행문제, 나중에 풀 문제 입력받기, 진입차수도 구해주기
		for(int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			adjList[start].add(end);
			
			inDegree[end]++;
		}
		
	}
	
	static void topologicalSort() {
		// 우선순위 큐에 넣어주기 (난이도 순 정렬)
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		// 진입차수 0인거 전부 넣기
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			// 하나 뽑아서 담기
			int problem = queue.poll();
			// 스트링빌더에 저장
			sb.append(problem + " ");
			
			for(int i = 0; i < adjList[problem].size(); i++) {
				// 연결된 문제들의 진입차수 감소시켜주고
				inDegree[adjList[problem].get(i)]--;
				
				// 0이 됐으면 큐에 추가
				if(inDegree[adjList[problem].get(i)] == 0) {
					queue.add(adjList[problem].get(i));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		input();
		topologicalSort();
		System.out.println(sb);
	}
}
