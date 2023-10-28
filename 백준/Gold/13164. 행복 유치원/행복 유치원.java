import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N, K; // 원생 수, 조 개수
	static int[] people; // 사람 정보 입력받기
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		people = new int[N];

		for (int i = 0; i < N; i++) {
			people[i] = sc.nextInt();
		}

		// 그루핑하고
		int ans = group();

		// 결과 출력
		System.out.println(ans);
	}

	// 인접한 항들의 키 차이 저장하고 오름차순 정렬해준 다음
	// 앞에서 N-K개를 하나의 그룹으로 묶어주고 나머지는 K-1개는 혼자인 그룹으로 냅둔다.
	private static int group() {
		for (int i = 1; i < N; i++) {
			int diff = people[i] - people[i - 1];

			list.add(diff);
		}

		Collections.sort(list);

		int result = 0;

		for (int i = 0; i < N - K; i++) {
			result += list.get(i);
		}

		return result;
	}
}