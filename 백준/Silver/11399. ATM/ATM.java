import java.util.Scanner;

public class Main {
	
	// 사람수 N과 각 사람이 인출하는데 걸리는 시간 데이터를 받을 배열, 인출하는데 걸리는 최소 시간을 받을 전역 변수 생성
	static int N;
	
	static int[] time; 

	static int minSum;
	
	static int[] rank;
	
	// input을 받을 메서드 생성
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// 사람 수 N, 각 사람이 걸리는 시간을 나타내는 배열 time
		// 시간을 걸리는 순서대로 순위를 매긴 배열을 rank
		N = sc.nextInt();
		
		time = new int[N];
		
		rank = new int[N];
		
		// time 배열에 입력받기
		for(int idx = 0; idx < time.length; idx++) {
			time[idx] = sc.nextInt();
		}
		
		// time배열을 인덱스별로 순위 매기기
		for(int idx1 = 0; idx1 < rank.length; idx1++) {
			// 순위를 셀 변수
			int cnt = 1;
			
			// 배열을 돌면서 탐색
			for(int idx2 = 0; idx2 < rank.length; idx2++) {
				
				if(time[idx1] < time[idx2]) {
					// 더 큰 값을 만나면 순위를 증가시킨다.
					cnt++;
				} else if(time[idx1] == time[idx2]) {
					// 중복된 숫자가 나올 때의 처리가 중요!
					if(idx1 < idx2) {
						// 중복된 숫자일 때는 임의로 순위를 매기자.
						// 값이 같다면 인덱스값이 작은 수의 순위를
						// 더 낮은 순위로 매겨준다.
						cnt++;
					}
				}
			}
			// 순위값을 rank 배열에 저장.
			rank[idx1] = cnt;
		}
		
	}
	
	// 목적 : 최소 시간 구하기
	// 방법 : time배열 안에 있는 각 시간을 그 시간의 순위만큼 곱해주면 된다.
	// why? 최소 시간을 쓰려면
	// 제일 시간이 많이 걸리는 (순위가 1위) 사람은 제일 나중에 와야한다.
	// 즉 시간*1만큼 총 시간에 더해진다.
	// 순위가 2위인 사람은 마지막에서 두번째로 와야한다.
	// 즉 순위가 2위인 사람의 시간은 순위가 2위인 당사자가 쓸 때와 1위인 사람이 쓸 때 2번이므로
	// 시간*2만큼 총 시간에 더해진다.
	static int minTime(int[] timeArr, int[] rankArr) {
		minSum = 0;
		
		// 배열을 돌면서 시간*랭크를 더해준다.
		for(int idx = 0; idx < timeArr.length; idx++) {
			minSum += timeArr[idx] * rankArr[idx];
		}
		
		// 시간값 반환
		return minSum;
	}
	
	
	public static void main(String[] args) {
		// input 메서드 실행
		input();
		
		///minTime 메서드 실행
		minTime(time, rank);
		
		// 결과값 출력
		System.out.println(minSum);
		
	}
}
