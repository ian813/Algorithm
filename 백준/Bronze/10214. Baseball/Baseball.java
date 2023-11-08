import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테케 개수
		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		// 테케만큼 실행
		for (int tc = 1; tc <= testCase; tc++) {

			// 연세대 득점, k대 득점
			int yonsei = 0;
			int k = 0;

			for (int i = 0; i < 9; i++) {
				yonsei += sc.nextInt();
				k += sc.nextInt();
			}

			if (yonsei > k) {
				// 연세가 더 득점했으면 Yonsei 저장
				sb.append("Yonsei").append("\n");
			} else if (yonsei == k) {
				// 동점이면 Draw 저장
				sb.append("Draw").append("\n");
			} else {
				// 아니면 Korea 저장
				sb.append("Korea").append("\n");
			}
		}

		// 출력
		System.out.println(sb);
	}
}