import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int bookNum = sc.nextInt(); // 책 수
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < bookNum; i++) {
			// 책 제목을 키값으로 입력받기
			String key = sc.next();
			
			if(map.containsKey(key)) { // 이미 같은 키값이 존재하면
				int num = map.get(key); // 키 값에 해당하는 밸류를 빼와서
				map.replace(key, num+1); // 같은 키 값에 밸류는 1 늘려서 교체해서 저장
			} else { // 같은 키값이 존재하지 않으면
				map.put(key, 1); // 키와 밸류를 처음으로 넣어주기
			}
		}
		
		// 가장 많은 책을 뽑아보자.
		int max = 0;
		for(int m : map.values()) { // 맵의 밸류를 돌면서
			max = Math.max(max, m); // 최댓값 갱신
		}
		
		// 키값을 사전순으로 정리할 맵
		TreeMap<String, Integer> sortedMap = new TreeMap<>(map);
		
		for(String str : sortedMap.keySet()) { // 키값들을 돌면서
			if(map.get(str) == max) { // 해당 키 값에 해당하는 밸류가 최댓값과 같으면
				System.out.println(str); // 프린트해주고 중단 (사전순으로 정렬되어 있으므로)
				break;
			}
		}
		
		sc.close();
	}
}