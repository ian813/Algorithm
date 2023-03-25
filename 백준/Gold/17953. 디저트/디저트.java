import java.util.Scanner;

public class Main {
	static int date;
	static int dessert;
	static int[][] satisfied;
	static int[][] maxSatisfied;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// 날짜, 디저트 종류
		date = sc.nextInt();
		dessert = sc.nextInt();
		
		// 만족도 정보
		satisfied = new int[dessert][date];
		
		for(int row = 0; row < dessert; row++) {
			for(int col = 0; col < date; col++) {
				satisfied[row][col] = sc.nextInt();
			}
		}
		
		maxSatisfied = new int[dessert][date];
		
		sc.close();
	}
	
	static void dp() {
		input();
		
		// 초기 만족도 저장
		for(int idx = 0; idx < dessert; idx++) {
			maxSatisfied[idx][0] = satisfied[idx][0];
		}

		
		for(int col = 1; col < date; col++) {
			for(int row = 0; row < dessert; row++) {
				// 임시 최댓값
				int tmpMax = 0;
				for(int tmpRow = 0; tmpRow < dessert; tmpRow++) {
					if(tmpRow != row) {
						// 전날의 현재 디저트와 다른 디저트들에 저장된 값 중에 최댓값을 구해보자.
						tmpMax = Math.max(maxSatisfied[tmpRow][col-1], tmpMax);
					}
				}
				
				// 날짜에 따라 최댓값을 구해보자.
				// 전날이랑 같은 걸 먹으면 현재 만족도/2를 더해주고 다른걸 먹으면 현재 만족도를 더해줘서 더 큰 값을 저장
				maxSatisfied[row][col] = Math.max(maxSatisfied[row][col-1] + satisfied[row][col]/2, tmpMax + satisfied[row][col]);				
			}
		}
		// 마지막 날 만족도 중에 최댓값 구해주고
		int max = 0;
		for(int row = 0; row < dessert; row++) {
			max = Math.max(maxSatisfied[row][date-1], max);

		}
		
		// 출력
		System.out.println(max);
		
	}
	
	public static void main(String[] args) {
		dp();
	}
}
