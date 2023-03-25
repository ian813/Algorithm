import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Stack<Integer> save = new Stack<>();
	
	static int K;
	static int sum;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 입력받을 정수 개수
		K = sc.nextInt();
		
		for(int i = 0; i < K; i++) {
			// K번 반복해서
			int tmp = sc.nextInt();
			
			if(tmp == 0) {
				// tmp가 0이면 스택에 저장된 값 하나 팝해주기
				save.pop();
			} else {
				// tmp가 0이 아니면 스택에 푸시
				save.push(tmp);
			}
			
		}
		// sum값 초기화
		sum = 0;
	}
	
	static void solve() {
		input();

		while(!save.isEmpty()) {
			// 스택이 빌 때까지 뽑아서 더해주기
			sum += save.pop();
		}
	}
	public static void main(String[] args) {
		solve();
		// 출력
		System.out.println(sum);
	}
}