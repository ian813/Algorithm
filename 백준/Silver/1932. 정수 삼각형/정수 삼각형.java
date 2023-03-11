import java.util.Scanner;

public class Main {
	static int size;
	
	static int[][] triangle;
	
	static int[][] maxSum;
	
	static int max;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 삼각형 크기
		size = sc.nextInt();
		// 삼각형 생성
		triangle = new int[size+1][size+1];
		
		// 문제에 제시된 형태로
		// 값 입력받기
		for(int row = 1; row <= size; row++) {
			for(int col = 1; col <= row; col++) {
				triangle[row][col] = sc.nextInt();
			}
		}
		
		// 각 위치에서의 최댓값을 담을 배열 생성
		maxSum = new int[size+1][size+1];
		
	}
	
	static void sum() {
		input();
		
		// 첫 자리에 최댓값을 저장
		maxSum[1][1] = triangle[1][1];
		
		// 배열 돌면서
		// 최댓값을 구해보자.
		for(int row = 2; row <= size; row++) {
			for(int col = 1; col <= row; col++) {
				// 바로 위쪽 행의 col-1, col 부분 중 최댓값을 저장하고 현재 위치의 값을 더해주면 된다.
				maxSum[row][col] = Math.max(maxSum[row-1][col-1], maxSum[row-1][col]) + triangle[row][col];
				
			}
		}
		
		// 최댓값을 저장할 변수
		max = 0;
		
		// 맨 마지막 행 탐색하면서 최댓값 찾기
		for(int idx = 1; idx <= size; idx++) {
			if(maxSum[size][idx] > max) {
				max = maxSum[size][idx];
			}
		}
		// 출력
		System.out.println(max);
	}
	
	
	public static void main(String[] args) {
		sum();
	}
}
