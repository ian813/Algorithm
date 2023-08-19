import java.util.Scanner;

public class Main {

	static int[] queue;
	static int front, back;

	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sb = new StringBuilder();

		// 맨 앞과 맨 뒤를 가리킬 포인터
		front = 0;
		back = 0;

		// 큐를 구현할 배열 (명령어가 최대 10000개이므로 크기도 10000으로)
		queue = new int[10000];

		// 명령어 개수
		int N = sc.nextInt();

		// 명령어 개수만큼 반복
		for (int i = 0; i < N; i++) {
			// 명령어 입력받고
			String order = sc.next();

			// 명령어에 따라 실행
			if (order.equals("push")) {
				int x = sc.nextInt();
				push(x);
			} else if (order.equals("pop")) {
				pop();
			} else if (order.equals("size")) {
				size();
			} else if (order.equals("empty")) {
				empty();
			} else if (order.equals("front")) {
				front();
			} else if (order.equals("back")) {
				back();
			}
		}
		System.out.println(sb);
	}

	// queue에 순서대로 집어넣기
	static void push(int x) {
		queue[back++] = x;
	}

	// front에 있는 수 출력하고 front값 늘리기
	static void pop() {
		if (front < back) {
			// front가 back보다 작아야 출력할 값이 있다.
			sb.append(queue[front++]).append("\n");
		} else {
			sb.append(-1).append("\n");
		}
	}

	// back이 가리키는 곳 직전까지 정수가 들어있고
	// front가 가리키는 곳부터 정수가 들어있으므로
	// 두 값을 뺴주면 된다.
	static void size() {
		if (front < back) {
			// front가 back보다 작아야 출력할 size가 있다.
			sb.append(back - front).append("\n");
		} else {
			sb.append(0).append("\n");
		}
	}

	static void empty() {
		if (front == back) {
			// front와 back이 같아야 비어있다.
			sb.append(1).append("\n");
		} else {
			sb.append(0).append("\n");
		}
	}

	static void front() {
		if (front < back) {
			// front가 back보다 작아야 들어있는 정수가 있다.
			sb.append(queue[front]).append("\n");
		} else {
			sb.append(-1).append("\n");
		}
	}

	static void back() {
		if (front < back) {
			// back은 새로 push할 수 있는 위치를 가리키므로
			// back - 1한 곳이 마지막 위치이다.
			sb.append(queue[back - 1]).append("\n");
		} else {
			sb.append(-1).append("\n");
		}
	}
}