import java.util.Scanner;

public class Main {

	private static int N, M;
	private static int[] light;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		// 가로등 정보 입력받기
		light = new int[M];

		for (int i = 0; i < M; i++) {
			light[i] = sc.nextInt();
		}

		int h = install();

		System.out.println(h);
	}

	private static int install() {
		// 구간별 최댓값을 구하면 된다.

		int h = Math.max(light[0] - 0, N - light[M - 1]);

		for (int i = 1; i < M; i++) {
			int tmp = ((light[i] - light[i - 1]) % 2 == 0) ? (light[i] - light[i - 1]) / 2 :
				(light[i] - light[i - 1]) / 2 + 1;

			h = Math.max(h, tmp);
		}

		return h;
	}
}