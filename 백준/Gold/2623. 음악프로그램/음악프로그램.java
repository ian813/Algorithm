import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int singer, pd;
	static ArrayList<Integer>[] adjList;
	static int[] indegrees;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 가수와 pd 수
		singer = sc.nextInt();
		pd = sc.nextInt();
		
		// 인접정보
		adjList = new ArrayList[singer+1];
		// 진입차수
		indegrees = new int[singer+1];
		
		// 인접정보 담을 배열에 arraylist들 담아주기
		for(int i = 1; i <= singer; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < pd; i++) {
			int re = sc.nextInt();
			
			int[] tmp = new int[re];
			
			for(int j = 0; j < re; j++) {
				tmp[j] = sc.nextInt();
			}
			// 진입차수와 인접정보 저장
			for(int j = 0; j < re-1; j++) {
				adjList[tmp[j]].add(tmp[j+1]);
				indegrees[tmp[j+1]]++;
			}
		}
		
		sc.close();
		
		topologicalSort();
	}
	
	// 위상정렬
	static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입차수 0인 가수들 전부 큐에 넣기
		for(int i = 1; i <= singer; i++) {
			if(indegrees[i] == 0) {
				queue.add(i);
			}
		}
		
		// 큐가 빌 때까지 실행
		while(!queue.isEmpty()) {
			// 현재 가수 정보
			int cur = queue.poll();
			// 스트링빌더에 값 저장
			sb.append(cur + "\n");
			
			// 현재 가수와 연결된 가수들을 돌면서
			for(int next : adjList[cur]) {
				// 진입차수를 1씩 깎아주고
				indegrees[next]--;
				
				// 진입차수가 0인 점을 발견하면 큐에 넣어준다.
				if(indegrees[next] == 0) {
					queue.add(next);
				}
			}
		}
		// 순서를 정하는 것이 가능한지 체크할 불리안
		boolean flag = true;
		for(int i : indegrees) {
			// 진입차수가 0이 아닌 가수가 와일문을 빠져나왔는데도 존재하면
			// 이건 불가능한 경우
			if(i != 0) {
				// flag를 false로 바꾸고 멈춤
				flag = false;
				break;
			}
		}
		
		// flag에 따라 원하는 값 출력
		if(flag) {
			System.out.println(sb);
		} else {
			System.out.println(0);
		}
	}
}
