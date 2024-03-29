import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 사람 수
		int N = sc.nextInt();

		// 사람 정보 입력받기
		Integer[] people = new Integer[N];

		for (int i = 0; i < N; i++) {
			people[i] = sc.nextInt();
		}

		// 내림차순 정렬 (큰 애부터 팁 준다)
		Arrays.sort(people, Collections.reverseOrder());

		// 팁의 합
		long totalTip = 0;

		for (int i = 0; i < N; i++) {
			// 현재 팁 계산
			int tip = people[i] - i;

			// 팁이 0이하가 되면 멈추기
			if (tip <= 0)
				break;

			// 아니면 tip 더해주기
			totalTip += tip;
		}

		System.out.println(totalTip);
	}
}