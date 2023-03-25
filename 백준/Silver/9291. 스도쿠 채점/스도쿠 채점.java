import java.util.Scanner;

public class Main {

	// 조건이 맞는지 확인하는 메소드를 생성한다.
	public static boolean check(int[][] arr) {

		// 가로 체크
		// 가로부터 돌아야 하니까 r 안에 c
		for (int r = 0; r < 9; r++) {
			// 카운팅 배열을 만든다.
			int[] cntArr = new int[10];
			for (int c = 0; c < 9; c++) {
				// 해당 숫자가 있으면 카운팅 배열을 늘려준다.
				cntArr[arr[r][c]]++;
			}
			// 하나라도 안 늘어있다면 false를 반환한다.
			for (int i = 1; i < 10; i++) {
				if (cntArr[i] != 1) {
					return false;
				}
			}
		}

		// 세로 체크
		// 세로로 도니까 열 고정
		for (int c = 0; c < 9; c++) {
			int[] cntArr = new int[10];

			for (int r = 0; r < 9; r++) {
				cntArr[arr[r][c]]++;
			}
			for (int i = 1; i < 10; i++) {
				if (cntArr[i] != 1) {
					return false;
				}
			}
		}

		// 네모 체크
		// 다음 인덱스로 가기 위한 변수 생성
		int nextR = 0;
		int nextC = 0;
		// 마지막 칸이 9이므로 6까지만 본다
		while (nextR != 6 && nextC != 6) {
			// 카운팅 배열 만들어주고
			int[] cntArr = new int[10];
			// 해당 인덱스부터 네모네모하게 확인
			for (int r = nextR; r < nextR + 3; r++) {
				for (int c = nextC; c < nextC + 3; c++) {
					// 숫자가 있으면 늘려준다.
					cntArr[arr[r][c]]++;
				}
			}
			// 숫자가 하나라도 없으면 false 반환
			for (int i = 1; i < 10; i++) {
				if (cntArr[i] != 1) {
					return false;
				}
			}
			// 다음 네모칸 확인을 위해 행렬을 3씩 늘려준다.
			// 원래는 9칸 다 확인해야 하지만
			// 스도쿠 특성상 1 5 9번째 네모만 확인해도 다 맞다.
			nextR += 3;
			nextC += 3;
		}
		// 조건이 모두 일치하면 트루 반환
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 번호를 입력 받는다.
		int testCase = sc.nextInt();
		// 테스트 케이스만큼 실행
		for (int tc = 1; tc <= testCase; tc++) {
			// 배열을 입력 받는다.
			int[][] arr = new int[9][9];

			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			// 답이라면 CORRECT
			String ans = "CORRECT";
			// check함수로 확인했을 때
			boolean flag = check(arr);
			// flag 반환값이 false라면 0을 출력한다.
			if (!flag) {
				ans = "INCORRECT";
			}
			// 출력한다.
			System.out.println("Case "+tc+": " + ans);
		}
	}
}