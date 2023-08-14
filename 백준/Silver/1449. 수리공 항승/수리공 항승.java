import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 물 새는 곳 개수, 테이프 길이
		int N = sc.nextInt();
		int L = sc.nextInt();

		boolean[] check = new boolean[1001];

		// 물 새는 곳 위치
		for (int i = 0; i < N; i++) {
			int idx = sc.nextInt();

			check[idx] = true;
		}

		// 뽑아주는 개수, 탐색 위치
		int pick = 0;
		int idx = 1;

		// 테이프 개수
		int ans = 0;

		while (pick < N && idx < 1001) {
			if (check[idx]) { // 현재 위치가 물 새는 곳이면
				ans++; // 테이프 붙여주고
				for (int i = idx; i < idx + L && i < 1001; i++) {
					// 현재 인덱스부터 테이프 길이 L까지 돌면서
					if (check[i]) {
						// 물 새는 곳 있으면 막아주고
						// 막아준 개수 카운팅
						check[i] = false;
						pick++;
					}
				}
				// 탐색 끝났으면 테이프 개수만큼 탐색 위치 옮기기
				idx += L;
			} else {
				// 물 새는 곳 아니면 탐색 위치 키워주기
				idx++;
			}
		}
		// 출력
		System.out.println(ans);
	}
}