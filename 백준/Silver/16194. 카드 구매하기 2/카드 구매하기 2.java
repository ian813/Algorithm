import java.util.Scanner;

public class Main {
	static int N; // 카드 개수, 최소 가격
	static int[] price, buy; // 카드팩별 가격, 개수별 구매한 최소 카드 가격

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		price = new int[N + 1];
		buy = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			price[i] = sc.nextInt();
		}

		sc.close();
		
		solve();
		
		// N개 카드팩 최소값 출력
		System.out.println(buy[N]);
		
	}

	static void solve() {

		buy[1] = price[1]; // 한개 구입할 땐 무조건 카드팩 하나 값이 최소

		for (int i = 2; i <= N; i++) {
			buy[i] = price[i]; // i개 카드 구입할 때 i개의 카드팩 값을 최소로 일단 저장
			for(int j = i; j >= 1; j--) {
				// i개 카드 구입할 때 i-1개 + 1개 카드팩 최소값, i-2개 + 2개 카드팩 최소값.... 이런식으로 최소값 갱신 
				buy[i] = Math.min(buy[j-1] + price[i-j+1], buy[i]); 
			}
		}
	}
}