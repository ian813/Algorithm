import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 위상정렬을 하되, N번 노드부터 시작 -> 거꾸로 위상정렬
 * 왜냐하면 N번째 완구를 완성하는게 목표이므로
 */

public class Main {

    static int N, M;
    static int[] inDegree, dp;
    static ArrayList<Node>[] adjList;

    static class Node {
        int num, cnt;

        Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 부품의 번호, 부품 관계 개수
        N = sc.nextInt();
        M = sc.nextInt();

        // 진입차수
        inDegree = new int[N+1];
        
        dp = new int[N+1]; // 부품이 쓰인 누적값
        
        // 인접관계
        adjList = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 기본 부품 찾는 배열 생성 (진입차수가 없고, 다른거 만드는데 쓰이면 기본부품)
        int[] basic = new int[N+1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            // 인접 정보 추가 (x를 만드는데 필요한 부품 y가 k개 쓰임)
            adjList[x].add(new Node(y, k));
            // y에 진입차수 추가
            inDegree[y]++;
            basic[x]++;
        }

        topologicalSort();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if(basic[i] != 0) continue;
            sb.append(i + " " + dp[i] + "\n");
        }
        System.out.println(sb);
    }

    static void topologicalSort() {
        Queue<Node> queue = new LinkedList<>();

        // 완제품 1개만 만들면 된다.
        queue.add(new Node(N, 1));

        dp[N] = 1;

        while (!queue.isEmpty()) {
            // 현재 노드를 뽑아주고
            Node cur = queue.poll();

            for (int i = 0; i < adjList[cur.num].size(); i++) {
                // 그 노드 번호에 인접한 노드만큼 반복
                // 그 다음 노드를 선택
                Node next = adjList[cur.num].get(i);

                // 진입차수 빼줌
                inDegree[next.num]--;
                
                // 다음꺼를 만드는데 필요한 개수 = 현재꺼 만드는데 필요한 개수 * 다음꺼 카운트
                dp[next.num] += dp[cur.num] * next.cnt;

                if(inDegree[next.num] == 0) {
                    queue.add(new Node(next.num, dp[next.num]));
                }
            }
        }
    }
}
