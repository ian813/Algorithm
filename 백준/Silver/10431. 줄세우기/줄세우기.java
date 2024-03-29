import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			int num = sc.nextInt();

			// 카운팅 값
			int cnt = 0;

			// 키 정보 입력받기
			int[] people = new int[20];

			for (int i = 0; i < 20; i++) {
				people[i] = sc.nextInt();
			}

			// 줄 세울 배열
			int[] line = new int[20];

			line[0] = people[0];

			// 현재 인덱스
			int idx = 0;

			while (idx++ < 19) {

				// 새로 들어오는 애
				int change = people[idx];

				// 삽입할 인덱스
				int insertIdx = idx;

				for (int i = idx - 1; i >= 0; i--) {
					if (change < line[i]) {
						// 더 작은 값 보면 카운팅하고 inserIdx 초기화
						cnt++;
						insertIdx = i;
					}
				}

				if (insertIdx != idx) {
					// 삽입할 인덱스가 갱신됐으면
					// back 연산
					back(idx, insertIdx, change, line);
				} else {
					// 그게 아니면 맨 뒤에 넣어줌
					line[insertIdx] = change;
				}
			}

			sb.append(tc + " " + cnt + "\n");
		}

		System.out.println(sb);
	}

	// insertIdx 자리에 삽입하고 나머지는 뒤로 밀기
	private static void back(int idx, int insertIdx, int change, int[] arr) {

		for (int i = idx; i > insertIdx; i--) {
			arr[i] = arr[i - 1];
		}

		arr[insertIdx] = change;
	}
}