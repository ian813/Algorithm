import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테케 개수
		int testCase = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (testCase-- > 0) {
			// 테케만큼 반복

			// 카드 개수
			int card = sc.nextInt();

			// 덱 이용
			Deque<Character> deque = new ArrayDeque<>();

			while (card-- > 0) {
				// 카드 개수만큼 반복

				// 현재 카드의 알파벳 입력받기
				char cur = sc.next().charAt(0);

				if (deque.isEmpty()) {
					// 덱이 비어있으면 현재 카드 그냥 넣어주고 넘기기
					deque.add(cur);
					continue;
				}

				if (deque.peekFirst() < cur) {
					// 현재 카드가 가져온 카드의 맨 앞 카드보다 큰 카드면
					// 맨 뒤에 넣어주기
					deque.addLast(cur);
				} else {
					// 현재 카드가 가져온 카드의 맨 앞 카드 이하면
					// 맨 앞에 넣어주기
					deque.addFirst(cur);
				}
			}

			while (!deque.isEmpty()) {
				// 덱이 빌 때까지 뽑아주면서 저장
				sb.append(deque.pollFirst());
			}
			// 개행
			sb.append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}