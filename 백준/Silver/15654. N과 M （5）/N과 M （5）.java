import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] nArr;
	static int[] sol;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 데이터를 받을 배열
		nArr = new int[N];
		// 방문 체크
		flag = new boolean[N];
		// 출력할 답
		sol = new int[M];
		
		for(int idx = 0; idx < N; idx++) {
			nArr[idx] = sc.nextInt();
		}
		
		// nArr을 버블정렬을 이용해서
		// 오름차순 정렬
		int i = 1;
		while(i != N) {
			for(int idx = 0; idx < N-i; idx++) {
				if(nArr[idx] > nArr[idx+1]) {
					int tmp = nArr[idx];
					nArr[idx] = nArr[idx+1];
					nArr[idx+1] = tmp;
				}
			}
			i++;
		}
		
	}
	
	static void recursion(int depth) {
		if(depth == M) {
			for(int idx = 0; idx < M; idx++) {
				// sb에 들어오는 순서대로 공백과 함께 담아준다.
				sb.append(sol[idx] + " ");
			}
			// 한번 시행이 끝나면 개행해준다.
			sb.append('\n');
			return; // 리턴이 없으면 재귀함수가 멈추지 않는다,,
		}
		
		// 재귀함수를 이용해서 구현
		for(int idx = 0; idx < N; idx++) {
			if(flag[idx] == false) {
				// 방문하지 않은 곳이면
				// 방문체크해주고
				flag[idx] = true;
				
				// 출력할 답에 데이터를 넣어준다.
				sol[depth] = nArr[idx];
				
				// 재귀함수 호출
				recursion(depth + 1);
				
				// 한번 끝나면 다시 방문체크 해제
				flag[idx] = false;
			}
			
		}
	}
	
	public static void main(String[] args) {
		input();
		
		recursion(0);
		
		System.out.print(sb);
	}
}
