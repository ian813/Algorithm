import java.util.Scanner;

public class Main {
	// top을 나타낼 변수
	static int top = -1;
	// 명령의 개수를 나타낼 변수
	static int orderNum;
	// stack을 구현할 배열 생성
	static int[] stack;
	// 명령문을 받아줄 변수
	static String order;

	// push를 구현해보자.
	static void push(int n) {
		// 높이를 하나 올려주고
		top++;
		// 거기에 숫자 넣어주기
		stack[top] = n;
	}

	// pop을 구현해보자.
	static int pop() {
		
		if(empty() == 1) {
			// 비어있으면
			// -1 리턴
			return -1;
		} else {
			// 비어있지 않으면
			// 맨 위의 수를 리턴하고
			// 높이 하나 줄이기
			return stack[top--];
		}
	}

	static int size() {
		// 높이 + 1만큼이 들어있는 정수의 개수
		return top + 1;
	}

	static int empty() {
		if (top == -1) {
			// 높이가 -1이면
			// 비어있으므로 1 리턴
			return 1;
		} else {
			// 높이가 -1이 아니면
			// 비어있지 않으므로 0 리턴
			return 0;
		}
	}

	static int top() {
		if (empty() == 1) {
			// 스택이 비어있으면
			// -1 리턴
			return -1;
		} else {
			// 비어있지 않으면
			// top에 있는 수 리턴
			return stack[top];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 명령어 개수 입력받고
		orderNum = sc.nextInt();

		// orderNum 크기만큼 생성
		stack = new int[orderNum];
		
		for (int i = 0; i < orderNum; i++) {
			// 그 수만큼 명령어 입력받기
			order = sc.next();

			if (order.equals("push")) {
				// 명령어가 push이면
				// 넣어줄 정수 입력받고
				int num = sc.nextInt();

				// 넣어주기
				push(num);

			} else if (order.equals("pop")) {
				// 명령어가 pop이면
				// pop한 수 출력
				sb.append(pop()).append("\n");
			} else if (order.equals("size")) {
				// 명령어가 size면
				// size 출력
				sb.append(size()).append("\n");
			} else if (order.equals("empty")) {
				// 명령어가 empty면
				// empty인지 아닌지 출력
				sb.append(empty()).append("\n");
			} else {
				// 명령어가 top이면
				// top에 있는 수 출력
				sb.append(top()).append("\n");
			}

		}
		System.out.println(sb);

	}

}