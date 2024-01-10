import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 개수
		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (testCase-- > 0) {
			// 	테케만큼 실행

			// 사탕 개수, 상자 개수
			int candy = sc.nextInt();
			int box = sc.nextInt();

			// 박스의 사이즈를 저장할 배열
			Integer[] size = new Integer[box];

			for (int i = 0; i < box; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();

				// 박스의 사이즈를 저장
				int pack = row * col;

				size[i] = pack;
			}

			// 내림차순 정렬
			Arrays.sort(size, Collections.reverseOrder());

			// 쓰이는 박스 개수
			int cnt = 0;
			while (candy > 0) {
				// 사탕 개수가 0보다 클때까지만 반복해서
				// 사탕 개수를 상자 크기만큼 빼주기
				candy -= size[cnt++];
			}

			// 저장
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}