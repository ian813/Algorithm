import java.util.Scanner;

public class Main {
	// 1부터 N까지의 자연수 중 중복 허용하여 M개 고르기
	static int N;
	static int M;
	static int[] sol;
	// 시간초과 떠서,, stringbuilder 사용
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		sol = new int[M];

	}
	
	static void recursion(int idx) {
		
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				// sb에 들어오는 순서대로 공백과 함께 담아준다.
				sb.append(sol[i] + " ");
			}
			// 한번 시행이 끝나면 개행해준다.
			sb.append('\n');
			return; // 리턴이 없으면 재귀함수가 멈추지 않는다,,
		}
		
		for(int i = 1; i <= N; i++) {
			
			sol[idx] = i; // sol[idx]에 i넣어주기
			
			// 재귀함수 호출
			recursion(idx + 1);
			
		}
		
	}
	
	static void solve() {
		input();
		recursion(0);
		// 다 끝나서 return 됐으면
		// sb에 저장된 문자열 그대로 프린트
		System.out.print(sb);
	}
	
	public static void main(String[] args) {
		solve();
	}
}