
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int width, height, landCnt; // 너비, 높이, 섬 개수
	static int[][] map; // 맵
	static boolean[][] visited; // 방문체크
	// 델타배열 (상하좌우, 좌상, 우상, 좌하, 우하 방향)
	static final int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static final int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	
	// 포인트 클래스
	static class Point {
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 계속 실행할지 판단할 불리안
		boolean flag = true;
		while(flag) {
			// 너비, 높이 입력받기
			width = sc.nextInt();
			height = sc.nextInt();
			if(width == 0 && height == 0) {
				// 둘 다 0이면 멈추기
				flag = false;
				continue;
			}
			map = new int[height][width];
			visited = new boolean[height][width];
			
			// 맵 정보 입력받기
			for(int row = 0; row < height; row++) {
				for(int col = 0; col < width; col++) {
					map[row][col] = sc.nextInt();
				}
			}
			// 섬개수 세줄 변수
			landCnt = 0;
			
			// 배열 돌면서 체크
			for(int row = 0; row < height; row++) {
				for(int col = 0; col < width; col++) {
					if(!visited[row][col] && map[row][col] == 1) {
						// 방문 안했고 땅이면 방문체크하고 탐색
						visited[row][col] = true;
						BFS(row, col);
						landCnt++; // 탐색 끝나면 섬개수 카운팅
					}
				}
			}
			// 섬개수 출력
			System.out.println(landCnt);
		}
		sc.close();
	}
	
	static void BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(r, c));
		
		while(!queue.isEmpty()) {
			// 현재 위치 뽑아주기
			Point cur = queue.poll();
			
			// 델타배열 돌면서 탐색
			for(int i = 0; i < 8; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr < 0 || nr >= height || nc < 0 || nc >= width) continue; // 배열범위 넘어가면 넘기기
				
				if(visited[nr][nc] || map[nr][nc] != 1) continue; // 방문한 곳이거나 땅이 아니면 넘기기
				
				// 두 조건 다 통과하면 갈 수 있는 곳
				visited[nr][nc] = true; // 방문체크
				queue.add(new Point(nr, nc)); // 큐에 담아주기
			}
		}
	}
}
