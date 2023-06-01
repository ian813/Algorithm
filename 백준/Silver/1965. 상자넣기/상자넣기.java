import java.util.Scanner;

public class Main {
	static int n, max;
	static int[] box, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 박스 개수
		box = new int[n]; // 박스크기
		dp = new int[n]; // 디피
		
		for(int i = 0; i < n; i++) {
			box[i] = sc.nextInt();
		}
		
		sc.close();
		
		max = 0; // 최댓값 담을 변수
		
		solve();
		
		System.out.println(max);
	}
	
	static void solve() {
		
		dp[0] = 1; // 처음 상자는 dp값 1로 초기화
		
		// 현재 인덱스와 그 전 인덱스들을 비교해주면서
		for(int curIdx = 1; curIdx < n; curIdx++) {
			for(int idx = 0; idx < curIdx; idx++) {
				if(box[idx] < box[curIdx]) { // 현재 상자 크기가 더 크면
					// 현재 상자의 dp배열에 그 전의 상자 중 작은 상자의 dp값과 현재 상자의 dp값 중 최댓값을 저장
					dp[curIdx] = Math.max(dp[curIdx], dp[idx]);
				}
			}
			// 현재 dp값의 갱신이 끝났으면 1 더해줌 (현재 상자도 포함되어야 하므로)
			dp[curIdx]++;
			// 그 다음 바로 최댓값 갱신
			max = Math.max(dp[curIdx], max);
		}
	}
}