import java.util.Scanner;

public class Main {
	// 전체 영역 배열, 종이 개수,
	// 종이의 x y 좌표
	// 종이의 넓이를 담을 변수들 생성
	static int[][] plane;
	
	static int paperNum;
	
	static int paperX;
	
	static int paperY;
		
	static int area;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 영역 크기는 100*100으로 고정
		plane = new int [100][100];
		
		// 종이 개수 입력받고
		paperNum = sc.nextInt();
		
		for(int paper = 0; paper < paperNum; paper++) {
			// 종이의 x y 좌표 입력받은 뒤
			paperX = sc.nextInt();
			
			paperY = sc.nextInt();
			
			// 색종이 영역에 해당하는 부분에 1을 채워넣는다.
			// 색종이 영역이 아니라면 디폴트값인 0이 남아있음..
			for(int x = paperX; x < paperX+10; x++) {
				for(int y = paperY; y < paperY+10; y++) {
					plane[x][y] = 1;
					
				}
				
			}

		}
		
		// 종이의 개수만큼 실행해서 1을 채워넣었으므로
		// 그 값들을 다 더하면 색종이의 넓이가 된다.
		// 넓이를 초기화시켜준 후,
		area = 0;
		for(int row = 0; row < 100; row++) {
			for(int col = 0; col < 100; col++) {
				
				// 넓이를 구해준다.
				area += plane[row][col];
				
			}
			
		}
		// 넓이 출력~
		System.out.println(area);
	}
}