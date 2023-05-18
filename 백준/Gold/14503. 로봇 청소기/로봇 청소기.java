import java.util.Scanner;

public class Main {
	static int N, M, direction, cleanCnt; // 방의 크기 N*M, 청소기가 가리키는 방향, 청소한 칸의 개수
	static int[][] map; // 방 정보
	static boolean[][] visited; // 방문 체크
	static int x, y;
	// 델타배열 (북 동 남 서)
	static final int[] delR = { -1, 0, 1, 0 };
	static final int[] delC = { 0, 1, 0, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 방 크기
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 처음 로봇 위치 (행, 열)
		x = sc.nextInt();
		y = sc.nextInt();
		
		direction = sc.nextInt(); // 로봇 방향
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		// 맵 정보 입력받기
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				map[row][col] = sc.nextInt();
			}
		}
		
		sc.close();
		
		cleanCnt = 0; // 청소한 칸 개수 초기화
		
		clean(x, y, direction);
		
		System.out.println(cleanCnt);
	}
	
	// 처음 방향 입력받아야 되네....
	static void clean(int r, int c, int dr) {
		cleanCnt++;
		
		visited[r][c] = true;
		
		while(true) {
			// 주변에 청소 가능한 곳 있는지 체크할 불리안
			boolean flag = false;
			for(int i = 0; i < 4; i++) {
				int nr = r + delR[i];
				int nc = c + delC[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
					// 배열 범위 넘어가면 넘기기
					continue;
				}
				
				if(!visited[nr][nc] && map[nr][nc] == 0) { // 방문 안했고 청소되지 않은 곳이 존재하면
					// flag true로 바꾸고 탐색 멈추기
					flag = true;
					break;
				}
			}
			
			// 동서남북 방향 (북 0-> 서3 -> 남2 -> 동1)로 회전
			if(flag) { // 청소 가능한 곳 있으면
				dr = (dr+3) % 4; // 반시계방향으로 회전
				
				// 현재 보고 있는 방향으로 탐색
				int nr = r + delR[dr];
				int nc = c + delC[dr];
				
				if(!visited[nr][nc] && map[nr][nc] == 0) { // 청소 안 했고 벽이 아니면
					visited[nr][nc] = true; // 방문처리 (청소)
					// 그 방향으로 전진
					r += delR[dr];
					c += delC[dr];
					cleanCnt++; // 청소 횟수 카운팅
				}
			} else { // 청소 가능한 곳 없으면
				// 한칸 후진
				r -= delR[dr];
				c -= delC[dr];
				if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 1) {
					// 만약 후진이 불가능한 곳이면 작동 멈추기
					break;
				}
				if(!visited[r][c]) { // 후진 가능한 곳인데 청소 안되어 있으면
					cleanCnt++; // 청소 횟수 카운팅
					visited[r][c] = true; // 방문처리
				}
			}
		}
	}
}