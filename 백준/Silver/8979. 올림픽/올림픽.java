import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		// 국가 번호와 메달 정보 입력받을 배열
		int[][] medals = new int[N][4];

		// K 국가가 몇 번 인덱스에 있는지 저장할 변수
		int idx = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				medals[i][j] = sc.nextInt();
			}
			if (medals[i][0] == K) {
				// K 국가 찾아서 저장
				idx = i;
			}
		}

		// K 국가의 rank
		int rank = 1;

		for (int i = 0; i < N; i++) {
			if (medals[idx][1] < medals[i][1]) {
				// 금메달 개수로 랭킹 매기기
				rank++;
			} else if (medals[idx][1] == medals[i][1]) {
				// 금메달 개수 같으면
				if (medals[idx][2] < medals[i][2]) {
					// 은메달 개수로 랭킹 매기기
					rank++;
				} else if (medals[idx][2] == medals[i][2]) {
					// 은메달 개수 같으면
					if (medals[idx][3] < medals[i][3]) {
						// 동메달 개수로 랭킹 매기기
						rank++;
					}
				}
			}
		}

		// 랭킹 출력
		System.out.println(rank);
	}
}