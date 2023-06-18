import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 크루스칼로 풀어야겠다!
public class Main {
	
	static int computer, connect; // 컴퓨터 수, 연결 수
	static ArrayList<Edge> edgeList; // 엣지리스트
	static int[] parent; // 대표자 나타낼 배열
	
	// 엣지 클래스
	static class Edge implements Comparable<Edge>{
		int start, end, weight;
		
		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			if(this.weight > e.weight) {
				// 기존 있던것보다 나중에 들어온게 더 작으면 나중에 들어온게 더 앞으로 가야하므로 위치를 바꿔야 한다. 따라서 1을 리턴
				return 1;
			}
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		computer = Integer.parseInt(br.readLine());
		connect = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList<>();
		
		// edge 입력받기
		for(int i = 0; i < connect; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			Edge e = new Edge(start, end, weight);
			
			edgeList.add(e);
		}
		
		// 오름차순 정렬 (comparable을 이용해서 정렬 기준을 설정해주어서 weight 기준 오름차순으로 자동 정렬된다.)
		Collections.sort(edgeList);
		
		parent = new int[computer+1];
		
		// make-set
		for(int i = 1; i <= computer; i++) {
			parent[i] = i;
		}
		
		int pick = 0; // 뽑은 엣지 수
		int ans = 0; // 답
		
		
		// 모든 edge들을 탐색
		for(int i = 0; i < edgeList.size(); i++) {
			// edge 하나 받아오기
			Edge e = edgeList.get(i);
			
			// 시작과 끝 컴퓨터의 대표자가 다르면 뽑아주고 가중치 누적해주고 유니온해주면 된다.
			if(findSet(e.start) != findSet(e.end)) {
				pick++;
				ans += e.weight;
				union(e.start, e.end);
			}
			
			// edge를 원하는만큼 뽑았으면 중단
			if(pick == computer-1) break;
		}
		
		// 답 출력
		System.out.println(ans);
	}
	
	// findSet (대표자 찾기)
	static int findSet(int x) {
		if(x == parent[x]) return x;
		return findSet(parent[x]);
	}
	
	// union (y를 x대표자로 합치기)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}
