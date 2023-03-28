import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();

	static int M;
	static int N;
	static int cabbageNum;
	static int[][] map;
	static int snake;
	static boolean[][] visit;
	// 우, 상, 좌, 하 방향 델타배열
	static int[] deltaRow = { 0, -1, 0, 1 };
	static int[] deltaCol = { 1, 0, -1, 0 };

	static void input() {
		M = sc.nextInt();
		N = sc.nextInt();
		cabbageNum = sc.nextInt();

		map = new int[M][N];

		// 배추 위치정보 입력받아서 표시
		for (int n = 0; n < cabbageNum; n++) {
			int tmpRow = sc.nextInt();
			int tmpCol = sc.nextInt();

			map[tmpRow][tmpCol]++;
		}
		// 방문 체크할 배열
		visit = new boolean[M][N];
		// 뱀 숫자 초기화
		snake = 0;
	}

	// bfs로 구현해보자.
	static void bfs(int row, int col) {
		// 위치 저장할 큐
		Queue<int[]> location = new LinkedList<int[]>();
		// 새로운 row, col을 값으로 갖는 새로운 배열을 생성해서 추가해준다.
		location.add(new int[] { row, col });

		while (!location.isEmpty()) { // 큐가 빌 때까지 실행
			// 가장 앞에 있는 값을 row, col에 대입
			row = location.peek()[0];
			col = location.peek()[1];
			// 앞에 있는 값을 poll
			location.poll();
			// 방문 처리
			visit[row][col] = true;
			for (int i = 0; i < 4; i++) {
				// 현재 위치에서 델타배열을 이용해서 탐색
				int newRow = row + deltaRow[i];
				int newCol = col + deltaCol[i];

				if (newRow >= 0 && newCol >= 0 && newRow < M && newCol < N) { // 탐색 위치가 범위 안일 때
					if (!visit[newRow][newCol] && map[newRow][newCol] == 1) { // 방문 안 했고, 배추가 있는 곳이면
						location.add(new int[] { newRow, newCol }); // 큐에 탐색 위치를 추가해주고
						visit[newRow][newCol] = true; // 방문 처리
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int tc = 1; tc <= testCase; tc++) {
			input();

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visit[i][j]) { // 배추가 있고 방문 안한 곳에서 탐색출발
						bfs(i, j); // 탐색하고
						snake++; // 탐색을 마치면 뱀의 수를 늘려준다.
					}
				}
			}
			// 형식에 맞게 담아주고
			sb.append(snake + "\n");
		}
		// 출력
		System.out.println(sb);

	}

}
