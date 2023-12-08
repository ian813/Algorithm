import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();

		// 몇 개 붙였는지 카운팅 (수를 이진법으로 변환했을 때 1의 개수를 세주면 된다.)
		int cnt = 0;

		// i를 1부터 시작해서 target이하일 동안 계속 2배해주면서 카운팅
		// i << 1 -> i를 2배 해준다는 뜻
		for (int i = 1; i <= target; i <<= 1) {
			if ((i & target) == i) {
				// i와 target을 AND 연산 했을 때 값이 i면 카운팅
				// ex) i = 2 -> 10, target = 23 -> 10111
				// i & target = 10 = i
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}