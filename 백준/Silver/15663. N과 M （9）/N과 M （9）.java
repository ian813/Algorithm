import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] numArr;
	static boolean[] visit;
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
		// 방문 체크해줄 배열
		visit = new boolean[N];
		
		// 오름차순 정렬
		Arrays.sort(numArr);

		// 정답을 임시 저장할 배열
		sol = new int[M];
		
		sc.close();
	}
	
	// 재귀함수 (깊이)
	static void recursion(int depth) {
		if (depth == M) {
			// 원하는 길이만큼 depth가 되면
			for (int num : sol) {
				// sol에 저장된 값들 스트링빌더에 담아주기
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 전에 입력받은 수를 저장할 변수
		int before = 0;
		
		for(int idx = 0; idx < N; idx++) {
			// 방문한 곳이면 넘어가기
			if(visit[idx]) {
				continue;
			}
			
			// 전에 입력받은 수가 아니면
			if(before != numArr[idx]) {
				// 방문 처리
				visit[idx] = true;
				
				// 결과값 저장
				sol[depth] = numArr[idx];
				// 전에 입력받은 수를 갱신
				before = numArr[idx];
				// 재귀 호출
				recursion(depth+1);
				
				// 재귀 끝나면 방문 취소 처리
				visit[idx] = false;
			}

		}
		
	}

	public static void main(String[] args) {
		input();
		// 0에서 시작
		recursion(0);
		// 마지막에 출력
		System.out.println(sb);
	}
}