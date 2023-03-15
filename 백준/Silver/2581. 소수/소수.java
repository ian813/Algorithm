import java.util.Scanner;

public class Main {
	static int M;
	static int N;
	static boolean[] numArr;

	static int minPrime;
	static int primeSum;

	static void input() {
		Scanner sc = new Scanner(System.in);
		// 정수 M, N
		M = sc.nextInt();
		N = sc.nextInt();

		// N까지의 숫자가 소수인지 판단할 불리안 배열
		numArr = new boolean[N + 1];

		// 최소 소수와 소수의 합을 저장할 변수
		minPrime = 0;
		primeSum = 0;
	}

	static void solve() {
		input();

		for (int idx = M; idx <= N; idx++) {
			// 인덱스 M부터 N까지 돌면서
			for (int num = 2; num <= Math.sqrt(N); num++) {
				// 에라토스테네스의 체를 이용해서 소수 판별
				if (idx != num && idx % num == 0) {
					// 자기 자신이 아닌데 나눠지는 수가 있으면
					// 소수가 아니면 true로 바꿔줌
					numArr[idx] = true;
				}

			}
		}

		// 1은 못 거르므로,,
		// 자체적으로 걸러준다.
		if (M == 1) {
			numArr[M] = true;
		}

		for (int idx = M; idx <= N; idx++) {
			// 소수이고 최소 소수가 아직 갱신되지 않았으면
			if (!numArr[idx] && minPrime == 0) {
				// 최소 소수를 갱신
				minPrime = idx;
			}

			if (!numArr[idx]) {
				// 소수인 값들 전부 더해주기
				primeSum += idx;
			}
		}
	}

	public static void main(String[] args) {
		solve();
		if (primeSum != 0) {
			// 소수 합이 0이 아니면 소수가 존재한 것이므로
			// 최소 소수와 소수 합 출력
			System.out.println(primeSum);
			System.out.println(minPrime);
		} else {
			// 아니면 소수가 존재하지 않으므로 -1 출력
			System.out.println(-1);
		}
	}
}