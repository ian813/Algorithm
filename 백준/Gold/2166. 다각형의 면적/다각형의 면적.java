import java.util.Scanner;

/**
 * 신발끈 공식 사용해서 구해보자.
 */

public class Main {

	static int N;

	static Point[] figure;

	static class Point {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// 포인트 정보를 담을 배열
		figure = new Point[N + 1];

		for (int i = 0; i < N; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();

			figure[i] = new Point(x, y);
		}

		// 신발끈 공식 이용해야되니까
		// 첫번째 포인트를 마지막에도 저장해준다.
		figure[N] = figure[0];

		long sum1 = 0;
		long sum2 = 0;

		// 신발끈 공식
		for (int i = 0; i < N; i++) {
			sum1 += figure[i].x * figure[i + 1].y;
			sum2 += figure[i].y * figure[i + 1].x;
		}

		long tmp = Math.abs(sum1 - sum2);

		// 공식을 이용한 최종 넓이
		double area = tmp / 2.0;

		// 소수점 첫째자리까지 출력
		System.out.printf("%.1f", area);
	}
}