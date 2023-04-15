import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] numArr;	
	static int[] result;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		numArr = new int[N];
		
		for(int idx = 0; idx < N; idx++) {
			numArr[idx] = sc.nextInt();
		}
		
		Arrays.sort(numArr);
		
		result = new int[M];
	}
	
	static void recur(int start, int depth) {
		if(depth == M) {
			// 원하는 깊이에 도달했으면
			// 형식에 맞게 출력
			for(int idx = 0; idx < M; idx++) {
				sb.append(result[idx] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int num = 0; // 수를 비교할 변수
		for(int i = start; i < N; i++) {
			// 시작점부터 값을 넣어준다.
			// 만약 직전에 쓰였던 수와 같은 수가 중복되면 넘김 (자기 자신말고 중복되는 수가 있을시)
			if(num == numArr[i]) continue;
			
			result[depth] = numArr[i]; // 수를 원하는 위치에 넣어줌
			recur(i, depth+1); // 재귀 호출 (현재 넣은 수를 시작위치로)
			num = numArr[i]; // 직전에 쓰였던 수를 저장
		}
		
	}
	
	public static void main(String[] args) {
		input();
		recur(0, 0);
		
		System.out.println(sb);
	}
}