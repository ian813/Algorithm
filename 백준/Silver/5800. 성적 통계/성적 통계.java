import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 반 수
		int classNum = sc.nextInt();
		
		for(int cl = 1; cl <= classNum; cl++) {
			int student = sc.nextInt(); // 학생수
			
			int[] score = new int[student];
			
			// 점수 입력받기
			for(int i = 0; i < student; i++) {
				score[i] = sc.nextInt();
			}
			
			Arrays.sort(score); // 오름차순 정렬
			
			int min = score[0]; // 최소점수
			int max = score[student-1]; // 최대점수
			
			int tmpGap = 0; // 점수 차이
			// 배열 돌면서 최대 점수 차이 저장
			for(int i = 1; i < student; i++) {
				tmpGap = Math.max(tmpGap, score[i]-score[i-1]);
			}
			
			// 형식에 맞게 출력
			System.out.println("Class " + cl);
			System.out.println("Max " + max + ", Min " + min + ", Largest gap " + tmpGap);
			
		}
		
		sc.close();
		
	}
}