import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 번호
		int tc = 0;

		StringBuilder sb = new StringBuilder();

		while (true) {
			// 괄호 정보 입력받기
			String bracket = sc.next();

			if (bracket.contains("-")) {
				// -를 포함하고 있으면 종료
				break;
			}

			// 테케 번호 증가
			tc++;

			// 연산 카운팅
			int cnt = 0;

			// 스택 생성
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < bracket.length(); i++) {
				// 하나씩 쪼개서 판단
				char cur = bracket.charAt(i);

				if (cur == '{') {
					// 열린 괄호면 무조건 스택에 넣어주기
					stack.push(cur);
				} else if (!stack.empty()) {
					// 닫힌 괄호인데 스택이 비어있지 않으면 열린 괄호가 들어있어 짝이 맞으므로
					// 스택에서 빼주기
					stack.pop();
				} else {
					// 닫힌 괄호인데 스택이 비어있으면 짝이 안 맞으니까
					// 열린 괄호로 바꿔서 넣어주고 카운팅
					stack.push('{');
					cnt++;
				}
			}

			if (!stack.empty()) {
				// 짝이 맞지 않은 열린 괄호들이 존재하면 절반만 닫힌 괄호로 바꿔서 짝 맞춰주기
				cnt += stack.size() / 2;
			}

			// 형식에 맞게 스트링빌더에 저장
			sb.append(tc).append(". ").append(cnt).append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}