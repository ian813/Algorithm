import java.util.Scanner;

public class Main {
	
	// 동전의 종류와 목표값을 담을 전역변수 생성
	static int N;
	
	static int K;
	
	// 각각의 동전의 가치를 담을 배열과 동전긔 개수를 세줄 변수 생성
	static int[] money;
	
	static int cnt = 0;
	
	// input을 받을 메서드 생성
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// N, K값 받기
		N = sc.nextInt();
		K = sc.nextInt();
		
		// money 배열 생성
		money = new int[N];
		
		// 배열에 값 받기
		for(int idx = 0; idx < N; idx++) {
			money[idx] = sc.nextInt();
		}
	}
	
	// 돈의 합을 계산하면서 동전의 개수 세주는 메서드 생성
	static int sumOfMoney(int limitMoney, int[] typeOfMoney) {
		
		// 들어온 한계 돈보다 클 때 반복
		while(limitMoney > 0) {
			
			// 오름차순 정렬이기 때문에 뒤에서 부터 탐색해준다.
			for(int idx = typeOfMoney.length -1; idx >= 0; idx--) {
				
				// 한계돈보다 작거나 같은 순간을 찾으면
				if(typeOfMoney[idx] <= limitMoney) {
					
					// 돈을 차감해주고 동전 개수 더해주고
					// 바로 멈춘 다음
					// 다시 맨 뒤부터 재탐색
					limitMoney -= typeOfMoney[idx];
					cnt++;
					break;
				}
			}
		}
		
		// 동전의 개수 반환
		return cnt;
	}
	
	public static void main(String[] args) {
		// 위에서 생성한 메서드 2개 실행
		input();
		// 파라미터는 K와 money
		sumOfMoney(K, money);
		
		// 반환값인 cnt 출력
		System.out.println(cnt);
		
	}
}