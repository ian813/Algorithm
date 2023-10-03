import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자카드 개수
		int N = sc.nextInt();
		// 가지고 있는 카드 정보
		boolean[][] card = new boolean[2][10000001];

		for (int i = 0; i < N; i++) {
			int cur = sc.nextInt();
			if (cur >= 0) {
				// 숫자가 0이상인 건 1행에 해당 열에 저장
				card[1][cur] = true;
			} else {
				// 숫자가 0미만인 건 2행에 해당 열에 저장
				card[0][-cur] = true;
			}
		}

		// 주어지는 숫자카드 개수
		int M = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (M-- > 0) {
			// 비교할 숫자카드
			int compare = sc.nextInt();
			if (compare >= 0 && card[1][compare]) {
				// 0이상이고 1행에 가지고 있으면 1 담기
				sb.append(1).append(" ");
			} else if (compare < 0 && card[0][-compare]) {
				// 0미만이고 0행에 가지고 있으면 1 담기
				sb.append(1).append(" ");
			} else {
				// 아니면 0 담기
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
}