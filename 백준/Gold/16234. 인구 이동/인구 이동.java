import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 메서드 끝에서 계산해줌. 방문 여부도 체크 -> 각 칸에 대해 상하좌우 델타배열 써줘야됨..
 * BFS로 큐에 넣어서 판단하는게 좋을 듯
 * 방문 안했으면 메서드로 탐색
 * 델타배열로 탐색을 하면서 구역만 나눠줌
 * 재탐색을 통해 인구 수 합과 나라 수를 카운팅한 다음
 * -> 이걸 인구 이동이 없을 때까지 한 뒤 인구이동 며칠동안 했는지 출력해야됨.
 * -> 날짜 카운팅을 해야됨.
 * -> 인구 이동 없는 날인지 어떻게 판단?
 * 구역이 한번이라도 나눠지면 불리안을 통해 트루 필스 바꿔주기
 * 트루면 카운팅
 */

// 포인트 클래스
class Point {
	int r, c;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {

	static int size, lowerBound, upperBound, landCnt, weight, day;
	static int[][] map;
	static boolean[][] check;
	static boolean flag;
	// 델타배열 (상하좌우)
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	static ArrayList<Point> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 맵 크기, 인접 나라의 인구 차의 경계값 입력받기
		// 인구 차가 경계값 사이에 들어가야 인구 이동을 할 수 있다.
		size = sc.nextInt();
		lowerBound = sc.nextInt();
		upperBound = sc.nextInt();

		// 맵 정보 입력받기
		map = new int[size][size];

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		sc.close();

		// 인구이동이 일어나는 날짜
		day = 0;

		flag = true;

		while (flag) {
			flag = false; // 인구이동 안되면 멈추기

			// 인구 이동이 일어나는 지점인지 체크
			check = new boolean[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					// 이미 체크한 나라인지 판단
					if (!check[i][j]) {
						// 나라 개수, 인구 수 초기화
						landCnt = 0;
						weight = 0;
						list = new ArrayList<>(); // 인구이동 시켜야하는 나라들
						// 체크 안 됐으면 메서드로 탐색
						move(i, j);

						if (list.size() > 1) { // 리스트 사이즈가 1보다 크면
							// 인구이동이 가능하므로 flag도 true로 바꾸고 인구값도 업데이트 해준다.
							changePopulation();
							flag = true;
						}
					}
				}
			}
			if (flag) {
				day++; // 인구 이동이 됐으면 날짜 카운팅
			}
		}
		System.out.println(day);
	}

	// 인구이동 가능한지 판단하는 메서드
	static void move(int r, int c) {

		Queue<Point> queue = new LinkedList<>();

		// 현재지점 방문체크, 나라 개수 카운트, 인구 수 카운트, 리스트에 현재 점 넣어주기
		check[r][c] = true;
		landCnt++;
		weight += map[r][c];
		list.add(new Point(r, c));

		queue.add(new Point(r, c));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			// 현재 지점 인구 수
			int curWeight = map[cur.r][cur.c];

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				// 새로 탐색한 곳이 배열 범위 넘어가거나 방문한 곳이면 넘기기
				if (nr < 0 || nr >= size || nc < 0 || nc >= size || check[nr][nc])
					continue;

				// 탐색 지점 인구 수
				int nextWeight = map[nr][nc];

				// 인구 수 차이
				int diff = Math.abs(nextWeight - curWeight);

				// 인구 수 차이가 경계 범위 밖이면 넘기기
				if (diff < lowerBound || diff > upperBound)
					continue;

				// 그게 아니면 방문체크하고 큐에 넣어주고, 나라 개수, 인구수 카운트, list에도 넣어줌.
				check[nr][nc] = true;
				queue.add(new Point(nr, nc));
				landCnt++;
				weight += map[nr][nc];
				list.add(new Point(nr, nc));
			}
		}
	}

	// 인구 이동하는 메서드
	static void changePopulation() {
		// 평균값 구해서
		int avg = weight / landCnt;

		// 리스트에 있는 나라들의 인구 값 바꿔주기
		for (Point pt : list) {
			map[pt.r][pt.c] = avg;
		}
	}
}
