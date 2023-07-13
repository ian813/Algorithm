import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    static int height, width, part;
    static int[][] map;
    static boolean[][] visited;
    // 델타배열(상하좌우)
    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 높이, 너비
        height = sc.nextInt();
        width = sc.nextInt();

        // 맵 정보
        map = new int[height][width];

        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        sc.close();
        
        // 방문체크 배열
        visited = new boolean[height][width];
        
        part = 0; // 구역 개수

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    // 빈공간이고 (숲이 아니고) 방문 안 한 곳이면
                    // 방문체크하고 탐색
                    visited[i][j] = true;
                    explore(i, j);
                    // 탐색에서 빠져나오면 구역 개수 카운트
                    part++;
                }
            }
        }
        System.out.println(part);
    }

    static void explore(int r, int c) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {r, c});

        while (!queue.isEmpty()) { // 큐가 빌 때까지 탐색

            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = (cur[0] + dr[i]) % height;
                int nc = (cur[1] + dc[i]) % width;

                // 배열 넘어가면 좌표 수정해주기
                if(nr < 0) nr = height - 1;
                if(nc < 0) nc = width - 1;

                // 탐색한 곳이 숲이거나 방문한 곳이면 넘기기
                if (map[nr][nc] == 1 || visited[nr][nc]) continue;

                // 그게 아니면 방문체크하고 새로운 점 큐에 넣어주기
                visited[nr][nc] = true;
                queue.add(new int[] {nr, nc});
            }
        }
    }
}
