import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열 입력받아서
		String alphabet = sc.next();

		// 배열에 넣기
		char[] alphabetArr = alphabet.toCharArray();
		
		// 알파벳 개수 세줄 변수 (총 문자열 길이에서 크로아티아알파벳 나올 때 빼주기)
		int cnt = alphabetArr.length;

		for (int idx = 0; idx < alphabetArr.length; idx++) {
			if (idx + 2 < alphabetArr.length && alphabetArr[idx] == 'd' && alphabetArr[idx + 1] == 'z'
					&& alphabetArr[idx + 2] == '=') {
				// 밑에 z= 확인할 때 중복으로 확인되므로, 1만 빼줘도 된다.
				cnt--;
			} else if (idx + 1 < alphabetArr.length && alphabetArr[idx] == 'c' && alphabetArr[idx + 1] == '=') {
				cnt--;
			} else if (idx + 1 < alphabetArr.length && alphabetArr[idx] == 'c' && alphabetArr[idx + 1] == '-') {
				cnt--;
			} else if (idx + 1 < alphabetArr.length && alphabetArr[idx] == 'c' && alphabetArr[idx + 1] == '-') {
				cnt--;
			} else if (idx + 1 < alphabetArr.length && alphabetArr[idx] == 'd' && alphabetArr[idx + 1] == '-') {
				cnt--;
			} else if (idx + 1 < alphabetArr.length && alphabetArr[idx] == 'l' && alphabetArr[idx + 1] == 'j') {
				cnt--;
			} else if (idx + 1 < alphabetArr.length && alphabetArr[idx] == 'n' && alphabetArr[idx + 1] == 'j') {
				cnt--;
			} else if (idx + 1 < alphabetArr.length && alphabetArr[idx] == 's' && alphabetArr[idx + 1] == '=') {
				cnt--;
			} else if (idx + 1 < alphabetArr.length && alphabetArr[idx] == 'z' && alphabetArr[idx + 1] == '=') {
				cnt--;
			}
		}
		System.out.println(cnt);
	}
}
