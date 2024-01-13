import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		// 행 열 길이 입력받기
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		// 시간 정보 저장할 배열
		int[][] time = new int[row][col];

		// 맵에 기상정보 입력하기
		char[][] map = new char[row][col];

		for (int i = 0; i < row; i++) {
			String str = br.readLine();

			// 죄측에 구름이 뜬 적 있는지 판단할 불리안
			// 매 행마다 false로 초기화
			boolean flag = false;

			for (int j = 0; j < col; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'c') {
					// 구름 생성되면 true로 변경
					flag = true;
				}

				if (flag && map[i][j] == '.') {
					// 구름이 떴고 원래 구름 있던 곳이 아니면
					// 그 전 열의 시간에 +1
					time[i][j] = time[i][j - 1] + 1;
				}

				if (!flag) {
					// 구름이 좌측에 안 떴으면 시간 -1로 바꾸기
					time[i][j] = -1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		// 시간을 스트링빌더에 형식메 맞게 저장하고 출력
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sb.append(time[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}