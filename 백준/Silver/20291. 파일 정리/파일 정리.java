import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 파일 개수
		int fileNum = Integer.parseInt(br.readLine());

		// 파일의 확장자와 그 개수를 담을 트리맵 (트리맵은 키를 오름차순으로 자동 정렬해줌)
		TreeMap<String, Integer> map = new TreeMap<>();

		while (fileNum-- > 0) {
			// 파일숫자만큼 반복

			// 파일 입력
			String file = br.readLine();

			// .을 기준으로 파일 쪼개기 -> \\. 으로 써줘야됨
			// split에서 .은 모든 문자와 배치되는 것을 의미하기 때문
			String[] splitFile = file.split("\\.");

			if (!map.containsKey(splitFile[1])) {
				// 확장자를 키로 가지고 있지 않으면 맵에 새로 넣어주기
				map.put(splitFile[1], 1);
			} else {
				// 이미 가지고 있으면 +1해서 다시 넣어주기
				map.replace(splitFile[1], map.get(splitFile[1]) + 1);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (String key : map.keySet()) {
			// keyset에서 하나씩 뽑아서 넣어주기
			sb.append(key + " " + map.get(key)).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}