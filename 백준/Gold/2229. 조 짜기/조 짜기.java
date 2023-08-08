import java.util.Scanner;

public class Main {

	static int N;
	static int[] students, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		students = new int[N + 1];
		dp = new int[N + 1];

		// 학생 정보 입력받기
		for (int i = 1; i <= N; i++) {
			students[i] = sc.nextInt();
		}

		// dp로 구해보자
		for (int i = 1; i <= N; i++) {
			int max = 0;
			int min = 10001;

			for (int j = i; j > 0; j--) {
				// 현재 학생부터 값을 감소시키면서 최대 최소값을 구한다.
				max = Math.max(max, students[j]);
				min = Math.min(min, students[j]);

				// dp[j-1]에는 j-1까지 적당히 그룹핑했을 때의 최댓값이 저장되어 있고
				// max,min은 j부터 i까지 같은 그룹일 때 max값과 min값이므로
				// max - min + dp[j-1]로 구할 수 있다.
				// j는 i부터 감소시키므로 모든 그룹핑 경우의 수에 대해 파악 가능하다.
				dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
			}
		}

		// 출력
		System.out.println(dp[N]);
	}
}