import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 개수
		int testCase = Integer.parseInt(br.readLine());

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		while (testCase-- > 0) {
			// 테케만큼 입력받기
			st = new StringTokenizer(br.readLine());

			// 숫자 개수
			int num = Integer.parseInt(st.nextToken());

			// 숫자 정보 저장
			int[] numArr = new int[num];

			for (int i = 0; i < num; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}

			// gcd의 합 담을 변수
			long gcdSum = 0;

			// 모든 경우의 수 탐색해서 gcd 구해서 더해주기
			for (int i = 0; i < num - 1; i++) {
				for (int j = i + 1; j < num; j++) {
					gcdSum += findGCD(numArr[i], numArr[j]);
				}
			}

			// 스트링빌더에 저장
			sb.append(gcdSum).append("\n");
		}

		// 출력
		System.out.println(sb);
	}

	// 유클리드 호제법으로 GCD 구하기
	private static int findGCD(int A, int B) {
		while (B > 0) {
			int tmp = A % B;
			A = B;
			B = tmp;
		}

		return A;
	}
}