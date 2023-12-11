import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 가로 세로 길이
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		// 자르는 횟수
		int cut = Integer.parseInt(st.nextToken());

		// 세로 가로 잘리는 지점 저장할 리스트
		ArrayList<Integer> horizon = new ArrayList<>();
		ArrayList<Integer> vertical = new ArrayList<>();

		while (cut-- > 0) {
			st = new StringTokenizer(br.readLine());
			// 자르는 방향
			int direction = Integer.parseInt(st.nextToken());

			// 잘리는 위치 저장
			if (direction == 0) {
				vertical.add(Integer.parseInt(st.nextToken()));
			} else {
				horizon.add(Integer.parseInt(st.nextToken()));
			}
		}

		// 처음 좌표 넣어주기
		vertical.add(0);
		horizon.add(0);

		// 끝 좌표 넣어주기
		vertical.add(height);
		horizon.add(width);

		// 오름차순 정렬
		Collections.sort(vertical);
		Collections.sort(horizon);

		// 최대 넓이
		// 최대 가로 세로 길이 초기화
		int maxWidth = 0;
		int maxHeight = 0;

		// 최대 가로 길이 구하기
		for (int i = 0; i < horizon.size() - 1; i++) {
			int curWidth = horizon.get(i + 1) - horizon.get(i);

			maxWidth = Math.max(maxWidth, curWidth);
		}

		// 최대 세로 길이 구하기
		for (int i = 0; i < vertical.size() - 1; i++) {
			int curHeight = vertical.get(i + 1) - vertical.get(i);

			maxHeight = Math.max(maxHeight, curHeight);
		}

		// 최대 넓이 구하기
		int maxArea = maxWidth * maxHeight;

		// 출력
		System.out.println(maxArea);
	}
}