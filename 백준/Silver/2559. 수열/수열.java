import java.util.Scanner;

public class Main {
	static int maxSum;
	static int N;
	static int K;
	static int[] temperature;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// 온도 측정한 날짜 수와 구하려는 연속된 날짜 수
		N = sc.nextInt();
		K = sc.nextInt();
		
		temperature = new int[N];
		// 온도 입력받기
		for(int idx = 0; idx < N; idx++) {
			temperature[idx] = sc.nextInt();
		}
		// 최솟값이 음수일 수 있으므로 편하게
		// 정수범위 최솟값으로 해주자
		maxSum = Integer.MIN_VALUE;
	}
	
	static void partSum() {
		input();
		
		for(int idx = 0; idx <= N - K; idx++) {
			// 임시로 합을 담을 변수
			int tmpSum = 0;
			for(int tmpIdx = idx; tmpIdx < idx + K; tmpIdx++) {
				// 연속된 K일만큼 합 구해주기
				tmpSum += temperature[tmpIdx];
			}
			// 최댓값 갱신
			maxSum = Math.max(maxSum, tmpSum);
		}
	}
	
	public static void main(String[] args) {
		partSum();
		System.out.println(maxSum);
	}
}