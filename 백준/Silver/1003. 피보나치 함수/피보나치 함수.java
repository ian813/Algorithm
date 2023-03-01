import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	static int testCase = sc.nextInt();

	static int N;

	static int[] fibonacci0;
	static int[] fibonacci1;

	// 인풋 메서드
	static void input() {

		N = sc.nextInt();
	}

	static void dp() {
		// 입력값인 N의 최댓값이 40이므로,,
		// fibonacci0은 각 인덱스에서 fibonacci(0)이 쓰인 개수를 담을 배열
		// fibonacci1은 각 인덱스에서 fibonacci(1)이 쓰인 개수를 담을 배열
		fibonacci0 = new int[N + 1];
		fibonacci1 = new int[N + 1];

		// 초기 두 값을 계산해서 담아주자.
		fibonacci0[0] = 1;
		fibonacci1[0] = 0;
		
		// N이 0이면 오류 걸리니까,,
		// 범위 지정
		if (N > 0) {
			fibonacci0[1] = 0;
			fibonacci1[1] = 1;
		}

		// 인덱스 2부터는 dp를 이용해서 구현
		for (int idx = 2; idx <= N; idx++) {
			// 앞 두 인덱스에서 쓰인 개수를 더해주면 현재 인덱스에서 쓰인 개수가 나온다.
			fibonacci0[idx] = fibonacci0[idx - 1] + fibonacci0[idx - 2];
			fibonacci1[idx] = fibonacci1[idx - 1] + fibonacci1[idx - 2];

		}
	}

	public static void main(String[] args) {
		// 테스트케이스만큼 반복 시행
		for (int tc = 1; tc <= testCase; tc++) {
			input();
			dp();

			// 형식에 맞게 출력
			System.out.printf("%d %d\n", fibonacci0[N], fibonacci1[N]);

		}

	}
}