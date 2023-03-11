import java.util.Scanner;

public class Main {
	static int stair;
	static int[] score;
	static int[] maxScore;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 계단 개수
		stair = sc.nextInt();
		// 계단 점수
		score = new int[stair+1];
		
		for(int idx = 1; idx <= stair; idx++) {
			score[idx] = sc.nextInt();
		}

		// 각 계단에서의 점수의 합을 담을 배열 (인덱스 맞추기 위해 stair+1 크기로 생성)
		maxScore = new int[stair+1];
	}
	
	static void climb() {
		input();
		// 초기값 설정
		maxScore[1] = score[1];
		
		if(stair > 1) {
			// 계단이 1개보다 많으면
			// 2번째 계단에 1번째 계단과 2번째 계단의 점수를 더해줌
			// 관계식에서 -3까지 쓰이므로,, 2까지는 지정해줘야한다.
			maxScore[2] = score[1] + score[2];
		}
		
		for(int idx = 3; idx <= stair; idx++) {
			
			// 현재 계단의 점수 최댓값은 (-2한 계단의 점수 최댓값과 -3한 계단 점수 최댓값 + -1한 계단점수) 중 최댓값 + 현재 계단 점수이다.
			maxScore[idx] = Math.max(maxScore[idx-2], maxScore[idx-3] + score[idx-1]) + score[idx];
		}
		
		// 마지막 계단에 저장된 최댓값 출력
		System.out.println(maxScore[stair]);
	}

	
	public static void main(String[] args) {
		climb();
	}
}