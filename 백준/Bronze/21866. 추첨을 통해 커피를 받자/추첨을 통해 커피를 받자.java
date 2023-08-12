import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] score	 = new int[9];
		
		int[] maxScore = { 100, 100, 200, 200, 300, 300, 400, 400, 500 };
		
		String ans = "";		

		int studentScore = 0;

		boolean isTrue = true; // 해커인지 구분해줄 불리안
		
		for(int i = 0; i < 9; i++) {
			score[i] = sc.nextInt();
			studentScore += score[i];
			if(score[i] > maxScore[i]) isTrue = false; // 최대점수를 넘기는 점수가 있으면 false로 변경
		}
		
		sc.close();
		
		if(!isTrue) { // 해커인 경우
			ans = "hacker";
		} else { // 해커가 아닐 때는 추첨 대상자인지 판단
			if(studentScore < 100) { // 점수 총합이 100보다 작으면 대상자가 아니다.
				ans = "none";
			} else { // 나머지 경우 처리
				ans = "draw";
			}
		}
		
		System.out.println(ans);
	}
}