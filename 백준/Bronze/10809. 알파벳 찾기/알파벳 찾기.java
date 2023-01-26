import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문자열 입력받을 변수 S 생성
		String S = sc.next();
		
		// 각각의 알파벳에 대해 처음 등장하는 위치를 저장할 배열 생성 (알파벳 개수가 26개이므로 크기가 26인 배열 생성)
		int[] alphabet = new int[26];
		
		// 알파벳의 개수만큼 순환
		for(int ASCII = 0; ASCII < 26; ASCII++) {
			// 문자열의 길이만큼 순환
			for(int idx = 0; idx < S.length(); idx++) {
				// 문자열을 char단위로 쪼개서 아스키코드로 반환하여 비교
				// a ~ z까지 아스키코드로 97~122로 표현되므로 ASCII + 97을 해줌.
				if(S.charAt(idx) == ASCII + 97) {
					// 아스키코드와 문자가 일치할 때 그 문자의 index를 alphabet 배열의 알맞은 위치에 넣어줌.
					alphabet[ASCII] = idx;
					// 알파벳이 중복해서 나타나도 처음 일치한 알파벳만 생각하면 되므로 한번 찾으면 break를 걸어준다.
					break;
				} else {
					// 찾는 알파벳이 없으면 alphabet 배열의 해당 위치에 -1 값을 할당해준다.
					alphabet[ASCII] = -1;
				}
			
			}
		}
		for(int idx = 0; idx < alphabet.length; idx++) {
			System.out.print(alphabet[idx] + " ");
		}
	}
}