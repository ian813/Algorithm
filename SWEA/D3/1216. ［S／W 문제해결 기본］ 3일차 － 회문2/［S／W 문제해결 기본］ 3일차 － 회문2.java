import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			// 테스트넘버 입력받기
			int testNum = sc.nextInt();

			// 문자를 입력받을 배열 생성
			char[][] plane = new char[100][100];

			// 배열을 돌면서 입력받기
			for (int row = 0; row < 100; row++) {
				String str = sc.next();
				for (int col = 0; col < 100; col++) {
					plane[row][col] = str.charAt(col);

				}
			}

			// 회문의 길이를 나타낼 변수
			int lengthPalindrome = 100;

			// 최대 회문 길이
			int maxLength;
			
			// 회문을 찾았는지 판단할 불리안
			boolean isPalindrome = false;
			
			// 목적 : 회문의 길이가 100이 있는지 배열을 돌면서 찾고 없으면
			// 회문의 길이를 하나씩 감소시키고 배열을 돌면서 찾는다.
			while (!(isPalindrome)) {

				// 배열을 돌면서 회문을 찾아보자.
				for (int row = 0; row < 100; row++) {
					for (int col = 0; col < 100; col++) {

						// 가로방향 회문, 세로방향 회문의 불리안 값을 생성
						boolean rowPalindrome = true;
						boolean colPalindrome = true;

						// (회문 길이 + 1)/2만큼만 조사해주면 된다.
						for (int search = 0; search < (lengthPalindrome + 1) / 2; search++) {

							if (col + lengthPalindrome - 1 - search < 100) {
								// 조사할 범위가 배열을 넘어가지 않을 때
								if (plane[row][col + search] != plane[row][col + lengthPalindrome - 1 - search]) {
									// 불일치하면 colPalindrome을 false로 바꿔줌.
									colPalindrome = false;
								}
							} else {
								// 조사할 범위가 배열을 넘어가도
								// colPalindrome을 false로 바꿔줌.
								colPalindrome = false;
							}

							// col일 때와 마찬가지로 실행
							if (row + lengthPalindrome - 1 - search < 100) {
								if (plane[row + search][col] != plane[row + lengthPalindrome - 1 - search][col]) {
									rowPalindrome = false;
								}
							} else {
								rowPalindrome = false;
							}
							
							// 회문을 찾지 못했으면
							// break하고 다음 좌표로 넘어간다.
							if(!(colPalindrome) && !(rowPalindrome)) {
								break;
							}
						}

						// 둘 중 하나가 true라면
						// 해당 길이의 회문을 찾았으므로 isPalindrome을
						// true로 바꿔줘서 while문 탈출.
						if (rowPalindrome || colPalindrome) {
							isPalindrome = true;
						}

					}

				}
				
				// 만약 회문을 못찾았으면 회문 길이를 감소시켜서 다시 배열 탐색을 해서 찾아준다.
				if(!(isPalindrome)) {
					lengthPalindrome--;
				}

			}
			// 형식에 맞게 출력
			System.out.printf("#%d %d\n", testNum, lengthPalindrome);
		}
	}
}