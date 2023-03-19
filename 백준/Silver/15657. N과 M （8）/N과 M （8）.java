import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] numArr;

	static StringBuilder sb = new StringBuilder();
	static int[] sol;

	static void input() {
		Scanner sc = new Scanner(System.in);
		// 수 입력받기
		N = sc.nextInt();
		M = sc.nextInt();

		numArr = new int[N];
		
		// 수 입력받고
		for (int idx = 0; idx < N; idx++) {
			numArr[idx] = sc.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(numArr);

		// 정답을 임시 저장할 배열
		sol = new int[M];
		
		sc.close();
	}
	
	// 재귀함수 (시작 위치, 깊이)
	static void recursion(int startIdx, int depth) {
		if (depth == M) {
			// 원하는 길이만큼 depth가 되면
			for (int num : sol) {
				// sol에 저장된 값들 스트링빌더에 담아주기
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 시작위치부터 재귀로 탐색
		for (int i = startIdx; i < N; i++) {
			// 해당 depth에 값 넣어주고
			sol[depth] = numArr[i];
			// 중복을 허용하므로 자기 자신인 i부터 출발
			recursion(i, depth + 1);
		}
	}

	public static void main(String[] args) {
		input();
		// 0,0에서 시작
		recursion(0, 0);
		// 마지막에 출력
		System.out.println(sb);
	}
}
