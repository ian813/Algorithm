import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		// 큐에 1부터 N까지 차례대로 넣기
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		// 제일 위에 카드를 버릴지, 제일 위에 카드를 제일 아래로 옮길지 결정할 불리안
		boolean flag = true;

		// 큐에 한 개남을 때까지 반복
		while (queue.size() > 1) {

			if (flag) {
				// 제일 위에 카드 버리고 flag = false
				queue.poll();
				flag = false;
			} else {
				// 제일 위에 카드 제일 밑으로 옮기고 flag = true
				int cur = queue.poll();
				queue.add(cur);
				flag = true;
			}
		}

		// 출력
		System.out.println(queue.peek());
	}
}