import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int god, connect; // 우주신의 수, 이미 연결된 통로 개수
	static Point[] pointInfo; // 포인트 정보
	static ArrayList<Edge> edgeList; // 엣지 리스트
	static int[] parent; // 대표자
	
	// 포인트 클래스 (신의 좌표)
	static class Point{
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// 엣지 클래스 (시작점, 끝점, 거리)
	static class Edge implements Comparable<Edge>{
		int start, end;
		double distance;
		
		Edge(int start, int end, double distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Main.Edge o) {
			if(this.distance > o.distance) {
				return 1;
			} else if(this.distance < o.distance) {
				return -1;
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		god = sc.nextInt();
		connect = sc.nextInt();
		
		pointInfo = new Point[god+1];
		
		// 포인트 정보 담아주기
		for(int i = 1; i <= god; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			pointInfo[i] = new Point(x, y);
		}
		
		edgeList = new ArrayList<>();
		
		// 엣지 정보를 담아주기
		for(int i = 1; i < god; i++) {
			for(int j = i+1; j <= god; j++) {
				double distance = calDistance(pointInfo[i], pointInfo[j]);
				Edge e = new Edge(i, j, distance);
				edgeList.add(e);
			}
		}
		
		// 거리 기준 오름차순 정렬
		Collections.sort(edgeList);
		
		parent = new int[god+1];
		
		// make-set
		for(int i = 1; i <= god; i++) {
			parent[i] = i;
		}
		
		// 이미 연결되어 있는 신들 입력받아서
		for(int i = 0; i < connect; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 둘의 대표자가 다르면 미리 합치기
			if(findSet(a) != findSet(b)) {
				union(a, b);
			}
		}
		
		sc.close();

		double ans = 0; // 답
		
		// 엣지리스트 돌면서
		for(int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			
			// 시작점과 끝점의 대표자가 다르면
			if(findSet(e.start) != findSet(e.end)) {
				// 카운팅하고 거리 누적시키고 합쳐준다.
				ans += e.distance;
				union(e.start, e.end);
			}

		}
		
		// 형식에 맞게 출력
		System.out.printf("%.2f\n", ans);
	}
	
	// 거리 계산할 메서드
	static double calDistance(Point p1, Point p2) {
		double tmp = Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
		double distance = Math.sqrt(tmp);
		
		return distance;
	}
	
	// findSet
	static int findSet(int x) {
		if(x == parent[x]) return x;
		return findSet(parent[x]);
	}
	
	// union (y 대표자를 찾아서 x 대표자로 업데이트)
	static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
}
