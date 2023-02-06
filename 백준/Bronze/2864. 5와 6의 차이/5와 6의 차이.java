import java.util.Scanner;

public class Main {
	// 전역변수 만들기
	static String A;
	static String B;
	static String minA;
	static String minB;
	static String maxA;
	static String maxB;
	
	// 스캐너 생성
	static Scanner sc = new Scanner(System.in);
	
	// input함수 만들기
	static void input() {
		
		// A, B값 입력
		A = sc.next();
		B = sc.next();
		
		// minA~maxB를 빈 문자열로 생성
		minA = "";
		minB = "";
		maxA = "";
		maxB = "";
		
		// 먼저 A의 최대 최소부터 구해보자.
		for(int idx = 0; idx < A.length(); idx++) {
			// A 문자열을 돌면서

			// 참고 : 문자열은 더하면 뒤에 붙는다. ex) "5" + "6" = "56"
			if(A.charAt(idx) == '5') {
				// 5를 발견하면
				// 6으로 바꿔서 maxA에 더해준다.
				maxA += '6';
			} else {
				// 나머지 수들은 그대로 maxA에 더해준다.
				maxA += A.charAt(idx);
			}
			
			// A 문자열을 돌면서
			if(A.charAt(idx) == '6') {
				// 6을 발견하면
				// 5로 바꿔서 minA에 더해준다.
				minA += '5';
			} else {
				// 나머지 수들은 그대로 minA에 더해준다.
				minA += A.charAt(idx);
			}
		}
		
		// B도 A와 마찬가지로 구한다.
		for(int idx = 0; idx < B.length(); idx++) {
			if(B.charAt(idx) == '5') {
				maxB += '6';
			} else {
				maxB += B.charAt(idx);
			}
			
			if(B.charAt(idx) == '6') {
				minB += '5';
			} else {
				minB += B.charAt(idx);
			}
		}
		
		
		
	}
	

	// sum함수 생성
	// 정수 a,b가 들어왔을 때 두 수를 더하고 프린트해준다.
	static void sumAB(int a, int b) {
		int sum = a + b;
		
		System.out.printf("%d ", sum);
	}
	
	// main함수 실행
	// input함수와 sumAB함수 실행
	public static void main(String[] args) {
		input();
		
		try {
			int minnumA = Integer.parseInt(minA);
			int maxnumA = Integer.parseInt(maxA);

			int minnumB = Integer.parseInt(minB);
			int maxnumB = Integer.parseInt(maxB);
			
			sumAB(minnumA, minnumB);
			sumAB(maxnumA, maxnumB);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}
}