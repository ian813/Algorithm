import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int n; // 행성 개수
	static PriorityQueue<Edge> queue; // 행성 간 거리를 담을 큐 (자동으로 정렬)
	static int[] parent; // 집합의 대표자
	static int result; // 결과값
	static Planet[] planet; // 행성 정보를 담을 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		planet = new Planet[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			planet[i] = new Planet(i, x, y, z); // 행성의 넘버와 좌표
		}
		
		sc.close();
		
		queue = new PriorityQueue<>();

		// x좌표 순서대로 오름차순 정렬 후 작은 값부터 queue에 edge정보 저장.
		Arrays.sort(planet, (o1, o2) -> o1.x - o2.x);
		for (int i = 0; i < n - 1; i++) {
			queue.offer(new Edge(planet[i].num, planet[i + 1].num, Math.abs(planet[i].x - planet[i + 1].x)));
		}
		// y좌표 순서대로 오름차순 정렬 후 작은 값부터 queue에 edge정보 저장.
		Arrays.sort(planet, (o1, o2) -> o1.y - o2.y);
		for (int i = 0; i < n - 1; i++) {
			queue.offer(new Edge(planet[i].num, planet[i + 1].num, Math.abs(planet[i].y - planet[i + 1].y)));
		}
		// z좌표 순서대로 오름차순 정렬 후 작은 값부터 queue에 edge정보 저장.
		Arrays.sort(planet, (o1, o2) -> o1.z - o2.z);
		for (int i = 0; i < n - 1; i++) {
			queue.offer(new Edge(planet[i].num, planet[i + 1].num, Math.abs(planet[i].z - planet[i + 1].z)));
		}
		
		// 이렇게하면 가장 작은값부터 오름차순 정렬됨 (그리고 같은 행성번호로 연결되어 있으면 대표자가 같다.)
		// 따라서 x좌표로 행성을 연결하고 비용을 썼으면, 나중에 같은 행성을 y나 z좌표로 연결한 엣지가 나와도 대표자가 같으므로 패스할 수 있다.
		// 따라서 한번 연결된 행성들의 비용을 중복 계산할 일이 없고, 오름차순 정렬되어 있으므로 연결 안 된 행성들을 처음 연결할 때 최소 비용으로 연결이 된다.
		
		parent = new int[n];
		kruskal();
		// 결과값 출력
		System.out.println(result);
	}

	// 크루스칼
	public static void kruskal() {
		// 대표자 설정
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		// 큐가 빌 때까지 실행
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			// 대표자를 찾아서 비교
			int p1 = find(edge.start);
			int p2 = find(edge.end);
			
			// 대표자 다르면 합치고 비용 더해주기
			if (p1 != p2) {
				union(p1, p2);
				result += edge.cost;
			}
		}
	}
	
	// 유니온
	public static void union(int a, int b) {
		parent[a] = b;
	}
	
	// 대표자 찾아주기 (본인이 대표자가 아니면 거슬러 올라가자)
	public static int find(int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}
	
	// 행성 클래스
	public static class Planet {
		// 행성번호, 좌표
		int num;
		int x;
		int y;
		int z;

		public Planet(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	// 엣지 클래스
	public static class Edge implements Comparable<Edge> {
		// 시작행성번호, 끝행성번호, 비용
		int start;
		int end;
		int cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		// 비용 순 정렬
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}

}
