import java.util.Scanner;

public class Main {
	static int people;
	
	static int[][] stat;
	
	static boolean[] visit;
	
	static int min;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 사람 수
		people = sc.nextInt();
		// 능력치 저장
		stat = new int[people][people];
		
		for(int row = 0; row < stat.length; row++) {
			for(int col = 0; col < stat.length; col++) {
				stat[row][col] = sc.nextInt();
				
			}
		}
		

		// 방문 체크
		visit = new boolean[people];

		
		// 최소값 설정
		min = Integer.MAX_VALUE;
	}
	
	static void combination(int idx, int depth) {
		
		if(depth == people / 2) {
			// 원하는 수만큼 조합이 모이면
			findDiff();
			return;
		}
		
		for(int i = idx; i < people; i++) {
			// 방문헀으면 넘어감
			if(visit[i]) {
				continue;
			}
			// 방문 안했으면 방문 체크
			visit[i] = true;
			// 재귀 호출
			combination(i+1, depth+1);
			// 재귀 끝나면 방문 해제
			visit[i] = false;
		}
		
	}
	
	static void findDiff() {
		// 스타트팀과 링크팀의 능력치 저장
		int startTeam = 0;
		int linkTeam = 0;
		
		for(int row = 0; row < people - 1; row++) {
			for(int col = row+1; col < people; col++) {
				// 대각선 위쪽만 탐색해주면 충분
				
				// row와 col에 해당하는 사람이 true면 스타트팀 배정
				if(visit[row] && visit[col]) {
					// 스타트팀에 능력치 더해주기
					startTeam += stat[row][col] + stat[col][row];
				} else if (!visit[row] && !visit[col]) {
					// 둘 다 false면 링크팀 배정
					linkTeam += stat[row][col] + stat[col][row];
				}
				
			}
			
		}
		// 두 팀의 점수차 계산
		int tmpMin = Math.abs(linkTeam - startTeam);
		
		// 최소값 갱신
		min = Math.min(tmpMin, min);
		
		
	}
	
	public static void main(String[] args) {
		input();
		combination(0, 0);
		System.out.println(min);
	}
}