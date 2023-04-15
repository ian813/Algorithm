import java.util.Scanner;

public class Main {
	static String S, T;
	static int result;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		S = sc.next();
		T = sc.next();
	}
	
	static void solve() {
		// 방식 : S에 A를 추가하거나 문자열을 뒤집고 B를 추가한다.
		// -> T에서 A를 제거하거나 B를 제거하고 문자열을 뒤집는다. (두가지 경우밖에 존재 안함!)
		
		while(S.length() < T.length()) {
			// S보다 T의 길이가 길때까지만 실행
			if(T.endsWith("A")) {
				// A로 끝나면 A를 제거
				T = T.substring(0, T.length()-1);
			} else if(T.endsWith("B")) {
				// B로 끝나면 B를 제거하고
				T = T.substring(0, T.length()-1);
				// 빈 문자열 생성해서
				String temp = "";
				for(int i = T.length()-1; i>=0; i--) {
					// T를 역순으로 담아주고
					temp += T.charAt(i);
				}
				// T에 대입
				// T가 뒤집어서 저장되었다.
				T = temp;
			}
		}
		// 와일문을 빠져나오면 S와 T의 길이는 일단 같아졌다.
		// 이제 비교해주면 된다.
		if(S.equals(T)) { // 같으면 결과값을 1로
			result = 1;
		} else { // 다르면 결과값을 0으로
			result = 0;
		}
	}
	
	public static void main(String[] args) {
		input();
		solve();
		// 결과값 출력
		System.out.println(result);
	}
}
