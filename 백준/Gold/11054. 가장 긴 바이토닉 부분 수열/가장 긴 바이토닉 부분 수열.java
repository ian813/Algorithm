import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxLength;
	static int[] sequence;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수열의 크기
		N = Integer.parseInt(br.readLine());
		
		// 수열을 담을 배열
		sequence = new int[N+2];
		
		st = new StringTokenizer(br.readLine().trim());
		
		// 수열정보 입력받기
		for(int i = 1; i <= N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		calLength();
		
		System.out.println(maxLength);
	}
	
	// dp 배열에 첫 행에는 증가하는 길이, 두 번쨰행에는 감소하는 길이를 담을 것(역방향으로 증가하는 길이를 담으면 된다.)
	static void calLength() {
		// dp 배열
		dp = new int[2][N+2];
		// 정방향
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < i; j++) {
				if(sequence[i] > sequence[j]) { // 현재 값이 예전 값보다 증가했을 때
					if(dp[0][i] <= dp[0][j]) { // 현재 저장된 길이값이 예전 값에 저장된 길이값보다 작거나 같으면
						dp[0][i] = dp[0][j] + 1; // 하나 더해서 저장
					}
				}
			}
		}
		// 역방향
		for(int i = N; i > 0; i--) {
			for(int j = N+1; j > i; j--) {
				if(sequence[i] > sequence[j]) { // 현재 값이 예전 값보다 증가했을 때
					if(dp[1][i] <= dp[1][j]) { // 현재 저장된 길이값이 예전 값에 저장된 길이값보다 작거나 같으면
						dp[1][i] = dp[1][j] + 1; // 하나 더해서 저장
					}
				}
			}
		}
		
		maxLength = 0; // 길이 최댓값 초기화
		
		// 같은 열에 저장된 dp값을 더해준 다음 1을 빼주면 증가했다 감소하는(정방향으로 증가했다가 역방향으로 증가하는 것과 같음) dp값과 같게 된다.
		// 일단 같은 열에 저장된 dp값을 더해준 값들 중 최댓값을 구해준다.
		for(int i = 1; i <= N; i++) {
			maxLength = Math.max(maxLength, dp[0][i] + dp[1][i]);
		}
		
		// 구한 최대길이에 1을 빼주면 끝
		maxLength--;
	}
}
