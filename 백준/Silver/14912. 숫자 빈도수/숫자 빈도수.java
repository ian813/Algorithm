import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자 빈도수 저장할 배열
		int[] digit = new int[10];

		// 숫자 범위 입력받기
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			int cur = i;

			while (cur > 0) {
				// 1의 자리수부터 차례대로 각 자리 수에
				// 무슨 숫자가 등장하는지 digit에 저장
				int idx = cur % 10;
				digit[idx]++;
				cur /= 10;
			}
		}

		// 타깃 입력받기
		int target = sc.nextInt();

		// 출력
		System.out.println(digit[target]);
	}
}