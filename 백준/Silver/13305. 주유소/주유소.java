import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 도시 개수
		int city = Integer.parseInt(st.nextToken());

		// 도로 길이와 가격 정보 받을 배열
		int[] road = new int[city];

		int[] price = new int[city];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < road.length - 1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < price.length; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		// 최소값을 갖는 인덱스, 끝 인덱스
		int minIdx = city;
		int endIdx = city - 1;

		// 최소 비용
		Long minCost = 0L;

		// 최소값 인덱스가 0보다 클때까지만 반복
		while (minIdx > 0) {
			// 최소값 인덱스 찾아주기
			minIdx = findMin(0, endIdx, price);

			// 누적시킬 도로 길이
			Long roadLength = 0L;

			for (int i = minIdx; i <= endIdx; i++) {
				// 최소값인덱스부터 끝 인덱스까지 도로 누적
				roadLength += road[i];
			}

			// 최소 비용 구하고 끝 인덱스 초기화
			minCost += roadLength * price[minIdx];
			endIdx = minIdx - 1;
		}

		// 최소 비용 출력
		System.out.println(minCost);
	}

	// 최솟값과 최솟값 위치 구하는 메서드
	private static int findMin(int startIdx, int endIdx, int[] arr) {
		// 최소 가격과 그 위치 저장
		int min = arr[startIdx];
		int minIdx = startIdx;

		// 최소값 찾기
		for (int i = startIdx + 1; i <= endIdx; i++) {
			if (min > arr[i]) {
				min = arr[i];
				minIdx = i;
			}
		}

		return minIdx;
	}
}