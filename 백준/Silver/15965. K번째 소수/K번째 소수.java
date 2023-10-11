import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int INF = 8000000;

		int K = sc.nextInt();

		// 소수인지 판단 (K <= 500000)
		boolean[] notPrime = new boolean[INF];

		// 에라토스테네스 채 이용해서 소수 저장
		for (int i = 2; i <= (int)Math.ceil(Math.sqrt(INF)); i++) {
			for (int j = i * 2; j < INF; j += i) {
				notPrime[j] = true;
			}
		}

		int cnt = 0;

		for (int i = 2; i < INF; i++) {
			if (!notPrime[i]) // 소수인 거 카운트
				cnt++;
			if (cnt == K) { // K번쨰 소수이면 출력하고 끝
				System.out.println(i);
				return;
			}
		}
	}
}