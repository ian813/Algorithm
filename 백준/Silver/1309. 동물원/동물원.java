import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		int[][] dp = new int[N][3];
		
		// 0열 : 두 개 방에 사자 없는 경우
		// 1열 : 두 개 방 중 왼쪽 방에 사자 넣은 경우
		// 2열 : 두 개 방 중 오른쪽 방에 사자 넣은 경우
		
		dp[0][0] = dp[0][1] = dp[0][2] = 1; // 초기값 설정 (1번쨰 행에 1씩 저장 -> 경우의 수가 하나씩 이므로)
		
		for(int i = 1; i < N; i++) { // 이제 2번쨰 행부터 dp로 저장해보자
			dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]; // 현재 행에 아무 사자도 안 넣는 경우는 그 직전 행이 어떤 상황이더라도 상관 없다.
			dp[i][1] = dp[i-1][0] + dp[i-1][2]; // 현재 행의 왼쪽에 사자 넣는 경우는 직전 행에 사자 안 넣은 경우 + 직전 행에 오른쪽에 사자 넣은 경우
			dp[i][2] = dp[i-1][0] + dp[i-1][1]; // 현재 행의 오른쪽에 사자 넣는 경우는 직전 행에 사자 안 넣은 경우 + 직전 행에 왼쪽에 사자 넣은 경우
			// 수가 너무 커지면 안되니까 9901로 나눈 나머지로 저장한다.
			dp[i][0] %= 9901;
			dp[i][1] %= 9901;
			dp[i][2] %= 9901;
		}
		
		// 경우의 수 합 구하기
		int sum = 0;
		
		for(int i = 0; i < 3; i++) {
			sum += dp[N-1][i]; // 마지막 행에 저장된 값을 모두 더한다.
			sum %= 9901; // 여기도 9901로 나눠서 구한다.
		}
		System.out.println(sum);
	}
}
