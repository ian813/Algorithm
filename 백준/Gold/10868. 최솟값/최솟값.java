import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static class SegmentTree {
		int treeSize;
		long[] minTree;

		private SegmentTree(int arrSize) {
			// 트리의 높이
			int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
			// 트리 사이즈 (노드 개수)
			this.treeSize = (int)Math.pow(2, h + 1);
			// 트리 배열
			minTree = new long[treeSize];
		}

		// 최솟값 담은 트리 만들기
		public long init(long[] arr, int node, int start, int end) {

			if (start == end) {
				// 시작과 끝이 같으면 리프 노드
				// 트리의 해당 노드에 배열의 시작점 넣어주기
				return minTree[node] = arr[start];
			}

			int mid = (start + end) / 2;
			return minTree[node] = Math.min(init(arr, node * 2, start, mid),
				init(arr, node * 2 + 1, mid + 1, end));
		}

		// 최솟값 찾기
		public long findMin(long[] arr, int node, int start, int end, int left, int right) {

			// 아예 구간 밖이면 최댓값 반환
			if (right < start || end < left) {
				return Integer.MAX_VALUE;
			}

			// 완전 구간에 포함되어 있으면 해당 노드값 반환
			if (left <= start && end <= right) {
				return minTree[node];
			}

			int mid = (start + end) / 2;

			// 양쪽 자식들 중 최솟값 찾기
			return Math.min(findMin(arr, node * 2, start, mid, left, right),
				findMin(arr, node * 2 + 1, mid + 1, end, left, right));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 크기, 구간 순서쌍 개수
		int arrSize = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] arr = new long[arrSize + 1];
		// 배열에 정보 입력받기
		for (int i = 1; i <= arrSize; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(st.nextToken());
		}

		// 세그먼트 트리 생성
		SegmentTree t = new SegmentTree(arrSize);

		// 트리에 값 넣기
		t.init(arr, 1, 1, arrSize);

		StringBuilder sb = new StringBuilder();

		// 구하려는 구간 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// 왼쪽, 오른쪽
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			// 구간 내 최솟값 구하기
			long min = t.findMin(arr, 1, 1, arrSize, l, r);

			sb.append(min).append("\n");
		}

		System.out.println(sb);
	}
}