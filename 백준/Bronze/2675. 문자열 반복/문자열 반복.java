import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트캐이스 개수 입력받기
		int testCase = sc.nextInt();
		
		for(int tc = 0; tc < testCase; tc++) {
			// 반복하는 횟수, 문자열 입력값 받기
			int repitition = sc.nextInt();
			String word = sc.next();
			
			// 문자열을 char 단위로 chars 배열에 넣어주기
			char[] chars = word.toCharArray();
			
			// 배열을 돌면서
			for(char ch : chars) {
				// 반복횟수만큼 프린트
				for(int i = 0; i < repitition; i++) {
					System.out.print(ch);
				}
			}
			System.out.println();
		}
	}
}