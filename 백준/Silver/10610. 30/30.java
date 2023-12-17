import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자를 문자열 형태로 입력받기
		String num = sc.next();

		// 30의 배수를 만들 수 있는지 판단할 불리안
		// 30의 배수 -> 10의 배수 + 3의 배수 -> 0이 포함되어 있고, 각 자릿수 합이 3의 배수이면 된다
		boolean flag = true;

		if (!num.contains("0")) {
			// 0이 포함되어 있지 않으면 false
			flag = false;
		}

		if (flag) {
			// 10의 배수인 것은 확인했으니,, 3의 배수인지 판단해보자

			// char 형태로 쪼개기
			char[] numArr = num.toCharArray();

			// 자리수의 합을 구할 변수
			int sum = 0;

			for (int i = 0; i < numArr.length; i++) {
				// 각 자리 합 구해주기
				sum += numArr[i] - '0';
			}

			if (sum % 3 != 0) {
				// 3의 배수가 아니면 flag false로 변경
				flag = false;
			}

			if (flag) {
				// 30의 배수가 되었으면 가장 큰 수로 만들어보자.

				// 오름차순 정렬
				Arrays.sort(numArr);

				StringBuilder sb = new StringBuilder();

				for (int i = numArr.length - 1; i >= 0; i--) {
					// 끝에서부터 담기
					sb.append(numArr[i]);
				}

				// 답 출력
				System.out.println(sb);
			} else {
				// 3의 배수 아니면 -1 출력
				System.out.println(-1);
			}
		} else {
			// 10의 배수 아니면 -1 출력
			System.out.println(-1);
		}
	}
}