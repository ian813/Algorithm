import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 정의석
 *
 * BFS로 풀어보자. (Queue 이용)
 * 각 섬을 구분하기 위해 섬 번호를 먼저 붙여준다. makeLand 메서드 이용
 * 각 섬에서 BFS를 통해서 출발해서 델타배열로 탐색
 *  -> 만약 바다면 길이를 늘려서 저장해주고
 *  같은 섬이면 넘기고 다른 섬이면 현재까지 누적된 다리 길이를 이용해
 *  최솟값을 갱신해준다.
 */
public class Main {
	
	static int size, landNum, min;
	static int[][] map;
	// 델타배열 (상하좌우)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited; // 방문체크
	
	// 포인트 클래스 (좌표와 다리 길이)
	static class Point{
		int x, y, length;
		
		Point(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		
		map = new int[size][size];
		visited = new boolean[size][size];
		
		// map에 정보 입력받기
		for(int r = 0; r < size; r++) {
			st = new StringTokenizer(br.readLine().trim());
			
			for(int c = 0; c < size; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		landNum = 2; // 섬 번호 선언
		
		// 섬마다 번호 붙여주기
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				if(map[r][c] == 1) { // 1이면 섬에 번호붙여주기					
					map[r][c] = landNum; // 섬 번호 붙여주고
					visited[r][c] = true; // 방문체크
					makeLand(r, c); // 연결된 곳에 동일한 섬 번호 붙여줄 메서드 호출
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		
		// 섬에 대해서 진행
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				if(map[r][c] > 1) {
					// 매 BFS 시행 전에 방문 배열 초기화
					visited = new boolean[size][size];
					BFS(r, c);
				}
			}
		}
		
		System.out.println(min);
	}
	
	static void makeLand(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c, 0));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.x + dr[i];
				int nc = cur.y + dc[i];
				
				// 범위 넘어가면 넘기기
				if(nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
				
				if(visited[nr][nc]) continue; // 방문한 곳 넘기기
				
				if(map[nr][nc] == 1) { // 연결된 육지면
					// 섬번호 붙이고 방문체크하고 큐에 넣어주기
					map[nr][nc] = landNum;
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc, 0));
				}
			}
		}
		landNum++; // 탐색 끝나면 섬 번호 올려주기
	}
	
	// BFS를 이용한 탐색
	static void BFS(int r, int c) {
		
		Queue<Point> queue = new LinkedList<>();
		
		// 현재 위치 정보 저장하고 현재 섬 번호도 저장
		queue.add(new Point(r, c, 0));
		
		int curLandNum = map[r][c];
		
		while(!queue.isEmpty()) {
			// 현재 위치를 가져와서
			Point cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				
				// 델타배열로 탐색
				int nr = cur.x + dr[i];
				int nc = cur.y + dc[i];
				
				// 범위 넘어가면 넘기기
				if(nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
				
				if(visited[nr][nc]) continue; // 방문한 곳도 넘기기
				
				if(map[nr][nc] == 0) { // 방문 안 한 바다면 다리길이 length + 1해서 저장
					queue.add(new Point(nr, nc, cur.length+1));
					visited[nr][nc] = true; // 방문 체크
				} else if(map[nr][nc] != curLandNum){ // 현재 섬 번호랑 다르면
					// 최솟값 갱신
					min = Math.min(min, cur.length);
				}
			}
		}
	}
}
