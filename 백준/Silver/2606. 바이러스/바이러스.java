import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int computerNum;
	static int connection;
	static int[][] map;
	static int cnt;
	static boolean[] visit;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 컴퓨터 개수, 연결된 선 개수
		computerNum = sc.nextInt();
		connection = sc.nextInt();
		// 연결 정보를 담아줄 맵 생성
		map = new int[computerNum+1][computerNum+1];
		
		for(int re = 0; re < connection; re++) {
			int tmpRow = sc.nextInt();
			int tmpCol = sc.nextInt();
			// 맵에 값 입력하기
			// 방향 구분 없으므로 대칭이 되도록 값 대입
			map[tmpRow][tmpCol] = map[tmpCol][tmpRow] = 1;
			
		}
		// 방문 여부 체크해줄 배열
		visit = new boolean[computerNum+1];
		
		sc.close();
	}
	
	static void bfs(int start) {
		input();
		
		Queue<Integer> q = new LinkedList<Integer>();
		// 시작점 큐에 저장
		q.offer(start);
		// 방문 체크
		visit[start] = true;
		
		while(!q.isEmpty()) {
			// 큐가 빌 때까지 실행
			// 큐에 들어있는걸 빼주고
			int tmp = q.poll();
			
			for(int idx = 1; idx <= computerNum; idx++) {
				// 배열을 다 돌면서 확인
				if(map[tmp][idx] == 1 && visit[idx] == false) {
					// 큐에서 뺀 값과 연결되어 있고 방문하지 않은 점이면
					// 큐에 넣어주고
					q.offer(idx);
					// 방문 체크
					visit[idx] = true;
					// 카운트도 세줌
					cnt++;
				}
			}
		}
		// 다 끝나면 출력
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		bfs(1);
	}
}