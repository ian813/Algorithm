import java.util.Scanner;

public class Main {

	static int vertical, horizon, x, y, orderNum; // 가로 세로 길이, 주사위 좌표, 명령 개수
	static int[][] map; // 맵 정보
	static int[] order; // 명령어를 저장할 배열

	// 동서남북 방향
	static final int EAST = 1;
	static final int WEST = 2;
	static final int NORTH = 3;
	static final int SOUTH = 4;

	// 델타배열 (제자리, 동서북남)
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	// 주사위 클래스
	static class Dice {
		int now, left, right, top, bottom, nowtop;
		
		Dice(int now, int left, int right, int top, int bottom, int nowtop) {
			this.now = now;
			this.left = left;
			this.right= right;
			this.top = top;
			this.nowtop = nowtop;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		vertical = sc.nextInt();
		horizon = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		orderNum = sc.nextInt();

		map = new int[vertical][horizon];

		// 맵 정보 입력받기
		for (int r = 0; r < vertical; r++) {
			for (int c = 0; c < horizon; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		order = new int[orderNum];

		for (int i = 0; i < orderNum; i++) {
			order[i] = sc.nextInt();
		}

		sc.close();
		
		// 주사위 생성
		Dice dice = new Dice(0, 0, 0, 0, 0, 0);
		
		for (int i = 0; i < orderNum; i++) {
			// 명령에 따라 이동시키기
			int nr = x + dr[order[i]];
			int nc = y + dc[order[i]];
			
			// 명령에 따라 이동한 곳이 배열 범위 밖이면 넘기기
			if(nr < 0 || nc < 0 || nr >= vertical || nc >= horizon) continue;
			
			if(order[i] == EAST) {
				// 동쪽으로 굴리기
				int tmp = dice.left;
				dice.left = dice.now;
				dice.now = dice.right;
				dice.right = dice.nowtop;
				dice.nowtop = tmp;
			} else if(order[i] == WEST) {
				// 서쪽으로 굴리기
				int tmp = dice.left;
				dice.left = dice.nowtop;
				dice.nowtop = dice.right;
				dice.right = dice.now;
				dice.now = tmp;
			} else if(order[i] == NORTH) {
				// 북쪽으로 굴리기
				int tmp = dice.now;
				dice.now=dice.top;
				dice.top = dice.nowtop;
				dice.nowtop = dice.bottom;
				dice.bottom = tmp;
			} else if(order[i] == SOUTH) {
				// 남쪽으로 굴리기
				int tmp = dice.now;
				dice.now = dice.bottom;
				dice.bottom = dice.nowtop;
				dice.nowtop = dice.top;
				dice.top = tmp;
			}
			
			// 주사위 굴린 맵의 칸이 0이면 주사위 바닥면에 쓰인 수가 맵에 복사
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice.now;
			} else { // 아닐 경우 주사위에 맵의 값이 복사되고 맵의 값이 0으로 변경
				dice.now = map[nr][nc];
				map[nr][nc] = 0;
			}
			
			// 현재 바닥면의 반대에 있는 값 담아주기
			sb.append(dice.nowtop).append("\n");
			
			// 명령이 잘 수행되었으면 x, y값 갱신
			x = nr;
			y = nc;
		}
		
		System.out.println(sb);
	}
}
