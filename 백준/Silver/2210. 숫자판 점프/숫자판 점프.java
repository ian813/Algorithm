import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// 완성도니 숫자 담을 배열 (문자열로 받아야됨 -> 000123도 되므로)
	static ArrayList<String> list = new ArrayList<>();
	static int[][] numbers;

	// 델타배열(상하좌우)
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자판 정보 입력받기
		numbers = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}

		// 배열 돌면서 dfs 탐색
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, "" + numbers[i][j], 1);
			}
		}

		// 리스트 크기 출력
		System.out.println(list.size());
	}

	private static void dfs(int r, int c, String number, int depth) {
		if (depth == 6) {
			// 뎁스가 6일 때
			for (int i = 0; i < list.size(); i++) {
				// 배열 돌면서 같은 게 있으면 리턴
				if (list.get(i).equals(number)) {
					return;
				}
			}
			// 리턴 안됐으면 리스트에 숫자 추가
			list.add(number);
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 델타배열로 탐색
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 배열 범위 넘어갔으면 넘기기
			if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
				continue;
			}

			dfs(nr, nc, number + numbers[nr][nc], depth + 1); // dfs 탐색
		}
	}
}