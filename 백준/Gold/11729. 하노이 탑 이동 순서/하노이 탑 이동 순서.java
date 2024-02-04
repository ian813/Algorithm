import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 원판 개수
		int num = sc.nextInt();

		// 이동 횟수 -> An = 2*An-1 + 1의 관계 만족
		int moveCnt = (int)Math.pow(2, num) - 1;

		sb.append(moveCnt).append("\n");

		// num개를 1에서 2를 거쳐 3으로 이동
		move(num, 1, 2, 3);

		// 출력
		System.out.println(sb);
	}

	// num : 원반 개수, start : 시작점, mid : 중간점, end : 도착점
	private static void move(int num, int start, int mid, int end) {
		if (num == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}

		// N-1개를 start에서 end를 거쳐서 mid로 이동
		move(num - 1, start, end, mid);

		// 남은 1개를 start에서 end로 이동
		sb.append(start).append(" ").append(end).append("\n");

		// N-1개를 mid에서 start를 거쳐서 end로 이동
		move(num - 1, mid, start, end);
	}
}