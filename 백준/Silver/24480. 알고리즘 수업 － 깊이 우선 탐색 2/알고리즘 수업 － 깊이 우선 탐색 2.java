import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int node, edge, startNode, cnt;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder sb;
    static int[] cntArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        // 노드 개수, 엣지 개수, 시작 정점
        node = sc.nextInt();
        edge = sc.nextInt();
        startNode = sc.nextInt();

        // 인접 정보 입력받기
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

        // 내림차순 정렬
        for (int i = 1; i <= node; i++) {
            Collections.sort(adjList[i], Collections.reverseOrder());
        }

        sc.close();
        // 각 노드를 몇번쨰로 방문했는지 세줄 배열 (forEach문 쓰려고 노드랑 인덱스 안맞춰줌,, 나중에 node-1 해서 저장해주면 됨)
        cntArr = new int[node];
        // 몇번째 방문인지 담을 변수
        cnt = 1;
        // 방문체크
        visited = new boolean[node+1];
        // 탐색
        DFS(startNode);
        for (int ans : cntArr) {
            sb.append(ans + "\n");
        }
        // 출력
        System.out.println(sb);
    }

    static void DFS(int cur) {
        // 방문체크
        visited[cur] = true;
        cntArr[cur-1] = cnt++;

        for (int next : adjList[cur]) {

            if(!visited[next]) {
                // 인접 정점이고 방문 안했으면
                // 탐색
                DFS(next);
            }
        }
    }
}