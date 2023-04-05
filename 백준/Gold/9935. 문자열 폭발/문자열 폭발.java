import java.util.Scanner;
import java.util.Stack;

public class Main {
	static String str; // 입력받을 문자열
	static String bombStr; // 폭발 문자열
	static String result = "FRULA";
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		bombStr = sc.next();
	}
	
	static void bomb() {
		// 스택 써서 폭발시키자
		Stack<Character> stack = new Stack<>();
		
		// 문자열을 하나씩 쪼개서 스택에 넣어준다.
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			
			if(stack.size() >= bombStr.length()) {
				// 만약 폭발문자열 길이보다 크거나 같아지면 이제 계속
				// 폭발시킬수 있는지 판단
				
				// 폭발이 가능한지 판단할 불리안
				boolean flag = true;
				
				for(int j = 0; j < bombStr.length(); j++) {
					// 스택에 쌓인 문자열과 폭발 문자열을 하나씩 비교해서
					// 하나라도 틀리면 flag=false로 갱신하고 멈추기
					if(stack.get(stack.size() - bombStr.length() + j) != bombStr.charAt(j)) {
						flag = false;
						break;
					}
					
				}
				
				if(flag) {
					// flag가 그대로 true라면 폭발시킬게 있으므로
					for(int k = 0; k < bombStr.length(); k++) {
						// 폭발문자열 길이만큼 팝해줌
						stack.pop();						
					}
				}
			}
		}
		
		// 폭발이 다 끝났으면 스트링빌더에 순서대로 담아주기
		for(int idx = 0; idx < stack.size(); idx++) {
			sb.append(stack.get(idx));
		}
		
	}
	
	public static void main(String[] args) {
		input();
		bomb();
		
		
		// 문자열이 완전히 사라지면 result를 출력하고 그게 아니면 문자열 출력
		if(sb.length() != 0) System.out.println(sb);
		else System.out.println(result);
	}
}
