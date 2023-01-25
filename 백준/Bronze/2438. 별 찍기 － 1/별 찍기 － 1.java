import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String star = "*";
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if (row < col) {
					continue;
				} else {
					System.out.print(star);
				}
			}
			System.out.println();
		}
	}
}