import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int row, col;
	static int[][] space;
	static int[] goal;
	// 델타배열
	static int[] dr = {1, 1, 1};
	static int[] dc = {-1, 0, 1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		// 우주 크기
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		// 우주 배열, 각 도착지별 도착 정보
		space = new int[row][col];
		goal = new int[col];

		// 정보 입력받기 (첫 행에는 dp 배열에도 똑같이 저장)
		for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
			for (int c = 0; c < col; c++) {

				space[r][c] = Integer.parseInt(st.nextToken());

				if (r == row - 1) {
					// 맨 끝행은 최댓값으로 채워넣기
					goal[c] = Integer.MAX_VALUE;
				}
			}
		}

		// 출발점을 돌아가면서 dfs 탐색
		for (int j = 0; j < col; j++) {
			dfs(0, j, space[0][j], -1);
		}

		// 최솟값 찾기
		int min = Integer.MAX_VALUE;

		for (int j = 0; j < col; j++) {
			min = Math.min(min, goal[j]);
		}

		System.out.println(min);
	}

	// dfs 탐색 메서드
	private static void dfs(int r, int c, int sum, int direction) {
		if (r == row - 1) {
			// 끝 행에 도달했으면 최솟값 구하고 리턴
			goal[c] = Math.min(goal[c], sum);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (direction == i)
				continue;

			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= row || nc >= col)
				continue;

			dfs(nr, nc, sum + space[nr][nc], i);
		}
	}
}