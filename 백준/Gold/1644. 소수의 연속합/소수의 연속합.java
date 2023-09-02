import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// N, N이하의 소수 판별할 배열
	static int N;
	static boolean[] prime;
	// 소수들만 저장할 배열
	static ArrayList<Integer> primeList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		prime = new boolean[N + 1];

		primeList = new ArrayList<>();

		findPrime();

		// 답 찾아서 출력
		int ans = twoPointer();

		System.out.println(ans);
	}

	// 소수 찾을 메서드
	private static void findPrime() {
		if (N <= 1)
			return;

		// 2이상 N이하의 수를 모두 소수라고 초기화
		for (int i = 2; i <= N; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= N; i++) {
			if (prime[i]) { // 소수일 때 그 소수의 배수들을 소수가 아니라고 표시해주자.
				for (int j = i * i; j <= N; j += i) {
					//i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화
					prime[j] = false;
				}
			}
		}

		// 이제 N까지의 소수들만 모아서 저장해주자.
		for (int i = 2; i <= N; i++) {
			if (prime[i]) {
				primeList.add(i);
			}
		}
	}

	// twoPointer로 경우의 수 찾기
	private static int twoPointer() {
		// 시작 인덱스, 끝인덱스
		int start = 0;
		int end = 0;
		// 시작인덱스부터 끝인덱스까지의 값의 합
		int sum = 0;
		// 경우의 수 카운팅
		int cnt = 0;

		// 시작인덱스가 끝인덱스 이하이고 끝인덱스가 primeList 크기이하까지 반복
		while (start <= end && end <= primeList.size()) {
			if (sum < N) {
				if (end == primeList.size())
					break;
				// sum이 N보다 작으면 끝인덱스값을 더하고 끝인덱스 증가
				sum += primeList.get(end++);
			} else if (sum > N) {
				if (start == primeList.size())
					break;
				// sum이 N보다 크면 시작인덱스값을 빼고 시작인덱스 증가
				sum -= primeList.get(start++);
			} else {
				// sum이 N과 같으면 경우의수 카운팅
				cnt++;
				if (end == primeList.size())
					break;
				// sum을 바꿔주면서
				// 시작인덱스 끝인덱스 모두 증가시키기
				sum = sum + primeList.get(end++) - primeList.get(start++);
			}
		}
		// 다 탐색했으면 경우의 수 카운팅
		return cnt;
	}
}