import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열로 한번에 받기
		String str = sc.next();

		// 문자열 길이만큼 배열 생성
		int[] numArr = new int[str.length()];

		// char 단위로 쪼개서 정수로 바꿔서 저장
		for (int i = 0; i < str.length(); i++) {
			numArr[i] = str.charAt(i) - '0';
		}

		// 버블 정렬
		for (int i = 1; i < numArr.length; i++) {
			for (int j = 0; j < numArr.length - i; j++) {
				if (numArr[j] < numArr[j + 1]) {
					// 뒤 수가 더 크면 swap해서 내림차순 정렬
					int tmp = numArr[j];
					numArr[j] = numArr[j + 1];
					numArr[j + 1] = tmp;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		// 스트링빌더에 차례대로 담기
		for (int x : numArr) {
			sb.append(x);
		}
		System.out.println(sb);
	}
}