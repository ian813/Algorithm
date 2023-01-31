import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 세 종류 방의 정원
		int room1 = sc.nextInt();
		int room2 = sc.nextInt();
		int room3 = sc.nextInt();
		
		// 총 학생 수
		int totalStudent = sc.nextInt();
		
		// 방의 정원의 총합
		int sum = 0;
		
		// 최종출력값 변수
		int output = 0;
		
		// 브루트포스 알고리즘... 삼중 포문 쓰기
		for(int i = 0; i <= totalStudent; i++) {
			for(int j = 0; j <= totalStudent; j++) {
				for(int k = 0; k <= totalStudent; k++) {
					
					// room1, room2, room3를 이용한 모든 합의 경우의 수 찾기
					sum = room1 * i + room2 * j + room3 * k;
					
					// 총 학생 수와 같으면 output = 1
					if(sum == totalStudent) {
						output = 1;
						break;
					}
				}
				
				// output이 1로 됐으면 for문 더 돌 필요 없으므로 break
				if(output == 1) {
				break;	
				}
			}
			
			// output이 1로 됐으면 for문 더 돌 필요 없으므로 break
			if(output == 1) {
				break;
			}
		}
	System.out.println(output);
	}
}
