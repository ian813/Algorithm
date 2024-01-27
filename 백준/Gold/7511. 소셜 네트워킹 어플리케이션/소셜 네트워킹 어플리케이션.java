import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 대표자 배열
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			// 테케마다 형식에 맞게 저장
			sb.append("Scenario ").append(tc).append(":").append("\n");

			// 유저 수
			int user = Integer.parseInt(br.readLine());

			parent = new int[user + 1];

			// makeSet
			for (int i = 1; i <= user; i++) {
				parent[i] = i;
			}

			int relation = Integer.parseInt(br.readLine());

			while (relation-- > 0) {
				st = new StringTokenizer(br.readLine());

				// 관계 수만큼 관계 형성
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (findSet(start) != findSet(end)) {
					// 만약 대표자가 다르면 합쳐주기
					union(start, end);
				}
			}

			// 궁금한 관계의 수
			int question = Integer.parseInt(br.readLine());

			while (question-- > 0) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (findSet(start) != findSet(end)) {
					// 대표자가 다르면 연결 안되어있으므로 0
					sb.append(0).append("\n");
				} else {
					// 대표자가 같으면 연결되어있으므로 1
					sb.append(1).append("\n");
				}
			}
			// 테케 사이에 빈 줄 하나씩 생성
			sb.append("\n");
		}

		System.out.println(sb);
	}

	// findSet
	private static int findSet(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = findSet(parent[x]);
	}

	// union
	private static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}