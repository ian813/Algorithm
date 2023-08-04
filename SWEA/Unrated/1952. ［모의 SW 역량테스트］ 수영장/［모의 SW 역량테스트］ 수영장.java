import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();

	static int[] price, plan; // 요금, 이용 계획
	static int[] dp;
	
	static void input() {
		price = new int[5];
		plan = new int[13];
		
		// 요금 입력받기
		for(int idx = 1; idx < price.length; idx++) {
			price[idx] = sc.nextInt();
		}
		
		// 이용계획 입력받기
		for(int idx = 1; idx < plan.length; idx++) {
			plan[idx] = sc.nextInt();
		}
		// 최소 가격 저장할 배열
		dp = new int[13];
	}
	
	static void choose() {
		for(int i = 1; i <= 12; i++) {
			// 1월부터 12월까지 계획을 탐색
			if(plan[i] != 0) {
				// 이용하는 달이면
				// 그 전 달 최소 가격 + 1일권 가격과 그 전 달 최소 가격 + 한달권 가격 중 최솟값으로 갱신
				dp[i] = Math.min(dp[i-1] + plan[i]*price[1], dp[i-1] + price[2]);
				if(i > 2) {
					// 근데 만약 i가 2보다 크면 세 달 전 최소 가격 + 세달권 가격과도 비교해서 최솟값 갱신
					dp[i] = Math.min(dp[i], dp[i-3] + price[3]);
				}
			} else {
				// 만약 이용하는 달이 아니면
				// 그 전달 최솟값 그대로 가져오기
				dp[i] = dp[i-1];
			}
		}
		// 탐색이 끝나면 dp를 이용해 구한 최솟값과 1년권 사이에 최솟값으로 다시 갱신
		dp[12] = Math.min(dp[12], price[4]);
		
	}
	
	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) {
			input();
			
			choose();
			
			sb.append("#"+tc+" "+dp[12]+"\n");
		}
		System.out.println(sb);
		
	}
}