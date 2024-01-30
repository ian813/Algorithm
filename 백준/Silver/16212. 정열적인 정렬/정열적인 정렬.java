import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열 길이
		int length = sc.nextInt();

		// 수열 정보 입력받기
		int[] numArr = new int[length];

		for (int i = 0; i < length; i++) {
			numArr[i] = sc.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(numArr);

		StringBuilder sb = new StringBuilder();

		// 스트링빌더에 저장
		for (int i = 0; i < length; i++) {
			sb.append(numArr[i]).append(" ");
		}

		// 출력
		System.out.println(sb);
	}
}