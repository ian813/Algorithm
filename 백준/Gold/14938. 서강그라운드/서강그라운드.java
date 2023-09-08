import java.util.Scanner;

public class Main {

	static int area, search, road, maxItem;
	static int[] items;

	static final int INF = 1000000;

	static int[][] map;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 지역 개수, 수색범위, 길 개수
		area = sc.nextInt();
		search = sc.nextInt();
		road = sc.nextInt();

		// 아이템 정보
		items = new int[area + 1];

		for (int i = 1; i <= area; i++) {
			items[i] = sc.nextInt();
		}

		// 지역 연결 정보
		map = new int[area + 1][area + 1];

		for (int i = 0; i < road; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int scope = sc.nextInt();

			map[start][end] = map[end][start] = scope;
		}

		// 입력정보 없는 곳은 INF로 초기화
		for (int i = 1; i <= area; i++) {
			for (int j = 1; j <= area; j++) {
				if (i == j)
					continue;
				if (map[i][j] == 0) {
					map[i][j] = INF;
				}
			}
		}

		for (int k = 1; k <= area; k++) {
			for (int i = 1; i <= area; i++) {
				for (int j = 1; j <= area; j++) {
					// 수색범위 값을 탐색하면서 최소로 바꿔주기
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		// 얻을 수 있는 최대 아이템
		maxItem = 0;

		// 아이템 값 구해보기
		for (int i = 1; i <= area; i++) {
			// 현재 출발점에서 구할 아이템
			int curItem = 0;
			for (int j = 1; j <= area; j++) {
				if (map[i][j] <= search) {
					// 거리가 수색범위이하이면
					// 아이템을 추가해주기
					curItem += items[j];
				}
			}
			// 아이템 최댓값 업데이트
			maxItem = Math.max(maxItem, curItem);
		}

		// 출력
		System.out.println(maxItem);
	}
}