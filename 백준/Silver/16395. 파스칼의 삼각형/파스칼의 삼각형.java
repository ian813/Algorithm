import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[][] pascal = new int[31][31];

		// 대각선과 맨 첫 열에 1로 채워넣음
		for (int i = 0; i <= 30; i++) {
			pascal[0][i] = 1;
			pascal[i][i] = 1;
		}

		// dp로 담아주기
		for (int i = 2; i <= 30; i++) {
			for (int j = 1; j < i; j++) {
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
			}
		}

		System.out.println(pascal[n][k]);
	}
}