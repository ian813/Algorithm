import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int n;
	static String ans = "NO";
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		Scanner sc = new Scanner(System.in);
		// 크기 입력받기
		n = sc.nextInt();
		// 수열 저장할 스택
		Stack<Integer> store = new Stack<>();
		// 수열 입력받을 배열
		int[] numArr = new int[n+1];
		for(int idx = 1; idx <= n; idx++) {
			numArr[idx] = sc.nextInt();
		}
		
		sc.close();
		
		// 비교할 인덱스와 넣어줄 숫자
		int idx = 1;
		int num = 1;
		
		// 인덱스가 n이하이거나  수가 n+1이하일 때만 탐색 (수는 후위연산자에 의해 더해지므로 n+1일 때도 스택을 비우기 위해 계속 비교해줘야된다.)
		while(idx <= n && num <= n+1) {
			if(store.isEmpty() || numArr[idx] != store.peek()) {
				// 스택이 비어있거나 스택 꼭대기와 비교할 숫자가 다르면
				// 스택에 푸시하고
				store.push(num++);
				// 스트링빌더에 저장
				sb.append("+").append("\n");
			} else if(numArr[idx] == store.peek()) {
				// 스택 꼭대기와 비교할 숫자가 같으면
				// 스택에서 팝하고
				store.pop();
				// 스트링빌더에 저장
				sb.append("-").append("\n");
				// 비교할 숫자 변경을 위해 인덱스++
				idx++;
			}
		}
		

		if(store.isEmpty()) {
			// 스택이 비어있으면 지금껏 저장한 답 출력
			System.out.println(sb);
		} else {
			// 스택이 비어있지 않으면 NO 출력
			System.out.println(ans);
		}
	}
	
	public static void main(String[] args) {
		solve();
	}
}
