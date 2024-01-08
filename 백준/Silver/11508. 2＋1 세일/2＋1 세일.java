import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 유제품 개수
		int dairy = sc.nextInt();

		// 가격 정보 입력받기
		Integer[] cost = new Integer[dairy];

		for (int i = 0; i < dairy; i++) {
			cost[i] = sc.nextInt();
		}

		// 내림차순 정렬 (가장 큰 거 끼리 묶어서 최대한 할인 금액을 높혀야 함)
		Arrays.sort(cost, Collections.reverseOrder());

		// 누적 비용
		int accumulateCost = 0;

		// 나머지 2일 때 할인 받을 수 있으므로 누적시키지 않고 나머지 비용만 더하기
		for (int i = 0; i < dairy; i++) {
			if (i % 3 == 2)
				continue;

			accumulateCost += cost[i];
		}

		// 출력
		System.out.println(accumulateCost);
	}
}