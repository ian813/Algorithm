import java.util.Scanner;

public class Main {
	// 1부터 N까지의 자연수 중 중복포함 비내림차순으로 M개 고르기
	static int N;
	static int M;
	static boolean[] flag;
	static int[] sol;
	
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		sol = new int[M];
		
		flag = new boolean[N+1];
		
	}
	
	static void recursion(int idx) {
		
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(sol[i] + " ");
			}
			System.out.println(); 
			return; // 리턴이 없으면 재귀함수가 멈추지 않는다,,
		}
		
		for(int i = 1; i <= N; i++) {
			if(flag[i]) { // 이미 방문한 숫자는 또 방문할 필요가 없음
				continue; // 바로 다음 i를 본다.
			}
			sol[idx] = i; // 방문 안 한 곳이므로 방문
			
			for(int idx1 = i-1; idx1 >=0; idx1--) {
				flag[idx1] = true; // 현재 인덱스보다 작거나 같은 모든 지점을 방문했다고 체크
			}
			
			
			recursion(idx + 1);
			
			// 재귀가 끝나고 돌아온 시점에는 for문으로 넘어가면서 방문을 안하게 됨
			// ex) idx = 1이고 sol[idx] = 2일 경우, 다음 재귀함수를 호출하고 돌아왔기 때문에 다음에는 sol[idx] = 3이 되니까
			// 2는 방문하지 않은 것이 된다.
			// 따라서 방문 안 했다고 다시 바꿔주기
			for(int idx2 = i-1; idx2 >= 0; idx2--) {
				flag[idx2] = false; // 현재 인덱스보다 작은 모든 지점을 다시 방문 안했다고 바꿔주기
			}	
			
		}
		
	}
	
	static void solve() {
		input();
		recursion(0);
	}
	
	public static void main(String[] args) {
		solve();
	}
}