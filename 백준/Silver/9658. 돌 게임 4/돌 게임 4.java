import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 1일 때 CY
		// 2일 때 SK
		// 3일 때 CY
		// 4일 때 SK
		// 5일 때 SK
		// 6일 때 SK
		// 7일 때 SK
		String ans = (N % 7 == 1 || N % 7 == 3) ? "CY" : "SK";

		System.out.println(ans);
	}
}