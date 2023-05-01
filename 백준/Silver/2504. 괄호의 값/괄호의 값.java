import java.util.Scanner;
import java.util.Stack;

public class Main {
	static char[] bracketArr;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String bracket = sc.next();

		bracketArr = bracket.toCharArray(); // 괄호들을 배열에 저장

		ans = 0; // 결과값 초기화

		store();

		System.out.println(ans); // 출력

		sc.close();
	}
	
//	temp = 2 * 2
//	result = 4 temp = 2 * 2 / 2
//	temp = 2*2/2 * 3 * 3 = 18
//	result = 4 + 18 temp = 2*2/2 *3*3/3
//	temp = 2*2/2 *3*3/3/2 = 1
//	temp = 1 * 2*3
//	result = 4 + 18 + 6 temp = 2*3/3/2
	
	static void store() {
		Stack<Character> stack = new Stack<>(); // 괄호들 담아줄 스택

		int temp = 1;

		for (int idx = 0; idx < bracketArr.length; idx++) {
			if (bracketArr[idx] == '(' || bracketArr[idx] == '[') { // 열린괄호를 만나면
				stack.push(bracketArr[idx]); // 스택에 푸시
				if (bracketArr[idx] == '(') { // 만약 ( 면 2를 곱해서 저장
					temp *= 2;
				} else { // 만약 [ 면 3을 곱해서 저장
					temp *= 3;
				}
			} else if (bracketArr[idx] == ')') { // 닫힌 괄호 )를 만나면
				if (stack.isEmpty() || stack.peek() != '(') { // 만약 스택이 비어있거나 스택 위의 값과 짝이 맞지 않으면
					ans = 0; // 0을 저장하고 바로 멈추기
					break;
				} else { // 그렇지 않을 때
					if(bracketArr[idx-1] == '(') ans += temp; // 만약 그 직전 괄호가 (였을 때만 결과값에 더해준다.
					stack.pop(); // 스택에서 꺼내주고
					temp /= 2; // 저장 값을 2로 나누기
				}
			} else { // 닫힌 괄호 ]를 만나면
				if (stack.isEmpty() || stack.peek() != '[') { // 만약 스택이 비어있거나 스택 위의 값과 짝이 맞지 않으면
					ans = 0; // 0을 저장하고 바로 멈추기
					break;
				} else { // 그렇지 않을 때
					if(bracketArr[idx-1] == '[') ans += temp; // 만약 그 직전 괄호가 [였을 때만 결과값에 더해준다.
					stack.pop(); // 스택에서 꺼내주고
					temp /= 3; // 저장 값을 3으로 나누기
				}
			}
		}
		if(!stack.isEmpty()) ans = 0; // 만약 다 했는데 스택이 안 비어있으면 결과값을 0으로 저장
	}
}