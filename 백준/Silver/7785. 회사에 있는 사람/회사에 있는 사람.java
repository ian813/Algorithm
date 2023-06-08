import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 입력받을 사람 수
		int people = sc.nextInt();
		// 맵을 이용해서 풀어보자
		HashMap<String, String> map = new HashMap<>();
		
		for(int i = 0; i < people; i++) {
			// 사람과 출입 정보를 나타낼 문자열
			String person = sc.next();
			String inout = sc.next();
			
			if(!map.containsKey(person)) {
				// 맵에 그 사람이 포함되어 있지 않으면 추가
				map.put(person, inout);				
			} else {
				// 이미 포함되어 있으면 제거
				map.remove(person);
			}
		}
		
		sc.close();
		
		// 어레이리스트를 생성해서 해시맵의 키셋들을 넣어준다.
		ArrayList<String> list = new ArrayList<String>(map.keySet());
		
		// 내림차순으로 리스트를 정렬
		Collections.sort(list, Collections.reverseOrder());
		
		// 답을 담을 스트링빌더
		StringBuilder sb = new StringBuilder();
		
		// 리스트를 돌면서 사람들을 받아주고
		for(String str : list) {
			// 스트링빌더에 담아준다.
			sb.append(str + "\n");
		}
		// 출력
		System.out.println(sb);
	}
}