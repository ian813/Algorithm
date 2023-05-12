import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int A, B, m, cal; // A진법, B진법, A진법의 자릿수, 10진법으로 계산했을 때 값
	static StringBuilder sb;

	static void solve() {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();
		m = sc.nextInt();

		sb = new StringBuilder();

		cal = 0;

		// A진수를 10진수로 바꿔주기
		for (int i = m - 1; i >= 0; i--) {
			int value = (int) Math.pow(A, i);
			int temp = sc.nextInt();

			cal += value * temp;
		}

		// 10진수를 B로 나눴을 때의 나머지를 저장할 스택 (B진수의 수가 된다.)
		Stack<Integer> stack = new Stack<>();

		// 0이 될 때까지 cal을 B로 나눈 나머지를 저장하고 cal은 B로 나눈 몫으로 갱신해서 반복
		while (cal != 0) {
			stack.push(cal % B);

			cal /= B;

		}
		
		// 스택에서 팝하면서 스트링빌더에 저장해주면 끝
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		solve();
		System.out.println(sb);
	}
}