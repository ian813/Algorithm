import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int school, road;
	static int[] parent;
	static ArrayList<Edge> edgeList;
	static char[] gender;
	
	// 엣지 클래스(거리로 오름차순 정렬)
	static class Edge implements Comparable<Edge>{
		int start, end, distance;
		
		Edge(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 학교, 도로 개수
		school = sc.nextInt();
		road = sc.nextInt();
		
		// 대학별 성별 담을 배열
		gender = new char[school+1];
		
		for(int i = 1; i <= school; i++) {
			gender[i] = sc.next().charAt(0);
		}
		
		// 엣지리스트
		edgeList = new ArrayList<>();
		
		// 정보입력받기
		for(int i = 0; i < road; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int distance = sc.nextInt();
			
			Edge e = new Edge(start, end, distance);
			
			edgeList.add(e);
		}
		
		sc.close();
		
		// 거리기준 오름차순 정렬
		Collections.sort(edgeList);
		
		// 대표자를 담을 배열
		parent = new int[school+1];
		
		// makeSet
		for(int i = 1; i <= school; i++) {
			parent[i] = i;
		}
		
		int pick = 0; // 뽑은 도로 개수
		int ans = 0; // 답
		
		for(int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			
			// 둘의 대표자가 다르고 둘의 성별이 다르면
			if(findSet(e.start) != findSet(e.end) && gender[e.start] != gender[e.end]) {
				// 도로개수 카운팅하고 거리 누적시키고 union시킨다.
				pick++;
				ans += e.distance;
				union(e.start, e.end);
			}
			
			// 원하는 만큼 뽑으면 멈춘다.
			if(pick == school - 1) break;
		}
		
		// 만약 원하는 만큼 못 뽑았으면 연결이 안되는 것이므로
		// 답을 -1로 바꿔준다.
		if(pick != school - 1) {
			ans = -1;
		}
		
		// 답 출력
		System.out.println(ans);
	}
	
	// findSet
	static int findSet(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findSet(parent[x]);
	}
	
	// union (y 대표자를 x 대표자로 합치기)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}
