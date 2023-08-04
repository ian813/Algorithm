import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	// 테스트케이스 입력받기
	static int testCase = sc.nextInt();
	static int size;
	static int[][] map;
	static int ans;
	static Node[] path;
	static boolean[][] visited;
	// 델타배열 (상하좌우 방향)
	static int[] deltaRow = { -1, 1, 0, 0 };
	static int[] deltaCol = { 0, 0, -1, 1 };

	// 노드 클래스 만들어서 가중치 순으로 정렬
	static class Node implements Comparable<Node> {
		int x, y, w;

		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static void input() {
		size = sc.nextInt(); // 맵 크기

		map = new int[size][size]; // 맵 정보를 담을 배열

		visited = new boolean[size][size]; // 방문체크할 배열

		for (int row = 0; row < size; row++) {
			// 문자열로 받고 char형으로 쪼개서 - '0'을 해준다.
			String str = sc.next();
			for (int col = 0; col < size; col++) {
				map[row][col] = str.charAt(col) - '0';
			}
		}
	}

	// 다익스트라 사용
	static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		// 처음 위치와 그 때의 비용을 큐에 저장
		queue.offer(new Node(0, 0, 0));

		visited[0][0] = true; // 처음 위치 방문 체크

		// 큐가 빌때까지 실행
		while (!queue.isEmpty()) {

			// 큐에서 가중치가 제일 작은 맨 앞에 있는 값을 하나 빼주고
			Node tmpNode = queue.poll();

			// 지금 뽑아준 값이 도착지점이면
			if (tmpNode.x == size - 1 && tmpNode.y == size - 1) {
				// 그때의 가중치를 저장하고 반환
				// 계속 더한 다음 정렬해서 저장해줬으몰 최솟값이 들어가 있다.
				ans = tmpNode.w;
				return;
			}

			// 델타배열을 이용해서 탐색
			for (int dr = 0; dr < deltaCol.length; dr++) {
				int newR = tmpNode.x + deltaRow[dr];
				int newC = tmpNode.y + deltaCol[dr];

				// 범위 벗어나거나 탐색한 곳이면 넘어감
				if (newR < 0 || newC < 0 || newR >= size || newC >= size || visited[newR][newC])
					continue;

				// 조건에 안 걸리면 방문 체크
				visited[newR][newC] = true;

				// 큐에 해당 지점에 있는 노드를 넣어준다. 가중치는 현재 가중치에 탐색한 곳에 있는 가중치를 더해서 저장해준다.
				// 이렇게 저장하면 자동으로 정렬돼서 가중치 순으로 정렬돼서 가장 앞에는 다른 노드가 올 수도 있다.
				queue.offer(new Node(newR, newC, tmpNode.w + map[newR][newC]));

			}

		}

	}

	public static void main(String[] args) {
		for (int tc = 1; tc <= testCase; tc++) {
			input();
			// 답 초기화
			ans = 0;

			dijkstra();

			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}