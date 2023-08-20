import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		// 각 변의 정보
		int[] line = new int[3];
		
		// 0이 입력될때까지 반복
		while(true) {
			// 변 정보 입력받기
			for(int i = 0; i < 3; i++) {
				line[i] = sc.nextInt();
			}
			
			// 0이 입력되면 중지
			if(line[0] == 0) break;
			
			// 버블 정렬로 오름차순 정렬
			for(int i = 1; i < 3; i++) {
				for(int j = 0; j < 3 - i; j++) {
					if(line[j] > line[j+1]) {
						int tmp = line[j];
						line[j] = line[j+1];
						line[j+1] = tmp;
					}
				}
			}
			
			// 답
			String ans = "wrong";
			
			// 직각삼각형(피타고라스 정리 이용)이면 답 바꾸기
			if(Math.pow(line[2], 2) == Math.pow(line[0], 2) + Math.pow(line[1], 2)) {
				ans = "right";
			}
			
			// 스트링빌더에 담기
			sb.append(ans + "\n");
		}
		
		sc.close();
		
		System.out.println(sb);
	}
}