import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 빗변, 윗변, 아랫변
		int hypotenuse = sc.nextInt();
		int upperSide = sc.nextInt();
		int lowerSide = sc.nextInt();

		// 윗변 - 아랫변 >= 0 인 조건이므로 가능
		double side = (upperSide - lowerSide) / 2.0;

		// 피타고라스 이용해서 높이 구해주기
		double height = Math.round((Math.pow(hypotenuse, 2) - Math.pow(side, 2)) * Math.pow(10, 6)) / 1000000.0;

		// 출력
		System.out.println(height);
	}
}