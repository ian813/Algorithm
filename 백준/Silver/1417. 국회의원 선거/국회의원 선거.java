import java.util.Scanner;

public class Main {
	static int N, max, ans;
	static int[] vote;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 후보 수 (다솜이는 제외)
		vote = new int[N-1];
		// 다솜이의 득표수
		max = sc.nextInt();
		// 나머지 사람 득표수
		for(int idx = 0; idx < vote.length; idx++) {
			vote[idx] = sc.nextInt();
		}
		// 매수한 사람 수
		ans = 0;
	}
	
	static void solve() {
		// 최대값을 갖는 인덱스 찾아줄 변수
		int maxIdx = 0;
		while(maxIdx != -1) {
			// -1로 초기화
			maxIdx = -1;
			// 다솜이 득표수로 비교
			int tmpMax = max;
			
			// 최댓값 찾아주기
			for(int i = 0; i < vote.length; i++) {
				if(vote[i] >= tmpMax) {
					tmpMax = vote[i];
					maxIdx = i;
				}
			}
			
			if(maxIdx != -1) {
				// -1이 아니면 최댓값의 득표수 깎고, 다솜이 득표수 늘리고, 매수한 사람 수 늘리기
				vote[maxIdx]--;
				max++;
				ans++;				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		input();
		solve();
		System.out.println(ans);
	}
}