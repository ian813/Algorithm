import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int city;
    static int[][] adjArr;
    static ArrayList<Edge> edgeList, installList;
    static int[] p; // 대표자

    // 엣지 클래스 (비용 기준 오름차순 정렬 가능)
    static class Edge implements Comparable<Edge> {
        int st, end, cost;

        Edge(int st, int end, int cost) {
            this.st = st;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 도시 개수, 인접행렬
        city = sc.nextInt();
        adjArr = new int[city+1][city+1];

        // 총 비용
        int totalCost = 0;

        edgeList = new ArrayList<>();

        p = new int[city+1];

        // makeSet
        for(int i = 1; i <= city; i++) {
            p[i] = i;
        }
        
        // 이미 설치된 도로 세주기 (단, 대표자가 다를 때만)
        int pick1 = 0;

        for(int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                adjArr[i][j] = sc.nextInt();
                if(i > j) continue; // 어차피 대각선 기준 대칭이니까 위쪽일 때만 로직 진행

                if (adjArr[i][j] < 0) { // 이미 설치되어 있을 때
                    // 비용 더하기 (음수로 표현되어있으므로 빼줌)
                    totalCost -= adjArr[i][j];

                    if(findSet(i) != findSet(j)) {
                        pick1++; // 대표자가 다를 때만 뽑아주고, 유니온
                        union(i, j);
                    }
                } else if(adjArr[i][j] > 0) { // 설치 안 되어 있을 때
                    // 아직 지어지지 않은 거는 엣지리스트에 넣어주기 (비용정보와 함께)
                    edgeList.add(new Edge(i, j, adjArr[i][j]));
                }
            }
        }
        sc.close();

        // 비용 순 오름차순 정렬
        Collections.sort(edgeList);

        int pick2 = 0; // 새로 설치될 도로 세주기

        installList = new ArrayList<>();

        for(int i = 0; i < edgeList.size(); i++) {
            Edge e = edgeList.get(i);

            if(findSet(e.st) != findSet(e.end)) { // 시작과 끝 도시가 다른 대표자를 가지면
                // 뽑은 거 카운트, 비용 누적, 유니온
                pick2++;
                totalCost += e.cost;
                union(e.st, e.end);
                installList.add(new Edge(e.st, e.end, 0));
            }
            
            // 이미 설치된 거(대표자 다른 것들만 더함) + 새로 설치된 거가 원하는 수만큼 설치 되었으면 중단
            if(pick1 + pick2 == city - 1) break;
        }
        
        // 건설 총 비용, 새로 지은 도로 개수 출력
        System.out.println(totalCost + " " + pick2);
        for(int i = 0; i < installList.size(); i++) {
            Edge e = installList.get(i);
            // 설치한 도로와 연결된 도시들 출력
            System.out.println(e.st + " " + e.end);
        }

    }

    // findSet
    static int findSet(int x) {
        if(x == p[x]) return x;
        return p[x] = findSet(p[x]);
    }

    // union
    static void union(int x, int y) {
        p[findSet(y)] = findSet(x);
    }
}