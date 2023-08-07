import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int operator = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[row + 1][col + 1];

		int[][] operatorInfo = new int[3][Math.max(row + 1, col + 1)];

		for (int i = 0; i < operator; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			int lo = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			operatorInfo[num][lo] += v;
		}

		for (int i = 1; i <= Math.max(row, col); i++) {
			if (operatorInfo[1][i] != 0) {
				for (int c = 1; c <= col; c++) {
					matrix[i][c] += operatorInfo[1][i];
				}
			}
			if (operatorInfo[2][i] != 0) {
				for (int r = 1; r <= row; r++) {
					matrix[r][i] += operatorInfo[2][i];
				}
			}
		}

		// for (int i = 0; i < operator; i++) {
		// 	st = new StringTokenizer(br.readLine());
		//
		// 	int num = Integer.parseInt(st.nextToken());
		// 	int lo = Integer.parseInt(st.nextToken());
		// 	int v = Integer.parseInt(st.nextToken());
		//
		// 	if (num == 1) {
		// 		for (int j = 1; j <= col; j++) {
		// 			matrix[lo][j] += v;
		// 		}
		// 	} else {
		// 		for (int j = 1; j <= row; j++) {
		// 			matrix[j][lo] += v;
		// 		}
		// 	}
		// }

		StringBuilder sb = new StringBuilder();

		for (int r = 1; r <= row; r++) {
			for (int c = 1; c <= col; c++) {
				sb.append(matrix[r][c] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}