import java.util.Scanner;

public class Main {

	private static final int Quarter = 25;
	private static final int Dime = 10;
	private static final int Nickel = 5;
	private static final int Penny = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 개수
		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (testCase-- > 0) {
			// 각 테스트케이스에 대해 거스름돈 입력받기
			int cost = sc.nextInt();

			// 쿼터, 다임, 니켈, 페니의 개수를 나타낼 변수
			int cntQ = 0;
			int cntD = 0;
			int cntN = 0;
			int cntP = 0;

			// 쿼터부터 개수 구해주기
			cntQ = cost / Quarter;
			cost = cost % Quarter;

			cntD = cost / Dime;
			cost = cost % Dime;

			cntN = cost / Nickel;

			// 남은 건 모두 페니로 지불해야하므로
			cntP = cost % Nickel;

			// 개수들 저장
			sb.append(cntQ).append(" ").append(cntD).append(" ").append(cntN).append(" ").append(cntP).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}