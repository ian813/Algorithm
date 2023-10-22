import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String x = sc.next();

		// 연산 몇 번 했는지 카운팅
		int cnt = 0;
		String ans = "";

		while (x.length() > 1) {
			// x길이가 1보다 클 때만 실행
			// 자릿수 합 구할 변수
			long sum = 0;

			for (int i = 0; i < x.length(); i++) {
				// 자릿수 합 구하고
				sum += Integer.parseInt(String.valueOf(x.charAt(i)));
			}
			// 연산횟수 카운팅
			cnt++;

			x = String.valueOf(sum);
		}

		// 10보다 작으면
		// 3의 배수인지 아닌지 판단
		if (Integer.parseInt(x) % 3 == 0) {
			ans = "YES";
		} else {
			ans = "NO";
		}

		System.out.println(cnt);
		System.out.println(ans);
	}
}