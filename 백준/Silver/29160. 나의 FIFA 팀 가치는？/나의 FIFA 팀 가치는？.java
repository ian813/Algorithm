import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N, K;
	static PriorityQueue<Integer>[] players = new PriorityQueue[12];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 선수 수, K년 후
		N = sc.nextInt();
		K = sc.nextInt();

		// 내림차순 우선순위큐를 배열의 각 인덱스에 넣어주기
		for (int i = 1; i <= 11; i++) {
			players[i] = new PriorityQueue<>(Collections.reverseOrder());
		}

		// 각 선수의 포지션에 알맞는 위치에 그 선수의 가치를 내림차순으로 추가
		for (int i = 0; i < N; i++) {
			int positon = sc.nextInt();
			int value = sc.nextInt();

			players[positon].add(value);
		}

		for (int i = 1; i <= 11; i++) {
			if (players[i].size() == 0) {
				// 혹시 포지션 공석인 곳이 있으면 디폴트로 0 추가해주기
				players[i].add(0);
			}
		}

		// 답
		int ans = 0;

		// K가 0보다 클때까지 반복
		while (K-- > 0) {

			// 8월까지 진행
			for (int i = 1; i <= 11; i++) {
				// 선수들 가치를 계속 업데이트
				int cur = players[i].poll();
				// 가치가 0보다 클 때만 1 감소
				if (cur > 0)
					cur--;
				players[i].add(cur);
			}

			// 마지막 팀구성
			if (K == 0) {
				// 0이면
				for (int i = 1; i <= 11; i++) {
					// 팀가치 구해주기
					int cur = players[i].poll();
					ans += cur;
				}
			}
		}

		// 답출력
		System.out.println(ans);
	}
}
