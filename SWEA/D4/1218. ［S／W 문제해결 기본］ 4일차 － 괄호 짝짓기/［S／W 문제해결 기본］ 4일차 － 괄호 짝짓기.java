import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			// 유효한지 판단할 불리안
			boolean isValid = false;
			
			// 결과값을 저장할 변수
			int result = 0;
			
			// 괄호의 길이를 받을 변수
			int bracketLength = sc.nextInt();
			
			// 괄호 문자열을 받을 변수
			String bracket = sc.next();
			
			// 문자열의 길이만큼 배열 생성
			char[] bracketArr = bracket.toCharArray();
			
			// 스택 생성해서 판단해주자
			Stack<Character> store = new Stack<>();
			
			// 배열 돌면서 판단
			for(int idx = 0; idx < bracketLength; idx++) {
				// 여는 괄호 종류면 스택에 넣어주고
				if(bracketArr[idx] == '(' || bracketArr[idx] == '[' ||
						bracketArr[idx] == '{' || bracketArr[idx] == '<') {
					store.push(bracketArr[idx]);
				} else {
					// 닫는 괄호들이면 
					if(store.peek() + 1 == bracketArr[idx]) {
						// (과 )는 아스키코드 차이가 1이라 이렇게 표현
						// 짝이 맞으면 스택에서 팝
						store.pop();
					} else if(store.peek() + 2 == bracketArr[idx]) {
						// 나머지 괄호들은 아스키코드 차이가 2라 이렇게 표현
						// 짝이 맞으면 팝
						store.pop();
					} else {
						// 아니면 유효하지 않으므로
						// 바로  break
						isValid = false;
						break;
					}
				}
			}
			
			if(store.isEmpty()) {
				isValid = true;
			}
			
			// 유효하면 결과값을 1로 바꿔줌
			if(isValid) {
				result = 1;
			}
			
			// 형식에 맞게 출력
			System.out.printf("#%d %d\n", tc, result);
		}
		
	}
}