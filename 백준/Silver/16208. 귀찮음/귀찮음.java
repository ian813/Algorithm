import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 원하는 막대 개수
		int stickNum = sc.nextInt();

		// 막대 정보
		Integer[] stick = new Integer[stickNum];

		// 막대 총 길이
		int sum = 0;

		// 막대 정보 입력받으면서 총 길이 구해주기
		for (int i = 0; i < stickNum; i++) {
			stick[i] = sc.nextInt();

			sum += stick[i];
		}

		// 오름차순 정렬 (두 막대의 곱이 젤 작게 하려면 젤 작은 것부터 잘라줘야 함)
		Arrays.sort(stick);

		// 최소 비용
		long min = 0;

		for (int i = 0; i < stickNum - 1; i++) {
			// 현재 막대를 잘라주고
			sum -= stick[i];

			// 비용 누적시켜주기
			min += (long)stick[i] * sum;
		}

		System.out.println(min);
	}
}