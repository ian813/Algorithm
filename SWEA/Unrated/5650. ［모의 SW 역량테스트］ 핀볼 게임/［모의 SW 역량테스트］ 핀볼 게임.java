import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();
	
	static int size, maxScore, score;
	static int[][] map;
	// 델타배열 상,우,하,좌 방향
	static int[] delR = {-1, 0, 1, 0};
	static int[] delC = {0, 1, 0, -1};
	
	
	static void input() {
		size = sc.nextInt();
		// 핀볼 맵 생성
		map = new int[size][size];
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				map[row][col] = sc.nextInt();
			}
		}
	}
	
	static void pinball(int r, int c) {
		
		for(int dr = 0; dr < delR.length; dr++) {
			// 출발 위치
			int tempRow = r;
			int tempCol = c;

			// 매 시행마다의 점수를 저장할 변수
			score = 0;
			
			// 현재 방향을 저장해두고 이 방향부터 출발지점에서 시작해보자.
			int curDr = dr;
			
			while(true) {
				// 델타배열을 이용한 탐색
				tempRow += delR[curDr];
				tempCol += delC[curDr];
				
				if(tempRow < 0 || tempRow >= size || tempCol < 0 || tempCol >= size) {
					// 배열 경계를 넘어가면 벽에 맞았으므로 점수를 증가시키고 방향 바꾸기
					curDr = (curDr+2) % 4;
					score++;
					continue;
				}
				
				if(map[tempRow][tempCol] == -1 || (tempRow == r && tempCol == c)) {					
					// 블랙홀을 만나거나 처음 위치로 돌아오면 점수 최댓값 갱신하고 멈춰!
					maxScore = Math.max(maxScore, score);
					break;
				} else if(map[tempRow][tempCol] >= 1 && map[tempRow][tempCol] <= 5) {
					// 벽을 만나면 block메서드 실행
					// return 값으로 방향을 바꿔주기
					curDr = block(tempRow, tempCol, curDr);
				} else if(map[tempRow][tempCol] >= 6 && map[tempRow][tempCol] <= 10) {
					// 웜홀을 만나면 wormHole메서드 실행
					int[] tmpArr;
					tmpArr = wormHole(tempRow, tempCol);
					// 위치 바꿔주기
					tempRow = tmpArr[0];
					tempCol = tmpArr[1];
				}
			}
		}
	}
	
	
	static int[] wormHole(int tempRow, int tempCol) {
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				if(map[row][col] == map[tempRow][tempCol] && (row != tempRow || col != tempCol)) {
					// 맵에 다른 위치에서 같은 값을 발견하면 그 위치를 저장해두고 리턴
					tempRow = row;
					tempCol = col;
					int[] arr = {tempRow, tempCol};
					return arr;
				}
			}
		}
		
		return null;
	}

	static int block(int tempRow, int tempCol, int dr) {
		switch (map[tempRow][tempCol]) {
		// 블록 케이스별로 방향바꿔주고 블록을 부딪혔으므로 점수를 더해준다.
		// 방향은 상 우 하 좌
		case 1 :
			if(dr == 0 || dr == 1) dr = (dr+2) % 4;
			else if (dr == 2) dr = 1;
			else dr = 0;
			score++;
			break;
		case 2 : 
			if(dr == 1 || dr == 2) dr = (dr+2) % 4;
			else if(dr == 0) dr = 1;
			else dr = 2;
			score++;
			break;
		case 3 :
			if(dr == 2 || dr == 3) dr = (dr+2) % 4;
			else if(dr == 0) dr = 3;
			else dr = 2;
			score++;
			break;
		case 4 :
			if(dr == 0 || dr == 3) dr = (dr+2) % 4;
			else if(dr == 1) dr = 0;
			else dr = 3;
			score++;
			break;
		case 5 :
			dr = (dr+2) % 4;
			score++;
			break;
		}
		return dr;
	}

	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) {
			// 맥스값 초기화
			maxScore = 0;
			input();
			
			for(int row = 0; row < size; row++) {
				for(int col = 0; col < size; col++) {
					// 출발 가능한 곳에서 핀볼게임 시작
					if(map[row][col] == 0) pinball(row, col);
				}
			}
			
			sb.append("#"+tc+" "+maxScore+"\n");
		}
		System.out.println(sb);
	}
}