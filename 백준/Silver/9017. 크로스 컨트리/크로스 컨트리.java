import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();

			// 랭킹 정보 입력받기
			int[] rank = new int[N];

			// 각 팀이 몇 번 나왔는지 카운팅
			int[] cnt = new int[201];

			for (int i = 0; i < N; i++) {
				// 랭킹 정보와 카운팅 동시에
				int idx = sc.nextInt();

				rank[i] = idx;

				cnt[idx]++;
			}

			// 6명이 됐는지 체크할 불리안 배열
			boolean[] check = new boolean[201];

			for (int i = 1; i <= 200; i++) {
				// 카운트 배열을 이용해 체크
				if (cnt[i] == 6)
					check[i] = true;
				if (cnt[i] == 0) {
					break;
				}
			}

			int[] scores = new int[N];

			int score = 1;

			for (int i = 0; i < N; i++) {
				if (check[rank[i]]) {
					// 6명인 팀들에 대해 점수 매겨주기
					scores[i] = score++;
				}
			}

			// 카운트 배열 초기화
			cnt = new int[201];

			// 0열에는 각 팀의 상위 4명 합, 1열에는 각 팀의 상위 5명 합
			int[][] sumScores = new int[201][3];

			// 2열에는 팀 번호 입력해주기
			for (int i = 1; i <= 200; i++) {
				sumScores[i][2] = i;
			}

			for (int i = 0; i < N; i++) {
				if (cnt[rank[i]] < 4) {
					cnt[rank[i]]++;
					sumScores[rank[i]][0] += scores[i];
					sumScores[rank[i]][1] += scores[i];
				} else if (cnt[rank[i]] < 5) {
					cnt[rank[i]]++;
					sumScores[rank[i]][1] += scores[i];
				}
			}

			// 정렬
			Arrays.sort(sumScores, (o1, o2) -> {
				if (o1[0] - o2[0] > 0) {
					return 1;
				} else if (o1[0] - o2[0] < 0) {
					return -1;
				} else {
					return Integer.compare(o1[1] - o2[1], 0);
				}
			});

			// 오름차순 정렬 됐으므로 상위 5명의 합이 0이 아닌 팀이 나오면 바로 출력
			for (int i = 0; i <= 200; i++) {
				if (sumScores[i][1] != 0) {
					System.out.println(sumScores[i][2]);
					break;
				}
			}
		}
	}
}