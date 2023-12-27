import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행렬 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 행렬 생성 (인덱스 맞추기 위해 N+1, M+1)
		int[][] matrix = new int[N + 1][M + 1];

		// 행렬 정보 입력받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		// 부분 합 구할 개수
		int K = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		while (K-- > 0) {
			// K번만큼 반복
			st = new StringTokenizer(br.readLine());
			// 시작 위치와 끝 위치 입력받기
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

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