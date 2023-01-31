import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N, K를  받아줌.
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 몇 번째 약수인지 cnt
		int cnt = 0;
		
		// 약수 찾기
		for(int i = 1; i <= N; i++) {
			// 약수를 찾으면 cnt++;
			if(N % i == 0) {
				cnt++;
			}
			
			// K번째 약수를 찾으면 프린트하고 break
			if(cnt == K) {
				System.out.println(i);
				break;
			}
		}
		
		// 만약 for문에 끝났는데 cnt < K이면 0을 프린트
		if(cnt < K) {
			System.out.println(0);
		}
	}
}