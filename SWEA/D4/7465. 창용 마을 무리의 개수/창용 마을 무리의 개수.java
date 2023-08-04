import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();

	static int people; // 사람 수
	static int relation; // 관계 수
	static int[][] relationInfo; // 관계 정보
	static int group; // 그룹 개수
	static boolean[] visited; // 방문 체크

	static void input() {
		people = sc.nextInt();
		relation = sc.nextInt();

		// 사람들 사이의 관계를 나타낼 배열
		relationInfo = new int[people+1][people+1];

		// 관계정보 입력받기
		for (int idx = 0; idx < relation; idx++) {
			int tmpRow = sc.nextInt();
			int tmpCol = sc.nextInt();
			// 아는 사람이면 그 위치에 1 써주기
			relationInfo[tmpRow][tmpCol] = relationInfo[tmpCol][tmpRow] = 1;
		}
		// 방문 체크할 배열
		visited = new boolean[people + 1];
	}

	// bfs를 이용해서 탐색해주자.
	static void bfs(int person) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(person); // 큐에 현재 사람 넣어주고
		visited[person] = true; // 그룹에 포함되었다고 체크
		
		// 큐가 빌 때까지 모든 사람을 확인하자
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int idx = 1; idx <= people; idx++) {
				// 모르는 사람이거나 알고 있는 사람 중에서 이미 그룹에 포함된 사람이면 패스
				if (relationInfo[cur][idx] != 1 || visited[idx]) continue;
								
				// 둘 다 아니라면
				// 큐에 넣어주고 그룹에 포함됐다고 표시
				queue.add(idx);
				visited[idx] = true;
			}
		}
		
	}


	public static void main(String[] args) {
		for (int tc = 1; tc <= testCase; tc++) {
			input();
			// 그룹 개수 초기화
			group = 0;
			
			for (int i = 1; i <= people; i++) {
				// 아직 그룹에 포함 안 된 사람이 있으면
				if(!visited[i]) {
					// 탐색하고
					bfs(i);
					// 한번 탈출할 때마다 그룹 수 증가
					group++;
				}
			}
			// 스트링빌더에 담아주기
			sb.append("#" + tc + " " + group + "\n");
		}
		System.out.println(sb);
	}
}