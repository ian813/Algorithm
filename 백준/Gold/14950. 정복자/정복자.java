import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int city, road, increment;
	static int[] parent;
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
		public int compareTo(Main.Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		// 도시 개수, 도로 개수, 정복시 증가하는 도로 비용
		city = Integer.parseInt(st.nextToken());
		road = Integer.parseInt(st.nextToken());
		increment = Integer.parseInt(st.nextToken());
		
		// 엣지리스트
		edgeList = new ArrayList<>();
		
		// 엣지 정보 입력받기
		for(int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			Edge e = new Edge(start, end, cost);
			
			edgeList.add(e);
		}
		
		// 비용으로 오름차순 정렬
		Collections.sort(edgeList);
		
		// makeSet
		parent = new int[city+1];
		
		for(int i = 1; i <= city; i++) {
			parent[i] = i;
		}
		
		// 뽑은 도로개수, 누적시킬 최소 비용
		int pick = 0;
		int minCost = 0;
		
		// 크루스칼 사용
		for(int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			
			// 시작과 끝의 대표자가 다르면
			if(findSet(e.start) != findSet(e.end)) {
				minCost += e.cost + increment*pick; // 비용 누적 (한번 정복할 때마다 비용이 increment만큼 증가, 맨 처음 정복 땐 그대로)
				pick++; // 뽑은 도로개수 카운팅
				union(e.start, e.end); // 두 도시 대표자 합치기
			}
			
			if(pick == city - 1) break; // 다 뽑았으면 멈추기
		}
		
		System.out.println(minCost);
	}
	
	// findSet
	static int findSet(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findSet(parent[x]);
	}
	
	// union (y 대표자를 x 대표자로 변경)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}
