import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M, length, minLength;
	static int[][] map;
	static List<Point> chicken = new ArrayList<>();
	static List<Point> house = new ArrayList<>();
	static boolean[] visited;

	// 포인트 클래스 생성
	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 도시 크기
		M = sc.nextInt(); // 제거할 치킨집 수

		map = new int[N + 1][N + 1]; // 좌표를 1~N으로 사용하므로

		// 맵에 도시정보 저장
		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				map[row][col] = sc.nextInt();

				if (map[row][col] == 2) {
					// 치킨집 발견하면 좌표를 리스트에 담아주기
					chicken.add(new Point(row, col));
				} else if (map[row][col] == 1) {
					// 집 발견하면 좌표를 리스트에 담아주기
					house.add(new Point(row, col));
				}
			}
		}
		visited = new boolean[chicken.size()]; // 치킨집 방문체크

		minLength = Integer.MAX_VALUE; // 최소 도시거리 저장할 변수

		sc.close();
	}

	// 폐업시킬 치킨집 고를 메서드
	static void comb(int sIdx, int cnt) {
		if (cnt == M) { // M개 뽑으면
			minLength = Math.min(minLength, cal()); // 최솟값 갱신
			return;
		}

		for (int i = sIdx; i < chicken.size(); i++) {
			if (!visited[i]) { // 방문하지 않았으면
				visited[i] = true; // 방문체크
				comb(i+1, cnt+1); // 다음으로 넘어가고
				visited[i] = false; // 방문해제
			}
		}
	}

	// 거리계산해서 담아줄 메서드
	static int cal() {
		length = 0;
		for (int h = 0; h < house.size(); h++) {
			// 집 개수만큼 반복
			int min = Integer.MAX_VALUE;
			for (int c = 0; c < chicken.size(); c++) {
				if (visited[c]) { // 폐업 안 한 치킨집 사이의 치킨거리 구하기
					int temp = Math.abs(house.get(h).r - chicken.get(c).r) + Math.abs(house.get(h).c - chicken.get(c).c);
					// 최솟값 갱신
					min = Math.min(temp, min);
				}
			}
			// 도시 치킨거리 구하기
			length += min;

		}
		// 도시 치킨거리 반환
		return length;
	}


	public static void main(String[] args) {
		input();
		// 조합으로 뽑아주자.
		comb(0, 0);
		System.out.println(minLength);
	}
}
