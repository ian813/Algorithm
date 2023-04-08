import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N, H, cnt; // 가로, 세로, 쌓은 상자 수, 안익은 토마토 개수
	static int[][][] map;
	static int day;
	// 델타배열
	static int[] delX = {0, 0, -1, 1, 0, 0};
	static int[] delY = {-1, 1, 0, 0, 0, 0};
	static int[] delZ = {0, 0, 0, 0, -1, 1};
	static Queue<Point> queue = new LinkedList<>();
	
	// 포인트 클래스 생성
	static class Point {
		int x, y, z, n;
		
		Point(int x, int y, int z, int n) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.n = n;
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		
		map = new int[H][N][M];
		
		cnt = 0;
		// 맵 정보 입력받기
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					map[i][j][k] = sc.nextInt();
					
					// 익은 토마토는 바로바로 큐에 넣어준다.
					if(map[i][j][k] == 1) {
						queue.add(new Point(i, j, k, 0));
					} else if(map[i][j][k] == 0) {
						// 안 익은 토마토 개수를 세준다.
						cnt++;
					}
					
				}
			}			
		}
		sc.close();
	}
	
	static void search() {
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int i = temp.x; // 익은 토마토의 가로
			int j = temp.y; // 익은 토마토의 세로
			int k = temp.z; // 익은 토마토 높이
			int num = temp.n; // 며칠쨰에 익은 토마토가 되었는지 담아줄 변수
			
			for(int dr = 0; dr < 6; dr++) {
				// 델타배열로 바로 주위 토마토 탐색
				int newI = i + delX[dr];
				int newJ = j + delY[dr];
				int newK = k + delZ[dr];
				
				// 배열 범위 넘어가면 다음 방향 탐색
				if(newI < 0 || newJ < 0 || newI >= H || newJ >= N || newK < 0 || newK >= M) {
					continue;
				}
				
				if(map[newI][newJ][newK] == 0) {
					// 안익은 토마토 찾으면
					// 안익은 토마토 개수 감소 후 익은 토마토로 바꿔 표시
					cnt--;
					map[newI][newJ][newK] = 1;
					// 큐에 넣어주기 (날짜는 지금 날짜 +1해서 넣어주기)
					queue.add(new Point(newI, newJ, newK, num+1));
				} else {
					// 토마토가 없거나 익은 토마토면 그냥 넘기기
					continue;
				}
			}
			// 탐색을 마치고 맨 마지막에 빠지는 토마토의 num이 최종 날짜가 된다.
			day = num;
		}
	}
	
	public static void main(String[] args) {
		input();
		// day값 초기화
		day = 0;
		if(cnt != 0) {
			// 안 익은 토마토가 있을 때 탐색 실행
			search();
		}
		// 다 탐색했는데 안 익은 토마토가 남아있으면..
		// 변경
		if(cnt != 0) {
			day = -1;
		}
		System.out.println(day);
	}
}
