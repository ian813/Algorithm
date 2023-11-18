import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];

		// 배열에 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();

		// 처음 수 담기
		sb.append(arr[0] + " ");

		// 그 전꺼랑 다르면 담기
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] != arr[i]) {
				sb.append(arr[i] + " ");
			}
		}

		// 출력
		System.out.println(sb);
	}
}