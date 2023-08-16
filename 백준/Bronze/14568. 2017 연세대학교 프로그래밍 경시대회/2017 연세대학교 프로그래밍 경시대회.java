import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int ans = 0;

		if (N < 6)
			// 6보다 작으면 나눠줄 수 있는 경우가 없다.
			System.out.println(ans);
		else {
			// 택희는 2의 배수개 받아야하고
			// 남규 = 영훈 + k개 (k >= 2)
			// 따라서 택희 + 2*영훈 + k = N이 되는 경우를 찾으면 된다.
			// 다만 택희가 2의 배수이므로
			// 2*i + 2*j + k = N이되는 경우의 수를 구해야한다.
			// 다만 i, j >= 1, k >= 2이고 N <= 100이다.
			for (int i = 1; i <= 50; i++) {
				for (int j = 1; j <= 50; j++) {
					for (int k = 2; k <= 100; k++) {
						if (2 * i + 2 * j + k == N)
							ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
}