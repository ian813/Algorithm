import java.util.Scanner;

public class Solution {
	static int testCase;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		// 테스트케이스만큼 실행
		for(int tc = 1; tc <= testCase; tc++) {
			
			// N, M값 입력받기
			N = sc.nextInt();
			M = sc.nextInt();
			
			// 그 크기만큼 배열 생성
			char[][] russiaFlag = new char[N][M];
			
			// 배열에 값 입력받기
			for(int row = 0; row < N; row++) {
				String tmpStr = sc.next();
				for(int col = 0; col < M; col++) {
					russiaFlag[row][col] = tmpStr.charAt(col);
					
				}
			}
			
			// 임시로 색 개수를 받을 변수
			int tmpCnt = 0;
			
			// 파란색으로 칠한 인덱스의 위치
			int blueIdx = 1;
			// 파란색으로 칠한 줄의 개수
			int blueLength = 1;
			
			// 임시 최소값을 저장할 변수
			int min = N*M;
			
			// 나머지 부분을 탐색하여 색을 칠해보자.
			// 그중 최솟값을 구하는게 목적
			while(blueIdx != N-1) {
				// 파란색 위치가 나오기 전까지는 흰색으로 칠해줘야한다.
				// 그때의 개수 세주기
				for(int wIdx = 0; wIdx < blueIdx; wIdx ++) {
					for(int col = 0; col < M; col++) {
						if(russiaFlag[wIdx][col] != 'W') {
							tmpCnt++;
						}
					}
				}
				
				// 파란색 위치가 나오면 파란색 줄의 길이만큼 파란색으로 칠해줘야 한다.
				// 그 때의 개수 세주기
				for(int bIdx = blueIdx; bIdx < blueIdx + blueLength; bIdx++) {
					for(int col = 0; col < M; col++) {
						if(russiaFlag[bIdx][col] != 'B') {
							tmpCnt++;
						}
						
					}
				}
				
				// 파란색 칠하는게 끝나면 그 뒤로는 빨간색으로 칠해줘야 한다.
				// 그때의 개수 세주기
				for(int rIdx = blueIdx + blueLength; rIdx < N; rIdx++) {
					for(int col = 0; col < M; col++) {
						if(russiaFlag[rIdx][col] != 'R') {
							tmpCnt++;
						}
					}
				}
				
				// 한번 시행이 끝나면 최솟값 갱신
				if(tmpCnt < min) {
					min = tmpCnt;
				}
				
				// tmpCnt 다시 0으로 초기화
				tmpCnt = 0;
				
				// 만약 blueIdx + blueLength가 N-1보다 작으면
				// 파란색 줄의 개수를 늘려주기
				if(blueIdx + blueLength < N-1) {
					blueLength++;
				} else {
					// 만약 범위를 넘어가면
					// 파란색 길이를 1로 초기화하고
					// 파란색의 시작위치를 1칸 늘려줘서
					// 다시 탐색한다.
					blueLength = 1;
					blueIdx++;
				}

			}

			System.out.printf("#%d %d\n", tc, min);
		}
	}
}