import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스만큼 실행
		for(int tc = 1; tc <= 10; tc++) {
			// 문자열 길이 입력받기
			int stringLength = sc.nextInt();
			
			// 계산식을 문자열로 입력받기
			String calculation = sc.next();

			// 후위연산자로 바꾸기 위해 임시로 저장할 스택 생성
			Stack<Character> store = new Stack<>();
			
			// 후위연산자로 바꿔서 저장해줄 문자열
			String newCalculation = "";
			
			// 계산식을 배열에 넣어주기
			char[] calculationArr = calculation.toCharArray();
			
			// 후위연산자로 바꿔보자.
			for(int idx = 0; idx < calculationArr.length; idx++) {
				
				
				if(calculationArr[idx] >= '0' && calculationArr[idx] <= '9') {
					// 0~9까지 숫자면 바로 새 문자열에 넣어준다.
					newCalculation += calculationArr[idx];
					
				} else if (calculationArr[idx] == '+') {
					// +이면
					if(store.isEmpty() || store.peek() == '(') {
						// 만약 스택이 비어있거나 ( 가 top에 있으면
						// 스택에 넣어주고
						store.push(calculationArr[idx]);
					} else if(store.peek() == '+'){
						// 스택의 top에 +가 있으면
						// 새 문자열에 더해준다.
						// 사실 스택에서 팝한 걸 새 문자열에 더해주고
						// 지금 인덱스껄 푸쉬해서 스택에 넣어줘야 하는데
						// 어차피 +는 여러개 쌓일 수가 없으므로,,,
						newCalculation += calculationArr[idx];
					} else if(store.peek() == '*') {
						// 스택의 top에 *가 있으면
						// 스택에 저장된 연산 스택이 (를 만나거나 빌 때까지 순서대로 pop해서
						// 새 문자열에 더해주고
						while(!store.isEmpty()) {
							char tmpSave = store.peek();
							if(tmpSave != '(') {
								newCalculation += store.pop();
							} else {
								break;
							}
							
						}
						
						// 마지막에 +를 push해서 스택에 넣어준다.
						store.push(calculationArr[idx]);
						
					}

				} else if(calculationArr[idx] == '*') {
					// *이면
					if(store.isEmpty() || store.peek() == '(') {
						// 스택이 비어있거나 top에 ( 가 있다면
						// push해서 넣어준다.
						store.push(calculationArr[idx]);
					} else if(store.peek() == '+') {
						// 스택의 top이 +이면
						// 위에 *를 push해서 쌓아준다.
						store.push(calculationArr[idx]);
					} else if(store.peek() == '*') {
						// 스택의 top이 *이면
						// *를 새 문자열에 그냥 더해준다.
						newCalculation += calculationArr[idx];

					}
					
				} else if(calculationArr[idx] == '(') {
					// ( 이면
					// 스택에 push
					store.push(calculationArr[idx]);
				} else if(calculationArr[idx] == ')') {
					// )이면
					char tmpSave = store.peek();
					while(!store.isEmpty()) {
						if(tmpSave != '(') {
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
				if(idx == calculationArr.length - 1) {
					while(!store.isEmpty()) {
						char tmpSave = store.pop();
						if(tmpSave != ')') {
							newCalculation += tmpSave;
						} else {
							continue;
						}
					}
				}
			}
			
			// 이제 계산해보자.
			// 새 문자열에 저장된 계산식을 배열에 넣어주기.
			char[] newCalculationArr = newCalculation.toCharArray();
			
			// 정수형을 저장해줄 스택 생성
			// 계산할 때는 정수만 스택에 담기므로,,,
			Stack<Integer> newStore = new Stack<>();
			
			// 계산할 값을 저장할 변수
			int result = 0;
			
			// 배열을 돌면서 실행
			for(int idx = 0; idx < newCalculationArr.length; idx++) {
				// 계산할 정수를 저장할 변수
				int tmpInt1 = 0;
				int tmpInt2 = 0;
				
				if(newCalculationArr[idx] == '+' || newCalculationArr[idx] == '*') {
					// 연산자가 나오면 스택 위에서 두개를 뽑아서 저장해주고
					// 그것에 맞는 연산을 해주면 된다.
					// 스택의 위에서 두 개를 뽑아서 저장해주고
					// (tmpInt들은 정수형이고 스택에 저장된 건 char형이므로
					// '0'을 빼줘서 값을 맞춰준다.)
					tmpInt1 = newStore.pop();
					tmpInt2 = newStore.pop();
					
					if(newCalculationArr[idx] == '+') {
						// 만약 연산자가 +라면
						// 그 두개를 더한 값을 저장해주면 된다.
						result = tmpInt1 + tmpInt2;
					} else {
						// 만약 연산자가 *라면
						// 그 두개를 곱한 값을 저장해주면 된다.
						result = tmpInt1 * tmpInt2;
					}
					
					// 스택에 push해준다.
					newStore.push(result);
					
				} else {
					// 숫자라면 스택에 넣어준다.
					// 시행하다보면 *한 수도 넣어주므로 두자리 이상의 수도 등장한다.
					// 그 수들도 모두 정수처럼 다뤄야 하므로,,
					newStore.push(newCalculationArr[idx] - '0');
					
				} 
				
			}
			// 형식에 맞게 출력
			System.out.printf("#%d %d\n", tc, result);
			
		}

		
	}
}