import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// sheep, wolf : 한 영역에 있는 양, 늑대, finalSheep, finalWolf : 끝까지 살아남은 양, 늑대
	static int R, C, sheep, wolf, finalSheep, finalWolf;
	static char[][] map;
	static boolean[][] visited;
	// 델타배열로 탐색 (상하좌우)
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	static class Point{
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 맵의 행, 열
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		
		// 맵 정보 입력받기
		for(int row = 0; row < R; row++) {
			String str = sc.next();
			for(int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col);
			}
		}
		sc.close();
		
		visited = new boolean[R][C]; // 방문체크
		
		// 마리수 초기화
		finalSheep = 0;
		finalWolf = 0;
		
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) {
				if(!visited[row][col] && map[row][col] != '#') {
					// 방문 안헀고, 울타리가 아니면
					visited[row][col] = true; // 방문체크 해주고
					// 늑대, 양 마리수 초기화 해주고
					sheep = 0;
					wolf= 0;
					if(map[row][col] == 'o') {
						sheep++;
					} else if(map[row][col] == 'v') {
						wolf++;
					}
					BFS(row, col); // 탐색 시작
				}
			}
		}
		System.out.println(finalSheep + " " + finalWolf);
	}
	
	static void BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		
		// 탐색 시작점 넣어주기
		queue.add(new Point(r, c));
		
		while(!queue.isEmpty()) { // 큐가 빌 때까지 실행
			// 현재위치 뽑아주기
			Point cur = queue.poll();
			
			// 델타배열로 탐색
			for(int i = 0; i < 4; i++) {
				// 탐색한 지점
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue; // 배열범위 넘어가면 넘어감
				
				if(visited[nr][nc] || map[nr][nc] == '#' ) continue; // 방문한 지점이거나 울타리면 넘어감
				
				// 다 통과하면 방문 가능
				visited[nr][nc] = true; // 방문체크
				if(map[nr][nc] == 'o') {
					sheep++;
				} else if(map[nr][nc] == 'v') {
					wolf++;
				}
				queue.add(new Point(nr, nc)); // 탐색지점 큐에 넣어주기
			}
			
		}
		
		// 탐색 끝나면 양, 늑대 수 비교
		if(sheep > wolf) { // 양이 더 많으면 양이 살아남으므로
			finalSheep += sheep; // 최종 양의 수에 현재 영역 양의 수 더해주기
		} else { // 반대면 늑대가 살아남고
			finalWolf += wolf; // 최종 늑대 수에 현재 영역 늑대 수 더해주기
		}
		
	}
}