import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();

		int position = sc.nextInt();

		int r = position / C;
		int c = position % C;
		
		System.out.println(r + " " + c);
	}
}