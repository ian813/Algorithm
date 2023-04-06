import java.util.Scanner;

public class Main {
	static int R, C; // 단어 개수 및 길이
	static char[][] alphabet; // 알파벳 받을 배열
	static boolean[] visited; // 지나온 알파벳인지 판단할 배열
	// 델타배열
	static int[] delR = {-1, 1, 0, 0};
	static int[] delC = {0, 0, -1, 1};
	static int cnt, maxCnt; // 칸 수를 세줄 변수, 그 중 최댓값 저장할 변수
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		alphabet = new char[R][C];
		
		for(int row = 0; row < R; row++) {
			String str = sc.next();
			for(int col = 0; col < C; col++) {
				alphabet[row][col] = str.charAt(col);
			}
		}
		
		// 알파벳이 26개이니까..
		visited = new boolean[26];
	}
	
	static void search(int r, int c) {
		// 기저 조건??
		
		// 현재 위치
		int tempRow = r;
		int tempCol = c;
		
		// 델타배열로 탐색
		for(int dr = 0; dr < 4; dr++) {
			// 탐색위치가 범위밖이거나 이미 탐색한 알파벳이 있는 곳이면 넘어감
			if(tempRow + delR[dr] < 0 || tempCol + delC[dr] < 0 || tempRow + delR[dr] >= R || tempCol + delC[dr] >= C
					|| visited[alphabet[tempRow+delR[dr]][tempCol+delC[dr]]-'A']) {
				continue;
			}
			
			// 탐색한 곳 아니면
			visited[alphabet[tempRow+delR[dr]][tempCol+delC[dr]]-'A'] = true; // 방문 체크
			cnt++; // 카운트
			maxCnt = Math.max(maxCnt, cnt); // 최댓값 갱신
			search(tempRow+delR[dr], tempCol+delC[dr]); // 탐색한 곳에서 재귀 호출
			cnt--; // 카운트 다시 감소
			visited[alphabet[tempRow+delR[dr]][tempCol+delC[dr]]-'A'] = false; // 방문 해제
		}
		
	}
	
	public static void main(String[] args) {
		input();
		// 카운트값들 초기화
		cnt = 1;
		maxCnt = 1;
		// 처음 위치 알파벳 방문체크
		visited[alphabet[0][0]-'A'] = true;
		
		// 탐색 시작
		search(0, 0);
		
		System.out.println(maxCnt);
	}
}
