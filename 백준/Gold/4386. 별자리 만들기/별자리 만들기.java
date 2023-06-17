import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int n;
	static Star[] place;
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	// 별의 위치를 담을 클래스
	static class Star{
		int num;
		double x, y;
		
		Star(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	// 별을 이은 엣지를 나타낼 클래스(시작별, 끝별, 가중치)
	static class Edge implements Comparable<Edge>{
		int start, end;
		double weight;
		
		Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		// 가중치로 오름차순 정렬 (비교할 가중치가 기존 가중치보다 작으면 양수 리턴)
		@Override
		public int compareTo(Edge o) {
			if(this.weight > o.weight) {
				return 1;
			}
			return -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 별 개수
		n = sc.nextInt();
		
		// 별 위치 정보
		place = new Star[n];
		
		for(int i = 0; i < n; i++) {
			// 새로운 별을 생성해서 좌표 입력받고
			Star s = new Star(i, sc.nextDouble(), sc.nextDouble());
			// 넣어주기
			place[i] = s;
		}
		
		sc.close();
		
		edgeList = new ArrayList<>();
		// 각 별 사이의 가중치를 모두 계산해서 edgeList에 저장
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				double weight = calDistance(place[i], place[j]);
				
				edgeList.add(new Edge(place[i].num, place[j].num, weight));
			}
		}
		// 가중치를 기준으로 오름차순 정렬
		Collections.sort(edgeList);
		
		// 크루스칼 알고리즘 쓸거임!
		// make-set (자신을 대표로 초기화)
		parent = new int[n];
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		// 답을 저장할 변수
		double ans = 0;
		
		int pick = 0; // 뽑은 edge의 수
		
		// edgeList를 돌면서 수행 (가중치 낮은걸로 정렬되어 있다)
		for(int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			
			if(findSet(e.start) != findSet(e.end)) { // edge의 시작별과 끝별의 대표자가 다르면 아직 연결 안되어 있으므로
				ans += e.weight; // edge의 가중치를 더해주고
				union(e.start, e.end); // 둘을 합쳐서 대표자를 같게 만들어준다.
				pick++; // 현재 edge를 뽑은 것이므로 카운팅
			}
			
			if(pick == n-1) break; // edge를 다 뽑았으면 멈추기
		}
		
		System.out.println(ans);
		
	}
	
	// 거리를 계산해줄 메서드
	static double calDistance(Star s1, Star s2) {
		double tmp = Math.pow(s1.x-s2.x, 2) + Math.pow(s1.y-s2.y, 2);
		double distance = Math.sqrt(tmp);
		return distance;
	}
	
	// findSet
	static int findSet(int x) {
		if(x == parent[x]) return x;
		
		return findSet(parent[x]);
	}
	
	// Union (y를 x 밑으로 합치기)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}
