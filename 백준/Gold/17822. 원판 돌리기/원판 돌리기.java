import java.util.Scanner;

public class Main {
	static int N, M, T, ans;
	static int[][] circle, rotate;
	static final int clock = 0;
	// 델타배열 (상하좌우)
	static int[] delR = { -1, 1, 0, 0 };
	static int[] delC = { 0, 0, -1, 1 };
	static int[] copyCircle; // 임시로 복사해줄 배열
	static boolean[][] check; // 인접한 수가 같은지 판단할 불리안
	
	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 원판 개수
		M = sc.nextInt(); // 한 원판에 적힌 숫자 개수
		T = sc.nextInt(); // 회전 횟수
		ans = 0; // 마지막에 원판에 적힌 합을 구할 변수
		
		circle = new int[N][M];

		// 원판에 점수 적어넣기
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				circle[row][col] = sc.nextInt();
			}
		}
		
		rotate = new int[T][3];

		// 회전 정보 입력받기
		for (int row = 0; row < T; row++) {
			for (int col = 0; col < 3; col++) {
				rotate[row][col] = sc.nextInt();
			}
		}
		
		copyCircle = new int[M];

		sc.close();
	}

	static void solve() {
		for (int idx = 0; idx < T; idx++) {
			for (int row = 0; row < N; row++) {
				if ((row + 1) % rotate[idx][0] == 0) {
					if (rotate[idx][1] == clock) {
						for (int col = 0; col < M; col++) { // 시계방향 회전한 값을 복사
							copyCircle[(col + rotate[idx][2]) % M] = circle[row][col];
						}
					} else { // 반시계방향으로 회전한 값을 복사
						for (int col = 0; col < M; col++) {
							copyCircle[(col + M - rotate[idx][2]) % M] = circle[row][col];
						}
					}
					// 복사해둔 걸 원래 원판에 넣어주기
					for(int col = 0; col < M; col++) {
						circle[row][col] = copyCircle[col];
					}
				}
				
			}
			
			check = new boolean[N][M]; // 회전이 한번 끝나면 초기화
			// 인접한 수가 있는지 세줄 변수
			int cnt = 0;
			for(int row = 0; row < N; row++) {
				// 회전이 다 끝나면 인접한 수가 같은지 판단해서 지워보자.
				for(int col = 0; col < M; col++) {
					for(int dr = 0; dr < 4; dr++) {
						int nr = row + delR[dr]; // row방향은 바로 옆에 붙어있는 것만 인접
						int nc = (col + delC[dr]) % M; // col방향은 양끝점끼리도 인접하다고 봐야..
						if(nr < 0 || nr >= N) continue; // row는 배열 범위 넘어가면 넘기고
						
						if(nc == -1) { // col은 배열 범위 넘어가면 조정해서 판단
							nc = M-1;
						}
						// 인접한 것까리 0이 아닌데 같으면
						if(circle[row][col] != 0 && circle[nr][nc] != 0 && circle[row][col] == circle[nr][nc]) {
							// 체크해주고, 카운트도 세줌
							check[nr][nc] = true;
							check[row][col] = true;
							cnt++;
						}
						
					}
				}				
			}
			double sum = 0; // 합을 구할 변수
			double num = 0; // 숫자 개수를 세줄 변수
			double avg = 0; // 평균을 저장할 변수
			if(cnt != 0) {
				// 인접한 수가 같은 경우가 존재하면
				for(int row = 0; row < N; row++) {
					for(int col = 0; col < M; col++) {
						if(check[row][col]) {
							// 체크해준 곳을 다 0으로 바꾸기
							circle[row][col] = 0;
						}
					}
				}
			} else {
				// 인접한 수가 같은 경우가 존재하지 않으면
				for(int row = 0; row < N; row++) {
					for(int col = 0; col < M; col++) {
						sum += circle[row][col]; // 합을 구하고
						if(circle[row][col] != 0) {
							num++; // 숫자 개수를 구해서
						}
					}
				}
				avg = sum / num; // 평균을 구해주고
				
				for(int row = 0; row < N; row++) {
					for(int col = 0; col < M; col++) {
						if(circle[row][col] != 0) {
							if(avg > circle[row][col]) { // 평균보다 작으면 +1
								circle[row][col]++;
							} else if(avg < circle[row][col]) { // 평균보다 크면 -1
								circle[row][col]--;
							}
						}
					}
				}
			}
		}

	}
	
	// 합 구해주기
	static void sum() {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				ans += circle[row][col];
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		solve();
		sum();
		System.out.println(ans);
	}
}
