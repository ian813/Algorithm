import java.util.Scanner;

public class Main {

	// A, B, C 버튼 눌렀을 때 시간
	private static final int A = 300;
	private static final int B = 60;
	private static final int C = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 목표 시간
		int time = sc.nextInt();

		// A, B, C 버튼 누른 횟수
		int cntA = 0;
		int cntB = 0;
		int cntC = 0;

		// C로 나눠지지 않으면 시간을 맞출 수 없으므로 -1 출력하고 끝내기
		if (time % C != 0) {
			System.out.println(-1);
			return;
		}

		// 버튼 눌러주기
		// A로 나눴을 때 몫만큼 눌러주고 나머지로 시간 초기화
		cntA = time / A;
		time = time % A;

		// B, C도 마찬가지
		cntB = time / B;
		time = time % B;

		cntC = time / C;

		System.out.println(cntA + " " + cntB + " " + cntC);
	}
}