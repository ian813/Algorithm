import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int house, road;
	static ArrayList<Edge> edgeList;
	static int[] parent;
	
	// 엣지 클래스 (시작집, 끝집, 거리)
	static class Edge implements Comparable<Edge> {
		int x, y, z;
		
		Edge(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.z - o.z;
		}	
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			// 집과 도로 개수 입력받기
			house = Integer.parseInt(st.nextToken());
			road = Integer.parseInt(st.nextToken());
			
			if(house == 0 && road == 0) break; // 입력받은 값이 모두 0이면 멈추기
			
			edgeList = new ArrayList<>(); // 엣지리스트
			
			// 총 비용 (거리의 총합)
			int totalCoat = 0;
			
			// 엣지 정보 입력받기
			for(int i = 0; i < road; i++) {
				st = new StringTokenizer(br.readLine().trim());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				Edge e = new Edge(x, y, z);
				
				edgeList.add(e);
				
				// 비용 누적
				totalCoat += z;
			}
			
			// z (거리) 기준 오름차순 정렬
			Collections.sort(edgeList);
			
			parent = new int[house];
			
			// makeSet
			for(int i = 1; i < house; i++) {
				parent[i] = i;
			}
			
			// 뽑은 간선 수, 최소연결비용
			int pick = 0;
			int cost = 0;
			
			for(int i = 0; i < edgeList.size(); i++) {
				Edge e = edgeList.get(i);
				
				// 엣지의 시작 끝의 대표자가 다르면 뽑아주고 비용 누적시키고 유니온시킨다.
				if(findSet(e.x) != findSet(e.y)) {
					pick++;
					cost += e.z;
					union(e.x, e.y);
				}
				
				// 원하는 만큼 뽑으면 멈추기
				if(pick == house-1) break;
			}
			
			// 최대절약비용 (= 총비용 - 최소연결비용)
			int ans = totalCoat - cost;
			
			sb.append(ans + "\n");
			
		}
		
		System.out.println(sb);
	}
	
	// findSet
	static int findSet(int x) {
		if(x == parent[x]) return x;
		return findSet(parent[x]);
	}
	
	// union (y 대표자를 x 대표자로 바꾸기)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}
