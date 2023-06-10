import java.util.Scanner;

public class Main {
	static int N, M, max;
	static int[][] map;
	static boolean[][] visited;
	// 델타배열(상하좌우)
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 행, 열 크기
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		// 맵 정보 입력받기
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				map[row][col] = sc.nextInt();
			}
		}

		sc.close();

		max = 0; // 합

		visited = new boolean[N][M]; // 방문체크

		// 전부 돌면서 탐색
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true; // 방문체크
				search(r, c, map[r][c], 1); // 메서드 호출
				visited[r][c] = false; // 방문해제
			}
		}
		System.out.println(max); // 출력
	}

	static void search(int r, int c, int sum, int depth) {
		if (depth == 4) {
			max = Math.max(max, sum); // 최댓값 갱신
			return;
		}

		// 델타배열로 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue; // 배열 범위 초과하면 넘기기
			if (visited[nr][nc])
				continue; // 방문한 곳도 넘기기

			if (depth == 2) { // ㅗ 모양 만들기 위해 depth가 2일 때도 또 재귀 호출해서 탐색
				visited[nr][nc] = true; // 방문체크
				search(r, c, sum + map[nr][nc], depth + 1); // 재귀 호출 (직전 자리로 가서 다시 사방탐색)
				visited[nr][nc] = false; // 방문해제
			}

			visited[nr][nc] = true; // 방문체크
			search(nr, nc, sum + map[nr][nc], depth + 1); // 재귀 호출
			visited[nr][nc] = false; // 방문해제
		}
	}
}
