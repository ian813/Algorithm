import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	static int length;
	static LinkedList<Integer> password;
	static int order;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			// 암호문의 길이를 입력받고
			length = sc.nextInt();

			password = new LinkedList<>();

			// 암호문의 길이만큼 값 입력받기
			for (int idx = 0; idx < length; idx++) {
				password.add(sc.nextInt());
			}

			// 명령문 개수 입력받기
			order = sc.nextInt();

			// 명령문의 개수만큼 문자열 입력받기
			for (int idx = 0; idx < order; idx++) {
				// 명령문의 개수만큼
				// 명령어 입력받기
				String str = sc.next();
				
				if (str.equals("I")) {
					// 명령문이 I일 때
					
					// 시작 인덱스 입력받고
					int iStartIdx = sc.nextInt();
					// 삽입할 숫자의 개수 입력받고
					int numI = sc.nextInt();

					for (int i = 0; i < numI; i++) {
						// 시작 인덱스부터 차례대로 값 입력받아서 끼워넣기
						password.add(iStartIdx + i, sc.nextInt());
					}

				} else if (str.equals("D")) {
					// 명령문이 D일 때

					// 시작 인덱스 입력받고
					int dStartIdx = sc.nextInt();
					// 삽입할 숫자 개수 입력받고
					int numD = sc.nextInt();

					for (int i = 0; i < numD; i++) {
						// 시작인덱스에 있는 값을 numD개만큼 삭제
						password.remove(dStartIdx);
					}

				} else if (str.equals("A")) {
					// 명령문이 A일 때
					
					// 삽입할 숫자 개수 입력받고
					int numA = sc.nextInt();

					for (int i = 0; i < numA; i++) {
						// 맨 뒤에 numA개만큼 숫자 입력받기
						password.add(sc.nextInt());
					}
				}

			}
			
			// 형식에 맞게 출력
			System.out.printf("#%d ", tc);

			for (int idx = 0; idx < 10; idx++) {
				System.out.print(password.poll() + " ");
			}

			System.out.println();
		}
	}
}