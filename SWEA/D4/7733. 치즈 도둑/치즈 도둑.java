import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();

	static int N;
	static int[][] map;
	static int ans;
	static boolean[][] visited; // 방문 체크
	// 탐색할 델타배열 (상, 하, 좌, 우) 방향
	static int[] deltaRow = { -1, 1, 0, 0 };
	static int[] deltaCol = { 0, 0, -1, 1 };
	static int max; // 치즈의 맛있는 정도의 최댓값
	
	// 인풋 메서드
	static void input() {
		N = sc.nextInt();
		// 맵 생성
		map = new int[N][N];
		max = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				map[row][col] = sc.nextInt();
				// 치즈의 맛있는 정도의 최댓값 구하기
				max = Math.max(map[row][col], max);
			}
		}
	}

	// 요정먹는 치즈를 표시해주자.
	static void eat(int n) {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == n) {
					map[row][col] = 0; // n번째 날에 n인 치즈들을 0으로 바꿔준다.
				}
			}
		}
	}

	static void DFS(int row, int col) {
		// 현재 위치 방문 처리
		visited[row][col] = true;
		
		// 델타배열로 탐색
		for (int dr = 0; dr < deltaCol.length; dr++) {
			if(row + deltaRow[dr] < 0 || row + deltaRow[dr] >= N ||
					col + deltaCol[dr] < 0 || col + deltaCol[dr] >= N) {
				// 배열범위 넘어가면 넘어감
				continue;
			}
			
			// 방문하지 않았고 0이 아니면 그 곳으로 갈 수 있다.
			if (!visited[row + deltaRow[dr]][col + deltaCol[dr]] && map[row + deltaRow[dr]][col + deltaCol[dr]] != 0) {
				DFS(row + deltaRow[dr], col + deltaCol[dr]);
			}
		}

	}

	public static void main(String[] args) {
		for (int tc = 1; tc <= testCase; tc++) {
			// 인풋 메서드 실행
			input();
			// 답 초기화
			ans = 0;
			// 치즈의 맛있는 정도의 최댓값까지만 탐색해주면 된다.
			for(int i = 0; i <= max; i++) {
				// 방문체크해줄 배열 (매 시행마다 초기화)
				visited = new boolean[N][N];
				// 먹은 곳을 0으로 다 바꿔주는 메서드 실행
				eat(i);
				// 임시로 덩어리를 세줄 변수
				int tmpCnt = 0;
				for(int row = 0; row < N; row++) {
					for(int col = 0; col < N; col++) {
						if(!visited[row][col] && map[row][col] != 0) { // 방문 안했고 0이 아닌 지점에서 출발
							DFS(row, col);
							// 탐색을 마치고 나오면 한 덩어리가 끝났으므로
							// 카운트
							tmpCnt++;
						}
					}
				}
				// 답을 큰 값으로 갱신
				ans = Math.max(ans, tmpCnt);
			}
			// 형식에 맞게 담아주기
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}