import java.util.Scanner;

public class Main {
	
	// 입력받을 변수
	static int N;
	
	// 팩토리얼 계산해서 저장할 변수
	static int factorial;

	// 값 입력받기
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
	}
	
	// 팩토리얼을 풀어보자.
	static int solution(int n) {
		
		// factorial을 1로 할당 (0일 때는 1 출력해야 하므로 기본값 설정)
		factorial = 1;
		
		// n >= 1인 구간동안 반복
		if(n >= 1) {
			
			// 재귀함수 사용
			// factorial에 N을 곱하고 solution이 n-1일 때 함수를 불러옴.
			// 그럼 factorial = N * (N-1) * solution(N-2)가 되고
			// 이를 N=1일 때까지 반복하면
			// factorial = N!이 된다.
			factorial = n * solution(n-1);
		}
		
		// 계산한 값 리턴
		return factorial;
	}
	
	
	public static void main(String[] args) {
		// 만든 메서드 사용해서 계산한 뒤 출력
		input();
		
		System.out.println(solution(N));
		
	}
}