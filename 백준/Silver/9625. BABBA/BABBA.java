import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 버튼 누르는 횟수
		int K = sc.nextInt();

		// A, B의 개수 초기값
		int cntA = 1;
		int cntB = 0;

		while (K-- > 0) {
			// K번 반복

			// A의 개수는 버튼 누르기 전 B의 개수와 같고
			// B의 개수는 버튼 누르기 전 B의 개수 + 버튼 누르기 전 A의 개수와 같다.
			int prevA = cntA;
			cntA = cntB;
			cntB += prevA;
		}

		// 출력
		System.out.println(cntA + " " + cntB);
	}
}