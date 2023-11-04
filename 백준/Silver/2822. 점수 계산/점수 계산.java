import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 점수 입력받기
		int[] scores = new int[8];

		for (int i = 0; i < 8; i++) {
			scores[i] = sc.nextInt();
		}

		// 순위 매기기
		int[] ranks = new int[8];

		for (int i = 0; i < 8; i++) {
			int rank = 1;
			int cur = scores[i];
			for (int j = 0; j < 8; j++) {
				if (cur < scores[j]) {
					rank++;
				}
			}
			ranks[i] = rank;
		}

		// 5위 안에 든 점수 합과 인덱스 저장
		int sum = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			if (ranks[i] <= 5) {
				sb.append(i + 1 + " ");
				sum += scores[i];
			}
		}
		
		// 출력
		System.out.println(sum);
		System.out.println(sb);
	}
}