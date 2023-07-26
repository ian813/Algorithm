import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 각 도시를 잇는 비용의 최댓값이 100000이고 도시 개수가 최대 100이므로 99개를 거쳐서 가는 최악의 경우가 9900000이므로
	// 넉넉하게 1억으로 INF값을 설정
	static final int INF = 100000000;
	static int city, bus;
	static int[][] minCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 도시와 버스 수
		city = Integer.parseInt(br.readLine().trim());
		bus = Integer.parseInt(br.readLine().trim());

		// 각 도시들을 이동하는데 필요한 최소비용을 담을 배열
		minCost = new int[city + 1][city + 1];

		// 각 도시를 이동하는데 필요한 최소비용을 일단 INF로 초기화
		// 자기자신으로 이동하는 건 제외
		for (int i = 1; i <= city; i++) {
			for (int j = 1; j <= city; j++) {
				if (i != j)
					minCost[i][j] = INF;
			}
		}
		// 버스 정보 입력받기
		for (int i = 0; i < bus; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// 한 점에서 시작해서 다음 점으로 가는데 필요한 비용을
			// 최솟값으로 갱신 (지금은 다 INF로 되어있다.)
			// 한 점에서 다음 점으로 가는 노선이 하나가 아닐 수 있으므로
			// Math.min함수를 써서 갱신
			minCost[start][end] = Math.min(minCost[start][end], cost);
		}

		for (int k = 1; k <= city; k++) {
			// k번째 노드를 중간 노드로 생각
			for (int i = 1; i <= city; i++) {
				for (int j = 1; j <= city; j++) {
					// i 노드에서 j 노드에 도착하는데 드는 최소 비용은 i->j로 직접 가는 경우와 k를 중간에 거쳐서 가는 경우 중
					// 최소 비용을 구해주면 된다.
					minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= city; i++) {
			for (int j = 1; j <= city; j++) {
				// 이동이 불가능하면 (INF가 갱신 안됐으면)
				// 0을 담아준다.
				if (minCost[i][j] == INF) {
					sb.append(0).append(" ");
				} else {
					// 아니면 최소비용을 담아준다.
					sb.append(minCost[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
