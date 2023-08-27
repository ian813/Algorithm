import java.util.Scanner;

public class Main {

	static final int INF = 100000000;
	// 집하장 개수, 경로 개수
	static int n, m;
	static int[][] minCost, minPoint;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		// 최소 비용 저장할 배열
		minCost = new int[n + 1][n + 1];
		// 최소 비용으로 가는 경로 저장
		minPoint = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					// INF로 가중치 초기화 시켜주고
					// minCost[i][j]는 i에서 j로 가는 비용이므로
					// 다음 노드는 j
					minCost[i][j] = INF;
					minPoint[i][j] = j;
				}
			}
		}

		// 연결 정보 입력받아서 저장
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();

			minCost[start][end] = minCost[end][start] = weight;
		}

		// 플로이드 워셜로 찾아주자.
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// k를 거쳐가는게 더 최소 비용이면
					// minCost를 k를 거쳐가는 가중치와 최단 경로를 가는 지점을 k로 업데이트
					if (minCost[i][j] > minCost[i][k] + minCost[k][j]) {
						minCost[i][j] = minCost[i][k] + minCost[k][j];
						minPoint[i][j] = minPoint[i][k];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) { // i j가 같으면 - 담기
					sb.append("- ");
				} else { // i j가 다르면 최소비용을 위해 다음 가야할 지점을 담고
					sb.append(minPoint[i][j] + " ");
				}
			}
			// 개행
			sb.append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}