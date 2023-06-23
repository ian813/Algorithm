import java.util.Scanner;

public class Main {
	
	static String A, B;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// A, B 문자열 입력받기
		A = sc.next();
		B = sc.next();
		
		sc.close();
		
		// A, B의 문자열을 배열로..
		char[] newA = A.toCharArray();
		char[] newB = B.toCharArray();
		
		// 최소값을 담을 변수
		int min = Integer.MAX_VALUE;
		
		// 완전 탐색 ( 아무 문자나 앞뒤로 추가할 수 있으므로 그냥 지금 문자열을 돌아가면서 비교해줘서 차이를 비교해주면 된다. )
		for(int i = 0; i < newB.length - newA.length + 1; i++) {
			int cnt = 0; // 문자가 다른 걸 카운팅할 변수
			for(int j = 0; j < newA.length; j++) {
				if(newA[j] != newB[i+j]) { // 다른 문자를 발견하면
					cnt++; // 카운팅
				}
			}
			// 최솟값 갱신
			min = Math.min(cnt, min);
			if(min == 0) break;
		}
		// 출력
		System.out.println(min);
	}
}