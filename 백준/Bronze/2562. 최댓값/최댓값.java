import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int i = 1;
		int row = 0;
		// 입력받은 자연수를 배열에 할당
		while(i <= 9) {
			int N = sc.nextInt();
			if (max < N) {
				max = N;
				row = i;
			}
			i++;
		}
		System.out.println(max);
		System.out.println(row);
	}
}