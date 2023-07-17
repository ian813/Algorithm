import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		sc.close();
		// 중복을 피해서 저장하기 위해 Set을 만든다.
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = i+1; j <= str.length(); j++) {
				// 하나씩 다 잘라서 부분문자열을 만들고
				String tmp = str.substring(i, j);
				// Set에 넣어준다.
				set.add(tmp);
			}
		}
		// Set의 크기 출력
		System.out.println(set.size());
	}
}