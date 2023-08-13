import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 시작점 입력받기
		char start = sc.next().charAt(0);

		// 답
		int ans = 0;

		// 정해진 target String 설정
		String str = "ILOVEYONSEI";

		// 배열로 바꾸기
		char[] target = str.toCharArray();

		// 시작점에서 첫번째 char인 I까지의 거리의 최솟값 더해주기
		ans += Math.min(Math.abs(target[0] - start), Math.abs(start - target[0]));

		// target 배열을 돌면서 최소 거리 계산해서 더해주기
		for (int i = 1; i < target.length; i++) {
			ans += Math.min(Math.abs(target[i - 1] - target[i]), Math.abs(target[i] - target[i - 1]));
		}

		// 출력
		System.out.println(ans);
	}
}