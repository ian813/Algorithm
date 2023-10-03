import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 타깃 채널
		int target = sc.nextInt();
		// 고장난 버튼 수
		int brokenNum = sc.nextInt();

		boolean[] broken = new boolean[10];

		// 고장난 버튼 입력받기
		for (int i = 0; i < brokenNum; i++) {
			int idx = sc.nextInt();
			broken[idx] = true;
		}

		// 초기 위치인 100에서 + -만 눌러서 노가다로 이동할 수 있는 횟수를 초기값으로 설정
		int result = Math.abs(target - 100);
		// 0부터 999999번까지 모두 탐색
		// 9빼고 전부 고장나면 999999에서 출발해야될 수도 있음
		for (int i = 0; i <= 999999; i++) {
			// 버튼을 눌러서 한 번에 이동할 채널 : i
			String cur = String.valueOf(i);
			int len = cur.length();

			// 고장난 버튼을 누르는지 체크
			boolean check = false;

			for (int j = 0; j < len; j++) {
				if (broken[cur.charAt(j) - '0']) {
					// i로 갈 때 누르는 버튼이 고장났는지 체크
					// 고장났으면 check = true로 바꾸고 멈추기
					check = true;
					break;
				}
			}

			if (!check) {
				// 무사히 이동 성공했으면 i로 이동할 때 누른 버튼 수 카운팅
				int cnt = len;
				cnt += Math.abs(target - i); // i에서 target까지 이동하는 횟수
				result = Math.min(result, cnt); // 최솟값 업데이트
			}
		}
		// 결과 출력
		System.out.println(result);
	}
}