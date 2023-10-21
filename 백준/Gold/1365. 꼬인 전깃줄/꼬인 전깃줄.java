import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 주어지는 수열의 크기
		int N = sc.nextInt();

		// 전깃줄 정보 입력받기
		int[] wire = new int[N];

		for (int i = 0; i < N; i++) {
			wire[i] = sc.nextInt();
		}

		// 최장 부분 수열 저장할 배열
		int[] store = new int[N];

		// 최장 길이를 1로 설정
		store[0] = wire[0];
		int maxLength = 1;

		for (int i = 1; i < N; i++) {
			// 현재 전깃줄 번호를 key값으로 저장
			int key = wire[i];

			if (key > store[maxLength - 1]) {
				// key값이 더 크면 최장길이를 늘리고
				maxLength++;

				// key값을 저장
				store[maxLength - 1] = key;
			} else {
				// 그게 아니면 들어갈 자리 이분탐색으로 탐색
				int left = 0;
				int right = maxLength;

				while (left < right) {
					int mid = (left + right) / 2;

					if (store[mid] < key) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				// 이분탐색 끝나면 왼쪽 위치에 저장
				store[left] = key;
			}
		}
		// 최장길이 부분 수열을 뺸 만큼 잘라주기
		System.out.println(N - maxLength);
	}
}