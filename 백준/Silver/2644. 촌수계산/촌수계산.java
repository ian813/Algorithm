import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// 사람수, 타겟 사람1, 2, 관계정보 수, 답
	static int people, targetPerson1, targetPerson2, relationNum, ans;
	// 관계를 담을 배열
	static ArrayList<Integer>[] relationInfo;
	static boolean[] visited; // 방문체크
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		people = sc.nextInt();
		targetPerson1 = sc.nextInt();
		targetPerson2 = sc.nextInt();
		relationNum = sc.nextInt();
		
		relationInfo = new ArrayList[people+1]; 
		
		for(int i = 1; i <= people; i++) {
			relationInfo[i] = new ArrayList<>();
		}
		
		visited = new boolean[people+1];
		
		for(int i = 0; i < relationNum; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			// 양방향으로 다 담아주기
			relationInfo[parent].add(child);
			relationInfo[child].add(parent);
		}
		ans = -1; // 만약 관계성을 발견 못하면 -1
		
		// 탐색 시작
		DFS(targetPerson1, targetPerson2, 0);
		
		System.out.println(ans);
		
		sc.close();
	}
	
	static void DFS(int start, int end, int cnt) {
		if(start == end) { // 시작점과 끝점이 같아지면
			// 담아주고 리턴
			ans = cnt;
			return;
		}
		
		visited[start] = true; // 시작점 방문처리
		
		// 시작점과 연결된 점들을 돌면서
		for(int i = 0; i < relationInfo[start].size(); i++) {
			// 다음 시작점 지정
			int next = relationInfo[start].get(i);
			if(!visited[next]) { // 방문 안했으면 재귀로 탐색
				DFS(next, end, cnt+1);
			}
			
		}
	}
	
}