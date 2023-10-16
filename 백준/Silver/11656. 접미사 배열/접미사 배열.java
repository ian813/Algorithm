import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열 입력
		String str = sc.next();

		String[] arr = new String[str.length()];

		// 배열에 잘라서 넣어주기
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(i, str.length());
		}

		// 사전순 정렬
		Arrays.sort(arr);

		// 출력
		for (String s : arr) {
			System.out.println(s);
		}
	}
}