import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테케 개수
		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (testCase-- > 0) {
			// 테케만큼 진행

			// 암호문 입력받기
			String password = sc.next();

			// 암호문 배열 크기
			int size = (int)Math.sqrt(password.length());

			char[][] letter = new char[size][size];

			// 암호문의 인덱스
			int idx = 0;

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					// 편지 형식으로 암호문 작성
					letter[i][j] = password.charAt(idx++);
				}
			}

			// 암호문 규칙대로 편지 읽기
			for (int j = size - 1; j >= 0; j--) {
				for (int i = 0; i < size; i++) {
					sb.append(letter[i][j]);
				}
			}
			// 개행
			sb.append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}