import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int[] limit;
	static boolean[][] check;
	static Set<Integer> answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
        // 물통 용량
		limit = new int[3];
        // 방문체크(부피 리미트가 200이므로) 두개의 물의 양을 알면 나머지 하나의 물의 양도 알기 때문에
        // 2차원 배열로 첫번째, 두번째 물통의 양만 체크해주면 된다.
		check = new boolean[201][201];
		for(int i=0; i<3; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
        // 트리셋은 자동으로 오름차순 정렬 가능
		answer = new TreeSet<>();
        // 초기 각 물통에 들은 물의 양으로 탐색 시작
		dfs(0,0, limit[2]);
		
        // 형식에 맞게 출력
		for(int num : answer) {
			System.out.print(num+" ");
		}
	}
	static void dfs(int a, int b, int c){
		// 방문한 곳이면 리턴
        if(check[a][b]) return;
		
        // 첫번째 물통에 물의 양이 0일 때 세번째 물통의 물의 양을 set에 추가
		if(a==0) {
			answer.add(c);
		}
        // 방문 안했으면 방문체크
		check[a][b] = true;
        
        // 6가지 경우의 수에 대해서 탐색
        
		// 0 -> 1
		if(a+b > limit[1]) { // a+b와 두번쨰 물통(1)의 리미트를 비교해서 맞는 조건으로 다시 탐색
			dfs((a+b)-limit[1], limit[1], c);
		}else {
			dfs(0, a+b, c);
		}
		
		// 1 -> 0
		if(a+b > limit[0]) {
			dfs(limit[0], a+b-limit[0], c);
		}else {
			dfs(a+b, 0, c);
		}
		
		// 2 -> 0
		if(a+c > limit[0]) {
			dfs(limit[0], b, a+c-limit[0]);
		}else {
			dfs(a+c, b, 0);
		}
		
		
		// 2 -> 1
		if(b+c > limit[1]) 	{
			dfs(a, limit[1], b+c-limit[1]);
		}else {
			dfs(a, b+c, 0);
		}
		
		// 0 -> 2
		dfs(a, 0, b+c);
		// 1 -> 2
		dfs(0, b, a+c);
	}
}