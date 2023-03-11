import java.util.Scanner;

public class Main {
	static int size;
	static int[][] board;
	static int appleNum;
	static int directionNum;
	static char[] directionInfo;
	static int[] changeTime;
	static int endTime;	
	static final int apple = 2;
	
	static void input() {
		Scanner sc= new Scanner(System.in);
		// 보드 크기
		size = sc.nextInt();
		// 보드 배열
		board = new int[size+1][size+1];
		// 사과 개수
		appleNum = sc.nextInt();
		
		// 사과의 개수만큼 반복해서
		// 해당 위치에 사과를 넣어줌
		for(int num = 0; num < appleNum; num++) {
			int tmpRow = sc.nextInt();
			int tmpCol = sc.nextInt();
			
			board[tmpRow][tmpCol] = apple;
			
		}
		
		// 방향전환 횟수
		directionNum = sc.nextInt();
		// 시간과 방향전환 정보를 담을 배열
		directionInfo = new char[directionNum];
		changeTime = new int[directionNum];
		
		// 방향을 바꿀 시간 정보는 int형으로,
		// 방향 정보를 char 형으로 받아주기
		for(int idx = 0; idx < directionNum; idx++) {
			changeTime[idx] = sc.nextInt();
			directionInfo[idx] = sc.next().charAt(0);
		}
	
		// 끝나는 시간을 받을 변수
		endTime = 0;
	}
	
	static void move() {
		input();
		
		// 머리 위치를 나타낼 변수
		int headRow = 1;
		int headCol = 1;
		
		// 꼬리 위치를 나타낼 변수
		int tailRow = 1;
		int tailCol = 1;
		
		// 우 하 좌 상 순서
		int[] deltaRow = {0, 1, 0, -1};
		int[] deltaCol = {1, 0, -1, 0};
		
		// 머리 방향을 나타낼 변수
		int headDirection = 0;
		// 꼬리 방향을 나타낼 변수
		int tailDirection = 0;
		
		// 비교할 시간
		int tmpHeadTime = 0;
		int tmpTailTime = 0;
		
		// 머리가 방향을 바꾸는 시간값
		int headTime = 0;
		// 꼬리가 방향을 바꾸는 시간값
		int tailTime = 0;
		
		// 초기 뱀의 위치에도 1 저장
		board[headRow][headCol] = 1;
		
		while(true) {
			
			// 탐색할 위치
			int newRow = headRow + deltaRow[headDirection];
			int newCol = headCol + deltaCol[headDirection];

			// 배열의 범위를 벗어나면 종료
			if(newRow < 1 || newCol < 1 || newRow > size || newCol > size) {
				headTime++;
				break;
			}
					
			if(board[newRow][newCol] == apple) {
				// 탐색 위치에 사과가 있을 때
				// 머리 시간만 늘려줌
				headTime++;
				// 그 위치에 값을 1로 바꿔주고
				board[newRow][newCol] = 1;

				// 머리 위치를 업데이트
				headRow = newRow;
				headCol = newCol;
				
			} else if(board[newRow][newCol] == 1) {
				// 탐색 위치에 몸통이 있을 때
				// 머리 시간만 늘려주고 종료
				headTime++;
				break;
			} else {
				// 탐색 위치에 아무것도 없을 때
				// 머리 시간 늘려주고
				headTime++;
				// 그 위치에 값을 1로 바꿔주고
				board[newRow][newCol] = 1;
				// 머리 위치를 업데이트
				headRow = newRow;
				headCol = newCol;
				// 꼬리 시간 늘려주고
				tailTime++;
				// 현재 꼬리위치 값을 0으로 바꿔주고
				board[tailRow][tailCol] = 0;
				// 꼬리 위치도 업데이트
				tailRow += deltaRow[tailDirection];
				tailCol += deltaCol[tailDirection];
			}
			
			// 방향전환 정보만큼만 비교
			if(tmpHeadTime < directionNum) {
				// 머리가 방향을 바꿔줄 시간이 되면
				if(headTime == changeTime[tmpHeadTime]) {
					if(directionInfo[tmpHeadTime] == 'D') {
						// 방향 정보가 D면 direction을 +1
						// 배열 범위 넘어가지 않게 나머지를 사용
						headDirection = (headDirection + 1) % 4;
					} else {
						// 방향 정보가 L면 direction을 +3
						// 배열 범위 넘어가지 않게 나머지를 사용
						headDirection = (headDirection + 3) % 4;
					}
					// 비교가 끝나면 다음 비교를 위해
					// 카운트
					tmpHeadTime++;
					
				}
			}
			
			// 방향전환 정보만큼만 비교
			if(tmpTailTime < directionNum) {
				// 꼬리가 방향을 바꿔줄 시간이 되면
				if(tailTime == changeTime[tmpTailTime]) {
					if(directionInfo[tmpTailTime] == 'D') {
						// 방향 정보가 D면 direction을 +1
						// 배열 범위 넘어가지 않게 나머지를 사용
						tailDirection = (tailDirection + 1) % 4;
					} else {
						// 방향 정보가 L면 direction을 +3
						// 배열 범위 넘어가지 않게 나머지를 사용
						tailDirection = (tailDirection + 3) % 4;
					}
					// 비교가 끝나면 다음 비교를 위해
					// 카운트
					tmpTailTime++;
				}
			}

			
		}	
		// 와일문을 나왔을 때
		// 머리 시간을 끝나는 시간에 대입
		endTime = headTime;
		
		// 출력
		System.out.println(endTime);
		
	}
	
	public static void main(String[] args) {
		move();
	}
}
