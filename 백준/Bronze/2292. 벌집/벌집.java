import java.util.Scanner;

public class Main {
	// 주어지는 숫자N과 가는 지나는 방의 개수, 몇 번째 테두리인지를 셀 변수
	static int N;
	
	static int cnt;
	
	static int bound;
	
	// input값 받기
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		sc.close();
		
	}
	
	// 목적 : 방의 개수 계산
	static int count(int input) {
		// cnt와 bound를 1로 놓기
		// 왜냐하면 경계와 방의 개수의 최솟값이 1이므로
		cnt = 1;
		
		bound = 1;
		
		while(bound < input) {
			// 주어진 값이 경계값보다 크면
			// 경계값을 늘려주고 (벌집의 경계는 6 -> 12 -> 18 ...으로 늘어난다.)
			bound = bound + 6*cnt;
				
			// 방의 개수도 늘려주자.
			cnt++;
		}
		
		// 방의 개수 return
		return cnt;
	}
	
	public static void main(String[] args) {
		// 위의 메서드들 차례로 실행
		input();
		
		count(N);
		
		// 출력
		System.out.println(cnt);
	}
}