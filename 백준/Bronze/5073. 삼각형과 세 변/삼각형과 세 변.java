import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		// 0 0 0이 나올 때까지 계속 반복
		while (true) {
			// 초기 답
			String ans = "Invalid";

			// 세 변 입력받기
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0 && b == 0 && c == 0) {
				// 세 변이 모두 0이면 멈추기
				break;
			}

			if (a + b <= c || b + c <= a || c + a <= b) {
				// 삼각형 조건을 만족하지 못하면 Invalid 저장하고 넘기기
				sb.append(ans).append("\n");
				continue;
			}
			if (a == b && b == c) {
				// 세 변이 모두 같으면 Equilateral 저장하고 넘기기
				ans = "Equilateral";
				sb.append(ans).append("\n");
				continue;
			}
			if (a == b || b == c || c == a) {
				// 두 변의 길이만 같으면 Isosceles 저장하고 넘기기
				ans = "Isosceles";
				sb.append(ans).append("\n");
				continue;
			}
			// 모든 조건 통과했으면 Scalene 저장
			ans = "Scalene";
			sb.append(ans).append("\n");
		}

		// while문 빠져나오면 출력
		System.out.println(sb);
	}
}