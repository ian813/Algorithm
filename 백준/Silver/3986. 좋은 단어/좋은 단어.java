import java.util.Scanner;
import java.util.Stack;

public class Main {
	static String tmpWord; // 입력받은 단어
	static char[] word; // 단어를 char로 쪼개기
	static int cnt; // 좋은 단어 개수 세줄 변수
	static Stack<Character> stack; // word에 있는 char를 하나씩 담아줄 스택
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int wordNum = sc.nextInt();
		
		cnt = 0;
		
		// 단어 개수만큼 반복
		for(int i = 0; i < wordNum; i++) {
			tmpWord = sc.next();
			
			word = tmpWord.toCharArray();
			
			findWord(); // 좋은 단어인지 판단		
		}
		sc.close();
		
		System.out.println(cnt);
	}
	
	// 좋은 단어 찾기
	static void findWord() {
		stack = new Stack<>();
		
		for(int i = 0; i < word.length; i++) { // 단어 배열을 돌면서
			if(stack.isEmpty() || stack.peek() != word[i]) {
				// 스택이 비어있거나 스택 꼭대기와 지금 넣으려는 단어가 일치하지 않으면
				// 스택에 푸시
				stack.push(word[i]);
			} else {
				// 아니면 스택에서 팝
				stack.pop();
			}
		}
		
		if(stack.isEmpty()) cnt++;
		
	}
}
