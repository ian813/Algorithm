import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자 개수 입력받기
		int num = sc.nextInt();

		// 숫자 저장할 배열 생성해서 수 입력받기
		Integer[] numArr = new Integer[num];

		for (int i = 0; i < num; i++) {
			numArr[i] = sc.nextInt();
		}

		// 내림차순 정렬
		Arrays.sort(numArr, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		// 순서대로 저장하고 출력
		for (int i = 0; i < num; i++) {
			sb.append(numArr[i]).append("\n");
		}

		System.out.println(sb);
	}
}