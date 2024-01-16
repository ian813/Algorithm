import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 입력받기
		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (testCase-- > 0) {
			// 테케만큼 반복하면서 A, B 입력받기
			long A = sc.nextLong();
			long B = sc.nextLong();

			// 최대공약수 구하기
			long gcd = findGCD(A, B);
            
			// 최소공배수 구하기 (gcd * lcm = A * B)
			long lcm = (A * B) / gcd;
            
			// 스트링빌더에 저장
			sb.append(lcm).append("\n");
		}
		// 출력
		System.out.println(sb);
	}

	// 유클리드 호제법 이용해서 최대공약수 구하기
	private static long findGCD(long A, long B) {

		while (B > 0) {
			long tmp = A % B;
			A = B;
			B = tmp;
		}

		return A;
	}
}