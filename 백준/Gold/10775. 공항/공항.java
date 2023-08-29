import java.util.Scanner;

public class Main {

	// 게이트 크기, 비행기 개수
	static int size;
	static int airplane;

	// 대표자 집합
	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		size = sc.nextInt();
		airplane = sc.nextInt();

		p = new int[size + 1];

		// makeSet
		for (int i = 1; i <= size; i++) {
			p[i] = i;
		}

		// 답
		int ans = 0;

		// 모든 비행기에 대해서 조사
		while (airplane-- > 0) {
			// 도킹 가능한 게이트 입력받기
			int gate = sc.nextInt();

			// 도킹할 게이트를 찾아주자 (도킹 가능 게이트의 부모를 찾아서 도킹)
			int dockingGate = findSet(gate);

			// 만약 도킹할 게이트가 0이면 도킹 안되므로 멈춤
			if (dockingGate == 0)
				break;

			// dockingGate와 dockingGate -1의 부모끼리 union
			// dockingGate의 부모를 dockingGate - 1의 부모로 업뎃해줘야하므로
			// 순서가 바뀌면 안된다.
			union(findSet(dockingGate - 1), findSet(dockingGate));

			// 카운팅
			ans++;
		}

		// 답 출력
		System.out.println(ans);
	}

	// findSet
	static int findSet(int x) {
		if (x == p[x])
			return x;
		return p[x] = findSet(p[x]);
	}

	// union
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}