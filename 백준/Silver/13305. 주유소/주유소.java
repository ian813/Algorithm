import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 도시 개수
		int city = sc.nextInt();

		// 도로 길이와 가격 정보 받을 배열
		int[] road = new int[city];

		int[] price = new int[city];

		for (int i = 0; i < road.length - 1; i++) {
			road[i] = sc.nextInt();
		}

		for (int i = 0; i < price.length; i++) {
			price[i] = sc.nextInt();
		}

		// 최소 비용, 최소 가격, 도로 길이 저장할 변수
		long minCost = 0;
		long minPrice = 1000000001;
		long roadLength = 0;

		for (int i = price.length - 1; i >= 0; i--) {
			if (price[i] <= minPrice) {
				// 더 작은 가격 발견하면
				// 최소 가격 업데이트 및 도로 길이 누적
				minPrice = price[i];
				roadLength += road[i];
			} else {
				// 더 큰 가격 발견하면
				// 지금까지 누적한 도로 길이와 최소 가격 이용해서 비용 구해주고
				minCost += (minPrice * roadLength);
				// 가격하고 도로 길이 업데이트
				minPrice = price[i];
				roadLength = road[i];
			}
		}

		// 마지막 남은 비용 구해주기
		minCost += minPrice * roadLength;

		// 출력
		System.out.println(minCost);
	}
}