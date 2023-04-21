import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();
	static int l;
	static Point[] info;
	// 델타배열로 탐색
	static final int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static final int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	static boolean[][] visited; // 방문체크
	
	// 위치를 저장할 포인트 클래스
	static class Point {
		int x, y, cnt;
		
		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static void input() {
		// 체스판 크기
		l = sc.nextInt();
		
		info = new Point[2];
		
		// 시작점 끝점 입력받기
		for(int idx = 0; idx < 2; idx++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			Point p = new Point(r, c, 0);
			
			info[idx] = p;
		}
		
		visited = new boolean[l][l];
		
		// 시작점 미리 방문체크
		visited[info[0].x][info[0].y] = true;
	}
	
	// bfs로 탐색.. 나이트 갈 위치를 델타배열로 만들어주고 탐색해보자... 탐색 가능하면(맵 범위를 안 벗아나면) 큐에 넣어주고
	// 그때마다 카운트해서 도착하면 멈추고 카운트한 값 출력.. 카운트 값도 포인트 클래스에 넣어줬으니
	// 탐색할때마다 플러스 해주면 됨.
	static void move() {
		Queue<Point> queue = new LinkedList<>();
		// 시작점 넣어주기
		queue.add(info[0]);
		
		while(!queue.isEmpty()) { // 큐가 빌 때까지 진행
			//
			Point temp = queue.poll();
			
			if(temp.x == info[1].x && temp.y == info[1].y) {
				// 도착점에 도착하면 카운트 저장해주고 중지
				info[1].cnt = temp.cnt;
				break;
			}
			
			for(int i = 0; i < 8; i++) {
				// 델타배열로 탐색
				int nr = temp.x + dr[i];
				int nc = temp.y + dc[i];
				// 범위 넘어가면 넘어감
				if(nr < 0 || nc < 0 || nr >= l || nc >= l) continue;
				
				// 방문한 곳도 넘어감
				if(visited[nr][nc]) continue;
				
				// 둘 다 아니면 방문체크하고 큐에 넣어줌 (이동횟수는 +1 해준다.)
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc, temp.cnt+1));
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) { // 테캐만큼 진행
			input();
			move();
			
			sb.append(info[1].cnt + "\n");
		}
		System.out.println(sb);
	}
}