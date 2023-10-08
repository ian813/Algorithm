import java.util.Scanner;

public class Main {
	static int first, last;
	static int[] deque;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 명령 개수
		int N = sc.nextInt();

		// 처음과 끝을 가리키는 변수
		first = 10000;
		last = 10000;

		// 덱을 구현할 배열, 명령이 최대 10000개이고 앞 뒤로 출력 가능하므로 크기는 20001로
		deque = new int[20001];

		for (int i = 0; i < N; i++) {
			String order = sc.next();
			// 명령어 종류에 따라 실행
			switch (order) {
				case ("push_front"):
					push_front(sc.nextInt());
					break;
				case ("push_back"):
					push_back(sc.nextInt());
					break;
				case ("pop_front"):
					sb.append(pop_front()).append("\n");
					break;
				case ("pop_back"):
					sb.append(pop_back()).append("\n");
					break;
				case ("size"):
					sb.append(size()).append("\n");
					break;
				case ("empty"):
					sb.append(empty()).append("\n");
					break;
				case ("front"):
					sb.append(front()).append("\n");
					break;
				case ("back"):
					sb.append(back()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}

	// first 위치 감소시키고 first 위치에 값 넣기
	static void push_front(int x) {
		deque[--first] = x;
	}

	// last 위치에 값 넣고 last 위치 증가
	static void push_back(int x) {
		deque[last++] = x;
	}

	static int pop_front() {
		if (first < last) {
			// last가 더 커야 deque에 출력할 수가 존재
			return deque[first++];
		} else {
			return -1;
		}
	}

	static int pop_back() {
		if (first < last) {
			// last가 더 커야 deque에서 출력할 수가 존재
			return deque[--last];
		} else {
			return -1;
		}
	}

	static int size() {
		return last - first;
	}

	static int empty() {
		if (last == first) {
			// last와 first가 같으면 비어있다.
			return 1;
		} else {
			return 0;
		}
	}

	static int front() {
		if (first < last) {
			// first보다 last가 커야 출력할 수가 존재
			return deque[first];
		} else {
			return -1;
		}
	}

	static int back() {
		if (first < last) {
			// first보다 last가 커야 출력할 수가 존재
			return deque[last - 1];
		} else {
			return -1;
		}
	}
}