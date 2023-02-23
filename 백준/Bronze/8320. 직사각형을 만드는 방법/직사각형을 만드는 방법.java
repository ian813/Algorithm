import java.util.Scanner;

public class Main {
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		// 직사각형 개수
		int cnt = 0;
		
		// 직사각형 개수 세기
		int i = 1;

		while(i*i <= n) {
			// i*i 정사각형에서 시작해서 한줄씩 늘려주는 식으로 개수를 세주면 된다.
			// i는 1씩 늘려가면서
			// i*i가 n보다 작거나 같을 때까지 반복해서 개수를 세준다.
			for(int k = i*i; k <= n; k = k + i) {
				cnt++;
			}
			i++;
		}
		
		System.out.println(cnt);
		
	}
}