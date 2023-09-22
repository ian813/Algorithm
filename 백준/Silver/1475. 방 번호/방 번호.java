import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자 저장할 배열
		int[] num = new int[10];

		int N = sc.nextInt();

		while (N > 0) {
			// 나머지로 구해서 하나씩 구하자
			int cur = N % 10;

			if (cur != 6 && cur != 9) {
				// 6, 9 둘 다 아니면 해당 인덱스에 카운팅
				num[cur]++;
			} else {
				// 6이나 9면
				// 더 작은 수에 카운팅
				if (num[6] >= num[9]) {
					num[9]++;
				} else {
					num[6]++;
				}
			}
			// N 자릿수 줄이기
			N /= 10;
		}

		// 최댓값 구해서 출력해주면 끝
		int max = 0;

		for (int i = 0; i < 10; i++) {
			max = Math.max(max, num[i]);
		}

		System.out.println(max);
	}
}