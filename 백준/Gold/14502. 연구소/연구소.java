import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, safe;
	static int[][] map, copyMap; // 맵과 카피맵
	// 델타배열
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		copyMap = new int[N][M];
		
		// 맵 정보 받기
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				map[row][col] = sc.nextInt();
				copyMap[row][col] = map[row][col];
			}
		}
		
		sc.close();
	}
	
	static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		
		// 바이러스 있는 곳 전부 큐에 넣어주기
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(map[row][col] == 2) {
					queue.add(new int[] {row, col});
				}
			}
		}
		
		
		while(!queue.isEmpty()) {
			// 큐에서 값 뺴내고
			int[] temp = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				// 델타배열로 탐색
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				// 배열 범위 넘어가면 지나감
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

				
				if(map[nr][nc] == 0) {
					// 빈칸이면 바이러스 감염시켜주고
					map[nr][nc] = 2;
					// 큐에 넣어줌
					queue.add(new int[] {nr, nc});
				} else continue;
			}
			
		}
	}
	
	static void DFS(int depth) {
		if(depth == 3) {
			// 벽 3개 설치 끝났으면 BFS로 탐색
			BFS();
			// 안전구역 값 갱신
			safeZone();
			// 맵 다시 복구 (벽은 설치된 상태로 빈칸을 바이러스로 바꾼 부분만 복구)
			restoreMap();
			return;
		}
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(map[row][col] == 0) {
					// 빈칸이면 벽 설치 (카피맵도 같이 갱신)
					map[row][col] = 1;
					copyMap[row][col] = 1;
					DFS(depth+1); // 재귀 호출
					// 벽 원상복구 (카피맵도 같이 갱신)
					map[row][col] = 0;
					copyMap[row][col] = 0;

				}
			}
		}		
	}
	
	// 맵을 원상복구해줄 메서드
	static void restoreMap() {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				map[row][col] = copyMap[row][col];
			}
		}
	}
	
	// 안전구역 개수 세줄 메서드
	static void safeZone() {
		int temp = 0;
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(map[row][col] == 0) {
					temp++;
				}
			}
		}
		safe = Math.max(safe, temp);
	}
	
	public static void main(String[] args) {
		safe = 0;
		input();
		DFS(0);
		System.out.println(safe);
	}
}