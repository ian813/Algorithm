import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 나머지를 저장하는 배열 생성
		int[] remainder = new int[10];
		
		// 서로 다른 나머지 개수를 셀 변수 생성
		int cnt = 0;
		
		// 나머지 값들을 배열에 저장
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			int R = num % 42;
			remainder[i] = R;
		}
		
		// 배열을 돌면서 같은 값이 나올 경우 값을 42로 바꿔줌 (왜냐하면 42로 나눈 나머지는 42보다 작으므로 일종의 예외처리)
		for (int j = 0; j < remainder.length; j++) {
			for (int k = j+1; k < remainder.length; k++) {
				if(remainder[j] == remainder[k]) {
					remainder[j] = 42;
				}
			}
		}
			
		// 배열을 돌면서 42보다 작은 값들만 세주기
		for (int idx = 0; idx < remainder.length; idx++) {
			if (remainder[idx] < 42) {
				cnt++;
			}
		}
		// 결과 출력
		System.out.println(cnt);
	}
}