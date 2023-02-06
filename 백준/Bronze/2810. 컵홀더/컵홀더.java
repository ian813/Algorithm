import java.util.Scanner;

public class Main {
	
	// 전역 변수 선언
	static int numOfChairs;
	static String chairs;
	
	static void maxChairs() {
		Scanner sc = new Scanner(System.in);
		
		// 좌석 개수와 좌석 정보를 받을 변수
		numOfChairs = sc.nextInt();
		chairs = sc.next();
		
		// L이 몇개인지 셀 변수
		// LL의 쌍이 2쌍이상일 때부터
		// 컵홀더를 사용 못하는 사람의 수가 1명씩 증가한다.
		int cnt = 0;
		
		for(int idx = 0; idx < chairs.length(); idx++) {
			if(chairs.charAt(idx) == 'L') {
				cnt++;
			}
		}
		
		// 컵홀더를 사용 못하는 사람 수..
		// L이 1쌍이하일 땐 0명, L이 2쌍이상일 때 1씩 증가
		int notCupHolder = cnt/2 - 1;
		if(notCupHolder < 0) {
			notCupHolder = 0;
		}
		
		int max = chairs.length() - notCupHolder;
		
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		maxChairs();
	}
}