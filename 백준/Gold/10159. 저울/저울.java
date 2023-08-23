import java.util.Scanner;

public class Main {

	// 물건과 물건관계 개수
	static int object, pair;
	// 물건관계 개수 저장할 배열
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		object = sc.nextInt();
		pair = sc.nextInt();

		// 각 물건들을 비교할 수 있는지 체크할 불리안 배열
		check = new boolean[object + 1][object + 1];

		// 비교 관계 입력받아서 true로 체크
		for (int i = 0; i < pair; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			check[start][end] = true;
		}

		// i에서 k를 거쳐서 j로 갈 수 있으면 true로 변경
		for (int k = 1; k <= object; k++) {
			for (int i = 1; i <= object; i++) {
				for (int j = 1; j <= object; j++) {
					if (check[i][k] && check[k][j]) {
						check[i][j] = true;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= object; i++) {
			// i에서 비교 불가능한 물건 개수 세줄 변수
			int cnt = 0;
			for (int j = 1; j <= object; j++) {
				if (i != j && !check[i][j] && !check[j][i]) { // 자기 자신이 아닌데 비교 불가능하면 카운팅
					cnt++;
				}
			}
			// 스트링빌더에 담기
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}