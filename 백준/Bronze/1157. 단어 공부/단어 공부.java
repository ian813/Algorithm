import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 단어 입력받기
		String word = sc.next();
		
		// 알파벳을 모두 대문자로 바꿔줌
		word = word.toUpperCase();
		
		// 빈도수를 값으로 받는 배열 arr 생성
		int[] arr = new int[26];
		
		for(int i = 0; i < word.length(); i++) {
			// 빈도수 체크
			if('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
				// 배열에 값 저장
				arr[word.charAt(i) - 'A']++;
			}
		}
		
		// 배열에서 최대값과 그 위치, 결과값을 담을 변수 생성
		int max = 0;
		char ch = ' ';
		
		// 배열에서 최대값을 찾고 그 위치에 해당하는 문자를 ch에 담아줌, 만약 max값이 중복되면 ch를 ?로 바꿔줌
		for(int idx = 0; idx < arr.length; idx++) {
			if(max < arr[idx]) {
				max = arr[idx];
				ch = (char)('A' + idx);
			} else if(max == arr[idx]) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}
}