import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		// 연속된 0의 그롭, 연속된 1의 그룹
		int zeroGroup = 0;
		int oneGroup = 0;

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '0') {
				// 0을 만나면 0 그룹 개수 카운팅
				zeroGroup++;

				while (i < S.length() && S.charAt(i) == '0') {
					// i가 문자열 길이보다 작고 연속된 0이 나오지 않을 때까지 반복
					i++;
				}
				// 연산을 다 거치면 for문에서 다시 i++해주므로
				// 한 번 빼줘야된다.
				i--;
			} else {
				// 위와 같은 식으로 구하기
				oneGroup++;

				while (i < S.length() && S.charAt(i) == '1') {
					i++;
				}
				i--;
			}
		}
		// 최솟값 출력
		System.out.println(Math.min(zeroGroup, oneGroup));
	}
}