import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int t;
	static int cnt;
	static int cola;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
	}
	
	static void solve() {
		// 입력받은 시간 중 최대 최소 구해주기
		int max = Math.max(n, m);
		int min = Math.min(n, m);
		// 시간을 임시시간으로 저장
		int tmpTime = t;
		// 햄버거 개수와 콜라 마신 시간을 저장할 변수 초기화
		cnt = 0;
		cola = 0;
		
		while(tmpTime > 0) {
			// 임시시간이 0보다 클 때 반복
			if(tmpTime % min == 0) {
				// 작은걸로 나눠떨어지면 몫을 카운트에 더해주고 끝
				cnt += tmpTime/min;
				break;
			}
			// 나눠 떨어지지 않으면 큰 값으로 빼주고
			// 카운트 하나 해줌
			tmpTime -= max;
			cnt++;
			
			if(tmpTime < 0) {
				// 만약 0보다 작아지면 햄버거를 먹는 도중에 시간이 끝나는 것이므로
				// 콜라 마시는 시간을 카운트해주고
				// 임시 시간을 전체 시간 - 콜라마신 시간으로 갱신해주고
				// 햄버거 카운트도 초기화
				cola++;
				tmpTime = t-cola;
				cnt = 0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		input();
		solve();
		System.out.println(cnt+" "+cola);
	}
}
