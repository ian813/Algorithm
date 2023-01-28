import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력받을 N
		// (임의의 자연수i와 i의 자릿수의 합)을 담을 result
		int N = sc.nextInt();
		int result = 0;
		
		// N보다 작은 자연수 i가 생성자인지 판단해보자.
		for(int i = 1; i < N; i++) {
			// 자릿수의 합을 담을 sum
			int sum = 0;
			
			int C = i;
			// 임의의 정수 C에 대한 자릿수의 합
			// 10으로 나눈 나머지를 sum에 더해주고
			// C를 10으로 나눈 몫으로 시행을 반복해주면
			// 구할 수 있다.
			while(C > 0) {
				sum += C%10;
				C /= 10;
			}
			// 자기자신과 자릿수의 합인 sum을 구한 결과를
			// result에 담아줌.
			// while문이 끝나면 C는 0이기 때문에 C를 더하면 안 됨.
			// -> int C = i 라고 선언해준 이유
			result = i + sum;
			
			// result가 N과 같으면 i를 출력
			if(result == N) {
				System.out.println(i);
				break;
			} else {
				result = 0;
			}
		}
		if(result == 0) {
			System.out.println(result);
		}
	}
}