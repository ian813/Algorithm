import java.util.Scanner;

public class Main {

	static int N;
	static char[][] map;

	static int headR, headC, heartR, heartC, waistR, waistC;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new char[N + 1][N + 1];

		boolean isHead = false;

		// 값 입력받기
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j - 1);

				if (!isHead && map[i][j] == '*') {
					// 처음 등장한 *을 머리로 설정
					headR = i;
					headC = j;
					isHead = true;
				}
			}
		}

		// 심장 위치 구하기
		heartR = headR + 1;
		heartC = headC;

		StringBuilder sb = new StringBuilder();

		// 심장 위치 담기
		sb.append(heartR + " " + heartC).append("\n");

		// 다른 신체 길이 찾기
		int leftArm = findLeftArm(heartR, heartC);
		int rightArm = findRightArm(heartR, heartC);
		int waist = findWaist(heartR, heartC);
		int leftLeg = findLeftLeg(waistR + 1, waistC - 1);
		int rightLeg = findRightLeg(waistR + 1, waistC + 1);

		// 신체 길이 담아서 출력
		sb.append(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);

		System.out.println(sb);
	}

	// 왼쪽 팔 길이 찾기
	private static int findLeftArm(int R, int C) {

		int length = 0;

		while (C > 0) {
			C--;
			if (map[R][C] != '*') {
				break;
			}
			length++;
		}

		return length;
	}

	// 오른쪽 팔 길이 찾기
	private static int findRightArm(int R, int C) {
		int length = 0;

		while (C < N) {
			C++;
			if (map[R][C] != '*') {
				break;
			}
			length++;
		}

		return length;
	}

	// 허리 길이 찾기
	private static int findWaist(int R, int C) {

		int length = 0;

		while (R < N) {
			R++;
			if (map[R][C] != '*') {
				break;
			}
			length++;
		}

		waistR = heartR + length;
		waistC = heartC;

		return length;
	}

	// 왼쪽 다리 길이 찾기
	private static int findLeftLeg(int R, int C) {

		int length = 1;

		while (R < N) {
			R++;
			if (map[R][C] != '*') {
				break;
			}
			length++;
		}

		return length;
	}

	// 오른쪽 다리 길이 찾기
	private static int findRightLeg(int R, int C) {

		int length = 1;

		while (R < N) {
			R++;
			if (map[R][C] != '*') {
				break;
			}
			length++;
		}

		return length;
	}

}