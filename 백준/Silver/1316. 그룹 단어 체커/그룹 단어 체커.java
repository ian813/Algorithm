import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받을 단어 개수
		int n = sc.nextInt();

		// 그룹단어인지 카운팅
		int ans = 0;

		for (int i = 0; i < n; i++) {
			// 단어 입력받기
			String str = sc.next();
			// 나온 알파벳인지 체크
			boolean[] check = new boolean[26];
			// 그룹단어인지 체크
			boolean isGroupWord = true;

			for (int j = 0; j < str.length(); j++) {
				int cur = str.charAt(j) - 'a';

				if (!check[cur]) { // 체크된 알파벳이 아니면
					// 체크하고 넘기기
					check[cur] = true;
					continue;
				}
				if (check[cur]) { // 체크된 단어면
					// 그 전 알파벳 확인해서
					int before = str.charAt(j - 1) - 'a';
					if (cur == before) { // 전과 같으면 넘기기
						continue;
					}
					// 전과 다르면 그룹단어 아닌 거로 체크하고 멈추기
					isGroupWord = false;
					break;
				}
			}
			// 그룹단어면 카운팅
			if (isGroupWord)
				ans++;
		}
		// 출력
		System.out.println(ans);
	}
}