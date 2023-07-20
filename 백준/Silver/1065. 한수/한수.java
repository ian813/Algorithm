import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		int ans = 0;
		
		if(N == 1000) N--; // 1000이 등차수열 이루지 않은 수이므로 999랑 개수는 같으니까 편의를 위해...
		
		if(N < 100) {
			ans = N; // 100보다 작으면 N개만큼 가지고 있음
		} else if(N >= 100) {
			ans += 99; // 기본 99개는 있음

			for(int i = 100; i <= N; i++) { // 100이상 N이하 수에 대해 모두 탐색
				int tmp = i;
				
				int a = tmp % 10; // 1의 자리 수
				tmp /= 10;
				int b = tmp % 10; // 10의 자리 수
				tmp /= 10;
				int c = tmp; // 100의 자리 수
				
				if(a-b == b-c) { // 자릿수끼리 등차수열인지 비교
					ans++; // 맞으면 카운트
				}
			}
		}
		
		System.out.println(ans);
	}
}