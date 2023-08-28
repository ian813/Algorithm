import java.util.Scanner;

public class Main {

	static int[] check;
	static int count = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 0~9까지 체크할 배열
		check = new int[10];

		// 초기값
		int A = 1;

		// 입력받은 값이 초기값이상일 때까지 반복
		// 일단 N과 A의 일의 자리를 각각 9와 0으로 조정
		while (A <= N) {
			while (N % 10 != 9 && A <= N) {
				// 일의 자리가 9가 될 때까지 반복
				// 카운팅
				cal(N);
				N--;
			}
			while (A % 10 != 0 && A <= N) {
				// 일의 자리가 0이 될 떄까지 반복
				// 카운팅
				cal(A);
				A++;
			}

			// 더 커지면 멈춤
			if (A > N)
				break;

			// 그게 아니면 각각 10으로 나눈 몫으로 바꾸고 계속 반복
			A /= 10;
			N /= 10;

			// 각 숫자가 몇 번 쓰였는지 카운팅
			for (int i = 0; i < 10; i++) {
				check[i] += (N - A + 1) * count;
			}

			// count값 업데이트
			count *= 10;
		}

		// 스트링빌더에 담아서 출력
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			sb.append(check[i] + " ");
		}

		System.out.println(sb);
	}

	private static void cal(int cur) {
		while (0 < cur) {
			// 들어온 값이 0보다 클 때까지 반복
			// 나머지에 해당하는 인덱스에 카운트만큼 더해주고
			// cur을 10으로 나눈 몫으로 바꾸고 반복
			check[cur % 10] += count;
			cur /= 10;
		}
	}
}