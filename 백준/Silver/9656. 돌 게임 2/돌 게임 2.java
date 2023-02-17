import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 돌개수 입력받기
		int numStone = sc.nextInt();
		
		// 돌개수가 짝수이면 먼저 게임 시작한 상근이가 이기고
		// 홀수이면 나중에 게임 시작한 창영이가 이긴다.
		if(numStone % 2 == 0) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
		
	}
}
