import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수 입력받기
		int testCase = sc.nextInt();
		for(int i = 0; i < testCase; i++) {
			// OX 문자열 입력받을 quiz 변수 생성
			String quiz = sc.next();
			
			// score의 합인 totalScore 변수 생성
			int totalScore = 0;
			
			for(int j = 0; j < quiz.length(); j++) {
				// 연속된 O의 개수를 세는 변수 score 생성 (개수가 곧 점수)
				int score = 0;
				
				// 문자열을 돌다가 O를 만나면 그 전에 몇개의 O가 연속되었는지 세주고 그 개수를 score 변수에 할당해야한다.
				if(quiz.charAt(j) == 'O') {
					for(int k = j; k >= 0; k--) {
						// O를 만났을 때 그 전으로 되돌아가면서 X를 만날때까지 세준다.
						// 다만 예외가 있다.
						// 만약 시작부터 연속된 O가 나오면 그 전으로 되돌아가도 X를 만날 수 없다.
						if(quiz.charAt(k) == 'X') {
							score = j - k;
							break;
						}
						// 예외 처리 : 만약 되돌아갔을 때 X를 만나지 못하면 시작부터 연속된 O인 경우이므로
						// J값에 +1을 해준 값을 score로 처리 (왜냐하면, 배열의 시작 index는 0이므로)ㄴ
						else {
							score = j + 1;
						}
					}
				}
				totalScore += score;
			}
			System.out.println(totalScore);
		}
	}
}