import java.util.Scanner;

public class Main {
	static int N, horizon, vertical;
	static char[][] map;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 방 크기
		N = sc.nextInt();
		map = new char[N][N];
		
		// 정보 입력받기
		for(int row = 0; row < N; row++) {
			String str = sc.next();
			for(int col = 0; col < N; col++) {
				map[row][col] = str.charAt(col);
			}
		}
		
		// 가로 세로 누울 자리 저장할 변수
		horizon = 0;
		vertical = 0;
		sc.close();
	}
	
	static void solve() {
		// 가로 누울 자리 찾기
		for(int row = 0; row < N; row++) {
			// 비어있는 칸 세줄 변수
			int cnt = 0;
			for(int col = 0; col < N; col++) {
				if(map[row][col] == '.') {
					// 비어있으면 카운트
					cnt++;
				} else {
					// 비어있지 않으면 카운트 초기화
					cnt = 0;
				}
				if(cnt == 2) {
					// 비어있는 칸 수가 2이면 누울자리 카운트
					horizon++;
				}
			}
		}
		
		// 세로 누울 자리 찾기
		for(int col = 0; col < N; col++) {
			// 비어있는 칸 세줄 변수
			int cnt = 0;
			for(int row = 0; row < N; row++) {
				if(map[row][col] == '.') {
					// 비어있으면 카운트
					cnt++;
				} else {
					// 비어있지 않으면 카운트 초기화
					cnt = 0;
				}
				if(cnt == 2) {
					// 비어있는 칸 수가 2이면 누울자리 카운트
					vertical++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		solve();
		System.out.println(horizon + " " + vertical);
	}
}