import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int planet;
	static ArrayList<Edge> edgeList;
	static int[] parent;
	
	// 행성 연결 정보
	static class Edge implements Comparable<Edge>{
		int start, end, cost;
		
		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		// 비용으로 오름차순 정렬 (세 경우 모두 안해주면 illegalArgument 런타임에러 발생)
		@Override
		public int compareTo(Edge e) {
			if(this.cost > e.cost) {
				return 1;
			} else if(this.cost < e.cost) {
				return -1;
			} else {
				return 0;				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 행성 수
		planet = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		// 엣지리스트
		edgeList = new ArrayList<>();
		
		// 엣지 정보 입력받기
		for(int i = 0; i < planet; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j = 0; j < planet; j++) {
				
				int cost = Integer.parseInt(st.nextToken());
				
				if(i < j) { // 어차피 대칭이므로 위쪽 삼각행렬만 엣지로 저장해준다.
					Edge e = new Edge(i, j, cost);
					
					edgeList.add(e);									
				}
			}
		}
		
		// 비용으로 오름차순 정렬
		Collections.sort(edgeList);
		
		// 각 행성의 대표자를 담을 배열
		parent = new int[planet];
		
		// make-set
		for(int i = 0; i< planet; i++) {
			parent[i] = i;
		}
		
		// 뽑은 엣지 수, 플로우 최소 관리비용(비용 범위가 1억까지이므로 누적하면 int형으로 받으면 터진다.)
		int pick = 0;
		long ans = 0;
		
		for(int i = 0; i < edgeList.size(); i++) { // 엣지리스트를 돌면서 하나씩 뽑는다.
			Edge e = edgeList.get(i);
			
			if(findSet(e.start) != findSet(e.end)) {
				// 시작행성과 끝행성의 대표자가 다르면 그 엣지를 뽑고
				pick++;
				// 비용 누적시킨 뒤
				ans += e.cost;
				// 둘의 대표자를 일치시켜준다.
				union(e.start, e.end);
			}
			// 뽑은 개수가 행성수-1개가 되면 더이상 뽑을 필요가 없다. (다 연결됨)
			if(pick == planet-1) break;
		}
		// 출력
		System.out.println(ans);
	}
	
	// findSet
	static int findSet(int x) {
		if(x == parent[x]) {
			return x;
		}
		return findSet(parent[x]);
	}
	
	// union (y 대표자를 x 대표자로 바꾸기)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}
