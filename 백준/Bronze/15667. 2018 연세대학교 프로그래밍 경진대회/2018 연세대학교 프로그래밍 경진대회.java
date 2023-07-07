import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		int K = 0;
		
		for(int i = 1; i <= 100; i++) { // 왜냐하면 N이 10101까지이므로 100까지만 조사하면 된다.
			int ans = i*i + i + 1;
			if(ans == N) {
				K = i;
				break;
			}
		}
		
		System.out.println(K);
	}
}