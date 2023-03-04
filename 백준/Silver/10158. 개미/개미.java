import java.util.Scanner;

public class Main {
	static int width;
	static int height;
	
	static int startX;
	static int startY;
	
	static int time;
	
	static int endX;
	static int endY;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// 격자의 너비와 높이
		width = sc.nextInt();
		height = sc.nextInt();
		
		// 개미가 출발하는 위치
		startX = sc.nextInt();
		startY = sc.nextInt();
		
		// 개미의 이동시간
		time = sc.nextInt();
	}
	
	static void goAnt() {
		input();
		// 끝나는 위치를 계산해보자.
		// 먼저 X값부터,,
		// 시작위치 + 시간을 해서 총 이동거리를 구해준 뒤 너비*2로 나눈 나머지를 구해준다.
		// 왜냐하면 너비*2만큼 이동하면 제자리로 돌아오기 때문
		endX = (startX + time) % (2 * width);
		if(endX > width) {
			// 다만 끝나는 위치가 기존 너비보다 크다면
			// 격자 범위를 벗어난 것이므로
			// 2배한 너비에서 끝나는 위치를 뺴줘서
			// 새로 갱신해준다.
			endX = Math.abs(2*width - endX);
		}
		
		// Y값은 X값과 같은 방식으로 계산해준다.
		endY = (startY + time) % (2 * height);
		if(endY > height) {
			endY = Math.abs(2*height - endY);
		}
		// 형식에 맞게 출력
		System.out.printf("%d %d\n", endX, endY);
	}
	
	public static void main(String[] args) {
		goAnt();
	}
}