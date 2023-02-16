import java.util.Scanner;

public class Main {
	
	// A, B와 최대공약수, 최소공배수 변수
	static int A;
	static int B;
	static int gcd;
	static int lcm;
	
	// input 메서드
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// A, B 입력받기
		A = sc.nextInt();
		
		B = sc.nextInt();
	
	}
	
	static int solve(int m, int n) {
		// 유클리드 호제법 사용
		// m >= n일 때 계속 나눠주면서
		// m = n , n = 나머지로 갱신
		if(m >= n) {
			// n이 0이 아닐 때까지 반복
			while(n != 0) {
				int remainder = m % n;
				
				m = n;
				n = remainder;
				
			}
			// 과정이 끝나면 최대공약수를 m으로 할당
			// 반환하기
			gcd = m;
			return gcd;
	
		} else {
			// n > m일 때 같은 방법으로 반복
			while(m != 0) {
				int remainder = n % m;
				
				n = m;
				m = remainder;
				
			}
			gcd = n;
			return gcd;
		}
		
		
	}
	
	public static void main(String[] args) {
		// 인풋 메서드
		input();
		// solve메서드로 최대공약수 구하기
		solve(A, B);
		
		// 최소공배수*최대공약수 = A*B
		lcm = (A*B)/gcd;
		
		// 출력!
		System.out.println(gcd);
		System.out.println(lcm);
		
	}
}
