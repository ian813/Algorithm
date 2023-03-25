import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int meetingNum;
	static int[][] meeting;
	static int[] meetingCnt;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 회의 수
		meetingNum = sc.nextInt();
		meeting = new int[meetingNum][2];
		
		// 회의시간 정보 받기
		for(int row = 0; row < meetingNum; row++) {
			for(int col = 0; col < 2; col++) {
				meeting[row][col] = sc.nextInt();
			}
		}
		// 회의시간을 끝나는 시간이 빠른 순서대로 정렬...
		Arrays.sort(meeting, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	// 두번쨰 숫자가 같을 경우 첫 번째 숫자 기준 오름차순 정렬
		    	if(o1[1] == o2[1]) {
		    		return o1[0] - o2[0];
		    	}
		    	
		        return o1[1]-o2[1]; // 두번째 숫자 기준 오름차순

		    }
		});
		
		meetingCnt = new int[meetingNum];
	}
	
	// 회의 끝나는 시간이 빠른게 중요
	static void dp() {
		input();
		// 첫번째 회의가 가장 빨리 끝나므로 카운팅
		meetingCnt[0] = 1;
		
		// 비교할 데이터의 인덱스
		int tmpIdx = 0;
		
		for(int idx = 1; idx < meetingNum; idx++) {
			if(meeting[tmpIdx][1] <= meeting[idx][0]) { // 지금 회의의 시작 시간이 이전에 사용했던 회의 시간보다 늦는다면
				meetingCnt[idx] = meetingCnt[tmpIdx] + 1; // 카운팅해주고
				tmpIdx = idx; // 인덱스도 갱신
			}
		}
		
		int max = 0;
		
		for(int idx = 0; idx < meetingNum; idx++) {
			// 카운팅 끝났으니 최댓값만 찾아주면 끝!
			max = Math.max(max, meetingCnt[idx]);
		}
		// 출력
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		dp();
	}
}
