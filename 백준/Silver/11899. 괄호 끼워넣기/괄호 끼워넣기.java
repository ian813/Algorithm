import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받을 괄호 정보
		char[] bracket = sc.next().toCharArray();

		// 괄호를 넣어줄 스택
		Stack<Character> stack = new Stack<>();

		// 추가할 괄호 개수
		int cnt = 0;

		for (int i = 0; i < bracket.length; i++) {
			// 배열 돌면서
			if (bracket[i] == '(') {
				// 열린 괄호만나면 스택에 넣어주기
				stack.push(bracket[i]);
			} else {
				// 닫힌 괄호 만나면
				if (!stack.empty()) {
					// 스택이 비어있지 않으면 열린 괄호가 들어있으므로
					// 그걸 스택에서 빼줘서 짝을 맞춰줌
					stack.pop();
				} else {
					// 비어있지 않으면 괄호를 추가해서 짝을 맞춰줌
					cnt++;
				}
			}
		}

		while (!stack.empty()) {
			// 배열 다 돌았을 때 스택이 비어있지 않으면
			// 짝이 맞지 않은 열린 괄호들이 남은 것이므로
			// 스택에서 빼주면서 괄호를 추가해서 짝을 맞춰줌
			stack.pop();
			cnt++;
		}

		System.out.println(cnt);
	}
}