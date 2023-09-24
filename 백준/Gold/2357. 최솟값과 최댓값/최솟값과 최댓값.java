import java.util.Scanner;

public class Main {

	static int N, M;
	static long[] arr;

	static class SegTree {
		int treeSize;
		long[] minTree, maxTree;

		public SegTree(int arrSize) {
			// 트리의 높이
			int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
			// 트리 사이즈 (노드 개수)
			this.treeSize = (int)Math.pow(2, h + 1);
			// 트리 배열
			minTree = new long[treeSize];
			maxTree = new long[treeSize];
		}

		// 각 구간 별로 최솟값을 저장
		public long minInit(long[] arr, int node, int start, int end) {

			if (start == end) {
				// 시작과 끝이 같으면 리프 노드
				// 트리의 해당 노드에 배열의 시작점 넣어주기
				return minTree[node] = arr[start];
			}

			int mid = (start + end) / 2;

			return minTree[node] = Math.min(minInit(arr, node * 2, start, mid),
				minInit(arr, node * 2 + 1, mid + 1, end));
		}

		// 각 구간 별로 최댓값을 저장.
		public long maxInit(long[] arr, int node, int start, int end) {
			if (start == end) {
				return maxTree[node] = arr[start];
			}

			int mid = (start + end) / 2;
			return maxTree[node] = Math.max(maxInit(arr, node * 2, start, mid),
				maxInit(arr, node * 2 + 1, mid + 1, end));
		}

		// left ~ right 범위 내에 최솟값을 찾기
		public long findMin(int node, int start, int end, int left, int right) {

			if (right < start || end < left) {
				// 구간 범위가 아예 벗어나 있으면 최댓값 리턴
				return Integer.MAX_VALUE;
			}

			// 완전 포함되어 있으면 해당 트리 노드 반환
			// 더 내려가지 않고 바로 리턴
			if (left <= start && end <= right) {
				return minTree[node];
			}

			int mid = (start + end) / 2;

			return Math.min(findMin(node * 2, start, mid, left, right),
				findMin(node * 2 + 1, mid + 1, end, left, right));
		}

		// left ~ right 범위 내에 최댓값을 찾기
		public long findMax(int node, int start, int end, int left, int right) {

			if (right < start || end < left) {
				// 구간 범위가 아예 벗어나 있으면 최솟값 리턴
				return Integer.MIN_VALUE;
			}

			// 완전 포함되어 있으면 해당 트리 노드 반환
			// 더 내려가지 않고 바로 리턴
			if (left <= start && end <= right) {
				return maxTree[node];
			}

			int mid = (start + end) / 2;

			return Math.max(findMax(node * 2, start, mid, left, right),
				findMax(node * 2 + 1, mid + 1, end, left, right));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N개의 정수, M개의 a, b쌍
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		// 세그먼트 트리 생성
		SegTree t = new SegTree(N);

		// 각 구간의 최솟값과 최댓값으로 트리 구성하기
		t.minInit(arr, 1, 1, N);
		t.maxInit(arr, 1, 1, N);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			// 각 구간 끝 점 (left, right) 입력받기
			int a = sc.nextInt();
			int b = sc.nextInt();

			// 최소 최대 구하기
			long min = t.findMin(1, 1, N, a, b);
			long max = t.findMax(1, 1, N, a, b);

			// 알맞게 넣어주기
			sb.append(min + " " + max).append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}