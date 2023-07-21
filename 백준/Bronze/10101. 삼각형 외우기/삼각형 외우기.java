import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String ans;
		
		int angA = sc.nextInt();
		int angB = sc.nextInt();
		int angC = sc.nextInt();
		
		sc.close();

		int sum = angA + angB + angC;
		
		if(sum != 180) {
			ans = "Error";
		} else if(angA != angB && angB != angC && angC != angA) {
			ans = "Scalene";
		} else if(angA == angB && angB == angC) {
			ans = "Equilateral";
		} else {
			ans = "Isosceles";
		}
		
		System.out.println(ans);
	}
}