import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int size, cnt, houseCnt;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> house;
	// 델타배열로 탐색 (상하좌우)
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	static class Point {
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 단지 크기
		size = Integer.parseInt(br.readLine());

		// 단지 생성
		map = new int[size][size];
		house = new ArrayList<>();
		
		// 방문체크 배열 생성
		visited = new boolean[size][size];
		
		// 맵 정보 입력받기
		for(int i = 0; i < size; i++) {
			String str = br.readLine();
			for(int j = 0; j < size; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		cnt = 0; // 단지 개수 세줄 변수
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				if(!visited[row][col] && map[row][col] == 1) {
					visited[row][col] = true; // 시작점 방문처리
					houseCnt = 1; // 집 개수 세줄 변수 (처음 집 카운팅)
					BFS(row, col);
					cnt++; // 탐색 빠져나오면 단지 개수 카운팅
					house.add(houseCnt);
				}
			}
		}
		// 집 개수 오름차순 정렬
		Collections.sort(house);
		
		StringBuilder sb = new StringBuilder();
		// 단지 개수 담기
		sb.append(cnt + "\n");
		
		// 단지별 집 개수 담기
		for(int i = house.size() - cnt; i < house.size(); i++) {
			sb.append(house.get(i) + "\n");
		}
		System.out.println(sb);
	}
	
	static void BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(r, c));
		
		while(!queue.isEmpty()) {
			// 현재 지점
			Point cur = queue.poll();
			
			// 델타배열로 탐색
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr < 0 || nr >= size || nc < 0 || nc >= size) continue; // 배열 범위 넘어가면 넘기기
				
				if(visited[nr][nc] || map[nr][nc] == 0) continue; // 방문한 곳이거나 집이 아니면 넘기기
				
				// 조건 다 통과했으면 갈 수 있는 곳이므로 방문처리하고 큐에 담아주기
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc));
				// 추가할 때마다 집 카운팅
				houseCnt++;
			}
		}
	}
}
