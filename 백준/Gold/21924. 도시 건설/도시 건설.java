import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int building, road;
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	static class Edge implements Comparable<Edge>{
		int st, end, cost;
		
		Edge(int st, int end, int cost) {
			this.st = st;
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
		
		building = sc.nextInt();
		road = sc.nextInt();
		
		edgeList = new ArrayList<>();
		
		long totalCost = 0;
		
		// 엣지 추가
		for(int i = 0; i < road; i++) {
			Edge e = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			edgeList.add(e);
			
			totalCost += e.cost; // 총 비용 구해주기
		}
		
		sc.close();
		
		// 오름차순 정렬
		Collections.sort(edgeList);
		
		// makeSet
		parent = new int[building+1];
		for(int i = 1; i <= building; i++) {
			parent[i] = i;
		}
		
		int pick = 0;
		long minCost = 0;
		
		for(int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			
			// 두 대표자가 다르면
			if(findSet(e.st) != findSet(e.end)) {
				// 뽑아주고, 비용 누적시키고 union
				pick++;
				minCost += e.cost;
				union(e.st, e.end);
			}
			
			// 원하는만큼 뽑았으면 멈추기
			if(pick == building - 1) break;
		}
		
		// 모든 건물이 연결되지 않으면 -1 출력
		if(pick != building - 1) {
			System.out.println(-1);
		} else { // 아니면 절약 금액 출력
			long saveCost = totalCost - minCost;
			
			System.out.println(saveCost);
		}
		
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
