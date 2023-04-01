
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static int[] parent;
	public static int V;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점 개수 :10만개
		int E = Integer.parseInt(st.nextToken()); // 간선 개수:20만개

		int[][] edges = new int[E][3]; // 간선 정보를 담을 배열
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken()); // 시작점
			edges[i][1] = Integer.parseInt(st.nextToken()); // 종점
			edges[i][2] = Integer.parseInt(st.nextToken()); // 가중치
		}

		// 크루스칼 알고리즘
		// 1. 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2]; // 오름차순 정렬 : o1, o2 순서대로 빼주면 됨
			}
		});

		// 2. 가중치가 가장 낮은 간선부터 선택
		// - 사이클이 발생하지 않도록 선택
		// - 간선의 두 정점이 각각 다른 트리에 있어야만
		// => union-find

		parent = new int[V + 1]; // 정점 번호가 1부터 시작해서 V까지 있으므로

		makeset();

		long dist = 0; // 간선 가중치의 합
		int num = 0; // 선택된 간선의 수

		for (int i = 0; i < E; i++) { // 모든 간선에 대해.. 20만개
			// 유니온할 수 있으면 유니온 한다. = 간선을 선택 = 두 정점을 연결
			if (union(edges[i][0], edges[i][1])) {
				dist += edges[i][2]; // 간선이 선택됐다면 가중치를 더해주고
				num++;
				if (num == V - 1)
					break;
			}
		}

		System.out.println(dist);

	}

	// 1. makeset
	private static void makeset() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

	}

	// 2. find: 정점 a의 대표자를 찾아 반환하는 함수
	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}

	// 3. union
	public static boolean union(int a, int b) {
		int aRoot = find(a); // a의 대표자 찾기
		int bRoot = find(b); // b의 대표자 찾기
		if (aRoot != bRoot) { // 대표자가 서로 다른 경우에만 유니온 가능
			parent[bRoot] = aRoot; // 유니온
			return true; // 유니온 성공
		}
		return false; // 유니언 실패
	}

}
