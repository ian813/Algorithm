import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 올바른 세트
		int[] ans = {1, 1, 2, 2, 2, 8};

		// 수정해야할 정보
		int[] correct = new int[6];

		for (int i = 0; i < 6; i++) {
			// 현재 피스 정보
			int cur = sc.nextInt();

			// 올바른 세트와의 차이만큼 저장
			correct[i] = ans[i] - cur;
		}

		for (int i = 0; i < 6; i++) {
			System.out.print(correct[i] + " ");
		}
	}
}