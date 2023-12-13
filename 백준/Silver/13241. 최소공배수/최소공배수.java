import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자 A, B 입력받기
		long A = sc.nextLong();
		long B = sc.nextLong();

		long gcd = findGcd(A, B);

		// 최소공배수 찾기 (lcm * gcd = A * B)
		long lcm = (A * B) / gcd;

		// 최소공배수 출력
		System.out.println(lcm);
	}

	// 유클리드 호제법 이용해서 최대공약수 구하기
	private static long findGcd(long a, long b) {
		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}

		return a;
	}
}