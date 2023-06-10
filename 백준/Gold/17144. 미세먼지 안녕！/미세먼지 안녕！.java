import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T, ans; // 행, 열, 시간, 답
	static int[][] map; // 맵정보	
	static int[] cleaner; // 공기청정기 위치
	static Queue<Dust> queue; // 먼지 정보를 저장할 큐
	// 델타배열 (상하좌우)
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	// 먼지의 좌표와 양을 담아줄 클래스
	static class Dust{
		int r, c, w;
		
		Dust(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		cleaner = new int[2]; // 공기청정기의 행정보 (열은 항상 0)
		int idx = 0;
		
		map = new int[R][C]; // 맵 생성
		
		// 맵에 정보 입력받기
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) { // 공기청정기 위치 저장
					cleaner[idx++] = i;
				}
			}
		}
		
		for(int t = 0; t < T; t++) { // 시간만큼 반복
			isDust();
			
			spread();
			
			clean();
		}
		cal();
		
		System.out.println(ans);
	}
	
	// 먼지 위치 저장할 메서드
	static void isDust() {
		queue = new LinkedList<>();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) {
					// 먼지가 존재하면 큐에 넣어준다.
					queue.add(new Dust(i, j, map[i][j]));
				}
			}
		}
	}
	
	// 먼지를 확산시킬 메서드
	static void spread() {
		
		while(!queue.isEmpty()) { // 큐가 빌 때까지 실행
			Dust cur = queue.poll();
			
			// 확산시킬 먼지 없으면 넘기기
			if(cur.w < 5) continue;
			
			int weight = cur.w/5; // 확산시킬 먼지의 양
			int cnt = 0; // 확산시킨 칸의 개수
			
			// 델타배열로 확산시키자
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue; // 배열범위 넘어가면 넘기기
				if(map[nr][nc] == -1) continue; // 공기청정기 있어도 넘기기
				
				map[nr][nc] += weight; // 둘 다 아니면 먼지 확산시키기
				cnt++; // 확산된 칸 수 카운트
			}
			
			// 현재 위치에 미세먼지양 감소시켜주기(확산되었으므로)
			map[cur.r][cur.c] -= weight*cnt;
		}
	}
	
	// 공기청정기 작동시킬 메서드
	static void clean() {
		// 공기청정기 위,아래 위치 저장
		int top = cleaner[0];
		int bottom = cleaner[1];
		
		// 위쪽 공기청정기는 반시계, 아래쪽 공기청정기는 시계방향 순환
        // 아래로 당기기
		for (int i = top - 1; i > 0; i--) 
            map[i][0] = map[i-1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) 
            map[0][i] = map[0][i+1];
        // 위로 당기기
        for (int i = 0; i < top; i++) 
            map[i][C - 1] = map[i + 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
            map[top][i] = map[top][i-1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[top][1] = 0;
        
        // 위로 당기기
        for (int i = bottom + 1; i < R - 1; i++) 
            map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) 
            map[R - 1][i] = map[R - 1][i + 1]; 
        // 아래로 당기기
        for (int i = R - 1; i > bottom; i--) 
            map[i][C - 1] = map[i - 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
            map[bottom][i] = map[bottom][i - 1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[bottom][1] = 0;
	}
	
	// 남아있는 먼지 양 계산
	static void cal() {
		ans = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue; // 공기청정기면 넘기기
				ans += map[i][j]; // 공기청정기 아닌 부분의 모든 칸에 있는 미세먼지 양 더하기
			}
		}
	}
}
