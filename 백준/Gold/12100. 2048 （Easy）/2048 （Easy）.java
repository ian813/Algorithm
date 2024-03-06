import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 상하좌우 상수로 설정
	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	private static int size, max;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		max = 0;
		map = new int[size][size];
		StringTokenizer st;
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 게임 시작
		game(0);

		// 최댓값 출력
		System.out.println(max);
	}

	// count번째 게임 시작
	private static void game(int count) {
		if (count == 5) {
			// 5번째 게임 후 최댓값 찾고 리턴
			findMax();
			return;
		}

		// 맵 복사 (각 게임에서 복사배열을 생성해서 복사해두고 그 다음 게임을 마치고 돌아왔을 때 지금 복사해둔 맵으로 복구해준다.)
		// ex) 3번째 게임 당시 맵을 복사해둠
		int[][] copy = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				copy[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < 4; i++) {// 네 방향 다 탐색
			// 한 방향으로 이동후 게임 수 카운팅
			move(i);
			game(count + 1);
			// 맵 복구 (게임 마치고 오면 위에서 복사해둔 맵으로 복구)
			// 4~5번째 게임 모두 마치고 오면 그 때 3번째 게임 당시 복사해둔 맵으로 다시 복구
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					map[j][k] = copy[j][k];
				}
			}
		}
	}

	// 한 방향으로 움직이기
	private static void move(int direction) {
		switch (direction) {
			case UP:
				for (int i = 0; i < size; i++) {
					int insertIdx = 0; // 넣어줄 인덱스
					int block = 0; // 넣을 숫자 (같은 수가 겹치는지 판단)
					for (int j = 0; j < size; j++) {
						if (map[j][i] != 0) { // 옮겨줄 숫자를 만나면 (0이면 옮길 필요 x))
							if (block == map[j][i]) { // 그 전에 넣어준 수와 같으면
								map[insertIdx - 1][i] = block * 2; // 그 전에 넣어준 위치에 *2해서 넣어주고
								block = 0; // 넣어준 수 초기화
								map[j][i] = 0; // 현재 위치에 0 넣기 (이동했으므로)
							} else { // 그 전에 넣어준 수와 같지 않으면
								block = map[j][i]; // 넣을 숫자에 현재 위치에 있는 수 저장
								map[j][i] = 0; // 현재 위치에 0넣어서 초기화 (이동했으므로)
								map[insertIdx][i] = block; // 넣어줄 위치에 숫자 넣기
								insertIdx++; // 다음에 넣어줄 위치 변경
							}
						}
					}
				}
				break;
			case DOWN:
				for (int i = 0; i < size; i++) {
					int insertIdx = size - 1;
					int block = 0;
					for (int j = size - 1; j >= 0; j--) {
						if (map[j][i] != 0) {
							if (block == map[j][i]) {
								map[insertIdx + 1][i] = block * 2;
								block = 0;
								map[j][i] = 0;
							} else {
								block = map[j][i];
								map[j][i] = 0;
								map[insertIdx][i] = block;
								insertIdx--;
							}
						}
					}
				}
				break;
			case LEFT:
				for (int i = 0; i < size; i++) {
					int insertIdx = 0;
					int block = 0;
					for (int j = 0; j < size; j++) {
						if (map[i][j] != 0) {
							if (block == map[i][j]) {
								map[i][insertIdx - 1] = block * 2;
								block = 0;
								map[i][j] = 0;
							} else {
								block = map[i][j];
								map[i][j] = 0;
								map[i][insertIdx] = block;
								insertIdx++;
							}
						}
					}
				}
				break;
			case RIGHT:
				for (int i = 0; i < size; i++) {
					int insertIdx = size - 1;
					int block = 0;
					for (int j = size - 1; j >= 0; j--) {
						if (map[i][j] != 0) {
							if (block == map[i][j]) {
								map[i][insertIdx + 1] = block * 2;
								block = 0;
								map[i][j] = 0;
							} else {
								block = map[i][j];
								map[i][j] = 0;
								map[i][insertIdx] = block;
								insertIdx--;
							}
						}
					}
				}
				break;
		}
	}

	// 최댓값 찾기
	private static void findMax() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				max = Math.max(max, map[i][j]);
	}
}