import java.util.Scanner;

public class Main {
	static int fireDay;
	static int[][] consulting;
	
	static int[] price;
	
	static int maxPrice;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 퇴사 날짜
		fireDay = sc.nextInt();
		
		// 상담 정보를 담을 배열
		consulting = new int[3][fireDay+1];
		
		// 배열에 값 입력받기
		for(int col = 1; col <= fireDay; col++) {
			for(int row = 1; row <= 2; row++) {
				consulting[row][col] = sc.nextInt();
				
				// 각 날짜와 상담에 걸리는 일수를 더해서 저장
				// 이 숫자와 퇴사날짜를 비교해줄 예정
				if(row == 1) {
					consulting[row][col] += col;
				}
			}
		}
		// 각 날짜별 금액의 합을 받을 배열 생성
		price = new int[fireDay+1];
		
	}
	
	static void consult() {
		input();
		
		// 임시 최댓값
		maxPrice = 0;

		// 우선 첫 번째 금액을 받아주자.
		price[0] = consulting[2][0];
		
		// 탐색은 인덱스 2부터 시작
		for(int idx = 1; idx <= fireDay; idx++) {
			if(fireDay+1 < consulting[1][idx]) {
				// 만약 상담을 시작해서 퇴사날까지 상담이 끝나지 못하는 날이면
				// 그냥 패스
				continue;
			}
			
			// 그 전 인덱스들과 비교하기 위해 설정한 변수
			int day = 1;
			while(idx - day > 0) {
				// 인덱스가 0보다 클 때까지 진행
				if(consulting[1][idx - day] <= idx) {
					// 그 전 상담일들 중 그 날 상담하고 idx날 상담이 가능한 날짜들만 뽑아줌
					
					// 그 날의 금액과 현재 날짜의 금액을 비교해가면서 계속 최댓값으로
					// 현재 날짜의 금액을 갱신시켜준다.
					price[idx] = Math.max(price[idx], price[idx - day]);
					
				}
				// 하나씩 늘려가면서 다 확인
				day++;
			}
			// 그 금액에 현재 상담일의 금액까지 더해주면 된다.
			price[idx] += consulting[2][idx];
			
		}
		
		// 이제 각 날짜별 최대 금액을 넣어줬으므로
		// 그 중에서 최댓값을 찾아보자.
		for(int idx = 1; idx <= fireDay; idx++) {
			if(maxPrice < price[idx]) {
				maxPrice = price[idx];
			}
		}
		// 찾은 뒤 출력
		System.out.println(maxPrice);
	}
	
	public static void main(String[] args) {
		consult();
	}
}