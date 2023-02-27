import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		String str = sc.nextLine();
		Stack<Character> strStack = new Stack<>();

		// <> 안에 있는 문자인지 아닌지 판단
		// 안에 있으면 true
		boolean inBracket = false;

		for (int idx = 0; idx < str.length(); idx++) {

			if (str.charAt(idx) == '<') {
				// < 를 만났을 때
				// 이제부터 괄호 안이므로
				inBracket = true;

				// 스택에 저장되어 있는 게 있으면 전부 pop해주기
				while (!strStack.isEmpty()) {
					sb.append(strStack.pop());
				}

				// < 도 스트링빌더에 추가해주기
				sb.append(str.charAt(idx));
			} else if (str.charAt(idx) == '>') {
				// > 만났을 때
				// 이제부터 괄호 밖이므로
				inBracket = false;

				// > 스트링빌더에 추가해주기
				sb.append(str.charAt(idx));
			} else if (inBracket) {
				// 괄호 안에 있는 문자면
				// 스트링빌더에 바로 추가
				sb.append(str.charAt(idx));
			} else if (!inBracket) {
				// 괄호 안에 있는 문자면
				// 공백을 만났을 때와 아닐 때로 구분해서
				// 시행해줘야 한다.

				if (str.charAt(idx) == ' ') {
					// 공백을 만나면
					while (!strStack.isEmpty()) {
						// 스택이 빌 때까지 스택에 있는 값들을
						// 스트링빌더에 넣어주기
						sb.append(strStack.pop());
					}

					// 마지막에 공백도 스트링빌더에 넣어주기
					sb.append(str.charAt(idx));
				} else {
					// 공백이 아니면
					// 스택에 넣어주기
					strStack.push(str.charAt(idx));
				}

			}

		}

		// 마지막까지 돌았을 때 스택에 남아있는게 있으면
		// 전부 스트링빌더에 담아주기
		while (!strStack.isEmpty()) {
			sb.append(strStack.pop());
		}
		
		// 스트링빌더에 저장된거 출력
		System.out.println(sb);

	}
}