import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if (M >= 45) {
			M -= 45;
			System.out.println(H + " " + M);
		} else if (0 <= M && M < 45) {
			if(H > 0) {
				M = 60 - (45 - M);
				H--;
				System.out.println(H + " " + M);
			} else if(H == 0) {
				M = 60 - (45 - M);
				H = 23;
				System.out.println(H + " " + M);
			}
		}
		
		
	}
}