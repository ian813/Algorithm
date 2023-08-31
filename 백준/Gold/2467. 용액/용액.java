import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오름차순으로 주어져서 더 쉽게 구할 수 있다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] solution = new int[N];

		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		// 시작 인덱스, 끝 인덱스
		int start = 0;
		int end = N - 1;
		// 합
		int sum = 0;
		// 합이 0과 가까울 때 최소값, 최대값
		int min = 0;
		int max = 0;
		// 0과 가까운 sum으로 계속 업뎃해줄 값
		int dist = Integer.MAX_VALUE;

		// 시작 인덱스가 끝 인덱스보다 작을 때까지만 탐색
		while (start < end) {
			// sum은 지금 가리키는 두 포인터의 합으로 초기화
			sum = solution[start] + solution[end];

			// sum의 절댓값이 dist의 절댓값보다 작으면
			if (Math.abs(sum) < Math.abs(dist)) {
				// dist 업뎃하고
				dist = sum;
				// 최소 최대값을 각각 업뎃
				min = solution[start];
				max = solution[end];
			}

			if (sum < 0) {
				// sum이 0보다 작으면
				// 작은 값을 늘려줘야 하므로 start++
				start++;
			} else if (sum > 0) {
				// sum이 0보다 크면
				// 큰 값을 줄여줘야 하므로 end--
				end--;
			} else {
				// sum이 0이면 멈추기
				break;
			}
		}

		// 출력
		System.out.println(min + " " + max);
	}
}