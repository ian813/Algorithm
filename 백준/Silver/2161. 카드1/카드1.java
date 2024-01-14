import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 카드 숫자 입력받기
		int card = sc.nextInt();

		// 큐 생성
		Queue<Integer> queue = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();

		// 큐에 차례대로 숫자 넣어주기
		for (int i = 1; i <= card; i++) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			// 큐가 빌 때까지 실행
			// 처음 카드는 뽑아서 버리고
			sb.append(queue.poll()).append(" ");

			if (!queue.isEmpty()) {
				// 아직 카드가 남아있으면 또 뽑아서 맨 뒤에 넣어주기
				int next = queue.poll();
				queue.add(next);
			}
		}

		System.out.println(sb);
	}
}