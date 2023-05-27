import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 지방 수
		int N = sc.nextInt();
		// 각 지방들의 예산
		int[] budget = new int[N];
		
		// 탐색을 양쪽 끝지점 변수
		int left = 0, right = -1;
		
		// 예산 정보
		for(int i = 0; i < N; i++) {
			budget[i] = sc.nextInt();
			// 오른쪽 지점을 예산 최댓값으로 갱신
			right = Math.max(right, budget[i]);
		}

		// 총 예산
		int totalBudget = sc.nextInt();
		
		while(left <= right) {
			// 중간값(임시 상한선)
			int mid = (left+right)/2;
			// 터질 수 있으니까 long으로 받자
			long tmpBudget = 0;
			
			// 배열 돌면서 합 구하기
			for(int i = 0; i < N; i++) {
				if(budget[i] > mid) {  // 상한선보다 예산이 큰 곳은
					tmpBudget += mid; // 상한선을 더해주고
				} else { // 아니면
					tmpBudget += budget[i]; // 그 지방의 예산 더해주기
				}
			}
			if(tmpBudget <= totalBudget) { // 예산의 합이 총 예산보다 작으면
				left = mid+1; // 상한선을 높여보자
			} else { // 그렇지 않으면
				right = mid-1; // 상한선을 낮춰보자
			}
		}
		// 위의 while문을 반복해서 최대 상한선을 구하면 그 값을 출력
		System.out.println(right);
	}
}