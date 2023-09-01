import java.util.Scanner;

public class Main {

	static int point, round;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		point = sc.nextInt();
		round = sc.nextInt();

		// makeSet
		parent = new int[point];

		for (int i = 0; i < point; i++) {
			parent[i] = i;
		}

		int ans = 0;

		// round 수만큼 실행
		for (int i = 1; i <= round; i++) {
			// 시작점과 끝점을 입력받고
			int start = sc.nextInt();
			int end = sc.nextInt();

			if (findSet(start) != findSet(end)) {
				// 시작점과 끝점의 대표자가 다르면 union
				union(start, end);
			} else {
				// 같은 점이 나오면 사이클이 완성되었으므로
				// ans를 현재 라운드로 업뎃하고 break
				ans = i;
				break;
			}
		}

		// 답 출력
		System.out.println(ans);
	}

	// findSet
	static int findSet(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = findSet(parent[x]);
	}

	// union
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}