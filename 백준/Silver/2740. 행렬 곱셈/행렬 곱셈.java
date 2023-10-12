import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행렬 정보와 행렬 생성해서 입력받기
		int row1 = Integer.parseInt(st.nextToken());
		int col1 = Integer.parseInt(st.nextToken());
		int[][] matrix1 = new int[row1][col1];

		for (int i = 0; i < row1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col1; j++) {
				matrix1[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		int row2 = Integer.parseInt(st.nextToken());
		int col2 = Integer.parseInt(st.nextToken());

		int[][] matrix2 = new int[row2][col2];

		for (int i = 0; i < row2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col2; j++) {
				matrix2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 결과 행렬 생성
		int[][] result = new int[row1][col2];

		// 곱셈 구현
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col2; j++) {
				for (int k = 0; k < col1; k++) {
					// 잘 생각해 보면 나온다...
					result[i][j] += (matrix1[i][k] * matrix2[k][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		// 출력
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col2; j++) {
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}