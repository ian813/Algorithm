import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열 입력받아서 char 배열로 쪼개기
		String str = sc.next();

		char[] strArr = str.toCharArray();

		int cnt = 0;

		int ans = 0;

		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] == 'X' && i != strArr.length - 1) {
				// X인데 인덱스가 끝이 아니면 카운팅
				cnt++;
			} else if (strArr[i] == 'X') {
				// X인데 인덱스가 끝이면 카운팅하고
				cnt++;
				if (cnt == 4) {
					// 4면 A로 덮기
					for (int j = i - 3; j <= i; j++) {
						strArr[j] = 'A';
					}
				} else if (cnt == 2) {
					// 2면 B로 덮기
					for (int j = i - 1; j <= i; j++) {
						strArr[j] = 'B';
					}
				} else {
					// 아니면 ans = -1
					ans = -1;
				}
			} else {
				// .이면
				if (cnt == 2) {
					// 2일 때 그 전까지 B로 덮기
					for (int j = i - 2; j <= i - 1; j++) {
						strArr[j] = 'B';
					}
					cnt = 0;
				} else if (cnt == 0) {
					// 0이면 그 전이 .이라는 뜻이므로 넘기기
					continue;
				} else {
					// 그게 아니면 불가능하므로 ans = -1로 바꾸고 멈추기
					ans = -1;
					break;
				}
			}

			if (cnt == 4) {
				// cnt가 4면 A로 덮고 cnt 초기화
				for (int j = i - 3; j <= i; j++) {
					strArr[j] = 'A';
				}
				cnt = 0;
			}
		}

		StringBuilder sb = new StringBuilder();

		if (ans != -1) {
			// ans가 -1이 아니면 뽑아서 출력
			for (int i = 0; i < strArr.length; i++) {
				sb.append(strArr[i]);
			}
			System.out.println(sb);
		} else {
			// ans = -1이면 ans 출력
			System.out.println(ans);
		}
	}
}