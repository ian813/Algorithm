import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author 정의석
 * 크루스칼 알고리즘으로 풀어보자.
 * 크루스칼 알고리즘을 쓰면 N개의 점을 N-1개의 선으로 사이클 없이 연결하므로
 * 출발점에서 시작해서 다시 출발점으로 돌아오는데 2*N - 1개의 점과 2*(N-1)개의 선을 지난다.
 * 원래 어레이리스트로 풀었는데 이번엔 우선순위큐로 크루스칼 알고리즘 풀어봐야겠다!!
 *
 */

public class Main {
	
	static int country, road;
	static int[] parent, visitCost;
	static PriorityQueue<Edge> edges;
	
	// 엣지 클래스
	static class Edge implements Comparable<Edge>{
		int start, end, cost;
		
		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 나라, 도로 개수
		country = sc.nextInt();
		road = sc.nextInt();
		
		// 나라 방문 비용
		visitCost = new int[country+1];
		
		// 정보 입력
		for(int i = 1; i <= country; i++) {
			visitCost[i] = sc.nextInt();
		}
		
		// 엣지정보 담을 우선순위큐
		edges = new PriorityQueue<>();
		
		// 엣지 정보
		for(int i = 0; i < road; i++) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			
			// 비용은 연결된 엣지의 비용의 2배(왔다갔다할 떄 두번 엣지를 거치므로)와 시작점과 끝점을 방문하는 비용(왔다갔다할 때 두번 지나게되므로)로 설정해주면 된다.
			cost = 2 * cost + visitCost[st] + visitCost[end];
			
			Edge e = new Edge(st, end, cost);
			
			// 우선순위 큐라 비용 순으로 자동 오름차순 정렬(엣지 클래스의 비교 기준을 비용으로 설정해뒀다.)
			edges.add(e);
		}
		
		sc.close();
		
		parent = new int[country+1];
		
		// makeSet
		for(int i = 1; i <= country; i++) {
			parent[i] = i;
		}
		
		// 뽑은 선 개수, 최소비용
		int pick = 0;
		int minCost = 0;

		while(!edges.isEmpty()) { // 큐가 빌 때까지 실행
			Edge e = edges.poll();
			
			// 시작점과 끝점의 대표자가 다르면
			if(findSet(e.start) != findSet(e.end)) {
				// 뽑은 개수 카운팅하고 union하고 비용 누적시켜준다.
				pick++;
				union(e.start, e.end);
				minCost += e.cost;
			}
			
			// 다 뽑았으면 중지
			if(pick == country - 1) break;
		}
		// 이렇게 하면 2(N-1)개의 나라의 방문 비용과 엣지 비용을 냈으므로
		// 나라 하나의 방문 비용만 더 더해주면 된다. (이게 시작점)
		// 왜냐하면 어떤 점에서 시작해도 시작점을 제외하고 각 나라의 방문횟수는 동일하므로..
		// 또한 시작점은 임의로 지정해주면 되므로 가장 방문 비용 작은 값을 더해주면 된다.
		// 여기서 한번 오름차순으로 방문비용을 정렬해준다.
		Arrays.sort(visitCost);
		
		// 처음 있는게 최소 비용이므로 더해준다.
		minCost += visitCost[1];
				
		// 비용출력
		System.out.println(minCost);
	}
	
	// findSet
	static int findSet(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findSet(parent[x]);
	}
	
	// union
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
	
}
