import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정수 개수
		int num = sc.nextInt();

		// 정수 범위가 -100~100이므로 총 201개
		int[] numArr = new int[201];

		while (num-- > 0) {
			// 수를 입력받아서
			int cur = sc.nextInt();

			// 100 더해서 저장
			numArr[cur + 100]++;
		}

		// 목표 정수
		int target = sc.nextInt();

		// 100 더한 지점에서 출력
		System.out.println(numArr[target + 100]);
	}
}