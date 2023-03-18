import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner sc = new Scanner(System.in);	
	static int testCase = sc.nextInt();
	
	static String bracket;
	static String ans;
	
	static void solve() {
		bracket = sc.next();
		// 답을 YES로 설정
		ans = "YES";
		
		// 매 시행마다 스택을 새로 생성해서 초기화
		Stack<Character> isBracket = new Stack<>();
		
		for(int idx = 0; idx < bracket.length(); idx++) {
			// 문자열에서 탐색
			if(bracket.charAt(idx) == '(') {
				// 여는 괄호가 나오면 스택에 푸시
				isBracket.push(bracket.charAt(idx));
			} else {
				// 닫는 괄호가 나왔을 때
				if(!isBracket.isEmpty()) {
					// 스택이 비어있지 않으면 팝
					isBracket.pop();
				} else {
					// 스택이 비어있으면
					// 유효하지 않으므로
					// 답을 NO로 바꾸고 탐색 종료
					ans = "NO";
					break;
				}
			}
		}
		
		if(!isBracket.isEmpty()) {
			// 탐색 종료 시 스택이 비어있지 않으면
			// 답을 NO로 변경
			ans = "NO";
		}
		// 답 출력
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		// 테스트케이스만큼 반복
		for(int tc = 1; tc <= testCase; tc++) {
			solve();
		}
	}
}