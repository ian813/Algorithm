import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = 123456 * 2;

		// n의 범위만큼 소수 판단할 배열 만들어주기
		boolean[] notPrime = new boolean[length + 1];

		notPrime[1] = true;

		// 에라토스테네스의 채 이용해서 소수 판단
		for (int i = 2; i <= length; i++) {
			if (!notPrime[i]) {
				for (int j = i * 2; j <= length; j += i) {
					notPrime[j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break; // n이 0이면 중단

			int cnt = 0;

			for (int i = n + 1; i <= 2 * n; i++) {
				if (!notPrime[i]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}