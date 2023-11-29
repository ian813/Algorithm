import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		// 측정 최대 기간
		int endDay = Integer.parseInt(st.nextToken());

		// 구할 구간
		int period = Integer.parseInt(st.nextToken());

		// 일자별 방문자 수
		int[] visit = new int[endDay];

        st = new StringTokenizer(br.readLine());
		for (int i = 0; i < endDay; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}

		// 누적 방문자 수 최댓값
		int max = 0;

		// 최댓값 횟수 카운팅
		int cnt = 1;

		for (int i = 0; i < period; i++) {
			max += visit[i];
		}

		// 현재 구한 누적 방문자 수
		int cur = max;

		// 구하는 기간의 시작과 끝 인덱스
		int start = 0;
		int end = period;

		while (end < endDay) {
			// 다음 구간 누적 방문자 수 구하기
			cur -= visit[start++];
			cur += visit[end++];

			if (max < cur) {
				max = cur;
				cnt = 1;
			} else if (max == cur) {
				cnt++;
			}
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}