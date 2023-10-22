import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = sc.nextInt();

		// 입력받은 크기+1만큼의 배열을 생성하고
		int[] numArr = new int[length + 1];

		// 그 안에 값을 입력받자. (맨 첫 항은 0으로 고정시킨다.)
		// 뒤에서부터 입력받아서 가장 긴 증가하는 부분 수열을 구해주면 된다.

		for (int i = length; i > 0; i--) {
			numArr[i] = sc.nextInt();
		}

		// 각 인덱스까지의 증가 부분 수열의 가장 큰 크기를 변수로 받을 배열 생성
		int[] dp = new int[length + 1];

		// 목적 : 최장 증가 부분 수열 찾기
		// 인덱스가 0일 때의 값은 0으로 고정시켰으므로
		// 인덱스가 1일 때부터 탐색
		for (int curIdx = 1; curIdx <= length; curIdx++) {

			// curIdx보다 인덱스가 작은 idx에 대해
			for (int i = 0; i < curIdx; i++) {

				// numArr[idx] < numArr[curIdx]이면
				// numArr[idx] 뒤에 numArr[curIdx]를 붙여 줄 수 있다.
				// 즉 부분 증가 수열이 성립한다.

				// 그때의 증가 부분 수열의 크기를 비교했을 때
				// dp[curIdx] <= dp[i]라면
				// dp[curIdx] 값을 dp[i] + 1으로 갱신해주고
				// 이를 curIdx가 될 때까지 반복한다.
				if (numArr[i] < numArr[curIdx]) {
					dp[curIdx] = Math.max(dp[curIdx], dp[i] + 1);
				}

			}
		}

		// 각 인덱스에서의 최장 증가 부분 수열 값을 찾았으므로
		// 그 중 최댓값을 찾으면 된다.
		// max값을 담을 변수 생성
		int max = 0;

		// dp배열을 돌면서 최댓값 탐색
		for (int i = 0; i <= length; i++) {
			max = Math.max(max, dp[i]);
		}

		// 출력
		System.out.println(max);
	}
}