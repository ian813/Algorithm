import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//아이템의 개수 N개 / 최대 가방의 무게 W
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] weights = new int[N+1];
		int[] cost = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][W+1];
		//아이템을 한번도 고려하지 않은경우는 0행에 0으로 초기화가 되어있으니 안할래
		//아이템을 한개씩 늘려가면서 고려를 해보자
		for(int i = 1; i <= N; i++) {
			//각각의 아이템을 이용하여 최적해 갱신
			//w : 임시 배낭의 크기
			for(int w = 0 ; w<=W; w++) {
				if(weights[i] <= w) {
					//해당 물건을 넣을지 말지 판단을 해보겠다.
					//해당 w의 최적해는 : dp[i-1][w]
					//이번 물건을 고려하는 최적해는 : dp[i-1][w-weights[i]]+cost[i]
					//위의 두개의 값중 더 좋은걸로 갱신하겠다.
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]);
				}else{
					dp[i][w] = dp[i-1][w]; //현재 임시무게가 지금 물건을 담을 수 없어서 고려제외
				}
			}
		}
		
		System.out.println(dp[N][W]);
	}
}