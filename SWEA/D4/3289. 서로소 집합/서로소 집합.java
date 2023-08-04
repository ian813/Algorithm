import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();
	static int n;
	static int m;
	static int[] p;
	static int result;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		
		p = new int[n+1];
	}
	
	static void solve() {
		input();
		
        for (int i = 1; i <= n; i++) {
            // 집합을 만드는 메서드
            p[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            // 연산의 종류(합집합 : 0, 같은 집합에 포함되는 지에 대한 유무 : 1)
            int calculate = sc.nextInt();
            // 주어지는 수 1
            int a = sc.nextInt();
            // 주어지는 수2
            int b = sc.nextInt();

            if (calculate == 0) {
                // 원소 a가 포함된 집합과 원소 b가 포함된 집합 합치기
                p[find_set(b)] = find_set(a);
            } else if (calculate == 1) {
                // 두 원소 a와 b가 같은 집합에 포함되어 있는지 확인
                if (find_set(a) == find_set(b)) {
                    result = 1;
                } else {
                    result = 0;
                }
                sb.append(result);
            }
            
        }
	}
	
    private static int find_set(int x) {
        if (x != p[x]) {
            p[x] = find_set(p[x]);
        }
        return p[x];
    }
	
	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) {
			sb.append("#"+tc+" ");
			solve();
			sb.append("\n");
		}
		System.out.println(sb);
	}
}