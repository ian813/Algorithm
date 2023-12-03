import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		// 테이블 크기
		int size = Integer.parseInt(st.nextToken());

		// 한계거리
		int limit = Integer.parseInt(st.nextToken());

		// 테이블 정보
		String info = br.readLine();

		int[] table = new int[size];

		// 햄버거는 1, 사람은 0으로 정보 구성
		for (int i = 0; i < size; i++) {
			if (info.charAt(i) == 'H') {
				table[i] = 1;
			}
		}
		// 먹은 햄버거인지 체크할 배열
		boolean[] check = new boolean[size];

		// 먹은 햄버거 수
		int cnt = 0;

		for (int i = 0; i < size; i++) {
			if (table[i] == 0) {
				// 사람 발견하면
				for (int j = Math.max(i - limit, 0); j < Math.min(i + limit + 1, size); j++) {
					// 한계 범위 내에서 햄버거 찾아주자
					if (table[j] == 1 && !check[j]) {
						// 햄버거 발견했고 아직 안 먹은 햄버거면
						// 먹었다고 체크하고 카운팅하고 멈추기
						check[j] = true;
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}