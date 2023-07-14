import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int height, width;
    static char[][] map;
    static boolean[][] visited;
    // 델타배열(상하좌우)
    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    // 포인트 클래스 (좌표와 거리 담기)
    static class Point{
        int r, c, dist;

        Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 높이 너비 입력받기
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        // 맵 정보 입력
        map = new char[height][width];

        for (int i = 0; i < height; i++) {
            String str = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 결과값
        int result = 0;

        for (int i = 0; i < height; i++) {
            for (int j= 0; j < width; j++) {
                if (map[i][j] == 'L') { // 땅이면 탐색
                    // 방문체크 (모든 출발점에서 최댓값을 구해서 갱신해야하므로 초기화)
                    visited = new boolean[height][width];
                    visited[i][j] = true; // 현재 지점 방문 체크
                    int tmp = BFS(i, j); // 현재 지점에서 출발한 거리 최댓값 구하기

                    // 최댓값 갱신
                    result = Math.max(tmp, result);
                }
            }
        }
        // 결과값 출력
        System.out.println(result);
    }

    static int BFS(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        // 최대 거리 담을 변수 (참고 : shift+F6 -> 변수명 일괄변경)
        int distance = 0;
        // 현재 포인트 큐에 넣기
        queue.add(new Point(r, c, 0));

        while (!queue.isEmpty()) { // 큐가 빌 때까지 실행
            Point cur = queue.poll();
            
            // 거리 최댓값을 계속 갱신
            distance = Math.max(distance, cur.dist);

            for (int i = 0; i < 4; i++) { // 델타배열로 탐색
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                // 탐색한 곳이 배열범위 넘어가거나 이미 방문한 곳이거나 바다면 넘기기
                if (nr < 0 || nc < 0 || nr >= height || nc >= width) continue;
                if (visited[nr][nc] || map[nr][nc] == 'W') continue;
                
                // 위에 조건 다 통과하면 방문체크하고 포인트 새로 큐에 넣어주기
                visited[nr][nc] = true;
                queue.add(new Point(nr, nc, cur.dist+1));

            }
        }
        // 현재 출발점에서 최대거리 리턴값으로 받기
        return distance;
    }
}
