import java.util.Scanner;

public class Main {
	// 집 개수
	static int house;
	
	// R,G,B 비용을 집의 개수만큼 받을 2차원 배열
	static int[][] cost;
	
	// 비용의 누적합을 구해줄 배열
	static int[][] totalCost;
	
	// 헷갈리니까,, R,G,B를 상수로 생성해두자.
	static final int red = 0;
	static final int green = 1;
	static final int blue = 2;
	
	// 최소 비용을 담을 변수
	static int minCost = 0;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 집 개수
		house = sc.nextInt();
		
		// R, G, B 비용 입력받기
		// 인덱스를 맞춰주기 위해,, +1해서 생성
		cost = new int[house+1][3];
		
		// 집 별 비용 입력받기
		for(int row = 1; row <= house; row++) {
			for(int col = 0; col < 3; col++) {
				cost[row][col] = sc.nextInt();
			}
		}
		
		
		// 누적비용을 구할 배열 생성
		totalCost = new int[house+1][3];
	}
	
	static void dp() {
		input();
		
		// dp를 이용해서 각 경우마다 totalCost의 최소값을 구해보자.
		// ex) 현재 집에 빨간 색을 칠할 때 totalCost의 최소값은
		// 그 전 집에 초록색을 칠할 때와 파란색을 칠할 때의 totalCost 최소값 + 현재 집에 빨간색을 칠할 때의 비용이다.
		for(int idx = 1; idx <= house; idx++) {
			totalCost[idx][red] = Math.min(totalCost[idx-1][green], totalCost[idx-1][blue]) + cost[idx][red];
			totalCost[idx][green] = Math.min(totalCost[idx-1][red], totalCost[idx-1][blue]) + cost[idx][green];
			totalCost[idx][blue] = Math.min(totalCost[idx-1][red], totalCost[idx-1][green]) + cost[idx][blue];
		}

		
		// totalCost의 최소값은 마지막 집을 빨간색, 초록색, 파란색을 칠할 때의 값 중 최소값을 구하면 된다.
		// 먼저 빨간색 초록색 중 최소값을 구한 뒤,,
		int tmpMin = Math.min(totalCost[house][red], totalCost[house][green]);
		
		// 그 최소값을 파란색과 비교해서 최소값을 구해준다.
		minCost = Math.min(tmpMin, totalCost[house][blue]);
	}
	
	public static void main(String[] args) {
		dp();
		
		// 최소값 출력!
		System.out.println(minCost);
	}
}
