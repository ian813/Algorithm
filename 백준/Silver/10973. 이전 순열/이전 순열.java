import java.util.Scanner;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열의 크기, 현재 배열
		N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		if (prevPerm()) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				sb.append(arr[i] + " ");
			}

			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	// 다음 순열을 찾을 메서드
	static boolean prevPerm() {
		// 끝에서부터 오름차순 수열 찾기 (경계 인덱스)
		int idx = N - 1;
		while (idx > 0 && arr[idx - 1] <= arr[idx])
			idx--;
		// 경계가 0까지 가면 전체가 오름차순이므로 첫번쨰 수열이다.
		// false 리턴
		if (idx <= 0)
			return false;

		// 경계랑 바꿀 값 (경계값보다 작은 수 중에 가장 큰 수 찾기)
		// 다시 뒤에서부터 탐색해서 idx-1보다 changeIdx가 더 큰 경우 찾기
		// 이미 idx - 1보다 큰 쪽에 있는 수열들은 오름차순 정렬되어 있는 것을 알고 있으므로
		// 뒤쪽부터 찾아서 arr[idx-1] > arr[changeIdx]이 최초로 발견되는 지점을 찾아주면 된다.
		// 찾아서 swap
		int changeIdx = N - 1;
		while (arr[idx - 1] <= arr[changeIdx])
			changeIdx--;

		// idx-1과 changeIdx 스왑
		swap(idx - 1, changeIdx);

		// 이제 경계값 윗부분을 내림차순으로 변경 (idx부터 끝까지)
		for (int i = idx; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] < arr[j])
					swap(i, j);
			}
		}

		return true;
	}

	// 스왑 메서드
	static void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
