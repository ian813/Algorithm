import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 측정 최대 기간
		int endDay = sc.nextInt();

		// 구할 구간
		int period = sc.nextInt();

		// 일자별 방문자 수
		int[] visit = new int[endDay];

		for (int i = 0; i < endDay; i++) {
			visit[i] = sc.nextInt();
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