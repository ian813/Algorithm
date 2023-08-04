import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int testCase = sc.nextInt();
	static StringBuilder sb = new StringBuilder();
	static int maxScore, materialNum, limitCal;
	static int[] score, calories;
	static int[][] dp;
	
	static void input() {
		// 재료 개수
		materialNum = sc.nextInt();
		// 제한 칼로리
		limitCal = sc.nextInt();
		
		score = new int[materialNum+1];
		calories = new int[materialNum+1];
		
		for(int idx = 1; idx <= materialNum; idx++) {
			score[idx] = sc.nextInt();
			calories[idx] = sc.nextInt();
		}
		dp = new int[materialNum+1][limitCal+1];
	}
	
	static void eat() {
		//재료를 한개씩 늘려가면서 고려를 해보자
		for(int i = 1; i <=materialNum; i++) {
			//각각의 재료를 이용하여 최적해 갱신
			//cal : 임시 칼로리
			for(int cal = 0 ; cal<=limitCal; cal++) {
				if(calories[i] <= cal) {
					//해당 재료를 넣을지 말지 판단을 해보겠다.
					//해당 맛의 최적해는 : dp[i-1][cal]
					//이번 재료를 고려하는 최적해는 : dp[i-1][cal-calories[i]]+score[i]
					//위의 두개의 값중 더 좋은걸로 갱신하겠다.
					dp[i][cal] = Math.max(dp[i-1][cal], dp[i-1][cal-calories[i]]+score[i]);
				}else{
					dp[i][cal] = dp[i-1][cal]; //현재 칼로리가 지금 재료를 담을 수 없어서 고려제외
				}
			}
		}
	}
	
	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) {
			input();
			// dp 사용
			eat();
			// 형식에 맞게 담아주기
			sb.append("#"+tc+" "+dp[materialNum][limitCal]+"\n");
		}
		System.out.println(sb);
	}
}