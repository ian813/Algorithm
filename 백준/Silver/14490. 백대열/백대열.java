import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열 입력받기
		String str = sc.next();

		// : 기준으로 잘라서 배열로 저장
		String[] numArr = str.split(":");

		// N, M으로 나눠서 저장
		int N = Integer.parseInt(numArr[0]);
		int M = Integer.parseInt(numArr[1]);

		// 최대공약수 구하기
		int GCD = findGCD(N, M);

		// 각각 최대공약수로 나눠주기
		N /= GCD;
		M /= GCD;

		// 답 형식으로 변경해서 출력
		String ans = N + ":" + M;

		System.out.println(ans);
	}

	// 최대공약수 구하는 메서드
	private static int findGCD(int N, int M) {
		while (M != 0) {
			int tmp = N % M;

			N = M;

			M = tmp;
		}

		return N;
	}
}