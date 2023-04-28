import java.util.Scanner;

public class Main {
	static int N, M, cnt; // 행렬의 크기, 연산 세줄 변수
	static int[][] A, B; // 행렬들
	static boolean check; // 마지막에 두 행렬이 같은지 체크해줄 불리안
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		A = new int[N][M];
		B = new int[N][M];
		
		// 행렬에 정보 입력하기
		for(int row = 0; row < N; row++) {
			String tmp = sc.next();
			for(int col = 0; col < M; col++) {
				A[row][col] = tmp.charAt(col) - '0';
			}
		}
		
		for(int row = 0; row < N; row++) {
			String tmp = sc.next();
			for(int col = 0; col < M; col++) {
				B[row][col] = tmp.charAt(col) - '0';
			}
		}
		
		sc.close();
		// 리버스 연산이 몇번 수행되었는지 세줄 변수 초기화
		cnt = 0;
		
		// 체크 불리안 초기화
		check = true;
	}
	
	static void search() {
		// 배열을 돌면서 값이 다르면 reverse 메서드 수행
		for(int i = 0; i < N-2; i++) {
			for(int j = 0; j < M-2; j++) {
				if(A[i][j] != B[i][j]) {
					reverse(i, j);
					cnt++;
				}
			}
		}
		
		// 리버스 연산이 끝났으면 두 행렬 비교해서 다르면 check를 false로 바꾸고 멈추기
		x: for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				if(A[row][col] != B[row][col]) {
					check = false;
					break x;
				}
			}
		}
		
	}
	
	static void reverse(int r, int c) {
		// A행렬에 값이 1이면 0으로 0이면 1로 바꿔주는 메서드
		for(int row = r; row < r+3; row++) {
			for(int col = c; col < c+3; col++) {
				if(A[row][col] == 1) {
					A[row][col] = 0;
				} else {
					A[row][col] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		search();
		
		// 체크가 true면 cnt출력, 아니면 -1 출력
		if(check) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
		
	}
}