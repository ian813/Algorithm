import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 맵 크기
		N = sc.nextInt();
		M = sc.nextInt();

		// 맵 정보
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] += Math.max(map[i - 1][j], map[i][j - 1]);
			}
		}

		System.out.println(map[N][M]);
	}
}