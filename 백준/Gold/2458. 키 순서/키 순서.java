import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int student, comparison, ans;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 학생 수, 비교 횟수 입력받기
		student = Integer.parseInt(st.nextToken());
		comparison = Integer.parseInt(st.nextToken());

		// 키 정보
		check = new boolean[student + 1][student + 1];

		// 모든 간선에 대해 비교가 되는지 확인해야하므로 플로이드 워셜
		// 단 모든 정점과 연결되어 있는지만 확인하면 키 비교가 가능한 것이므로
		// 최단거리 구하는 게 아니라 연결 여부만 체크해준다.
		// 비교 정보 입력받아서 저장
		for (int i = 0; i < comparison; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			check[start][end] = true;
		}

		// 다른 정점을 거쳐 갈 수 있는 곳이면 true로 업뎃
		for (int k = 1; k <= student; k++) {
			for (int i = 1; i <= student; i++) {
				for (int j = 1; j <= student; j++) {
					if (check[i][k] && check[k][j]) {
						check[i][j] = true;
					}
				}
			}
		}

		// 답 초기화
		ans = 0;

		// check 배열을 돌면서 확인
		for (int i = 1; i <= student; i++) {
			boolean flag = true;
			for (int j = 1; j <= student; j++) {
				if (i != j && !check[i][j] && !check[j][i]) {
					// 자기 자신이 아닌데 비교할 수 없으면 (false이면)
					// flag를 false로 바꾸고 멈추기
					flag = false;
					break;
				}
			}
			// flag가 true이면 카운팅
			if (flag) {
				ans++;
			}
		}

		// 답 출력
		System.out.println(ans);
	}
}