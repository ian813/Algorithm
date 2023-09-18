import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 타겟
		int N = sc.nextInt();

		// 몇번째 수인지 카운팅, 답을 나타낼 변수
		int cnt = 0;
		int ans = 665;

		while (cnt != N) {
			// 수는 계속 더해가면서 반복
			ans++;

			// cnt가 N번쨰 수가 될 때까지 반복
			if (String.valueOf(ans).contains("666")) {
				// ans에 666이 포함되어 있으면
				// 카운팅
				cnt++;
			}
		}

		// 답 출력
		System.out.println(ans);
	}
}