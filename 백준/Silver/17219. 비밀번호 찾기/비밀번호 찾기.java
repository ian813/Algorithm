import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int addressNum;
	static int searchNum;
	static Map<String, String> search = new HashMap<>();
	
	static void input() {
		addressNum = sc.nextInt();
		searchNum = sc.nextInt();

		
		for (int idx = 0; idx < addressNum; idx++) {
			// 주소 숫자만큼 사이트와 비밀번호 입력받고
			String site = sc.next();
			String password = sc.next();
			// 맵에 넣어주기
			search.put(site, password);
		}
		
	}

	static void solve() {
		input();
		
		for (int idx = 0; idx < searchNum; idx++) {
			// 찾고 싶은 사이트 입력받아서
			String find = sc.next();
			// 그거를 키값으로 찾아서 스트링빌더에 담아주기
			sb.append(search.get(find)).append("\n");
		}
	}

	public static void main(String[] args) {
		solve();
		// 출력
		System.out.println(sb);
	}
}