import java.util.Scanner;

public class Main {

	static final int INF = 10000;
	static int building, road;
	static int[][] minCost;
	static int ansA, ansB, sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 빌딩, 도로 개수
		building = sc.nextInt();
		road = sc.nextInt();

		// 최소비용 담을 배열
		minCost = new int[building + 1][building + 1];

		// 일단 시작도시와 도착도시가 다르면 INF로 비용 초기화
		for (int r = 1; r <= building; r++) {
			for (int c = 1; c <= building; c++) {
				if (r == c)
					continue;
				minCost[r][c] = INF;
			}
		}

		// 도로 정보 입력받기 (양방향)
		for (int i = 0; i < road; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			minCost[start][end] = 1;
			minCost[end][start] = 1;
		}

		// i에서 출발해서 j에 도착하는 최솟값
		for (int k = 1; k <= building; k++) {
			for (int i = 1; i <= building; i++) {
				for (int j = i + 1; j <= building; j++) {
					minCost[i][j] = minCost[j][i] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
				}
			}
		}

		int min = search();

		// 출력
		System.out.println(ansA + " " + ansB + " " + min);
	}

	static int search() { // 최솟값 탐색
		int min = INF; // 최소값 초기화

		for (int i = 1; i < building; i++) {
			for (int j = i + 1; j <= building; j++) {
				// i, j번째 빌딩에 가게 짓기
				int sum = 0; // 비용 합

				for (int k = 1; k <= building; k++) {
					// i, j번째에 가게 지었을 때 다른 k번째 빌딩으로 가는 비용 구하기
					if (k == i || k == j)
						continue;
					// k번째 빌딩으로 가는 비용은 i, j 중 k로 가는 최솟값으로 해서 누적
					sum += Math.min(minCost[i][k], minCost[j][k]);
				}
				// 모든 빌딩 배달이 끝났으면 최솟값 갱신, 위치도 갱신
				if (min > sum) {
					min = sum;
					ansA = i;
					ansB = j;
				}
			}
		}
		// 편도 방향의 최솟값만 구했으므로 2배하면 왕복값이 된다.
		return 2 * min;
	}
}