import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();

	static int N, W, H; // 구슬 개수, 너비, 높이
	static int[][] map, copyMap; // 맵과 그 맵을 복사(폭탄이 터진 다음 벽돌을 저장할 배열)
	static int ans;
	static int[] selected; // 중복순열로 뽑은 값들 저장할 배열
	// 델타배열 (상,하,좌,우)
	static int[] delR = { -1, 1, 0, 0 };
	static int[] delC = { 0, 0, -1, 1 };

	static void input() {
		N = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][W];
		copyMap = new int[H][W];

		// map과 copyMap을 동시에 입력받아서 저장
		for (int row = 0; row < H; row++) {
			for (int col = 0; col < W; col++) {
				int temp = sc.nextInt();

				map[row][col] = temp;
				copyMap[row][col] = temp;
			}
		}
		// N개만큼 구슬을 뽑는다.
		selected = new int[N];
	}

	static void gravity() {
		for(int col = 0; col < W; col++) {
			for(int row = H-1; row >= 0; row--) {
				if(copyMap[row][col] == 0) {
					// 빈공간이 있다면
					for(int k = row - 1; k >= 0; k--) {
						// 그 위쪽을 탐색해서
						if(copyMap[k][col] != 0) {
							// 0이 아닌 값을 발견하면 값을 옮기고
							copyMap[row][col] = copyMap[k][col];
							// 옮긴 위치에는 0을 저장
							copyMap[k][col] = 0;
							break;
						}
					}
				}
			}
		}
	}

	static void perm(int cnt) {
		if (cnt == N) {
			// 기저 조건
			// 구슬을 쏘기 전에 맵을 원상복구 시켜준다.
			restoreMap();

			for (int i = 0; i < N; i++) {
				int bombCol = selected[i];
				
				// 구슬이 떨어지는 열에서 어떤 행에서 터질지 위치를 파악해주자.
				int bombRow = -1;
				for (int row = 0; row < H; row++) {
					if (copyMap[row][bombCol] != 0) {
						// 해당 열에서 0이 아닌 값을 갖는 행이 처음 등장하면
						// 갱신해주고 break
						bombRow = row;
						break;
					}
				}

				// 첫 번째로 만나는 벽돌 찾아서 폭탄 터뜨리는 메서드 실행
				if (bombRow != -1) {
					bomb(bombRow, bombCol, copyMap[bombRow][bombCol]);
					// 한 위치에서 구슬 쏘기로 인한 연쇄 폭파가 끝났으면
					// 중력을 이용해 아래로 정렬
					gravity();
				}

			}

			// 폭탄이 다 터졌으므로 벽돌 개수를 세주자.
			// 벽돌 개수 세줄 변수
			int blockCnt = 0;
			for (int row = 0; row < H; row++) {
				for (int col = 0; col < W; col++) {
					// 벽돌 개수 세주기
					if (copyMap[row][col] != 0)
						blockCnt++;
				}
			}
			// 최솟값 갱신 후 리턴
			ans = Math.min(ans, blockCnt);
			return;
		}

		// 중복순열을 통해 구슬을 쏠 위치를 담아준다.
		for (int idx = 0; idx < W; idx++) {
			selected[cnt] = idx;
			perm(cnt + 1);
		}

	}

	static void bomb(int r, int c, int dist) {

		if (dist == 1) {
			// 터지는 범위가 1이면 그 자리만 부수고 리턴
			copyMap[r][c] = 0;
			return;
		} else {
			// 터지는 범위가 1보다 크면
			// 그 위치 부수고
			copyMap[r][c] = 0;
			
			for (int dr = 0; dr < delC.length; dr++) {
				// 델타배열로 탐색
				int newR = r;
				int newC = c;

				for (int i = 1; i < dist; i++) {
					// 범위만큼 탐색
					newR += delR[dr];
					newC += delC[dr];

					// 맵의 크기를 넘어가면 break
					if (newR < 0 || newC < 0 || newR >= H || newC >= W) {
						break;
					}

					// 맵 범위 안이고 벽돌이 있으면
					if (copyMap[newR][newC] > 0) {
						// 그 자리부터 다시 범위만큼 부수기
						bomb(newR, newC, copyMap[newR][newC]);
					}
				}
			}
		}
	}

	// 맵 원상복구시킬 메서드
	static void restoreMap() {
		for (int row = 0; row < H; row++) {
			for (int col = 0; col < W; col++) {
				copyMap[row][col] = map[row][col];
			}
		}
	}

	public static void main(String[] args) {
		for (int tc = 1; tc <= testCase; tc++) {
			ans = Integer.MAX_VALUE;
			input();
			perm(0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}