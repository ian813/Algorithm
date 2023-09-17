import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 앞쪽으로 이동하는 요소는 1턴에 1칸이 최대인데, 뒤쪽으로 이동하는 요소는 1턴에 얼마든지 이동할 수 있다.
 * 따라서, 같은 시간으로 기준으로 하였을 때, 앞쪽 칸만을 이동하는 숫자들만 비교해서 가장 많이 이동한 수 + 1 해주면 된다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 데이터 입력받기
		Point[] arr = new Point[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Point(Integer.parseInt(br.readLine()), i);
		}

		// 정렬
		Arrays.sort(arr);

		// 최댓값
		int max = 0;

		// 배열을 돌면서
		// 기존 저장된 인덱스와 정렬되었을 때 인덱스를 비교한 값 (arr[i].index - i) 중
		// 가장 큰 값을 구해준다.
		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i].index - i);
		}

		// 가장 큰 값 + 1을 해주면 된다.
		System.out.println(max + 1);
	}

	// 데이터를 받을 때 value와 index를 같이 받아준다.
	// 정렬은 value 오름차순으로
	static class Point implements Comparable<Point> {
		int value;
		int index;

		Point(int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Point o) {
			return this.value - o.value;
		}
	}

}