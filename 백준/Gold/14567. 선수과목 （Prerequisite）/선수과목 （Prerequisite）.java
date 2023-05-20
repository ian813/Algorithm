import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int subjectNum, conditionNum; // 과목수, 조건수
	static int[] indegrees, dp; // 진입차수, 몇학기에 이수할지 저장할 배열
	static ArrayList<Integer>[] condition; // 조건을 담을 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		subjectNum = sc.nextInt();
		conditionNum = sc.nextInt();
		
		indegrees = new int[subjectNum+1];
		condition = new ArrayList[subjectNum+1];
		dp = new int[subjectNum+1];
		
		// 조건 배열에 어레이리스트를 담아주고
		for(int i = 1; i <= subjectNum; i++) {
			condition[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < conditionNum; i++) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			// 조건 정보 담고 진입차수 정보도 담아준다.
			condition[st].add(end);
			indegrees[end]++;
		}
		
		sc.close();
		
		topologicalSort();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : dp) {
			if(i != 0) { // 인덱스 0인 곳에 0이 저장되어있으니까 빼고 저장
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
		
	}
	
	static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입차수가 0인 과목들을 전부 큐에 담아준다.
		for(int i = 1; i <= subjectNum; i++) {
			if(indegrees[i] == 0) {
				queue.add(i);
				dp[i] = 1; // 처음 들어간 과목 모두 첫학기에 이수 가능
			}
		}
		
		while(!queue.isEmpty()) { // 큐가 빌때까지 실행
			int cur = queue.poll(); // 현재 과목 뽑아주기
			
			for(int i = 0; i < condition[cur].size(); i++) {
				// 현재 과목과 연결된 모든 다음 과목을 반복문으로 돌면서 저장
				int next = condition[cur].get(i);
				// 다음 과목의 진입차수를 낮춰주고
				indegrees[next]--;
				
				if(indegrees[next] == 0) {
					// 진입차수가 0이 되면 큐에 저장
					queue.add(next);
					// 큐에 저장된 순간 이수할 수 있다는 뜻인데
					// 현재 과목 직후 바로 다음 학기에 이수할 수 있으므로
					// 현재 과목 이수학기 +1로 저장
					dp[next] = dp[cur] + 1;
				}
			}
			
		}
		
	}
}
