import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int N, M, ans; // 큐의 크기, 뽑으려는 수의 개수, 결과값
	static int[] select; // 뽑으려는 수의 위치
	static LinkedList<Integer> deque;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		deque = new LinkedList<>();
		
		// 덱에 1~N까지 수를 넣어준다.
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		select = new int[M];

		for (int idx = 0; idx < M; idx++) {
			select[idx] = sc.nextInt();
		}

		ans = 0;

		sc.close();
	}

	static void solve() {

		int tmpIdx = 0;
		while (tmpIdx < M) {
			int targetIdx = deque.indexOf(select[tmpIdx]); // select에 저장된 값이 있는 인덱스를 반환

			int compareIdx; // 비교해줄 인덱스

			if (deque.size() % 2 == 0) { // 덱의 사이즈가 짝수일 때 중간 위치
				compareIdx = deque.size() / 2 - 1;
			} else { // 덱의 사이즈가 홀수일 때 덱의 위치
				compareIdx = deque.size() / 2;
			}
			if (targetIdx <= compareIdx) { // 타깃위치가 비교위치보다 작거나 같으면 왼쪽으로 이동시킨다.
				for (int i = 0; i < targetIdx; i++) {
					int tmp = deque.pollFirst();
					deque.addLast(tmp);
					// 카운팅
					ans++;
				}
			} else { // 타깃위치가 비교위치보다 크면 오른쪽으로 이동시킨다.
				for (int i = deque.size() - 1; i >= targetIdx; i--) {
					int tmp = deque.pollLast();
					deque.addFirst(tmp);
					// 카운팅
					ans++;
				}
			}
			// 연산이 완료됐으면 제일 앞에 타깃값이 있으므로 뽑아준다.
			deque.pollFirst();
			// 다음 저장된 값을 찾아준다.
			tmpIdx++;
		}
	}

	public static void main(String[] args) {
		input();
		solve();
		System.out.println(ans);
	}
}