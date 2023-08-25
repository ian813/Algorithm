import java.util.Scanner;

public class Main {

	static final int INF = 4000001;
	static int town, road;
	static int[][] edges;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 마을 개수, 도로 개수
		town = sc.nextInt();
		road = sc.nextInt();

		// 도로 정보 입력받을 배열
		edges = new int[town + 1][town + 1];

		// 도로 길이 INF로 초기화
		for (int i = 1; i <= town; i++) {
			for (int j = 1; j <= town; j++) {
				if (i != j) {
					edges[i][j] = INF;
				}
			}
		}

		// 도로 정보 입력받기 (단방향이므로 st->end 방향만)
		for (int i = 0; i < road; i++) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			int length = sc.nextInt();

			edges[st][end] = length;
		}

		// 플로이드 워셜
		ployd();

		// 답 구하기
		int ans = solve();

		// 답이 초기화 안됐으면 사이클이 없으므로 -1 출력
		if (ans == INF) {
			System.out.println(-1);
		} else {
			// 그게 아니면 답 출력
			System.out.println(ans);
		}
	}

	// 플로이드 워셜로 i -> j로 가는 최소 길이 구하기
	static void ployd() {
		for (int k = 1; k <= town; k++) {
			for (int i = 1; i <= town; i++) {
				for (int j = 1; j <= town; j++) {
					edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
				}
			}
		}
	}

	// i -> j -> i로 가는 사이클 중 최소값 구하기
	static int solve() {
		int ans = INF;

		for (int i = 1; i <= town; i++) {
			for (int j = 1; j <= town; j++) {
				if (i != j) {
					ans = Math.min(ans, edges[i][j] + edges[j][i]);
				}
			}
		}

		return ans;
	}
}