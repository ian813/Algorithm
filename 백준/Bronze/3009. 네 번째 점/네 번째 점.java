import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 점 세개 순서대로 입력받기
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();

		// x좌표, y좌표는 각각 두 번씩 등장해야함.

		// x4를 x1으로 설정해놓고 x2나 x3랑 같은지 판단해서
		// 만약 x2랑 같으면 이미 x1, x2가 같으므로 x4는 x3과 같아야 함
		// x3랑 같은 경우도 같은 이유로 x4는 x2여야 하고
		// 둘 다랑 같지 않으면 그대로 x4는 x1과 같아야 함.
		// y4도 같은 방식으로 찾아주기
		int x4 = x1;

		if (x4 == x2) {
			x4 = x3;
		} else if (x4 == x3) {
			x4 = x2;
		}

		int y4 = y1;

		if (y4 == y2) {
			y4 = y3;
		} else if (y4 == y3) {
			y4 = y2;
		}

		// 출력
		System.out.println(x4 + " " + y4);
	}
}