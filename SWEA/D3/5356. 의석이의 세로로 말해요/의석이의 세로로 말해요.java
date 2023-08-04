import java.util.Scanner;

public class Solution {
	
	// testCase 입력받기
	static int testCase;
	
	// 문자열을 쪼개서 char로 저장할 배열
	static char[][] word;
	
	// 문제를 풀 메서드 생성
	static void solve() {
		Scanner sc = new Scanner(System.in);
		
		// testCase 입력받기
		testCase = sc.nextInt();
		
		// 테스트케이스 만큼 실행
		for(int tc = 1; tc <= testCase; tc++) {
			// 단어의 개수는 5개이고 각 단어의 길이는 최대 15이므로
			// 아래와 같이 배열 생성
			word = new char[5][15];
			
			for(int row = 0; row < 5; row++) {
				// 각 행마다 단어 입력받고
				String str = sc.next();
				
				for(int col = 0; col < str.length(); col++) {
					// 그 단어의 길이만큼 char 형으로 쪼개서 배열에 넣어주기
					word[row][col] = str.charAt(col);
							
				}

			}
			
			// # 테스트케이스 번호 출력
			System.out.print("#" + tc + " ");
			
			// 열 우선탐색으로 프린트해주자.
			for(int col = 0; col < 15; col++) {
				
				for(int row = 0; row < 5; row++) {
					
					// 중간에 char이 채워지지 않은 부분은
					// 디폴트 값인 '\u0000'가 채워져있다.
					// 디폴트 값이 아닐 때만 순서대로 공백없이
					// 출력해주자.
					if(word[row][col] != '\u0000') {
						System.out.print(word[row][col]);
					}
	
				}
							
			}
			// 출력이 끝나면 개행
			System.out.println();

		}
			
	}
	
	public static void main(String[] args) {
		// 메서드 실행하면 끝
		solve();
	}
}