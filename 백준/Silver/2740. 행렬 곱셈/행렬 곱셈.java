import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 행렬 정보와 행렬 생성해서 입력받기
		int row1 = sc.nextInt();
		int col1 = sc.nextInt();
		int[][] matrix1 = new int[row1][col1];

		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col1; j++) {
				matrix1[i][j] = sc.nextInt();
			}
		}

		int row2 = sc.nextInt();
		int col2 = sc.nextInt();

		int[][] matrix2 = new int[row2][col2];

		for (int i = 0; i < row2; i++) {
			for (int j = 0; j < col2; j++) {
				matrix2[i][j] = sc.nextInt();
			}
		}

		// 결과 행렬 생성
		int[][] result = new int[row1][col2];

		// 곱셈 구현
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col2; j++) {
				result[i][j] = 0;
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