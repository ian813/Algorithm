import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Z = sc.nextInt();
		int M = sc.nextInt();

		// 장애물 정보 받을 배열
		boolean[] obstacle = new boolean[N + 1];

		// 장애물 있는 곳 표시
		for (int i = 0; i < M; i++) {
			obstacle[sc.nextInt()] = true;
		}

		// 이동할 거리
		int K = 1;
		// 현재 위치
		int cur = 1;

		while (K <= N - 1) {
			// 현재 위치를 K만큼 늘려주면서 반복
			cur = (cur + K) % N;

			if (cur == 0) {
				cur = N;
			}

			if (cur == Z) {
				// 목표에 도착하면 멈추기
				break;
			}

			if (cur == 1) {
				// 1로 돌아오면 무한루프 돈다는 뜻이므로
				// K 늘리고 위치를 1로 조정
				K++;
				cur = 1;
			}

			if (obstacle[cur]) {
				// 장애물 만나면
				// K 늘리고 위치를 1로 조정
				K++;
				cur = 1;
			}
		}

		System.out.println(K);
	}
}