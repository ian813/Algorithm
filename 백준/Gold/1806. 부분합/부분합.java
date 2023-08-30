import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수열 길이, 목표 합
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		// 수열 정보 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 만족하는 최소 길이
		int ans = 100001;

		// 투포인터로 풀어보자
		// 시작과 끝 인덱스 잡기
		int start = 0;
		int end = 0;

		int sum = 0; // 부분합

		while (start <= end && end <= N) {
			if (sum >= S) {
				// sum이 S 이상이면
				// 최소 길이 업데이트
				ans = Math.min(ans, end - start);
				// sum에서 start 인덱스 값 뺴주고 start 인덱스 늘리기
				sum -= arr[start++];
			} else {
				// sum이 S보다 작으면
				// end 인덱스 값 더해주고 end 인덱스 늘리기
				sum += arr[end++];
			}
		}

		if (ans == 100001) {
			// 합을 만드는게 불가능해서 ans가 업뎃 안됐으면
			// 0 출력
			System.out.println(0);
		} else {
			// 아니면 ans 출력
			System.out.println(ans);
		}
	}
}