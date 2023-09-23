import java.util.Scanner;

public class Main {

	// N개의 수, 변경 횟수, 구간 합 구하는 횟수
	static int N, M, K;
	// 배열
	static long[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		arr = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextLong();
		}

		// 세그먼트 트리 생성
		Segmenttree segmenttree = new Segmenttree(N);

		// 값 채워넣기
		segmenttree.init(arr, 1, 1, N);

		StringBuilder sb = new StringBuilder();

		// 명령어에 따라 수행
		for (int i = 0; i < M + K; i++) {
			int order = sc.nextInt();
			int a = sc.nextInt();
			long b = sc.nextLong();

			if (order == 1) {
				// 트리 정보, 배열 정보 업데이트 end : N, idx : a
				segmenttree.update(1, 1, N, a, b - arr[a]);
				arr[a] = b;
			} else {
				// 구간합 구해서 추가
				sb.append(segmenttree.sum(1, 1, N, a, (int)b) + "\n");
			}

		}
		System.out.println(sb);
	}

	// 세그먼트 트리
	static class Segmenttree {
		// 트리 배열, 트리 크기
		long[] tree;
		int treeSize;

		// 배열의 크기에 맞게 트리 생성
		public Segmenttree(int arrSize) {
			// ceil: 올림.. 배열 크기
			int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));

			this.treeSize = (int)Math.pow(2, h + 1);
			// 트리 생성
			tree = new long[treeSize];
		}

		// 트리에 값 넣기
		// arr = 원소배열, node = 현재노드, start = 현재구간 배열 시작, end = 현재구간 배열 끝
		public long init(long[] arr, int node, int start, int end) {

			if (start == end) {
				// 시작과 끝이 같으면 리프 노드
				// 트리의 해당 노드에 배열의 시작점 넣어주기
				return tree[node] = arr[start];
			}

			// 트리의 해당 노드에 양쪽 자식 노드의 합으로 구성
			// 왼쪽 자식 노드 번호는 2*node, 오른쪽 자식 노드 번호는 2*node+1
			// 배열의 시작과 끝점은 start, (start+end)/2 // (start+end)/2 + 1, end
			return tree[node] = init(arr, node * 2, start, (start + end) / 2) +
				init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
		}

		// 트리 정보 업데이트
		// node: 현재노드 idx, start: 배열의 시작, end:배열의 끝
		// idx: 변경된 데이터의 idx, diff: 원래 데이터 값과 변경 데이터값의 차이
		public void update(int node, int start, int end, int idx, long diff) {

			// 업데이트하려는 인덱스가 시작, 끝 범위 밖이면 리턴
			if (idx < start || end < idx)
				return;

			// 차이를 트리의 해당 노드에 더해주기
			tree[node] += diff;

			if (start != end) {
				// 리프노드가 아니면 아래 자식들도 확인
				update(node * 2, start, (start + end) / 2, idx, diff);
				update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
			}
		}

		// 부분 합 구하기
		// node: 현재 노드, start : 배열의 시작, end : 배열의 끝
		// left: 원하는 누적합의 시작, right: 원하는 누적합의 끝
		public long sum(int node, int start, int end, int left, int right) {
			// 구간 범위가 아예 벗어나 있으면 0 리턴
			if (left > end || right < start) {
				return 0;
			}

			// 완전 포함되어 있으면 해당 트리 노드 반환
			// 더 내려가지 않고 바로 리턴
			if (left <= start && end <= right) {
				return tree[node];
			}

			// 그 외의 경우 좌 / 우측으로 지속 탐색 수행
			return sum(node * 2, start, (start + end) / 2, left, right) +
				sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		}
	}
}