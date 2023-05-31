import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int height, width, year, cnt;
	static int[][] map;
	static boolean[][] visited;
	// 델타배열
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	// 포인트 클래스
	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 높이, 너비
		height = sc.nextInt();
		width = sc.nextInt();

		map = new int[height][width];
		// 빙산 정보
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				map[row][col] = sc.nextInt();
			}
		}

		sc.close();


        int ans = 0;
        int cnt = 0;
 
        // 빙하가 2개 이상 분리될 경우 반복문을 종료.
        // 빙하가 다 녹아버렸을 경우, 0을 출력.
        while ((cnt = SeparateNum()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }
 
            Melt();
            ans++;
        }
 
        System.out.println(ans);
    }
 
    // 빙하가 분리된 개수를 구하는 함수.
    public static int SeparateNum() {
        boolean[][] visited = new boolean[height][width];
 
        int cnt = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited); // DFS 방식을 통해 총 몇개의 빙하로 나누어졌는지 구할 수 있음.
                    cnt++;
                }
            }
        }
        return cnt;
    }
 
    public static void DFS(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
 
        // 델타배열을 이용한 탐색
        for (int i = 0; i < 4; i++) {
        	int nr = r + dr[i];
        	int nc = c + dc[i];
 
            if (nr < 0 || nc < 0 || nr >= height || nc >= width) { // 배열 넘어가면 넘김
                continue;
            }
 
            if (map[nr][nc] != 0 && !visited[nr][nc]) { // 바다가 아니고 방문 안했으면 탐색
                DFS(nr, nc, visited);
            }
        }
    }
 
    // 빙하를 녹이는 함수.
    public static void Melt() {
        Queue<Point> queue = new LinkedList<>();
 
        // visited 배열을 만드는 이유
 
        // visited 배열이 없다면,
        // 만약 1 2 가 있는 상태에서 1이 먼저 녹아서 0이 될 경우
        // 2는 녹아서 없어진 1 자리도 0이라고 판단하여
        // 필요 이상으로 더 많은 값을 녹이게 되어 버림.
        boolean[][] visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] != 0) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
        	Point cur = queue.poll();
 
            int seaNum = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.
 
            for (int i = 0; i < 4; i++) {
            	int nr = cur.r + dr[i];
            	int nc = cur.c + dc[i];
 
                if (nr < 0 || nc < 0 || nr >= height || nc >= width) { // 배열 넘어가면 넘김
                    continue;
                }
 
                if (!visited[nr][nc] && map[nr][nc] == 0) { // 빙산 높이가 0이고 방문 안했으면 바다이므로 카운트
                    seaNum++;
                }
            }
            
            // 빙산 녹이기
            if (map[cur.r][cur.c] - seaNum < 0) {
                map[cur.r][cur.c] = 0;
            } else {
                map[cur.r][cur.c] -= seaNum;
            }
        }
    }
}
