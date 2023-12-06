import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 높이, 너비 정보
		int height = sc.nextInt();
		int width = sc.nextInt();

		int[] map = new int[width];

		// 최대 높이와 그 때의 인덱스
		int maxHeight = 0;
		int maxIdx = 0;

		// 블록 쌓인 정보
		for (int i = 0; i < width; i++) {
			map[i] = sc.nextInt();

			if (map[i] > maxHeight) {
				// 최대 높이와 인덱스 업데이트
				maxHeight = map[i];
				maxIdx = i;
			}
		}

		// 시작 높이, 시작 인덱스
		int startHeight = map[0];
		int startIdx = 0;

		// 쌓인 물의 양
		int water = 0;

		for (int i = 0; i <= maxIdx; i++) {
			if (startHeight <= map[i]) {
				// 시작 높이이상의 블럭을 만나면
				// 그 곳을 끝 높이로 설정
				int endIdx = i;
				int endHeight = map[i];

				for (int j = startIdx + 1; j < endIdx; j++) {
					// 시작 높이 다음 인덱스부터 끝 높이 전 인덱스까지 물을 누적시켜보자.
					// 둘 중에 작은 값을 기준 높이로 해서 쌓일 물 구해주기
					int curWater = Math.min(startHeight, endHeight) - map[j];

					water += curWater;
				}

				// 시작점과 높이를 업데이트 시켜주고 계속 반복
				startIdx = endIdx;
				startHeight = endHeight;
			}
		}

		// 시작 높이, 시작 인덱스
		startHeight = map[width - 1];
		startIdx = width - 1;

		for (int i = width - 1; i >= maxIdx; i--) {
			if (startHeight <= map[i]) {
				// 시작 높이이상의 블럭을 만나면
				// 그 곳을 끝 높이로 설정
				int endIdx = i;
				int endHeight = map[i];

				for (int j = startIdx - 1; j > endIdx; j--) {
					// 시작 높이 다음 인덱스부터 끝 높이 전 인덱스까지 물을 누적시켜보자.
					// 둘 중에 작은 값을 기준 높이로 해서 쌓일 물 구해주기
					int curWater = Math.min(startHeight, endHeight) - map[j];

					water += curWater;
				}

				// 시작점과 높이를 업데이트 시켜주고 계속 반복
				startIdx = endIdx;
				startHeight = endHeight;
			}
		}

		// 누적시킨 물 출력
		System.out.println(water);
	}
}