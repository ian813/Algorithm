import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n; // 전체 종이 사이즈
	static int[][] board; // 입력받은 종이들
	static int zeroCnt; // 0의 개수
	static int plusCnt; // 1의 개수
	static int minusCnt; // -1의 개수
	static String[] inputStr;

	static void input() { // 입력 메소드
		n = sc.nextInt();
		board = new int[n][n];
		sc.nextLine();
		for (int y = 0; y < n; y++) {
			inputStr = sc.nextLine().split(" ");
			for (int x = 0; x < n; x++) {
				board[y][x] = Integer.parseInt(inputStr[x]);
			}
		}
	}

	static void cutPaper(int startY, int startX, int size) {
		int check = board[startY][startX]; // 첫번째 수를 check에 넣어준다.
		outer: for(int y = startY; y < startY + size; y++) { // size만큼 배열 확인
			for(int x = startX; x < startX + size; x++) {
				if(check != board[y][x]) {
					check = 2; // 첫번째 수와 다른 값이 있다면 check에 2를 넣어줘서 다른 값이 있다는 것을 확인할 수 있게 함
					break outer;
				}
			}
		}
		if(check == 2) { // check가 2면 종이를 9등분해서 재귀
			cutPaper(startY, startX, size / 3);
			cutPaper(startY + size / 3, startX, size / 3);
            cutPaper(startY + size * 2 / 3, startX, size / 3);
            cutPaper(startY, startX + size / 3, size / 3);
			cutPaper(startY + size / 3, startX + size / 3, size / 3);
            cutPaper(startY + size * 2 / 3, startX + size / 3, size / 3);
			cutPaper(startY, startX + size * 2 / 3, size / 3);
			cutPaper(startY + size / 3, startX + size * 2 / 3, size / 3);
			cutPaper(startY + size * 2 / 3, startX + size * 2 / 3, size / 3);
			
		} // check가 2가 아니라면 종이의 개수에 더해준다.
		else if(check == -1) {
			minusCnt++;
		}
		else if(check == 0) {
			zeroCnt++;
		}
		else {
			plusCnt++;
		}
	}
	
	public static void main(String[] args) {
		input();
		cutPaper(0, 0, n);
		System.out.println(minusCnt);
		System.out.println(zeroCnt);
		System.out.println(plusCnt);
	}
}