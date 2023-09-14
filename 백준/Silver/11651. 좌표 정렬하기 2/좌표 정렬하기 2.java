import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 포인트 개수
		int N = sc.nextInt();

		// 포인트 정보 담을 배열
		int[][] point = new int[N][2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				point[i][j] = sc.nextInt();
			}
		}

		// 배열 정렬시키기
		Arrays.sort(point, new Comparator<int[]>() {
			// new Comparator를 통해 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] - o2[1] > 0) {
					// 앞의 y좌표가 더 클 때 1 리턴
					// 앞의 수가 더 클 때 위치 바꾸기
					return 1;
				} else if (o1[1] - o2[1] < 0) {
					// 앞의 y좌표가 더 작을 때 -1 리턴
					// 앞의 수가 더 작을 때 위치 그대로
					return -1;
				} else {
					// y좌표가 같으면
					// x좌표 기준으로 비교해서 오름차순 정렬
					return o1[0] - o2[0];
				}
			}
		});

		// 스트링빌더에 형식에 맞게 담아서 출력
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				sb.append(point[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}