import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 개수 변수 생성
		int testCase = sc.nextInt();
		
		// 테스트 수만큼 반복
		for(int tc = 0; tc < testCase; tc++) {
			// 출력할 결과값 변수 생성
			// 테스트할 때마다 0으로 초기화 시키기
			int result = 0;
			
			// 숫자 입력받기
			int num = sc.nextInt();
			
			// 3중 for문 돌면서 입력받은 숫자가 세 수의 합의 되는지 판단...
			// 45까지 실행해주는 이유는 num <= 1000이고
			// (44*45)/2 < 1000 < (45*46)/2이므로...
			for(int i = 1; i < 46; i++) {
				for(int j = i; j < 46; j++) {
					for(int k = j; k < 46; k++) {
						
						// 삼각수 공식을 이용하여 i,j,j에 대한
						// 새로운 수 정의
						int newI = (i*(i+1))/2;
						int newJ = (j*(j+1))/2;
						int newK = (k*(k+1))/2;
						
						// 새로 정의된 세 수의 합이 num과 같은지 판단
						if(num == newI + newJ + newK) {
							// 같으면 result = 1해주고 출력
							result = 1;
							System.out.println(result);
							// result가 1이면 for문 더 돌 필요 없으므로 break
							break;
						}
					}
					// result가 1이면 for문 더 돌 필요 없으므로 break
					if(result == 1) {
						break;
					}
				}
				// result가 1이면 for문 더 돌 필요 없으므로 break
				if(result == 1) {
					break;
				}
			}
			// 만약 모두 탐색했는데 result가 1이 아닐 수도 있다.
			if(result == 0) {
				// result가 바뀌지 않고 0이면 출력
				System.out.println(result);
			}
		}
	}
}