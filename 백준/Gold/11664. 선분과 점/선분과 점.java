import java.util.Scanner;

public class Main {

	// 포인트 3개 생성 (A, B는 선분의 양 끝점)
	static Point A, B, C;

	private static class Point {
		double x, y, z;

		private Point(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 포인트 정보 입력받기
		A = new Point(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		B = new Point(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		C = new Point(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

		sc.close();

		// 두 점이 같은 지 확인할 불리안
		boolean isEqual = false;

		// 혹시 소수점 때문에 무한루프 빠질 수 있으니 cnt로 체크
		int cnt = 0;

		while (!isEqual) {

			// 십만번 돌면 그냥 멈춰주자.
			if (++cnt == 100000)
				break;

			// 두 점이 같아지면 isEqual true로 바꾸고 넘기기
			if (A.x == B.x && A.y == B.y && A.z == B.z) {
				isEqual = true;
				continue;
			}

			// 선분의 중앙점 찾기
			Point mid = new Point((A.x + B.x) / 2, (A.y + B.y) / 2, (A.z + B.z) / 2);

			if (dist(A, C) < dist(B, C)) {
				// A,C의 거리보다 B,C의 거리가 더 길면
				// B를 중앙점으로 업뎃
				B = mid;
			} else {
				// 만약 A,C의 거리가 B,C 거리보다 길면
				// A를 중앙점으로 업뎃
				A = mid;
			}
		}

		// 답 구하기 (A, C의 거리를 구하되 소수점 열번째 자리까지 구해야 하므로 10^10을 곱해주고 나눠준다)
		double ans = Math.round(dist(A, C) * 10000000000.0) / 10000000000.0;

		// 답 출력
		System.out.println(ans);
	}

	// 거리 구하는 메서드
	static double dist(Point a, Point b) {

		double distance = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));

		return distance;
	}
}