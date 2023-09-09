import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 듣도 못한 사람 수, 보도 못한 사람 수
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 듣도 못한 사람 명단 담을 해시셋
		HashSet<String> notListen = new HashSet<>();

		for (int i = 0; i < N; i++) {
			notListen.add(sc.next());
		}

		ArrayList<String> result = new ArrayList<>();

		// 보도 못한 사람 입력받고
		for (int i = 0; i < M; i++) {
			String str = sc.next();

			if (notListen.contains(str)) {
				// 듣도 못한 사람 명단에도 있으면
				// result에 넣어주기
				result.add(str);
			}
		}

		StringBuilder sb = new StringBuilder();

		// 스트링빌더에 듣보잡 수 담아주고
		sb.append(result.size() + "\n");

		// 사전순 정렬
		Collections.sort(result);

		// 듣보잡들 담아주기
		for (String s : result) {
			sb.append(s + "\n");
		}

		// 출력
		System.out.println(sb);
	}
}