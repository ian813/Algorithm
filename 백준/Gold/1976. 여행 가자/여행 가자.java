import java.util.Scanner;

public class Main {
	static int city, plan; // 도시 수, 계획 수
	static int[][] connect; // 도시들의 연결 정보
	static int[] plans, parent; // 도시 방문 계획, 부모집합
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		city = sc.nextInt();
		plan = sc.nextInt();
		
		connect = new int[city+1][city+1];

		parent = new int[city+1];
		
		makeSet();
		
		// 도시 간 연결정보 입력받기
		for(int row = 1; row <= city; row++) {
			for(int col = 1; col <= city; col++) {
				connect[row][col] = sc.nextInt();
				// 연결된 곳은 모두 union 해주기 (나중에 plans에 있는 도시들이 모두 같은 부모를 가지면 된다.)
				if(connect[row][col] == 1) {
					union(row, col);
				}
			}
		}
		
		plans = new int[plan];
		
		// 방문 계획 입력받기
		for(int i = 0; i < plan; i++) {
			plans[i] = sc.nextInt();
		}
		
		sc.close();
		
		String ans = "YES";
		for(int i = 0; i < plan-1; i++) {
			if(findSet(plans[i]) != findSet(plans[i+1])) {
				ans = "NO";
				break;
			}
		}
		System.out.println(ans);
	}
	// 부모 지정
	static void makeSet() {
		for(int i = 1; i <= city; i++) {
			parent[i] = i;
		}
	}
	// 부모 찾기
	static int findSet(int a) {
		if(parent[a] == a) {
			return a;
		} else {
			return findSet(parent[a]);
		}
	}
	// 유니온
	static void union(int a, int b) {
		int x = findSet(a);
		int y = findSet(b);
		
		if(x > y) {
			parent[x] = y;
		} else if (x < y) {
			parent[y] = x;
		}
	}
}
