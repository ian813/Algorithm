import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int size, fakeCnt, realCnt; // 그림 크기, 색맹 구역, 진짜 구역
	static char[][] picture; // 그림 정보
	static boolean[][] fakeVisited, realVisited; // 방문체크(색맹, 진짜)
	static final int[] delR = { -1, 1, 0, 0 }; // 델타배열(상하좌우 탐색)
	static final int[] delC = { 0, 0, -1, 1 };

	// 좌표를 담을 포인트 클래스
	static class Point {
		int row;
		int col;

		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		// 공백없이 줄로만 되어 있어서 stringtokenizer 필요 없음!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine()); // 그림 크기

		picture = new char[size][size];
		fakeVisited = new boolean[size][size];
		realVisited = new boolean[size][size];

		// 그림에 색칠 정보 입력받기
		for (int i = 0; i < size; i++) {
			String str = br.readLine();
			for (int j = 0; j < size; j++) {
				picture[i][j] = str.charAt(j);
			}
		}
		// 카운트 개수 초기화
		fakeCnt = 0;
		realCnt = 0;

		// 각 위치별로 방문 안했으면 탐색을 해보자. (색맹일 때 아닐 때 나눠서)
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (!fakeVisited[row][col]) { // 색맹인 사람이 방문 안 했을 때
					fakeVisited[row][col] = true; // 방문체크
					fakeBFS(row, col); // 탐색
					fakeCnt++; // 카운트
				}
				
				if (!realVisited[row][col]) { // 색맹이 아닌 사람이 방문 했을 때
					realVisited[row][col] = true; // 방문체크
					realBFS(row, col); // 탐색
					realCnt++; // 카운트
				}
			}
		}
		
		System.out.println(realCnt + " " + fakeCnt);

	}

	// BFS로 탐색
	static void realBFS(int row, int col) {
		Queue<Point> queue = new LinkedList<>();

		// 처음 위치 담아주고
		queue.add(new Point(row, col));

		while (!queue.isEmpty()) {
			// 큐가 빌때까지 뽑아주면서 반복
			Point tmp = queue.poll();

			// 현재 위치 저장
			int r = tmp.row;
			int c = tmp.col;

			for (int dr = 0; dr < 4; dr++) { // 델타배열로 탐색
				int nr = r + delR[dr];
				int nc = c + delC[dr];

				if(nr < 0 || nr >= size || nc < 0 || nc >= size) continue; // 배열 범위 넘어가면 넘기기
				
				if(realVisited[nr][nc]) continue; // 방문했으면 넘기기
				
				if (picture[nr][nc] == picture[r][c]) { // 현재 위치와 탐색 위치에 색이 같으면
					realVisited[nr][nc] = true; // 색맹 아닌 사람 방문체크
					queue.add(new Point(nr, nc)); // 큐에 담아주기
				}

			}
		}
	}

	// BFS로 탐색
	static void fakeBFS(int row, int col) {
		Queue<Point> queue = new LinkedList<>();

		// 처음 위치 담아주고
		queue.add(new Point(row, col));

		while (!queue.isEmpty()) {
			// 큐가 빌때까지 뽑아주면서 반복
			Point tmp = queue.poll();

			// 현재 위치 저장
			int r = tmp.row;
			int c = tmp.col;

			for (int dr = 0; dr < 4; dr++) { // 델타배열로 탐색
				int nr = r + delR[dr];
				int nc = c + delC[dr];
				
				if(nr < 0 || nr >= size || nc < 0 || nc >= size) continue; // 배열 범위 넘어가면 넘기기

				if(fakeVisited[nr][nc]) continue; // 방문했으면 넘기기
				
				if (picture[nr][nc] == picture[r][c] || (picture[r][c] != 'B' && picture[nr][nc] != 'B')) { // 현재 위치와 탐색 위치에 색이 같거나 둘 다 파란색이 아니면
					fakeVisited[nr][nc] = true; // 색맹인 사람 방문체크
					queue.add(new Point(nr, nc)); // 큐에 담아주기
				}

			}

		}

	}

}