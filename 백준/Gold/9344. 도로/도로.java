import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 테스트케이스, 도시, 도로, 이어야되는 시작과 끝 도시
    static int testCase, city, road, startCity, endCity;
    static int[] p; // 대표자
    static ArrayList<Edge> edgeList;
    
    // 엣지 클래스
    static class Edge implements Comparable<Edge>{
        int start, end, cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        // 테케
        testCase = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine().trim());

            city = Integer.parseInt(st.nextToken());
            road = Integer.parseInt(st.nextToken());
            startCity = Integer.parseInt(st.nextToken());
            endCity = Integer.parseInt(st.nextToken());

            edgeList = new ArrayList<>();

            for(int i = 0; i < road; i++) { // 도로 개수만큼 엣지리스트 추가
                st = new StringTokenizer(br.readLine().trim());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edgeList.add(new Edge(start, end, cost));

            }

            // 비용순 오름차순 정렬
            Collections.sort(edgeList);
            
            // makeSet
            p = new int[city+1];
            for (int i = 1; i <= city; i++) {
                p[i] = i;
            }
            
            String ans = "NO"; // 출력할 답
            int pick = 0; // 뽑은 도로 개수

            for(int i = 0; i < edgeList.size(); i++) {
                Edge e = edgeList.get(i);

                if(findSet(e.start) != findSet(e.end)) { // 시작과 끝 도시의 대표자가 다르면
                    pick++; // 뽑고
                    union(e.start, e.end); // union
                    if((e.start == startCity && e.end == endCity) || (e.start == endCity && e.end == startCity)) {
                        ans = "YES"; // startCity와 endCity를 연결하는 도로가 있으면 답 바꿔주기
                        break; // 모든 도시를 잇는 건 문제에서 보장했으므로 찾으면 멈춘다.
                    }
                }

                if (pick == city - 1) break; // 원하는만큼 뽑았어도 멈추기
            }
            // 스트링빌더에 담아주기
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    // findSet
    static int findSet(int x) {
        if(x == p[x]) return x;
        return p[x] = findSet(p[x]);
    }

    // union
    static void union(int x, int y) {
        p[findSet(x)] = findSet(y);
    }
}
