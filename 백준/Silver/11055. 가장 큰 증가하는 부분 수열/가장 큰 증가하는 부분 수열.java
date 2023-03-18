import java.util.Scanner;

public class Main {
	static int N;
	static int[] numArr;
	static int[] sumArr;
	
	static int max;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		// N번 인덱스까지 갖도록 배열 생성
		numArr = new int[N + 1];
		
		// 배열에 값 입력받기
		for(int idx = 1; idx <= N; idx++) {
			numArr[idx] = sc.nextInt();
		}
		
		sc.close();
		
		// 합을 담을 배열
		sumArr = new int[N+1];
		
		max = 0;
	}
	
	static void solve() {
		input();
		
		// N까지 탐색
		for(int idx = 1; idx <= N; idx++) {
			int tmpMax = 0;
			
			for(int tmpIdx = 0; tmpIdx < idx; tmpIdx++) {
				// idx보다 작은 인덱스를 탐색
				if(numArr[tmpIdx] < numArr[idx]) {
					// tmpMax에 값 저장 
					tmpMax = sumArr[tmpIdx];
					// 최댓값 갱신
					sumArr[idx] = Math.max(tmpMax, sumArr[idx]);
				}	
			}
			// for문 돌면서 최댓값 갱신이 끝나면
			// 그 위치에 있는 수도 더해서 저장
			sumArr[idx] += numArr[idx];
		}
		
		// sumArr에 값 저장이 다 끝났으므로
		// 그 안에서 최댓값 찾아서 갱신
		for(int idx = 1; idx <= N; idx++) {
			max = Math.max(sumArr[idx], max);
		}
		
		// 최댓값 출력
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		solve();
	}
}