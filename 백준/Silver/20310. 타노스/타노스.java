import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열
		String S = sc.next();

		// 문자열 길이, 0의 개수
		int length = S.length();
		int zeroCnt = 0;

		for (int i = 0; i < length; i++) {
			if (S.charAt(i) == '0') {
				// 0의 개수 카운팅
				zeroCnt++;
			}
		}

		// 1의 개수
		int oneCnt = length - zeroCnt;

		// 지울 0, 1의 개수
		int zeroTarget = zeroCnt / 2;
		int oneTarget = oneCnt / 2;

		// 새로운 문자열
		String ans = "";

		// 사전 순으로 절반을 남긴다. -> 새로운 문자열에 절반만 추가한다.
		// 0을 만나면 새로운 문자열에 즉시 0 추가, 1을 만났을 땐 절반을 넘긴 다음 1을 추가
		for (int i = 0; i < length; i++) {
			if (S.charAt(i) == '0' && zeroTarget > 0) {
				// 0을 만났는데 아직 추가할 수 있으면 카운팅하고 추가
				zeroTarget--;
				ans += "0";
				continue;
			}

			if (S.charAt(i) == '1' && oneTarget > 0) {
				// 1을 만났는데 아직 추가할 수 없다면 카운팅하고 넘기기
				oneTarget--;
				continue;
			}

			if (S.charAt(i) == '1') {
				// 1을 만났는 데 추가할 수 있으면 추가
				ans += "1";
			}
		}

		// 출력
		System.out.println(ans);
	}
}