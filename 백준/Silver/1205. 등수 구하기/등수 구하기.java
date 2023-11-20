import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 점수 정보
		Integer[] scores = new Integer[N];

		// 넣으려는 점수
		int score = sc.nextInt();

		// 랭킹 제한
		int limit = sc.nextInt();

		// 스코어 정보 입력받기
		for (int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
		}

		// 내림차순 정렬
		Arrays.sort(scores, Collections.reverseOrder());

		// N이 limit이랑 같거나 점수가 마지막꺼보다 작거나 같으면 -1
		if (N == limit && score <= scores[scores.length - 1])
			System.out.print(-1);
		else {
			// 구해줄 랭킹
			int rank = 1;
			for (int i = 0; i < scores.length; i++) {
				if (score < scores[i])
					// 작으면 랭킹더하기
					rank++;
				else
					break;
			}
			System.out.print(rank);
		}
	}
}