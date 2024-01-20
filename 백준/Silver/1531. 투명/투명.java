import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 그림 정보
		int[][] picture = new int[101][101];

		// 종이 개수와 그림이 숨겨지는 기준
		int paper = sc.nextInt();
		int hide = sc.nextInt();

		// 보이지 않는 그림의 개수
		int cnt = 0;

		while (paper-- > 0) {
			// 종이 정보 입력받아서
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			// 그림 가리기
			for (int y = y1; y <= y2; y++) {
				for (int x = x1; x <= x2; x++) {
					picture[y][x]++;
				}
			}
		}

		// 가려진 그림 개수 세기
		for (int y = 1; y <= 100; y++) {
			for (int x = 1; x <= 100; x++) {
				if (picture[y][x] > hide) {
					cnt++;
				}
			}
		}

		// 출력
		System.out.println(cnt);
	}
}