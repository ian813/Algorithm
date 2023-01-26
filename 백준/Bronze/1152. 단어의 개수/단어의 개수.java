import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문자열 입력받을 변수 sentence 생성
		String sentence = sc.nextLine();
		
		// 단어 사이의 공백의 개수를 셀 변수 생성
		int space = 0;
		
		// 문자열을 돌면서 공백 탐색
		for(int i = 0; i < sentence.length(); i++) {
			// 공백의 아스키코드는 32
			if(sentence.charAt(i) == 32) {
				// 맨 처음이나 맨 마지막이 공백인 경우는 제외
				if(i != 0 && i != sentence.length() - 1) {
					space++;
				}
			} else {
				continue;
			}
		}
		
		// 단어의 개수
		int numWord = space + 1;
		
		if (space == 0) {
			if(sentence.length() == 1 && sentence.charAt(0) == 32) {
				numWord = 0;
			}
		}
		
		
		System.out.println(numWord);
	}
}