import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 현재 위치
		int curX = sc.nextInt();
		int curY = sc.nextInt();

		// 직사각형 너비, 높이
		int width = sc.nextInt();
		int height = sc.nextInt();

		// 탈출 최솟값
		int exit = Math.min(Math.min(Math.min(curX, curY), width - curX), height - curY);

		// 출력
		System.out.println(exit);
	}
}