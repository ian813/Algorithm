import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int K;
	static int[] numArr;
	static int[] newArr;
	static int cnt;
	static int sum;
	
	static void input() {
		N = sc.nextInt();
		K = sc.nextInt();
		// 숫자 입력받을 배열
		numArr = new int[N];

		for (int idx = 0; idx < N; idx++) {
			numArr[idx] = sc.nextInt();
		}
		// 뽑은 데이터 저장할 배열
		newArr = new int[N];
	}

	static void combination(int idx, int select, int maxSelect) {
		if (select == maxSelect) {
			// 숫자들의 합 초기화
			sum = 0;
			// 뽑을 수 있는 최대수만큼 뽑으면
			for (int index = 0; index < N; index++) {
					// 뽑은 데이터들을 더해준다.
					sum += newArr[index];
			}
			if (sum == K) {
				// 합이 K면 카운팅
				cnt++;
			}
			return;
		}
		// 모든 경우의 수가 끝나면
		if(idx == N) {
			// 합을 초기화
			sum = 0;
			return;
		}
		
		newArr[select] = numArr[idx]; // 현재 보고있는 idx를 저장
		
		combination(idx + 1, select + 1, maxSelect); // 이번 꺼 저장하고 다음 거를 판단하러 가자

		combination(idx + 1, select, maxSelect); // 이번 꺼 저장 안하고 다음 거를 판단하러 가자
	}

	public static void main(String[] args) {
			input();
			// 카운트값 초기화
			cnt = 0;

			// i는 뽑을 숫자의 개수
			for(int i = 1; i <= N; i++) {
				// 조합 시행
				combination(0, 0, i);
			}

			System.out.println(cnt);
	}
}
