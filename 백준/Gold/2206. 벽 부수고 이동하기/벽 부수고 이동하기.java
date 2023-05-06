import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 방문처리를 하는 visit배열을 3차원 배열로 만들어서 벽을 부순 경우의 방문처리와
 * 벽을 부수지 않은 경우의 방문처리를 동시에 해서 bfs로 가장 빨리 도착한 경우의 거리를 측정해준다.(암튼 빨리 도착하면 된다.)
 */

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int[] dy = { 1, -1, 0, 0 };
	static final int[] dx = { 0, 0, 1, -1 };
	static final int CRASH = 1; // 부순 적이 있으면 1
	static final int NOCRASH = 0; // 없으면 0
	static int n; // y축
	static int m; // x축
	static String[] board; // 맵을 입력받을 배열
	static boolean[][][] visit; // 방문처리를 할 3차원 배열
	
	static class Info { // 큐에 현재 정보를 넣어줄 클래스
		int y;
		int x;
		int dist; // 지금까지 온 누적 거리
		int crash; // 현재 벽을 부순 적이 있는지 없는지 기록
		
		public Info(int y, int x, int dist, int crash) {
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.crash = crash;
		}
		
	}

	static void input() { // 입력 메소드
		n = sc.nextInt();
		m = sc.nextInt();
		board = new String[n];
		for (int i = 0; i < n; i++) {
			board[i] = sc.next();
		}
		visit = new boolean[n][m][2];
	}

	static int moveAndCrash() {
		visit[0][0][NOCRASH] = true; // 처음 위치는 0,0이며 벽을 부순 적이 없으므로 NOCRASH에 방문 처리
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0, 1, NOCRASH)); // 처음 위치도 거리에 포함하므로 누적 거리 1에서 시작
		while (!q.isEmpty()) {
			Info now = q.remove();
			if(now.y == n - 1 && now.x == m - 1) { // n - 1, m - 1이 도착지이기 때문에 누적거리를 리턴해준다.
				return now.dist;
			}
			for(int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) { // 인덱스 벗어나면 안됨
					continue;
				}
				
				/*
				 *  갈 수 있는 경우는 2가지
				 *  1. 벽이 있지만 현재 벽을 부순 적이 없는 경우
				 *  2. 벽이 없는 경우
				 *  두가지 경우 모두 방문 체크도 함께 해준다.
				 */
				
				// 벽이 있고 벽을 부순 적이 없으며 벽을 부수고 방문한 적이 없다면 큐에 이동한 정보를 넣어준다.
				if(board[ny].charAt(nx) == '1' && now.crash == NOCRASH && !visit[ny][nx][CRASH]) {
					q.add(new Info(ny, nx, now.dist + 1, CRASH)); // 누적 거리 + 1, 벽을 부순 것으로 갱신
					visit[ny][nx][CRASH] = true; // 방문 체크
				}
				// 벽이 없고 방문한 적 없는 곳은 내가 벽을 부순 경험이 있는지 없는지와 상관없이 현재 상태를 그대로 기록해준다.
				else if(board[ny].charAt(nx) == '0' && !visit[ny][nx][now.crash]) {
					q.add(new Info(ny, nx, now.dist + 1, now.crash)); // 누적 거리 + 1, 벽 부순 경험 유지
					visit[ny][nx][now.crash] = true; // 방문 체크
				}
			}
		}
		// 만약 도착지로 갈 수 없다면 -1을 리턴
		return -1;
	}

	public static void main(String[] args) {
		input();
		System.out.println(moveAndCrash());
	}
}