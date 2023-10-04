import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		// 연도 : 1부터 시작
		int year = 1;

		while (true) {
			// 연도를 15로 나눴을 때 나머지(15일 땐 15로)가 E랑 같고
			// 연도를 28로 나눴을 때 나머지(28일땐 28로)가 S랑 같고
			// 연도를 19로 나눴을 때 나머지(19일땐 19로)가 M랑 같으면
			// 연도를 찾은 거임
			if (((year % 15) == 0 ? 15 : (year % 15)) == E &&
				((year % 28) == 0 ? 28 : (year % 28)) == S &&
				((year % 19) == 0 ? 19 : (year % 19)) == M)
				break;
			// 연도 못찾았으면 하나 늘려서 실행
			year++;
		}
		// 연도 출력
		System.out.println(year);
	}
}