import java.util.Scanner;

public class Main {
	static int N;
	static int M;

	static int[] numArr;
	static int[][] section;

	static int sectionSum;

	static StringBuilder sb = new StringBuilder();

	static void input() {
		Scanner sc = new Scanner(System.in);
		// N, M
		N = sc.nextInt();
		M = sc.nextInt();

		// 숫자 정보 입력받기 (인덱스를 일치시키기 위해 크기는 N+1)
		numArr = new int[N + 1];

		for (int idx = 1; idx <= N; idx++) { // 누적 합으로 저장
			numArr[idx] = numArr[idx - 1] + sc.nextInt();
		}

		// 합을 구할 구간 정보를 저장할 배열
		section = new int[M][2];

		for (int row = 0; row < section.length; row++) {
			for (int col = 0; col < section[0].length; col++) {
				section[row][col] = sc.nextInt();
			}
		}
	}

	static void partSum() {
		input();

		// M회 반복해서 부분합 구하기
		for (int re = 0; re < M; re++) {
			// 매 시행마다 부분합 초기화
			sectionSum = 0;

			// 저장된 구간 정보 이용해서 부분합 구하기
			// 누적합을 담아줬으므로
			// 구간 끝 - 구간 시작으로 구하면 된다.
			sectionSum = numArr[section[re][1]] - numArr[section[re][0] - 1];

			// 저장한 값을 스트링빌더에 담아주기
			sb.append(sectionSum).append("\n");
		}

	}

	public static void main(String[] args) {
		partSum();
		// 출력
		System.out.print(sb);
	}
}