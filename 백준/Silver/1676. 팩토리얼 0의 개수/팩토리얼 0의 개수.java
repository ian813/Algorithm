import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();

		// 5의 배수만 세주면 될 듯?
		// 단 5가 여러개 포함된 수면
		// 결과값 저장
		int result = 0;
		
		while(N >= 5) {
			result += N/5;
			
			N /= 5;
		}
		
		System.out.println(result);
	}
}