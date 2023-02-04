import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자의 개수를 받을 변수
		int testCase = sc.nextInt();
		
		// 소수의 개수를 셀 변수 생성
		int cnt = 0;
		
		// testCase만큼 반복
		for(int tc = 0; tc < testCase; tc++) {
			// 숫자 입력받기
			int num = sc.nextInt();
			
			// 수가 소수인지 판단할 불리안 값 생성
			boolean isPrime = true;
			
			// 만약 입력된 수가 1이면 다음 테스트 케이스로 넘어가기
			if(num == 1) {
				continue;
			}
			
			// 입력된 수가 1이 아니고
			// 2~입력된 수보다 작은 수로 계속 나눴을 때
			// 나머지가 0인지 아닌지로 소수 판별 가능
			// 소수란 1과 자기자신만으로 나눠지기 때문에
			// 1보다 크고 자기자신보다 작은 수로 나눴을 때 나머지는 0이 아니다.
			for(int i = 2; i < num; i++) {
				if(num % i != 0) {
					// 만약 num이 i로 나누어 떨어지지 않으면
					continue;
				} else {
					// 중간에 한 번이라도 나누어 떨어지면
					// false로 바꾸고 break
					isPrime = false;
					break;
				}
			}
			
			// 여기까지 왔을 때 isPrime == true이면
			// 소수이므로 cnt++
			if(isPrime) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
