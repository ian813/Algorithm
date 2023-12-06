import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		// 반복할 횟수
		int re = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while (re-- > 0) {
			// 현재 값 입력받기
			int cur = sc.nextInt();

			if (cur == 0) {
				// 입력받은 값이 0이면
				if (!queue.isEmpty()) {
					// 큐에 값이 존재하면 가장 작은 값을 저장하고 없애기
					sb.append(queue.poll()).append("\n");
					continue;
				}

				// 큐에 값이 없으면 0 저장하기
				sb.append(0).append("\n");
				continue;
			}

			// 입력받은 값이 0이 아니면 큐에 저장
			queue.add(cur);
		}

		System.out.println(sb);
	}
}