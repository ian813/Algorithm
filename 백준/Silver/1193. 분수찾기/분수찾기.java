import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		// 몇 번쨰 대각선인지 파악할 변수
		int count = 0;
		// 대각선의 크기 (1번째 대각선은 1, 2번째 대각선은 2 ... n번째 대각선은 n개의 요소를 갖는다.
		int i = 1;
		// 분모
		int denominator = 0;
		// 분자
		int numerator = 0;

		while (count < X) {
			// 몇 번째 대각선인지 파악
			// count가 X이상이 되는 순간 X가 i-1번째 대각선에 있음을 알 수 있다.
			count += i;
			i++;
		}

		// 해당 대각선에 속한 수들은 분모와 분자 중 최댓값이 i-1이고 최솟값은 1이다.
		// 짝수이면 분모가 1부터 증가하고, 홀수이면 분자가 최댓값인 i=1부터 감소한다.
		// 증감값은 count - X만큼이다.
		// 홀수일 때는 반대로 구하면 된다.
		if ((i - 1) % 2 == 0) {
			denominator = 1 + (count - X);
			numerator = (i - 1) - (count - X);
		} else {
			denominator = (i - 1) - (count - X);
			numerator = 1 + (count - X);
		}

		// 출력
		System.out.println(numerator + "/" + denominator);

	}
}