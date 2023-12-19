import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 찾으려는 문자열, 반지 개수
		String target = sc.next();
		int ringNum = sc.nextInt();

		// 타깃을 포함하는 반지 개수 카운팅
		int cnt = 0;

		while (ringNum-- > 0) {
			// 반지 정보 입력받기
			String ring = sc.next();

			// 타깃의 길이만큼 일치하는지 판단
			int re = target.length();

			// 반지가 타깃을 완전히 포함하는지 판단할 변수
			boolean check = false;

			for (int i = 0; i < ring.length(); i++) {
				// 반지를 탐색
				// target의 인덱스
				int idx = 0;

				if (target.charAt(idx) == ring.charAt(i)) {
					// 만약 일치하는 걸 만나면 일단 포함한다고 생각
					check = true;
					// 반지의 인덱스
					int j = i;
					while (re-- > 1) {
						// 길이만큼 반복
						if (target.charAt(++idx) != ring.charAt((++j) % ring.length())) {
							// 만약 불일치하면 다시 포함 안한다고 변경하고 멈추기
							check = false;
							break;
						}
					}
				}
				if (check) {
					// 만약 true로 통과했으면 카운팅하고 멈추기
					cnt++;
					break;
				}
			}

		}

		// 출력
		System.out.println(cnt);
	}
}