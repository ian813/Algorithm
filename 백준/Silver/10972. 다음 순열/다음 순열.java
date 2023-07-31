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

		if (nextPerm()) {
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
	static boolean nextPerm() {
		// 끝에서부터 내림차순 수열 찾기 (경계 인덱스)
		int idx = N - 1;
		while (idx > 0 && arr[idx - 1] >= arr[idx])
			idx--;
		// 경계가 0까지 가면 전체가 내림차순이므로 마지막 수열이다.
		// false 리턴
		if (idx <= 0)
			return false;

		// 경계랑 바꿀 값 (경계값보다 큰 수 중에 가장 작은 수 찾기)
		// 다시 뒤에서부터 탐색해서 idx-1보다 changeIdx가 더 큰 경우 찾기
		// 찾아서 swap
		int changeIdx = N - 1;
		while (arr[idx - 1] >= arr[changeIdx])
			changeIdx--;

		// idx-1과 changeIdx 스왑
		swap(idx - 1, changeIdx);

		// 이제 경계값 윗부분을 오름차순으로 변경 (idx부터 끝까지)
		for (int i = idx; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j])
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
