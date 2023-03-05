import java.util.Scanner;

public class Main {
	// 출력해줄 코드 문자를 상수로 선언
	static final String rectangular = "a";
	static final String line = "b";
	static final String point = "c";
	static final String none = "d";
	
	static int x1;
	static int y1;
	static int p1;
	static int q1;
	
	static int x2;
	static int y2;
	static int p2;
	static int q2;
	
	static Scanner sc = new Scanner(System.in);
	
	// 인풋 메서드
	static void input() {
		// 첫 직사각형의 시작과 끝점
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		p1 = sc.nextInt();
		q1 = sc.nextInt();
		
		// 두번째 직사각형의 시작과 끝점
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		p2 = sc.nextInt();
		q2 = sc.nextInt();
		
	}
	
	// 문제를 풀어보자.
	static void solve() {
			input();
			
			if((p1 == x2 && q1 == y2) || (x1 == p2 && y1 == q2)
					|| (p1 == x2 && y1 == q2) || (x1 == p2 && q1 == y2)) {
				// 점에서 만나는 경우
				// 점 출력
				System.out.println(point);
			} else if ((p1 == x2 && q1 > y2 && y2 >= y1) || (y2 == q1 && x2 >= x1 && x2 < p1)
					|| (x2 == p1 && q2 <= q1 && q2 > y1) || (q2 == y1 && x2 < p1 && x2 >= x1)
					|| (q2 == y1 && p2 <= p1 && p2 > x1) || (p2 == x1 && q2 <= q1 && q2 > y1)
					|| (p2 == x1 && y2 < q1 && y2 >= y1) || (y2 == q1 && p2 <= p1 && p2 > x1)
					|| (y2 == q1 && x2 < x1 && p2 > p1) || (x2 == p1 && y2 < y1 && q2 > q1)
					|| (q2 == y1 && x2 < x1 && p2 > p1) || (p2 == x1 && y2 < y1 && q2 > q1)) {
				// 선분에서 만나는 경우
				// 선분 출력
				System.out.println(line);
			} else if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
				// 안 만나는 경우
				// none 출력
				System.out.println(none);
			} else {
				// 그 외의 경우는 직사각형에서 만나므로
				// 직사각형 출력
				System.out.println(rectangular);
			}
	
	}
	
	public static void main(String[] args) {
		for(int re = 0; re < 4; re++) {
			// 입력이 4번 주어지므로 4번 반복
			solve();
		}

	}
}
