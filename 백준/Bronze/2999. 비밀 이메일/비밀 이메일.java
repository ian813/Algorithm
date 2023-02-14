import java.util.Scanner;

public class Main {
	
	// N, R, C 변수 생성
	static int N;
	
	static int R;
	
	static int C;
	
	// 메시지 입력받을 변수 생성
	static String message;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 메시지 입력받기
		message = sc.next();
		
		// 메시지의 길이를 N에 할당
		N = message.length();
		
		// N의 약수를 찾아서 R과 C에 대입 (그 중 R의 최댓값 구하기)
		for(int i = 1; i <= Math.sqrt(N); i++) {
			if(N % i == 0) {
				R = i;
			}
		}
		
		C = N/R;
		
		// message를 하나씩 쪼개서 받을 배열 생성
		char[][] messageArr = new char[R][C];
		
		// 인덱스값 설정
		int idx = 0;
		
		// 배열을 돌면서 (열을 고정시키고 행부터 돈다.)
		for(int col = 0; col < C; col++) {
			for(int row = 0; row < R; row++) {
				
				// 값을 입력받는다.
				// charAt으로 쪼개면 아스키코드가 나오므로 다시 형변환을 통해 char로 바꿔준다.
				messageArr[row][col] = (char)(message.charAt(idx++));
				
			}
			
		}
		
		// 배열을 돌면서(이번엔 행을 고정시키고 열부터 돈다.
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) {
				
				// 값을 일렬로 출력한다.
				System.out.print(messageArr[row][col]);
				
			}
			
		}

	}
}