import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문서 정보 받아서 char 형태로 바꾸기
		char[] document = sc.nextLine().toCharArray();

		// 검색하려는 단어 정보 받아서 char 형태로 바꾸기
		char[] searchWord = sc.nextLine().toCharArray();

		// 단어가 등장하는지 체크할 불리안
		boolean check = false;

		// 개수 카운팅
		int cnt = 0;

		for (int i = 0; i <= document.length - searchWord.length; i = (check) ? i + searchWord.length : i + 1) {
			// 문서길이 - 단어길이만큼 체크
			// i의 증가량은 단어를 찾았는지에 따라 다르게 적용
			// 단어를 찾았으면 단어 길이만큼 더해주고 아니면 +1만 해서 다시 탐색

			// 단어의 인덱스
			int idx = 0;

			// 불리안은 계속 false로 초기화
			check = false;

			if (document[i] == searchWord[idx]) {
				// 첫 문자가 일치했으면
				// 일단 check해주고
				check = true;

				for (int j = i + 1; j < i + searchWord.length; j++) {
					// 그 다음부터 계속 탐색
					if (document[j] != searchWord[++idx]) {
						// 만약 불일치하면 다시 check 해제하고 멈추기
						check = false;
						break;
					}
				}

				if (check) {
					// 만약 체크되어있으면 단어가 등장했으므로 카운팅
					cnt++;
				}
			}
		}

		// 출력
		System.out.println(cnt);
	}
}