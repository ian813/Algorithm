import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, K, cnt, max; // 세로 가로 길이, 음식물 개수, 인접한 음식물 개수, 최댓값
	static int[][] map; // 음식물 정보
	static boolean[][] visited; // 방문체크
	// 델타배열 (상하좌우)
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	// 포인트 클래스 생성
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N+1][M+1]; // 좌표값 맞춰주기 위해
		
		for(int trash = 0; trash < K; trash++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			map[row][col]++;
			
		}
		// 방문체크
		visited = new boolean[N+1][M+1];
		
		sc.close();
	}
	
	static void BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(r, c));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			cnt++; // 뽑을 때 마다 개수 세주기
			
			for(int d = 0; d < 4; d++) {
				// 현재 위치에서 델타배열로 탐색
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr < 1 || nc < 1 || nr > N || nc > M) continue; // 배열범위 넘어가면 넘어감
				
				if(map[nr][nc] == 1 && !visited[nr][nc]) { // 탐색한 곳에 음식물이 있고 방문 안했으면
					visited[nr][nc] = true; // 방문체크
					queue.add(new Point(nr, nc)); // 큐에 넣어주기
				}
				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		input();
		max = 0;
		
		for(int row = 1; row <= N; row++) {
			for(int col = 1; col <= M; col++) {
				if(map[row][col] == 1 && !visited[row][col]) {
					cnt = 0; // 개수 세는 거 초기화
					visited[row][col] = true; // 방문체크
					BFS(row, col);
					max = Math.max(max, cnt); // 최대값 갱신
				}
			}
		}
		
		System.out.println(max);
		
	}
}