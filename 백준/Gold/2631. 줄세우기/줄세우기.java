import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int[] line = new int[size + 1];

		for (int i = 1; i <= size; i++) {
			line[i] = sc.nextInt();
		}

		sc.close();
		
		// 가장 긴 증가하는 부분수열 길이를 구해주고
		// 전체 길이에서 가장 긴 증가하는 부분수열의 길이를 구해주면 된다.
		int[] dp = new int[size + 1];

		int max = 0;

		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < i; j++) {
				// 현재 줄에 있는 수가 더 크면
				// dp 값 갱신
				if (line[i] > line[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// 가장 긴 증가하는 부분수열의 길이 구하기
			max = Math.max(max, dp[i]);
		}

		int ans = size - max;

		System.out.println(ans);
	}
}