import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] gear;
	static int rotate, score; // 회전정보 개수, 최종 점수
	static int[] turn; // 각 톱니의 회전정보를 담을 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gear = new int[4][8];
		
		// 톱니바퀴 정보 입력받기
		for(int row = 0; row < 4; row++) {
			String str = br.readLine();
			for(int col = 0; col < 8; col++) {
				gear[row][col] = str.charAt(col) - '0';
			}
		}
		// 회전 정보 수 입력받기
		rotate = Integer.parseInt(br.readLine());
		
		for(int re = 0; re < rotate; re++) { // 회전 정보만큼 반복
			st = new StringTokenizer(br.readLine());
			// 회전할 톱니
			int gearN = Integer.parseInt(st.nextToken()) - 1;
			// 회전 방향
			int dr = Integer.parseInt(st.nextToken());
			
			// 각 톱니의 회전 정보를 담을 배열
			turn = new int[4];
			// 현재 톱니에 방향 저장
			turn[gearN] = dr;
			// 모든 톱니의 회전 방향 정보를 담아보자.
			spin(gearN);
			
			// 회전 정보에 따라 회전 시켜준다.
			for(int i = 0; i < 4; i++) {
				if(turn[i] == 1) {
					clockwise(i);
				} else if(turn[i] == -1) {
					counterclockwise(i);
				} else {
					continue;
				}
			}
		}
		
		// 점수 계산 후 출력
		calScore();
		System.out.println(score);
	}
	
	// 2, 6번째 열에 있는 수로 계산
	static void spin(int gearN) {
		// 좌측 톱니 회전방향
		for(int i = gearN; i > 0; i--) {
			if(gear[i][6] != gear[i-1][2]) { // 좌측 톱니와 맞닿은 부분이 다르면
				turn[i-1] = -turn[i]; // 회전 정보 저장 (반대로 회전)
			} else { // 맞닿은 부분이 같으면 바로 멈춰줌
				break;
			}
		}
		// 우측 톱니 회전방향
		for(int i = gearN; i < 3; i++) {
			if(gear[i][2] != gear[i+1][6]) { // 우측 톱니와 맞닿은 부분이 다르면
				turn[i+1] = -turn[i]; // 회전 정보 저장 (반대로 회전)
			} else { // 맞닿은 부분이 같으면 바로 멈춰줌
				break;
			}
		}
		
	}
	
	// 시계방향 회전
	static void clockwise(int n) {
		int tmp = gear[n][7];
		for(int i = 7; i > 0; i--) {
			gear[n][i] = gear[n][i-1];
		}
		gear[n][0] = tmp;
	}
	
	// 반시계방향 회전
	static void counterclockwise(int n) {
		int tmp = gear[n][0];
		for(int i = 0; i < 7; i++) {
			gear[n][i] = gear[n][i+1];
		}
		gear[n][7] = tmp;
	}
	
	// 최종 점수 계산
	static void calScore() {
		score = 0;
		for(int i = 0; i < 4; i++) {
			if(gear[i][0] == 1) {
				score += Math.pow(2, i);
			}
		}
	}
}
