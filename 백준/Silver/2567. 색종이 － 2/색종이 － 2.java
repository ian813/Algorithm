import java.util.Scanner;

public class Main {
	// 정사각형 개수, 시작 위치를 담을 변수
	static int rectangularNum;

	static int startX;

	static int startY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정사각형 개수를 입력받기
		rectangularNum = sc.nextInt();

		// 100*100 평면 생성
		int[][] plane = new int[100][100];

		// 시작 위치 입력받기
		for (int num = 0; num < rectangularNum; num++) {
			startX = sc.nextInt();
			startY = sc.nextInt();

			// 각각의 정사각형 영역에 1을 채워넣자.
			for (int x = startX; x < startX + 10; x++) {
				for (int y = startY; y < startY + 10; y++) {
					plane[x][y] = 1;

				}

			}

		}
		// 델타배열 상,하,좌,우 방향
		int[] deltaRow = { -1, 1, 0, 0 };
		int[] deltaCol = { 0, 0, -1, 1 };

		// 둘레를 저장할 변수
		int result = 0;

		// 배열 탐색
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				// 각 위치에서 1인 위치를 찾아준다.
				if (plane[x][y] == 1) {
					// 만약 1이면
					for (int direction = 0; direction < deltaRow.length; direction++) {
						// 상하좌우 탐색
						int newRow = x + deltaCol[direction];
						int newCol = y + deltaRow[direction];

						if (newRow < 0 || newRow >= 100 || newCol < 0 || newCol >= 100) {
							// 탐색하려는 위치가 배열 범위 밖이면
							// 둘레의 길이를 1씩 더해준다.
							result++;
						} else if(plane[newRow][newCol] == 0) {
							// 탐색하려는 위치가 배열 범위 안이고
							// 그 위치의 값이 0이면
							// 둘레의 길이를 1씩 더해준다.
							result++;
						}

					}
				}

			}

		}

		System.out.println(result);

	}
}