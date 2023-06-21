import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int N, M, K; // 정점 수, 간선 수, 턴 수
	static ArrayList<Edge> edgeList; // 간선 정보
	static int[] parent; // 대표자
	
	// 엣지 클래스
	static class Edge implements Comparable<Edge>{
		int start, end, weight;
		
		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		// 가중치 기준 오름차순 정렬
		@Override
		public int compareTo(Main.Edge o) {
			if(this.weight > o.weight) {
				return 1;
			} else if(this.weight < o.weight) {
				return -1;
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		edgeList = new ArrayList<>();
		
		// 엣지 정보 입력받기
		for(int i = 1; i <= M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			Edge e = new Edge(start, end, i);
			
			edgeList.add(e);
		}
		
		sc.close();
		
		// 가중치 기준 오름차순 정렬
		Collections.sort(edgeList);
		
		StringBuilder sb = new StringBuilder();
		
		int score; // 점수
		
		parent = new int[N+1];
		
		while(K-- > 0) {
			score = 0;
			int pick = 0; // 뽑은 간선 개수
			
			makeSet(); // 대표자 설정
			
			for(int i = 0; i < edgeList.size(); i++) {
				Edge e = edgeList.get(i);
				
				// 시작점과 끝점의 대표자가 다르면
				if(findSet(e.start) != findSet(e.end)) {
					// 뽑은 개수 카운팅, 점수 누적, 유니온
					pick++;
					score += e.weight;
					union(e.start, e.end);
				}
				
				if(pick == N-1) break; // 원하는 만큼 뽑으면 중단
			}
			
			// 만약 엣지를 다 돌았는데 원하는 만큼 못 뽑았으면 점수는 0으로 초기화
			if(pick != N-1) score = 0;
			
			sb.append(score + " ");
			
			// 가중치 가장 작은거 (맨 앞에 있는 거 없애기)
			edgeList.remove(0);
		}
		
		System.out.println(sb);
	}
	
	// makeSet
	static void makeSet() {
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	// findSet
	static int findSet(int x) {
		if(x == parent[x]) return x;
		return findSet(parent[x]);
	}
	
	// union (y 대표자를 x 대표자로 갱신)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}
