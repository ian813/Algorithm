import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		String str = "";
		
		if(N == 0) str = "YONSEI";
		else str = "Leading the Way to the Future";
		
		System.out.println(str);
	}
}