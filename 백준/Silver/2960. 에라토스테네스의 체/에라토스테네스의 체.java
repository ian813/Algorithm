import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int cnt = 0;
		int ans = 0;

		boolean[] notPrime = new boolean[N + 1];

		x:
		for (int i = 2; i <= N; i++) {
			// 소수 2부터 시작해서 판단
			if (!notPrime[i]) {
				// 아직 지워지지 않은 수면
				for (int j = i; j <= N; j += i) {
					// 그 수의 배수들을 탐색하면서
					if (!notPrime[j]) {
						// 아직 지워지지 않은 수면
						// 지워주고 카운팅
						notPrime[j] = true;
						cnt++;

						if (cnt == K) {
							// 카운팅이 목표에 도달하면
							// ans에 저장하고 멈춤
							ans = j;
							break x;
						}
					}
				}
			}
		}
		// 출력
		System.out.println(ans);
	}
}