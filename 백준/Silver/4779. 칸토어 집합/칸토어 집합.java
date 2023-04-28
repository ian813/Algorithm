import java.util.Scanner;

public class Main {
	static int N, length;
	static char[] str;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			sb = new StringBuilder();
			
			N = sc.nextInt();

			length = (int) Math.pow(3, N); // 3^N 구하기

			str = new char[length];
			
			// -로 배열 채워주기
			for (int idx = 0; idx < length; idx++) {
				str[idx] = '-';
			}
			
			// 탐색 시작
			dfs(0, length);
			
			// 탐색 끝났으면 스트링빌더에 담아주고 
			for (int i = 0; i < length; i++) {
				sb.append(str[i]);				
			}
			
			// 출력
			System.out.println(sb);
		}

	}

	static void dfs(int start, int length) {
		if (length < 3) { //길이가 3미만이면 1씩 밖에 안 남은 것이므로 리턴
			return;
		}

		// 중간부분 공백으로 바꾸고
		for (int i = start + length / 3; i < start + length / 3 * 2; i++) {
			str[i] = ' ';			
		}

		// 처음, 마지막 부분 재귀함수로 다시 확인
		dfs(start, length / 3);

		dfs(start + length / 3 * 2, length / 3);
	}
}