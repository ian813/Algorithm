import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 단어 개수 및 단어 길이 한계 입력받기
		int wordNum = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());

		// 해시맵 생성
		HashMap<String, Integer> map = new HashMap<>();

		while (wordNum-- > 0) {
			// 단어 개수만큼 입력받기
			String word = br.readLine();

			// 한계길이보다 작으면 넘기기
			if (word.length() < limit)
				continue;

			if (!map.containsKey(word)) {
				// 맵에 포함되어있지 않은 단어면 추가하고 넘기기
				map.put(word, 1);
				continue;
			}

			// 맵에 있는 단어면 카운팅해서 새로 넣어주기
			map.replace(word, map.get(word) + 1);
		}

		// 키들로 새로운 리스트 만들기
		List<String> dictionary = map.keySet().stream().collect(Collectors.toList());

		// 사전 정렬
		dictionary.sort((o1, o2) -> {
			int c1 = map.get(o1);
			int c2 = map.get(o2);

			if (c1 == c2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2); // 알파벳 사전 순
				}
				return o2.length() - o1.length(); // 길이가 긴 단어 순
			}

			// 맵에 있는 value들 (빈도수) 빈도수가 클 수록 앞에
			return c2 - c1;
		});

		StringBuilder sb = new StringBuilder();

		// 단어 하나씩 저장해서 출력
		for (int i = 0; i < dictionary.size(); i++) {
			sb.append(dictionary.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
}