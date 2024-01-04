import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테케 개수
		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (testCase-- > 0) {
			// 테케만큼 실행

			// 꼭짓점과 모서리 개수
			int vertex = sc.nextInt();
			int edge = sc.nextInt();

			// 면 개수 구하기 by 오일러
			int face = edge - vertex + 2;

			// 스트링빌더에 저장
			sb.append(face).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}