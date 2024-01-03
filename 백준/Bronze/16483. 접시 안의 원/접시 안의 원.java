import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// T 입력받기
		double T = sc.nextDouble();

		// a^2 - b^2 = (T/2)^2
		// 절반 쪼개기
		T /= 2;

		// 제곱한 다음 반올림
		int ans = (int)Math.abs(Math.pow(T, 2));

		// 출력
		System.out.println(ans);
	}
}