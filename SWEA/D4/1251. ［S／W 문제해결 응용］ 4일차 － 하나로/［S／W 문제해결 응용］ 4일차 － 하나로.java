import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
    // 테스트케이스 입력받기
    static int testCase = sc.nextInt();
    static int N; // 섬의 개수
    static double E; // 세율
    static long[][] map; // 섬의 x, y 좌표
    static double[] minCost; // 최소 비용을 저장할 변수
    static double ans; // 답을 저장할 변수
    static boolean[] visited; // 방문 체크
    static final long INF = Long.MAX_VALUE;
    
    static void input() {
        // 섬의 갯수 입력받기
        N = sc.nextInt();
        // 섬의 x, y좌표를 저장할 배열
        map = new long[N][2];
        // 섬들의 x좌표 입력받기
        for(int i=0;i<N;i++) {
            map[i][0] = sc.nextLong();
        }
        // 섬들의 y좌표 입력받기
        for(int i=0;i<N;i++) {
            map[i][1] = sc.nextLong();
        }
        // 세율 입력받기
        E = sc.nextDouble();
    }
    
    static void solve() {
       // 최저 비용과 방문여부를 저장할 배열 생성
       minCost = new double[N];
       visited = new boolean[N];
       // 최대값으로 초기화
       Arrays.fill(minCost, INF);
        
       // 시작 섬을 0번 노드로 설정
       int start = 0;
       minCost[start] = 0;
        
       // 모든 섬을 순회하며 최소 비용 갱신
       for(int i=0;i<N;i++) {
           // 현재 섬에서 연결되는 간선 중 가장 가중치가 작은 간선을 찾는다.
           int minNode = -1;
           for(int j=0;j<N;j++) {
               if(!visited[j] && (minNode == -1 || minCost[j] < minCost[minNode])) {
                   minNode = j;
               }
           }
           // 최소 비용을 갖는 섬을 방문한다.
           visited[minNode] = true;
            
           // 현재 섬과 연결된 섬의 비용을 갱신한다.
           for(int j=0;j<N;j++) {
        	   // 방문 안한 섬이면
               if(!visited[j]) {
            	   // 거리 값을 계산해주고
            	   double cost = cal(minNode, j);
                   if(cost < minCost[j]) {
                       minCost[j] = cost;
                   }
               }
           }
       }
        
       // 최소 비용을 구해준다.
       ans = 0;
       for(int i=0;i<N;i++) {
           ans += minCost[i];
       }
    }
    
    public static void main(String[] args) {
        
        // 테스트 케이스만큼 반복
        for(int tc=1;tc<=testCase;tc++) {
        	input();
        	// solve 메서드
        	solve();
        	// 세율 곱해서 갱신
        	ans *= E;
        	// 형식에 맞게 담아주기
            sb.append("#"+tc+" "+ Math.round(ans)+"\n");      
             
        }   
        System.out.println(sb);
    }
     
    // 거리 계산 메서드
    static double cal(int i, int j) {
    	// 거리계산
        double cost = Math.pow(Math.abs(map[i][0] - map[j][0]), 2) + Math.pow(Math.abs(map[i][1] - map[j][1]), 2);
        return cost;
    }
}