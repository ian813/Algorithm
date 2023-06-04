import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M, time, cheeseCnt; // 맵의 크기 N, M , 걸리는 시간, 치즈 개수
	static int[][] map; // 맵
	static boolean[][] visited; // 방문체크
	static List<Point> cheese; // 치즈 좌표 담을 배열
	// 델타배열 (상하좌우)
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	// 좌표를 담을 포인트 클래스
	static class Point {
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		cheese = new ArrayList<>();
		
		for(int row = 0; row < N; row++ ) {
			for(int col = 0; col < M; col++ ) {
				map[row][col] = sc.nextInt();
				if(map[row][col] == 1) { // 만약 치즈라면
					cheeseCnt++; // 치즈 개수 카운팅
					cheese.add(new Point(row, col)); // 치즈 좌표 담기
				}
			}
		}
		
		sc.close();
		
		
		time = 0;
		
		while(cheeseCnt > 0) { // 치즈 개수가 0이 될 떄까지 반복
			visited = new boolean[N][M];

			DFS(0, 0); // 외부 공기 찾아주기
			
			melt(); // 치즈 녹이기!
			
			time++; // 시간 늘려주기
		}
		
		System.out.println(time);
	}
	
	static void melt() {
		for(int i = 0; i < cheese.size(); i++) {
			Point pt = cheese.get(i);
			
			int cnt = 0; // 외부 공기와 맞닿는 곳 카운팅
			
			for(int j = 0; j < 4; j++) {
				// 현재 점에서 델타배열로 탐색
				int nr = pt.r + dr[j];
				int nc = pt.c + dc[j];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; // 배열 범위 넘어가면 넘기기
				if(map[nr][nc] == 2) cnt++; // 외부 공기 맞닿으면 카운팅
			}
			if(cnt >= 2) { // 만약 외부공기와 2곳이상 맞닿으면 
				map[pt.r][pt.c] = 0; // 치즈 녹이고
				cheeseCnt--; // 치즈개수 깎기
				cheese.remove(pt); // 현재 치즈를 리스트에서 삭제
				i--; // 점 하나를 없애면 인덱스가 하나씩 줄어들기 때문에 제대로 탐색하려면 하나 깎아줘야 한다.
			}
			
		}
	}
	
	static void DFS(int r, int c) {
		// 현재 점 방문체크
		visited[r][c] = true;
		// 외부 공기로 바꿔주기
		map[r][c] = 2;
		
		// 델타배열로 탐색
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; // 배열 범위 넘어가면 넘기기
			if(visited[nr][nc] || map[nr][nc] == 1) continue; // 방문한 곳이거나 치즈면 넘기기
			
			DFS(nr, nc); // 조건 다 통과하면 재귀 호출
		}
	}
}
