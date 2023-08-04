import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static int testCase = sc.nextInt();
	static int N;
	static int K;
	static int[] numArr;
	static boolean[] check;
	static int cnt;
	
	static void input() {
		N = sc.nextInt(); // 자연수 개수
		K = sc.nextInt(); // 구할 합
		
		numArr = new int[N]; // 수열 정보
		
		for(int idx = 0; idx < N; idx++) {
			numArr[idx] = sc.nextInt();
		}
		
		check = new boolean[N];
		
	}
	
	static void powerSet(int idx) {
		if(idx == N) {
			int tmpSum = 0;
			
			for(int i = 0; i < N; i++) {
				if(check[i]) {
					tmpSum += numArr[i];					
				}
			}
			
			if(tmpSum == K) cnt++;
			
			return;
		}

		check[idx] = false; // 포함 안 시키고
		powerSet(idx+1); // 다음으로 넘어감
		check[idx] = true; // 포함 시키고
		powerSet(idx+1); // 다음으로 넘어감
		
	}
	
	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) {
			input();
			
			cnt = 0; // 경우의 수 초기화
			
			powerSet(0);
			
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(sb);
		
		
	}
}