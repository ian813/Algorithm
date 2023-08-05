import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = sc.nextInt();

		// 입력받은 크기+1만큼의 배열을 생성하고
		int[] numArr = new int[length + 1];

		for (int i = 1; i <= length; i++) {
			numArr[i] = sc.nextInt();
		}

		// 배열의 크기를 늘리고 맨 첫 항을 0으로 고정시키는 이유
		// 왜냐하면 크기가 1인 배열은 무조건 길이가 1인 부분 증가 수열을 갖는데
		// 이 때는 비교할 대상이 없기 때문에 for문으로 돌리기 힘듦.
		// 따라서 numArr 크기를 1 늘리고 첫 항에 0을 무조건 넣어서
		// 원래 첫 번째 항에 있던 값을 0과 비교해서 크기 때문에 부분 증가 수열의 크기가 1이다.

		// 각 인덱스까지의 증가 부분 수열의 가장 큰 크기를 변수로 받을 배열 생성
		// 2차원 배열로 만들어서 밑에는 그 전 인덱스 값도 저장
		int[][] dp = new int[2][length + 1];

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
				// dp[0][curIdx] <= dp[0][i]라면
				// dp[0][curIdx] 값을 dp[0][i] + 1으로 갱신해주고
				// dp[1][curIdx] = i로 갱신
				// 이를 curIdx가 될 때까지 반복
				if (numArr[i] < numArr[curIdx]) {
					dp[0][curIdx] = Math.max(dp[0][curIdx], dp[0][i] + 1);
					if (dp[0][curIdx] == dp[0][i] + 1) {
						dp[1][curIdx] = i;
					}
				}

			}
		}

		// 각 인덱스에서의 최장 증가 부분 수열 값을 찾았으므로
		// 그 중 최댓값을 찾으면 된다.
		// max값을 담을 변수 생성
		int max = 0;
		int maxIdx = 0;

		// dp배열을 돌면서 최댓값 탐색
		// 최댓값 갱신되었으면 그 때의 인덱스 저장
		for (int i = 0; i <= length; i++) {
			max = Math.max(max, dp[0][i]);
			if (max == dp[0][i])
				maxIdx = i;
		}

		// 가장 긴 부분 수열을 담을 배열
		int[] partArr = new int[max + 1];

		// num을 max로 idx를 maxIdx로 저장
		int num = max;
		int idx = maxIdx;

		// num이 0보다 클 때까지 반복
		while (num > 0) {
			// partArr에 수열값 저장하고 인덱스 낮추기
			partArr[num--] = numArr[idx];
			idx = dp[1][idx]; // 인덱스는 dp[1][idx]에 저장된 값으로 갱신
		}

		// 형식에 맞게 스트링빌더에 담기
		StringBuilder sb = new StringBuilder();

		sb.append(max + "\n");

		for (int i = 1; i <= max; i++) {
			sb.append(partArr[i] + " ");
		}

		System.out.println(sb);

	}
}