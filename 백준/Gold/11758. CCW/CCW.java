import java.util.Scanner;

public class Main {

	static Point p1, p2, p3;
	static final int counterClockwise = 1;
	static final int clockWise = -1;
	static final int inLine = 0;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		p1 = new Point(sc.nextInt(), sc.nextInt());
		p2 = new Point(sc.nextInt(), sc.nextInt());
		p3 = new Point(sc.nextInt(), sc.nextInt());

		// 반시계방향인지 판단 -> 첫 두 점을 지나는 직선 위쪽 영역에 세번째 점이 위치해야한다.
		// 시계방향인지 판단 -> 첫 두 점을 지나는 직선 아래쪽 영역에 세번째 점이 위치해야한다.
		// 일직선인지 판단 -> 첫 두 점을 지나는 직선에 세번째 점이 위치해야한다.
		// 첫 두 점을 이용해 직선의 방정식을 만든 뒤 세번째 점을 대입해서 판단해보자.
		int judge = (p2.y - p1.y) * (p3.x - p1.x) - (p2.x - p1.x) * (p3.y - p1.y);

		// 답을 저장할 변수
		int ans = 0;

		// 판단 값이 0보다 작으면 반시계
		// 0보다 크면 시계
		// 0과 같으면 일직선
		if (judge < 0)
			ans = counterClockwise;
		else if (judge > 0)
			ans = clockWise;
		else
			ans = inLine;

		System.out.println(ans);
	}
}
