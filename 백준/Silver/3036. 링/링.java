import java.util.Scanner;

public class Main {
	static int N; // 링 개수
	static int[] radius; // 반지름 크기
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		radius = new int[N];
		
		for(int idx = 0; idx < N; idx++) {
			radius[idx] = sc.nextInt();
		}
		
		sc.close();
	}
	
	// 최대공약수 구하는 메서드
	static int GCD(int a, int b) {
		if(a % b == 0) { // 나누어 떨어지면 b를 리턴
			return b;
		}
		
		// 나누어떨어지지 않으면, b와 (a와 b의 나머지)를 파라미터로 넣어준다.
		return GCD(b, a%b);
	}
	
	static void solve() {
		int x = radius[0]; // 첫번째 값은 따로 저장
		
		for(int i = 1; i < N; i++) { // 배열을 돌면서 최대공약수를 구해준다.
			int gcd = GCD(x, radius[i]); // 최대공약수 저장
			
			int numerator = x / gcd; // 분모
			int denominator = radius[i] / gcd; // 분자
			
			sb.append(numerator + "/" + denominator).append("\n");
		}
		
	}
	
	public static void main(String[] args) {
		input();
		solve();
		System.out.println(sb);
	}
}