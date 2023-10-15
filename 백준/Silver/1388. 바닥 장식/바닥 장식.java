import java.util.Scanner;

public class Main {

	// 판자 개수, 행 열
	static int cnt, row, col;
	// 맵 정보
	static char[][] map;
	// 방문체크 배열
	static boolean[][] visited;

	// 델타배열 (상하좌우)
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();

		// 맵 정보 입력받기
		map = new char[row][col];

		for (int r = 0; r < row; r++) {
			String str = sc.next();
			for (int c = 0; c < col; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		// 판자 개수
		cnt = 0;

		visited = new boolean[row][col];

		// dfs로 카운팅
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (!visited[r][c]) {
					// 방문 안 한 곳이면 방문 체크하고 dfs 탐색
					visited[r][c] = true;
					dfs(r, c, map[r][c]);
					// dfs 탐색 끝나면 카운팅
					cnt++;
				}
			}
		}

		// 출력
		System.out.println(cnt);
	}

	private static void dfs(int r, int c, char ch) {

		for (int i = 0; i < 4; i++) {
			// 델타배열로 탐색
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
				// 배열 범위 넘어가면 넘기기
				continue;
			}
			if (visited[nr][nc]) {
				// 방문한 곳 넘기기
				continue;
			}

			if (map[r][c] != map[nr][nc]) {
				// 다른 판자면 넘기기
				continue;
			}

			// 같은 판자여도 방향이 다르면 넘기기
			if (map[nr][nc] == '|') {
				if (nr == r) {
					continue;
				}
			} else {
				if (nc == c) {
					continue;
				}
			}

			// 다 만족하면 방문체크하고 dfs로 탐색
			visited[nr][nc] = true;
			dfs(nr, nc, map[nr][nc]);
		}
	}
}