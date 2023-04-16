import java.util.Scanner;

public class Main {
	static String str1, str2;
	static int[][] dp;
	static int length;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		str1 = sc.next();
		str2 = sc.next();
		// 값을 저장할 배열(dp)
		dp = new int[str1.length()+1][str2.length()+1];
		
		sc.close();
	}
	
	static void search() {
		for(int row = 1; row <= str1.length(); row++) {
			for(int col = 1; col <= str2.length(); col++) {
				// 만약 같은 문자를 찾으면 대각선 밑으로 값이 1씩 증가한다.
				// 그때마다 최댓값도 갱신해주면 된다.
				if(str1.charAt(row - 1) == str2.charAt(col - 1)) {
					dp[row][col] = dp[row-1][col-1] + 1;
					length = Math.max(length, dp[row][col]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		length = 0;
		search();
		// 길이 출력
		System.out.println(length);
	}
}
