import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, M 입력받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			// map에 입력받은 문자열을 키, 1을 벨류로 해서 집어넣기
			map.put(str, 1);
		}
		
		int cnt = 0; // 몇 개의 문자열이 포함되어있는지 세줄 변수
		
		for(int j = 0; j < M; j++) {
			String str = br.readLine();
			
			if(map.containsKey(str)) cnt++; // 입력받은 문자열을 포함하는 키가 있으면 카운팅
		}
		
		System.out.println(cnt);
	}
	
}