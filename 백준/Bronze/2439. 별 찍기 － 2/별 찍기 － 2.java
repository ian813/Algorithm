import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(row + col < N-1) {
					System.out.printf("%s", " ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}