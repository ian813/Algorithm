import java.util.Scanner;

public class Main {
	static int paperNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 종이 개수 입력받기
		paperNum = sc.nextInt();

		// 시작할 x,y좌표와 너비, 높이 변수
		int startX;
		int startY;
		int horizon;
		int height;

		// 101*101크기의 평면 생성
		int[][] plane = new int[101][101];

		for (int num = 1; num <= paperNum; num++) {
			// 종이 수만큼 반복해서
			// 각 변수들 입력받기
			startX = sc.nextInt();
			startY = sc.nextInt();

			horizon = sc.nextInt();
			height = sc.nextInt();
			
			// 평면에 색종이가 차지하는 범위에 그 색종이의 번호 써놓기
			// 1번 색종이부터 시작해서 2번 색종이랑 겹치면 2로 갱신
			for (int y = startY; y < startY + height; y++) {
				for (int x = startX; x < startX + horizon; x++) {
					plane[x][y] = num;

				}
			}

		}
		
		for (int n = 1; n <= paperNum; n++) {
			// 해당 숫자가 몇 번 나오는지 세줄 변수
			// 매시행마다 초기화
			int cnt = 0;

			for (int row = 0; row < 101; row++) {
				for (int col = 0; col < 101; col++) {
					if (plane[row][col] == n) {
						// 개수 세주기
						cnt++;

					}

				}
			}
			// 출력
			System.out.println(cnt);
		}
	}

}