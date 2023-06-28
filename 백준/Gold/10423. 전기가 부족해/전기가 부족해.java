import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int city, cable, plant; // 도시, 캐이블, 발전소 수
	static int[] parent; // 대표자
	static ArrayList<Edge> edgeList; // 엣지리스트
	
	// 엣지 클래스 (비용 순 오름차순 정렬 가능)
	static class Edge implements Comparable<Edge> {
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
		
		city = Integer.parseInt(st.nextToken());
		cable = Integer.parseInt(st.nextToken());
		plant = Integer.parseInt(st.nextToken());
	
		parent = new int[city+1];
		
		// makeSet
		for(int i = 1; i <= city; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		
		// 발전소 정보 입력받기 (발전소의 대표자를 -1로 초기화, 모든 도시의 대표자가 -1로 바뀌면 탐색 종료할 거임)
		for(int i = 0; i < plant; i++) {
			int idx = Integer.parseInt(st.nextToken());
			parent[idx] = -1;
		}
		
		edgeList = new ArrayList<>();
		
		// 엣지 정보 입력받기
		for(int i = 0; i < cable; i++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			Edge e = new Edge(start, end, cost);
			
			edgeList.add(e);
		}
		
		// 비용 오름차순 정렬
		Collections.sort(edgeList);
		
		int minCost = 0; // 최소 비용
		
		for(int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			
			// 대표자가 다르면 (발전소끼리 연결 못하게 해야한다...)
			if(findSet(e.start) != findSet(e.end)) {
				// 비용 누적시키고 유니온시키기
				minCost += e.cost;
				union(e.start, e.end);
			}
			
			// 다 연결되었으면 멈추기
			if(isConnect()) break;
		}
		
		System.out.println(minCost);
	}
	
	// findSet (x의 대표자를 찾아주기, -1이 대표이면 -1 리턴)
	static int findSet(int x) {
		if(parent[x] == -1) return -1;
		if(x == parent[x]) return x;
		return parent[x] = findSet(parent[x]);
	}
	
	// union (y 대표자를 x 대표자로 변경, 단 둘 중 하나의 대표자가 -1이면 다른 쪽의 대표자를 -1로 변경)
	static void union(int x, int y) {

		if(findSet(x) == -1) {
			parent[findSet(y)] = -1;
		} else if(findSet(y) == -1) {
			parent[findSet(x)] = -1;
		} else {
			parent[findSet(y)] = findSet(x);			
		}
	}
	
	// 다 연결되었는지 체크할 메서드
	static boolean isConnect() {
		// 다 연결되었는지 나타낼 불리안
		boolean flag = true;
		
		for(int i = 1; i <= city; i++) {
			if(parent[i] != -1) {
				// 대표자가 -1이 아닌 도시가 존재하면 false로 바꾸고 중단
				flag = false;
				break;
			}
		}
		
		return flag;
		
	}
}
