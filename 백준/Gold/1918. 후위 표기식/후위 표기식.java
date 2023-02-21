import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 계산식을 문자열로 입력받기
		String calculation = sc.next();

		// 후위연산자로 바꾸기 위해 임시로 저장할 스택 생성
		Stack<Character> store = new Stack<>();

		// 후위연산자로 바꿔서 저장해줄 문자열
		String newCalculation = "";

		// 계산식을 배열에 넣어주기
		char[] calculationArr = calculation.toCharArray();

		// 후위연산자로 바꿔보자.
		for (int idx = 0; idx < calculationArr.length; idx++) {

			if (calculationArr[idx] >= 'A' && calculationArr[idx] <= 'Z') {
				// A~Z까지면 바로 새 문자열에 넣어준다.
				newCalculation += calculationArr[idx];

			} else if (calculationArr[idx] == '+' || calculationArr[idx] == '-') {
				// + or -이면
				if (store.isEmpty() || store.peek() == '(') {
					// 만약 스택이 비어있거나 ( 가 top에 있으면
					// 스택에 넣어주고
					store.push(calculationArr[idx]);
				} else if (store.peek() == '+' || store.peek() == '-') {
					// 스택의 top에 + or -가 있으면
					// 새 문자열에 더해준다.
					// 사실 스택에서 팝한 걸 새 문자열에 더해주고
					// 지금 인덱스껄 푸쉬해서 스택에 넣어줘야 하는데
					// 어차피 + or -는 여러개 쌓일 수가 없으므로,,,
					newCalculation += store.pop();
					store.push(calculationArr[idx]);
				} else if (store.peek() == '*' || store.peek() == '/') {
					// 스택의 top에 * or /가 있으면
					// 스택에 저장된 연산 스택이 (를 만나거나 빌 때까지 순서대로 pop해서
					// 새 문자열에 더해주고
					while (!store.isEmpty()) {
						char tmpSave = store.peek();
						if (tmpSave != '(') {
							newCalculation += store.pop();
						} else {
							break;
						}

					}

					// 마지막에 * or /를 push해서 스택에 넣어준다.
					store.push(calculationArr[idx]);

				}

			} else if (calculationArr[idx] == '*' || calculationArr[idx] == '/') {
				// * or /이면
				if (store.isEmpty() || store.peek() == '(') {
					// 스택이 비어있거나 top에 ( 가 있다면
					// push해서 넣어준다.
					store.push(calculationArr[idx]);
				} else if (store.peek() == '+' || store.peek() == '-') {
					// 스택의 top이 + or -이면
					// 위에 * or /를 push해서 쌓아준다.
					store.push(calculationArr[idx]);
				} else if (store.peek() == '*' || store.peek() == '/') {
					// 스택의 top이 * or /이면
					// * or /를 새 문자열에 그냥 더해준다.
					newCalculation += store.pop();
					
					store.push(calculationArr[idx]);

				}

			} else if (calculationArr[idx] == '(') {
				// ( 이면
				// 스택에 push
				store.push(calculationArr[idx]);
			} else if (calculationArr[idx] == ')') {
				// )이면
				char tmpSave = store.peek();
				while (!store.isEmpty()) {
					if (tmpSave != '(') {
						newCalculation += store.pop();
						tmpSave = store.peek();
					} else {
						store.pop();
						break;
					}
				}

			}

			// 위의 조건문을 거치면,,
			// 마지막에 스택에 연산자가 남아있는채로 끝난다.
			// 그래서 마지막까지 도달하고 스택이 비어있지 않으면
			// 스택이 빌 때까지 팝해서 새 문자열에 더해준다.
			if (idx == calculationArr.length - 1) {
				while (!store.isEmpty()) {
					char tmpSave = store.pop();
					if (tmpSave != ')') {
						newCalculation += tmpSave;
					} else {
						continue;
					}
				}
			}	
		}
		System.out.println(newCalculation);

	}

}