import java.util.Scanner;

public class Main {
	
	// 가게 수와 가게에서 파는 우유 종류를 받을 전역변수 선언
	static int numOfStore;
	static int[] milk;
	
	// 마실 수 있는 우유 개수를 셀 전역변수
	static int cnt;
	
	// 값을 입력받아서 저장할 메서드
	static void inputMilk() {

		Scanner sc = new Scanner(System.in);
		
		// 입력받기
		numOfStore = sc.nextInt();
		
		milk = new int[numOfStore];
		
		for(int idx = 0; idx < numOfStore; idx++) {
			milk[idx] = sc.nextInt();
		}
	}
	
	static int maxDrinkMilk(int x, int[] arr) {
		
		// 처음엔 0으로 초기화
		cnt = 0;
		
		// 마실 수 있는 우유값 변수
		int drink = 0;
		
		// 배열을 돌면서 마실 수 있는 우유의 개수를 세보자.
		for(int idx = 0; idx < x; idx++) {
			if(arr[idx] == drink) {
				// drink와 같은 수를 찾으면
				// 마실 수 있으므로
				// cnt++
				cnt++;
				if(drink < 2) {
					// 우유를 마셨을 때의 우유 값이 2보다 작으면
					// drink값을 늘려줘서 비교해줘야한다.
					drink++;
				} else if(drink == 2) {
					// 우유를 마셨을 때 우유 값이 2이면
					// 다시 0으로 초기화 시킨 뒤 비교해야 한다.
					drink = 0;
				}
			}
		}
		
		// 마신 우유 값을 반환
		return cnt;
	}
	
	public static void main(String[] args) {
		// input값을 받은 뒤
		inputMilk();
		
		// maxDrinkMilk를 이용해 결과값을 return
		maxDrinkMilk(numOfStore, milk);
		
		// 반환값 출력
		System.out.println(cnt);
	}
}
