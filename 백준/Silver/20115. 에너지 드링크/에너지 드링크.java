import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 에너지 드링크 개수
		int energyDrink = sc.nextInt();

		// 드링크 정보
		int[] drink = new int[energyDrink];

		// 드링크 정보 입력받으면서 최댓값 구해주기
		for (int i = 0; i < energyDrink; i++) {
			drink[i] = sc.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(drink);

		// 결국 답은 가장 큰 용량 + (나머지 용량의 합) / 2이므로
		double accumulateDrink = 0;

		for (int i = 0; i < energyDrink - 1; i++) {
			accumulateDrink += drink[i] / 2.0;
		}

		// 마지막 값까지 누적
		accumulateDrink += drink[energyDrink - 1];

		// 출력
		System.out.println(accumulateDrink);
	}
}