import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자 A, B, C 입력받기
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		// 곱한 값 구하기
		int multiple = A*B*C;
		
		// 곱한 값을 문자열로 형변환
		String result = Integer.toString(multiple);
		
		// 0~9까지 for문 돌면서 count
		for(int i = 0; i < 10; i++) {
			// cnt : 몇 번 나오는지 세줌, 반복문 돌 때마다 cnt값 초기화
			int cnt = 0;
			// 문자열의 길이만큼 for문 반복
			for(int idx = 0; idx < result.length(); idx++) {
				// 문자열을 char 단위로 쪼개서 아스키코드로 변환 -> 48을 빼주면 숫자와 일치하는 값이 됨.
				// 그 값이 i와 같으면 cnt를 올려줌.
				if(result.charAt(idx)-48 == i) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}