import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Long N = sc.nextLong();

		String ans = ((N % 7 == 0) || (N % 7 == 2)) ? "CY" : "SK";

		System.out.println(ans);
	}
}