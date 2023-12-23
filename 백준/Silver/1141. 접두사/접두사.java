import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int wordNum = Integer.parseInt(br.readLine());
		String[] wordArr = new String[wordNum];

		for (int i = 0; i < wordNum; i++) {
			wordArr[i] = br.readLine();
		}

		// 문자열 길이를 기준으로 내림차순으로 정렬
		Arrays.sort(wordArr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s2.length(), s1.length());
			}
		});

		// set에 접두어X 집합 만들어주기
		HashSet<String> set = new HashSet<>();

		for (String s1 : wordArr) {
			if (set.size() == 0) {
				// 일단 첫번째꺼 바로 넣어주기
				set.add(s1);
				continue;
			}
			
			// 현재 단어가 다른 단어의 접두어인지 체크해줄 불리안
			boolean check = true;
			for (String s2 : set) {
				// set에 있는 문자열중에 s1을 접두어로 포함하는게 있으면 추가X
				if (s2.indexOf(s1) == 0) {
					check = false;
					break;
				}
			}
			if (check) {
				set.add(s1);
			}
		}

		System.out.println(set.size());
	}
}