import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int price = sc.nextInt();
		
		// 거스름돈 가격
		int money = 1000 - price;
		
		// 잔돈 개수를 셀 변수
		int cnt = 0;
		
		// 잔돈 개수 세주기
		while(money > 0) {
			if(money >= 500) {
				money -= 500;
				cnt++;
			} else if(money >= 100) {
				money -= 100;
				cnt++;
			} else if(money >= 50) {
				money -= 50;
				cnt++;
			} else if(money >= 10) {
				money -= 10;
				cnt++;
			} else if(money >= 5) {
				money -= 5;
				cnt++;
			} else {
				money -= 1;
				cnt++;
			}
		}
		
		// 결과 출력
		System.out.println(cnt);
	}
}