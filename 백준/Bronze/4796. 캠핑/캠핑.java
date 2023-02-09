import java.util.Scanner;

public class Main {
	
	// 전역 변수 선언
	static int L;
	static int P;
	static int V;
	
	// 메소드 구현
	static void maxVacationDay() {
		Scanner sc = new Scanner(System.in);
		
		// testCase 번호를 담을 변수
		int testCase = 1;
		
		while(true) {
			// L, P, V 입력받기
			L = sc.nextInt();
			P = sc.nextInt();
			V = sc.nextInt();
			
			// L, P, V가 모두 0이 나오면 while문 종료
			// 그렇지 않으면 계속 실행
			if(L == 0 && P == 0 && V == 0) {
				break;
			}
			
			// (V를 P로 나눈 몫) * L만큼은 무조건
			// 캠핑장을 쓸 수 있다.
			int cnt = V/P;
			
			int remainder = V % P;
			
			// 나머지는 L이 더 크거나 같으면 remainder만큼
			// 아니면 L만큼 더 캠핑장을 쓸 수 있다.
			if (remainder > L) {
				remainder = L;
			}
			
			// 결과값을 구해준다.
			int maxDay = L * cnt + remainder;
			
			// 출력 (한번 실행마다 testCase의 값을 +1해주기, 개행 필수)
			System.out.printf("Case %d: %d\n", testCase++, maxDay);
		
			
		}

	}
	
	
	public static void main(String[] args) {
		// 구현한 함수 실행
		maxVacationDay();
	}
}
