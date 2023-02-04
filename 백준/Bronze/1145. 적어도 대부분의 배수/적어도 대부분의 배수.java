import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력받을 숫자를 받을 배열
		int[] numList = new int[5];
		
		// 배열에 숫자 입력받기
		for(int idx = 0; idx < numList.length; idx++) {
			numList[idx] = sc.nextInt();
		}
		
		// 1~Integer.Max_Value까지 돌면서
		// 적어도 대부분 배수 찾기
		for(int num = 1; num < Integer.MAX_VALUE; num++) {
			
			// 배수일 때 카운트 할 변수
			int cnt = 0;
			
			for(int idx = 0; idx < numList.length; idx++) {
				// num이 배열의 수로 나누어 떨어질 때마다 카운트
				if(num % numList[idx] == 0) {
					cnt++;
				}
			}
			// 카운트한 값이 3이상이면
			// 적어도 대부분 배수를 찾은 것!
			if(cnt >= 3) {
				// 수 출력 후 break
				System.out.println(num);
				break;
			}
		}
	}
}