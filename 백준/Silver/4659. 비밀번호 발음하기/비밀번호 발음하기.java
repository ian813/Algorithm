import java.util.Scanner;

public class Main {

	static char[] gather = {'a', 'e', 'i', 'o', 'u'};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		while (true) {
			// 비밀번호 입력받기
			String password = sc.next();

			// 입력받은 비밀번호가 end면 멈추기
			if (password.equals("end"))
				break;

			// 입력받은 비밀번호 char형태로 쪼개기
			char[] arr = password.toCharArray();

			// 조건 하나씩 체크해줄 불리안
			boolean check1 = false;
			boolean check2 = true;
			boolean check3 = true;

			for (int i = 0; i < arr.length; i++) {
				// check1이 true로 바뀌면 계속 true로 업뎃, 그게 아니면 계속 모음이 하나라도 나오는지 판단
				boolean flag = (check1) ? true : isCondition1(arr[i]);

				check1 = flag;
			}

			for (int i = 0; i < arr.length - 2; i++) {
				// check2가 false로 바뀌면 계속 false로 업뎃, 그게 아니면 3개 연속된 자음 또는 모음이 나오는지 계속 판단
				boolean flag = (check2) ? isCondition2(arr[i], arr[i + 1], arr[i + 2]) : false;

				check2 = flag;
			}

			for (int i = 0; i < arr.length - 1; i++) {
				// check3이 false로 바뀌면 계속 false로 업뎃, 그게 아니면 2개 연속 같은 글자가 나오는지 계속 판단
				boolean flag = (check3) ? isCondition3(arr[i], arr[i + 1]) : false;

				check3 = flag;
			}

			if (check1 && check2 && check3) {
				// 세 조건 모두 만족하면 acceptable
				sb.append("<" + password + ">" + " is acceptable.").append("\n");
			} else {
				// 그게 아니면 not acceptable
				sb.append("<" + password + ">" + " is not acceptable.").append("\n");
			}
		}
		System.out.println(sb);
	}

	// 모음이 나오는지 판단할 메서드 (조건1)
	private static boolean isCondition1(char cur) {
		for (int i = 0; i < 5; i++) {
			// 모음 발견하면 true 리턴
			if (gather[i] == cur) {
				return true;
			}
		}
		// 모음 없었으면 false 리턴
		return false;
	}

	// 3개 연속된 자음 또는 모음이 나오는지 판단할 메서드 (조건2)
	private static boolean isCondition2(char prev, char cur, char next) {
		// 각각이 자음 또는 모음인지 판단
		boolean check1 = false;
		boolean check2 = false;
		boolean check3 = false;

		for (int i = 0; i < 5; i++) {
			if (gather[i] == prev) {
				check1 = true;
			}
			if (gather[i] == cur) {
				check2 = true;
			}
			if (gather[i] == next) {
				check3 = true;
			}
		}

		// 셋 다 모음이면 false 리턴
		if (check1 && check2 && check3) {
			return false;
		}
		// 셋 다 자음이면 false 리턴
		if (!check1 && !check2 && !check3) {
			return false;
		}
		// 아니면 true 리턴
		return true;
	}

	private static boolean isCondition3(char cur, char next) {
		// 연속된 글자 나오는데 ee나 oo 아니면 false 리턴
		if (cur == next && cur != 'e' && cur != 'o')
			return false;

		// 아니면 true 리턴
		return true;
	}
}