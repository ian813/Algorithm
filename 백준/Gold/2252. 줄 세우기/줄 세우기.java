import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static int N, M; // 학생 수, 키 비교 회수
	static List<Integer>[] compare; // 비교한 학생 정보
	static int[] inDegree; // 진입차수(비교 우위인 학생 정보 저장)

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		compare = new ArrayList[N + 1];
		inDegree = new int[N + 1];

		for (int idx = 1; idx <= N; idx++) {
			// 인덱스마다 새 어레이리스트를 생성 (정보를 담을 바구니)
			compare[idx] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			// 비교 정보를 담아주고
			compare[start].add(end);
			// 비교 우위인 사람의 정보를 저장
			inDegree[end]++;
		}
	}

	static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();

		for (int idx = 1; idx <= N; idx++) {
			// 비교 우위가 없는 사람들을 전부 큐에 넣어준다.
			if (inDegree[idx] == 0)
				queue.add(idx);
		}

		while (!queue.isEmpty()) {// 큐가 빌때까지 실행
			// 하나 뽑아서 저장해두고
			int person = queue.poll();
			// 스트링빌더에 담아둠
			sb.append(person + " ");

			for (int i = 0; i < compare[person].size(); i++) {
				// person과 비교할 수 있는 사람이 있다면
				// 그 때의 비교 우위 수를 감소시켜주고
				inDegree[compare[person].get(i)]--;
				// 비교 우위 수가 0이면 큐에 추가
				if (inDegree[compare[person].get(i)] == 0) {
					queue.add(compare[person].get(i));
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		topologicalSort();

		System.out.println(sb);
	}
}
