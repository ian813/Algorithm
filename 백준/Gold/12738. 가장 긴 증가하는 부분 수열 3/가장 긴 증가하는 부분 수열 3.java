import java.util.Scanner;

/**
 * 가장 긴 증가하는 부분수열의 길이만 출력하면 된다.
 * 첫번째 값을 부분수열의 시작이라고 생각하고 저장
 * 그 다음 값을 부분수열에 넣어둔 값과 비교해서 더 작은 값으로
 * 대체하면서 길이를 구해준다.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 주어지는 수열 크기
		int size = sc.nextInt();

		// 수열과 가장 긴 증가하는 부분수열을 저장할 배열
		int[] seq = new int[size];
		int[] store = new int[size];

		for (int i = 0; i < size; i++) {
			seq[i] = sc.nextInt();
		}

		// 가장 긴 증가하는 부분수열의 첫 값은 수열의 첫 값으로 저장
		// 부분수열의 길이도 1로 저장
		store[0] = seq[0];
		int maxLength = 1;

		// 수열에 있는 값들을 하나씩 키값으로 저장해서 확인
		for (int i = 1; i < size; i++) {
			int key = seq[i];

			if (key > store[maxLength - 1]) {
				// 키값이 스토어에 저장된 마지막 값보다 크면
				// 부분수열의 길이를 1 늘려주고 마지막에 키값을 저장
				maxLength++;
				store[maxLength - 1] = key;
			} else { // 그게 아니면 이분탐색을 통해 현재 키값이 들어갈 위치를 찾아서 넣어준다.
				int l = 0;
				int h = maxLength;

				while (l < h) {
					int mid = (l + h) / 2;

					if (store[mid] < key) {
						l = mid + 1;
					} else {
						h = mid;
					}
				}
				// 이분탐색이 끝나면 l의 위치에 key값을 저장하면 된다.
				store[l] = key;
			}
		}
		// 길이 출력하면 끝
		System.out.println(maxLength);
	}
}