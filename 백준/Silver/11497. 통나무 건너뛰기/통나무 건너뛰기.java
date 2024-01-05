import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (testCase-- > 0) {
			// 테케만큼 반복

			// 나무 개수 입력받기
			int tree = sc.nextInt();

			// 각 나무의 높이 정보 입력받기
			int[] height = new int[tree];

			for (int i = 0; i < tree; i++) {
				height[i] = sc.nextInt();
			}

			// 오름차순 정렬
			Arrays.sort(height);

			// 통나무로 징검다리 만들 배열
			int[] sortHeight = new int[tree];

			// 맨 앞 -> 맨 뒤 -> 두 번째 -> 뒤에서 두번째 이런 식으로 통나무 배치하기
			for (int i = 0; i < tree; i++) {
				if (i % 2 == 0) {
					sortHeight[i / 2] = height[i];
				} else {
					sortHeight[tree - 1 - i / 2] = height[i];
				}
			}

			// 처음 난이도 초기값 설정
			int difficulty = sortHeight[tree - 1] - sortHeight[0];

			// 난이도 구해주기
			for (int i = 0; i < tree - 1; i++) {
				difficulty = Math.max(difficulty, Math.abs(sortHeight[i + 1] - sortHeight[i]));
			}

			// 저장
			sb.append(difficulty).append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}