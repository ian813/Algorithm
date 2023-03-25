import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] board;
	static boolean[] visit;
	static int ans;
	static StringBuilder sb = new StringBuilder();

	// 인풋메서드
	static void input() {
		n = sc.nextInt();
		// 보드의 크기
		// 인덱스 맞춰주기 위해 n+1
		board = new int[n + 1];
		// 방문 체크
		visit = new boolean[n + 1];
		// 답은 0으로 설정
		ans = 0;
	}

	// 들어가는게 가능한지 체크할 메서드
	static boolean isPossible(int y, int x) {
		if (x == 1) { // 체스판에 첫번째로 말을 두는 상황
			return true;
		}
		if (visit[y]) {// 같은 행에 들어가는지 판단
			return false;
		}
		// 내가 이번 자리에 말을 놓았다고 가정하고 첫번째 칸에 있는 말부터 대각선인지 비교해준다.
		for (int i = 1; i < x; i++) {
			if (Math.abs(x - i) == Math.abs(y - board[i])) {
				return false;
			}
		}

		return true;
	}

	static void check(int cnt) {
		if (cnt == n + 1) { // 5 == 4 + 1
			ans++; // 답 + 1
			return; // 반환
		}

		for (int i = 1; i <= n; i++) {
			if (!isPossible(i, cnt)) {
				// 퀸이 들어갈 수 있는지 판단
				continue;
			}
			board[cnt] = i; // 보드에 순서대로 퀸을 넣어준다.
			visit[i] = true; // 방문 체크
			check(cnt + 1); // 1부터 시작해서 2 -> 3 -> 4 -> 5
			visit[i] = false; // 방문 해제
		}
	}

	public static void main(String[] args) {
		input();
		check(1);
		// 스트링빌더에 형식에 맞게 담아주기
		sb.append(ans);
		System.out.println(sb);
	}
}