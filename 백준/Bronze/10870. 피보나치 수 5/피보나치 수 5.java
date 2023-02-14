import java.util.Scanner;

public class Main {
	
	// 숫자 num과 피보나치의 n번째 수를 담을 변수 생성
	static int num;
	
	static int fnn;
	
	// input 메서드
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// num 입력받기
		num = sc.nextInt();
		
		sc.close();
		
	}

	static int fibonacci(int n) {

		// fnn 0으로 초기화
		fnn = 0;
		
		// n이 1일 때 fnn은 1로 초기화
		if(n == 1) {
			fnn = 1;
		}
		
		// n > 1일 때
		if(n > 1) {
			// 재귀함수 써서 구현해보자.
			// ex) n = 3 => fnn = f(2) + f(1) = (f(1) + f(0)) + f(1)
			// 	= (1 + 0) + 1
			// n = 4 => fnn = f(3) + f(2) = (f(2) + f(1)) + f(2)
			// = (f(1) + f(0)) + 1) + ...
			fnn = fibonacci(n-1) + fibonacci(n-2);
		}

		
		return fnn;
	}
	
	public static void main(String[] args) {
		// 구현한 메서드 순서대로 써주기
		input();
		
		fibonacci(num);
		
		// 출력
		System.out.println(fnn);
	}
}