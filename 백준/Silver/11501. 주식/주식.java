import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		// 테케만큼 반복
		for (int tc = 1; tc <= testCase; tc++) {

			// 일 수
			int days = sc.nextInt();

			// 주식 정보 입력받기
			int[] stocks = new int[days];

			for (int i = 0; i < days; i++) {
				stocks[i] = sc.nextInt();
			}

			// 현재 기준 가격 저장
			int curPrice = stocks[days - 1];
			// 이익
			long benefit = 0;

			// 끝부분부터 탐색
			for (int i = days - 2; i >= 0; i--) {
				if (curPrice > stocks[i]) {
					// 현재 기준 가격보다 작으면 판매할 수 있으므로 이익 계산
					benefit += curPrice - stocks[i];
				} else {
					// 아니면 현재 기준 가격을 업데이트
					curPrice = stocks[i];
				}
			}
			sb.append(benefit).append("\n");
		}
		System.out.println(sb);
	}
}