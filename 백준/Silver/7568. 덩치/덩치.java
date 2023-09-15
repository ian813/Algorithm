import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 사람 정보 입력받기
		int[][] people = new int[N][2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				people[i][j] = sc.nextInt();
			}
		}

		// 등수 정보 담을 배열
		int[] rank = new int[N];

		for (int i = 0; i < N; i++) {
			// 현재 사람의 등수 저장할 변수
			int seq = 1;
			for (int j = 0; j < N; j++) {
				// 브루트포스로 탐색해보자
				if (i == j) // 같은 사람이면 넘기기
					continue;
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					// 키, 몸무게 모두 더 큰 사람 발견하면 카운팅
					seq++;
				}
			}
			// 등수 저장
			rank[i] = seq;
		}

		// 형식에 맞게 출력
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(rank[i] + " ");
		}

		System.out.println(sb);
	}
}