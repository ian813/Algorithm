import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 행렬 크기
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 행렬 생성 (인덱스 맞추기 위해 N+1, M+1)
		int[][] matrix = new int[N + 1][M + 1];

		// 행렬 정보 입력받기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		// 부분 합 구할 개수
		int K = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (K-- > 0) {
			// K번만큼 반복
			// 시작 위치와 끝 위치 입력받기
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 부분합 구할 변수
			int sum = 0;

			for (int r = i; r <= x; r++) {
				for (int c = j; c <= y; c++) {
					// 시작점부터 끝점까지
					// 부분합 구해주기
					sum += matrix[r][c];
				}
			}

			sb.append(sum).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}