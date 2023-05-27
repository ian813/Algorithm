import java.util.Scanner;

public class Main {
	static int testCase, maxSum;
	static int[][] position;
	static boolean[] check;
	static int[] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		
		// 테케만큼 진행
		for(int tc = 1; tc <= testCase; tc++) {
			// 포지션별 능력치를 담을 배열
			position = new int[11][11];
			
			for(int row = 0; row < 11; row++) {
				for(int col = 0; col < 11; col++) {
					position[row][col] = sc.nextInt();
				}
			}
			// 선발에 넣은 선수 체크
			check = new boolean[11];
			
			// 선택된 포지션에서의 능력치
			select = new int[11];
			
			maxSum = 0;
			// 조합
			comb(0, 0);
			
			System.out.println(maxSum);
		}
		
		sc.close();
	}
	
	static void comb(int depth, int sum) {
		if(depth == 11) { // 다 뽑으면
			// 최댓값 갱신 후 리턴
			maxSum = Math.max(sum, maxSum);
			return;
		}
		
		for(int i = 0; i < 11; i++) { // 한 뎁스에 대해 모두 체크
			if(!check[i] && position[depth][i] != 0) { // 방문 안했고 능력치가 0이 아니면
				check[i] = true; // 방문체크
				comb(depth+1, sum + position[depth][i]); // 다음 선수로 넘어가고, 능력치 합은 지금 선수의 현재 포지션에서의 능력치만큼 더해준다.
				check[i] = false; // 방문해제
			}
		}
		
	}
}
