import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] maze;
	static int[][] dist;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 미로의 크기
		N = sc.nextInt();
		M = sc.nextInt();
		// 미로 정보 담을 배열
		maze = new int[N][M];
		// 거리 계산해줄 배열
		dist = new int[N][M];
		
		for(int row = 0; row < N; row++) {
			String str = sc.next();
			for(int col = 0; col < M; col++) {
				maze[row][col] = str.charAt(col) - '0';
				// 거리값들 전부 초기화
				dist[row][col] = -1;
			}
		}
	}
	
	static void bfs(int x, int y) {
		input();
		
		Queue<Location> q = new LinkedList<>();
		// 초기 위치 배열에 넣어주기
		q.offer(new Location(0, 0));
		// 초기 위치의 거리 갱신
		dist[x][y] = 0;
		
		// 상하좌우 탐색할 델타배열
		int[] deltaRow = {-1, 1, 0, 0};
		int[] deltaCol = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			// 큐가 빌때까지 실행
			// 큐에서 뽑아낸 값을 lc에 저장
			Location lc = q.poll();
			
			for(int dr = 0; dr < deltaRow.length; dr++) {
				// 델타배열을 이용해 탐색
				int newX = lc.x + deltaRow[dr];
				int newY = lc.y + deltaCol[dr];
				
				// 미로 범위 벗어나면 지나감
				if(newX < 0 || newY < 0 || newX >= N || newY >= M) {
					continue;
				}
				
				// 길이 아닌 곳으로 가거나 방문을 헀다면 지나감
				if(maze[newX][newY] == 0 || dist[newX][newY] != -1) {
					continue;
				}
				
				// 큐에 이동한 좌표 넣어주기
				q.offer(new Location(newX, newY));
				
				// 이동한 지점에 거리 갱신
				dist[newX][newY] = dist[lc.x][lc.y] + 1;
			}
			
		}
		// 마지막 지점의 거리 + 1을 해줘야 지나온 칸 수가 되므로,,
		System.out.println(dist[N-1][M-1] + 1);
			
	}
	
	// 위치를 나타낼 좌표
	static class Location {
		int x;
		int y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		bfs(0, 0);
	}
	
}