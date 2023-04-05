import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N, cnt; // 가로, 세로, 안익은 토마토 개수
	static int[][] map;
	static int day;
	// 델타배열 (상하좌우)
	static int[] delR = {-1, 1, 0, 0};
	static int[] delC = {0, 0, -1, 1};
	static Queue<Point> queue = new LinkedList<>();
	
	// 포인트 클래스 생성
	static class Point {
		int x, y, n;
		
		Point(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[N][M];
		
		cnt = 0;
		// 맵 정보 입력받기
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				map[row][col] = sc.nextInt();
				
				// 익은 토마토는 바로바로 큐에 넣어준다.
				if(map[row][col] == 1) {
					queue.add(new Point(row, col, 0));
				} else if(map[row][col] == 0) {
					// 안 익은 토마토 개수를 세준다.
					cnt++;
				}
				
			}
		}
		sc.close();
	}
	
	static void search() {
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int row = temp.x; // 익은 토마토의 행
			int col = temp.y; // 익은 토마토의 열
			int num = temp.n; // 며칠쨰에 익은 토마토가 되었는지 담아줄 변수
			
			for(int dr = 0; dr < 4; dr++) {
				// 델타배열로 바로 주위 토마토 탐색
				int newR = row + delR[dr];
				int newC = col + delC[dr];
				
				// 배열 범위 넘어가면 다음 방향 탐색
				if(newR < 0 || newC < 0 || newR >= N || newC >= M) {
					continue;
				}
				
				if(map[newR][newC] == 0) {
					// 안익은 토마토 찾으면
					// 안익은 토마토 개수 감소 후 익은 토마토로 바꿔 표시
					cnt--;
					map[newR][newC] = 1;
					// 큐에 넣어주기 (날짜는 지금 날짜 +1해서 넣어주기)
					queue.add(new Point(newR, newC, num+1));
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
