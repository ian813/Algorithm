import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final int INF = 1000000;
	static int member;
	static int[][] memberInfo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 멤버 수
		member = sc.nextInt();

		// 멤버 정보 입력받을 배열
		memberInfo = new int[member + 1][member + 1];

		// 대각요소 뺴고는 다 거리를 INF로 초기화
		for (int i = 1; i <= member; i++) {
			for (int j = i + 1; j <= member; j++) {
				memberInfo[i][j] = memberInfo[j][i] = INF;
			}
		}

		while (true) {
			// 시작점, 끝점
			int start = sc.nextInt();
			int end = sc.nextInt();

			if (start == -1 && end == -1)
				// 시작과 끝이 모두 -1이면 중단
				break;

			// 멤버 정보에 따라 1로 업데이트
			memberInfo[start][end] = memberInfo[end][start] = 1;
		}

		// 플로이드 워셜
		for (int k = 1; k <= member; k++) {
			for (int i = 1; i <= member; i++) {
				for (int j = 1; j <= member; j++) {
					// 하나 거쳐간 거와 바로 간 거 최솟값 구해서 업데이트
					memberInfo[i][j] = Math.min(memberInfo[i][j], memberInfo[i][k] + memberInfo[k][j]);
				}
			}
		}

		// 멤버별 최대 점수를 담을 배열
		int[] maxScore = new int[member + 1];
		int minScore = INF;

		// 멤버별 점수 업데이트
		for (int i = 1; i <= member; i++) {
			for (int j = 1; j <= member; j++) {
				maxScore[i] = Math.max(maxScore[i], memberInfo[i][j]);
			}
			// 최소 점수도 구해주기
			minScore = Math.min(minScore, maxScore[i]);
		}

		// 최소 점수를 갖는 멤버 수
		int cnt = 0;
		ArrayList<Integer> memberList = new ArrayList<>();

		for (int i = 1; i <= member; i++) {
			if (minScore == maxScore[i]) {
				// 최소 점수와 같은 멤버 수를 카운팅하고 그 멤버를 리스트에 저장
				cnt++;
				memberList.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();

		// 최소 점수와 최소 점수를 갖는 멤버 수 담아주고
		sb.append(minScore + " " + cnt).append("\n");

		// 그 멤버들을 하나씩 담아주기
		for (int i = 0; i < memberList.size(); i++) {
			sb.append(memberList.get(i) + " ");
		}
		// 출력
		System.out.println(sb);
	}
}