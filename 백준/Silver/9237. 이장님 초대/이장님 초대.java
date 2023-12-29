import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 묘목 심는 개수
		int tree = sc.nextInt();

		// 묘목이 자라는 일 수
		Integer[] grows = new Integer[tree];

		for (int i = 0; i < tree; i++) {
			grows[i] = sc.nextInt();
		}

		// 내림차순 정렬
		Arrays.sort(grows, Collections.reverseOrder());

		// 처음 심은 게 완전히 자라는 날을 최소 일로 설정
		int minDay = 2 + grows[0];

		// 그 다음날부터 심는 묘목들이 완전히 자라는 날을 최소 일로 설정
		for (int i = 1; i < tree; i++) {
			minDay = Math.max(minDay, 2 + i + grows[i]);
		}

		// 출력
		System.out.println(minDay);
	}
}