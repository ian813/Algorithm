import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String type = sc.next();

		// 게임할 수 있는 숫자
		int gameNum = 1;

		// 게임 타입 때 F이면 게임할 수 있는 숫자 초기화
		if (type.equals("F")) {
			gameNum = 2;
		}

		// 게임 타입 때 O이면 게임할 수 있는 숫자 초기화
		if (type.equals("O")) {
			gameNum = 3;
		}

		// 중복 허용 안하도록 set으로 정보 받기
		HashSet<String> name = new HashSet<>();

		for (int i = 0; i < N; i++) {
			name.add(sc.next());
		}

		// 몫 구해주면 끝
		int ans = name.size() / gameNum;

		System.out.println(ans);
	}
}