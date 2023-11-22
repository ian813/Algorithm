import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 평면 정보
		int[][] plane = new int[101][101];

		// 반복할 횟수
		int re = 4;

		while (re-- > 0) {
			// 꼭지점 2개 입력받기
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			// 입력받은 좌표의 면적내에서 반복
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					// 0이 아니면 넘기고 0이면 카운팅
					if (plane[i][j] != 0)
						continue;
					plane[i][j]++;
				}
			}
		}

		// 면적의 합
		int sum = 0;

		// 면적 합 구하기
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				sum += plane[i][j];
			}
		}

		System.out.println(sum);
	}
}