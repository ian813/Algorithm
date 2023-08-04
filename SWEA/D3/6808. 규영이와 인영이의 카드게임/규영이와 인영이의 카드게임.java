import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static int testCase = sc.nextInt();
	static int win;
	static int lose;
	static int[] myCard;
	static int[] yourCard;
	static boolean[] check;
	static int[] cardCheck;
	static int[] realCard;
	
	static void input() {
		// 내 카드, 상대 카드
		myCard = new int[9];
		yourCard = new int[9];
		// 상대카드를 넣어주기 위해 내 카드에 뭐가 들었는지 저장해줄 배열
		cardCheck = new int[18];
		// 실제 상대방이 낸 카드 순서를 저장할 배열
		realCard = new int[9];
		
		for(int idx = 0; idx < 9; idx++) {
			myCard[idx] = sc.nextInt();
			// 포함된 카드에 해당하는 인덱스 값을 늘려준다.
			cardCheck[myCard[idx]-1]++;
		}
		
		int tmpCol = 0;
		
		for(int idx = 0; idx < 18; idx++) {
			if(cardCheck[idx] == 0) {
				// 내 카드에 포함되어 있지 않은 카드를 담아준다.
				yourCard[tmpCol++] = idx+1;
			}
		}
		// 포함 여부 체크할 배열
		check = new boolean[9];
	}
	
	static void perm(int N, int idx) {
		if(N == idx) { // 다 뽑았으면
			int myScore = 0;
			int yourScore = 0;
			
			// 규칙에 맞게 스코어 계산해주기
			for(int i = 0; i < N; i++) {
				if(myCard[i] > realCard[i]) {
					myScore += myCard[i] + realCard[i];
				} else if(myCard[i] < realCard[i]) {
					yourScore += myCard[i] + realCard[i];
				}
			}
			// 이겼는지 졌는지 판단
			if(myScore > yourScore) {
				win++;
			} else if(myScore < yourScore) {
				lose++;
			}
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(check[i]) continue; // 이미 포함되어 있으면 패스
			
			realCard[idx] = yourCard[i]; // 실제로 낼 카드를 저장
			check[i] = true; // 포함 체크
			perm(N, idx+1); // 다음으로 넘어감
			check[i] = false; // 포함 해제
		}
		
		
		
	}
	
	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) {
			input();
			// 이기고 지는 횟수 초기화
			win = 0;
			lose = 0;
			
			perm(myCard.length, 0);
			
			sb.append("#"+tc+" "+win+" "+lose+"\n");
		}
		System.out.println(sb);
	}
}