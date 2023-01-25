import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 과목 개수를 받는 변수와 점수를 받는 배열 생성
		int numSubject = sc.nextInt();
		double[] scores = new double[numSubject];
		
		// 점수를 입력받아 배열에 넣어주기
		for(int i = 0; i < numSubject; i++) {
			scores[i] = sc.nextDouble();
		}
		
		// 최고점수 찾기
		double maxScore = 0;
		for(int i = 0; i < numSubject; i++) {
			if(maxScore < scores[i]) {
				maxScore = scores[i];
			}
		}
		
		// 기존 점수를 새 점수로 바꾸면서 새 점수들의 합 구하기
		double sum = 0;
		for(int i = 0; i < numSubject; i++) {
			scores[i] = (scores[i]/maxScore) * 100;
			sum += scores[i];
		}
		
		// 새 점수들의 평균 구하기
		double avg = sum/numSubject;
		
		System.out.println(avg);
	}
}