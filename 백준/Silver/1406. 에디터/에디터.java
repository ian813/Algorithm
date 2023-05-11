import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// 스택 2개 생성
		Stack<Character> strStack = new Stack<>();
		Stack<Character> result = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		// 문자열 입력받아서 스택에 푸시해주기
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			strStack.push(str.charAt(i));
		}
		
		int orderNum = sc.nextInt(); // 명령어 개수

		for (int i = 0; i < orderNum; i++) {
			String order = sc.next();
			if (order.equals("L")) { // 명령어가 L이면
				if (!strStack.empty()) { // 문자열 스택이 비어있지 않으면
					result.push(strStack.pop()); // 문자열 스택에서 팝해서 결과 스택에 넣어주기
				}
			} else if (order.equals("D")) { // 명령어가 D이면
				if (!result.empty()) { // 결과 스택이 비어있지 않으면
					strStack.push(result.pop()); // 결과 스택에서 팝해서 문자열 스택에 넣어주기

				}
			} else if (order.equals("B")) { // 명령어가 B이면
				if (!strStack.empty()) { // 문자열 스택이 비어있지 않으면
					strStack.pop(); // 팝해서 삭제
				}
			} else if (order.equals("P")) { // 명령어가 P이면
				char addChar = sc.next().charAt(0); // 추가할 문자 입력받기
				strStack.push(addChar); // 추가할 문자를 문자열 스택에 푸시해준다.
			}

		}
		sc.close();
		// 명령어 수행이 다 끝나면 문자열 스택이 빌때까지 팝해서 결과 스택에 푸시해주기
		while (!strStack.empty()) {
			result.push(strStack.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 결과열 스택이 빌때까지 팝해서 출력
		while (!result.empty()) {
			sb.append(result.pop());
		}
		
		System.out.println(sb);
	}

}