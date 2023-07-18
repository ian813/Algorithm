import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int testCase, height, width;
    static char[][] map;
    static boolean[][] visited;
    // 델타배열 (상하좌우)
    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    static class Point{
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // 테스트케이스
        testCase = sc.nextInt();

        for (int tc = 1; tc <= testCase; tc++) {
            // 맵의 높이, 너비
            height = sc.nextInt();
            width = sc.nextInt();

            map = new char[height][width];

            // 맵정보 입력받기
            for (int i = 0; i < height; i++) {
                String str = sc.next();
                for (int j = 0; j < width; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            // 방문체크
            visited = new boolean[height][width];

            int part = 0; // 무리 개수

            // BFS로 탐색
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++) {
                    if(map[i][j] == '#' && !visited[i][j]) {
                        // 양이고 방문 안한 곳이면 BFS로 탐색
                        BFS(i, j);
                        // 빠져나왔으면 무리 개수 카운팅
                        part++;
                    }
                }
            }
            // 스트링빌더에 정답 담기
            sb.append(part + "\n");
        }
        sc.close();
        
        // 출력
        System.out.println(sb);
    }

    static void BFS(int r, int c) {
        Queue<Point> queue = new LinkedList<>();

        // 현재 포인트를 담아주기
        queue.add(new Point(r, c));

        while (!queue.isEmpty()) { // 큐가 빌 때까지 실행
            Point cur = queue.poll(); // 큐에서 뽑아주기

            for (int i = 0; i < 4; i++) {
                // 델타배열로 탐색
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                // 배열 범위 넘어가거나 풀이거나 방문한 곳이면 넘기기
                if (nr < 0 || nc < 0 || nr >= height || nc >= width) continue;
                if (map[nr][nc] == '.' || visited[nr][nc]) continue;
                
                // 조건 통과했으면 탐색한 곳을 방문체크하고 큐에 넣어주기
                visited[nr][nc] = true;
                queue.add(new Point(nr, nc));
            }
        }
    }
}