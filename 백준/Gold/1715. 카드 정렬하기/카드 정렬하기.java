
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, compare; // 숫자 개수
	static PriorityQueue<Integer> card = new PriorityQueue<>(); // 카드 묶음 정보, 오름차순으로 정렬해서 넣어주기 위해 우선순위 큐 사용
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 우선순위 큐에 카드 넣어주기
		for(int i = 0; i < N; i++) {
			card.offer(sc.nextInt());
		}
		
	}
	
	static void solve() {
		compare = 0;
		while(!card.isEmpty()) {
			// 카드가 빌때까지 실행
			// 카드 하나를 뽑아서 저장
			// 나머지 하나는 일단 초기화
			int card1 = card.poll();
			int card2 = 0;
			if(!card.isEmpty()) {
				// 카드가 비어있다면 하나 더 뽑아서 초기화한 카드에 저장
				card2 = card.poll();				
			}
			// 두 카드를 더한 값 저장해주고
			compare += card1 + card2;
			if(!card.isEmpty()) {
				// 카드가 비어있지 않다면 넣어주기
				card.offer(card1+card2);				
			}
		}
	}
	
	
	public static void main(String[] args) {
		input();
		if(N == 1) {
			// N이 1이면 비교 못함 -> 0 출력
			System.out.println(0);
		} else {
			solve();			
			// 결과값 출력
			System.out.println(compare);
		}
	}
}
