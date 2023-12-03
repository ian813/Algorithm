import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 타겟 숫자
		String tareget = sc.next();

		// 처음부터 비교할 수, 타겟 숫자에서 비교할 위치를 가르킬 포인터
		int base = 0;
		int pointer = 0;

		out:
		while (true) {
			// base 증가시키고
			base++;
			// base를 문자열로 변환
			String cur = String.valueOf(base);

			for (int i = 0; i < cur.length(); i++) {
				// cur의 길이만큼 비교
				if (cur.charAt(i) == tareget.charAt(pointer)) {
					// 같으면 pointer 증가시켜서 비교
					pointer++;
				}
				if (pointer == tareget.length()) {
					// pointer가 target의 길이와 같아지면 while문 종료
					break out;
				}
			}
		}

		// 출력
		System.out.println(base);
	}
}