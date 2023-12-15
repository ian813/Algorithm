import java.io.*;

public class Main {

	// 알파벳 획수
	private static final int[] strokeCnt = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2,
		1};

	private static int[] nameStroke;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 종민이와 그녀의 영어 이름
		String jongmin = br.readLine();
		String her = br.readLine();

		// 두 이름의 길이는 같음을 보장하므로..
		int length = 2 * jongmin.length();

		// 이름 궁합을 볼 배열
		nameStroke = new int[length];

		for (int i = 0; i < length; i++) {
			if (i % 2 == 0) {
				// 짝수 인덱스일 때는 종민이 알파벳 가져다 쓰기
				int idx = i / 2;
				int strokeIdx = jongmin.charAt(idx) - 'A';

				nameStroke[i] = strokeCnt[strokeIdx];
			} else {
				// 홀수 인덱스일 때는 그녀의 알파벳 가져다 쓰기
				int idx = i / 2;
				int strokeIdx = her.charAt(idx) - 'A';

				nameStroke[i] = strokeCnt[strokeIdx];
			}
		}

		// 궁합 구하는 횟수
		int re = length - 2;

		// 반복해서 궁합 구해주기
		while (re-- > 0) {
			nameStroke = sum(nameStroke, nameStroke.length);
		}

		// 문자열로 받기
		String ans = String.valueOf(nameStroke[0]) + nameStroke[1];

		// 출력
		System.out.println(ans);
	}

	// 궁합 구하는 메서드
	private static int[] sum(int[] nameStroke, int length) {
		int[] result = new int[length];

		for (int i = 0; i < length - 1; i++) {
			// 인접한 두 수 더하고 10으로 나눈 나머지
			int cur = (nameStroke[i] + nameStroke[i + 1]) % 10;

			// 결과 배열에 저장
			result[i] = cur;
		}

		// 리턴
		return result;
	}
}