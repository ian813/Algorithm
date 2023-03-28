import java.util.Scanner;

public class Main {
	static int N;
	static int jimin;
	static int hansu;
	static int round;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 참가자 수
		N = sc.nextInt();
		// 지민이 한수 번호
		jimin = sc.nextInt();
		hansu = sc.nextInt();
	}
	
	static void solve() {
		input();
		// 라운드를 무조건 한번은 하므로 1로 초기화
		round = 1;
		// 지민과 한수 중 최솟값과 최댓값을 저장
		int min = Math.min(jimin, hansu);
		int max = Math.max(jimin, hansu);
		
		// 둘이 만나는 경우는 최솟값이 홀수이고 최댓값이 짝수이면서 둘 차이가 1일 때이다.
		// 따라서 세 조건 중 하나라도 만족하지 않으면 와일문을 돌려서 다음라운드로 진출해서
		// 번호를  새로 매겨준다.
		while(min % 2 != 1 || max % 2 != 0 || max - min != 1) {
			if(min % 2 == 0) { // 짝수이면 그냥 2로 나눠준 수로 배정
				min /= 2;
			} else { // 홀수이면 2로나눠준 수 +1로 배정
				min /= 2;
				min++;
			}
			// min과 똑같은 방식으로 배정
			if(max % 2 == 0) {
				max /= 2;
			} else {
				max /= 2;
				max++;
			}
			// 라운드 수 카운팅
			round++;
		}
		
	}
	
	public static void main(String[] args) {
		solve();
		// 출력
		System.out.println(round);
	}
}