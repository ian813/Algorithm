import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문자열 입력받기
		String str = sc.next();
		
		sc.close();
		
		// 답을 담을 변수
		String ans = "";
		
		// 각 알파벳 개수 세줄 배열
		int[] alphabet = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			// 각 인덱스에 개수 세서 저장
			int idx = str.charAt(i) - 'A';
			
			alphabet[idx]++;
		}
		
		// 알파벳 개수가 홀수인 것의 개수를 세줄 변수
		int odd = 0;
		
		// 홀수 개수 세주기
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] % 2 == 1) {
				odd++;
			}
		}
		
		if(odd > 1) { // 홀수 개수가 1을 넘어가면 팰린드롬이 될 수 없다. 왜냐하면 대칭이 될 수 없으니까...
			ans = "I'm Sorry Hansoo";
		} else {
			// 그게 아니면 팰린드롬 가능
			for(int i = 0; i < 26; i++) { // 사전순 출력이므로 배열 처음부터 돌면서 팰린드롬을 만들어가면 된다.
				for(int j = 0; j < alphabet[i]/2; j++) {
					// 알파벳 개수의 절반만큼 더해서 문자열 만들어주기
					ans += (char)(i+'A');
				}
			}
			if(odd == 1) { // 홀수 개수가 1이었으면 실행
				for(int i=0; i<26; i++) {
					if(alphabet[i]%2==1) {
						// 가운데에 그 알파벳 더해주기
						ans += (char)(i+65);
					}
				}				
			}
			// 이제 대칭을 만들어줘야 하므로 배열을 뒤에서부터 돌면서 똑같이 더해주기
			for(int i = 25; i >= 0; i--) {
				for(int j = 0; j < alphabet[i]/2; j++) {
					ans += (char)(i+'A');					
				}
			}
		}
		
		// 답 출력
		System.out.println(ans);
	}
}
