import java.util.*;

public class Main {
    static int node, edge, startNode, cnt;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] cntArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        node = sc.nextInt();
        edge = sc.nextInt();
        startNode = sc.nextInt();

        adjList = new ArrayList[node+1];

        for (int i = 1; i <= node; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            adjList[start].add(end);
            adjList[end].add(start);
        }

        // 오름차순 정렬
        for (int i = 1; i <= node; i++) {
            Collections.sort(adjList[i]);
        }

        cnt = 1; // 몇번째 방문인지 담아줄 변수
        cntArr = new int[node+1]; // 각 노드를 몇번째로 방문했는지 담아줄 배열

        // 방문체크
        visited = new boolean[node+1];

        // 탐색
        BFS(startNode);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= node; i++) {
            sb.append(cntArr[i] + "\n");
        }

        System.out.println(sb);
    }

    static void BFS(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        // 현재 점 큐에 추가
        queue.add(cur);

        while (!queue.isEmpty()) {
            // 큐에서 뺀 점을 시작점으로 하고 방문체크
            int start = queue.poll();

            visited[start] = true;
            cntArr[start] = cnt++;

            for (int i = 0; i < adjList[start].size(); i++) {
                // 다음가는 곳 설정
                int next = adjList[start].get(i);
                
                if(!visited[next]) { // 방문 안했으면
                    // 큐에 넣어주고 방문체크
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}