import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 카드의 개수와 새로 선언한 카드의 합 입력받기
		int cntCard = sc.nextInt();
		
		int max = sc.nextInt();
		
		// 카드에 쓰여있는 수를 받을 배열 생성
		int[] numCard = new int[cntCard];
		// 카드에 쓰여있는 수 cntCard만큼 입력받기
		for(int i = 0; i < cntCard; i++) {
			numCard[i] = sc.nextInt();
		}
		
		sc.close();
		
		// 카드 3장의 합을 담을 변수와 result 생성
		int result = 0;
		
		
		// M을 넘지 않는 3장의 합 찾기 (모든 경우의 수 탐색)
		for(int i = 0; i < cntCard - 2; i++) {
			for(int j = i+1; j < cntCard -1; j++) {
				for(int k = j+1; k < cntCard; k++) {
					int sum = numCard[i] + numCard[j] + numCard[k];
					
					// sum == max이면 멈추고 result=max 반환
					if (sum == max) {
						result = max;
						break;
					}
					// result < sum < max면 result=sum으로
					// 업데이트하고 계속 for문 반복
					if (sum < max && result < sum) {
						result = sum;
					}
				}
			}
		}
		System.out.println(result);
	}
}