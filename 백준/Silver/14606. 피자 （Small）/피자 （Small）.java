import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int pizza = sc.nextInt(); // 피자판 개수
		
		sc.close();
		
		// 피자판 최대개수가 10이므로 크기 11인 배열 만들기
		int[] dp = new int[11];
		
		// dp를 이용해서 구하기
		for(int i = 2; i <= pizza; i++) {
			if(i % 2 == 0) {
				dp[i] = (i/2)*(i/2) + 2*dp[i/2];
			} else {
				dp[i] = (i/2)*(i/2 + 1) + dp[i/2] + dp[i/2 + 1];
			}
		}
		
		System.out.println(dp[pizza]);
	}


}