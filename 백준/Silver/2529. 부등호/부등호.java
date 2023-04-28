import java.util.Scanner;

public class Main {
	static int k;
	static long max, min; // 터지니까 long형으로...
	static char[] inequality;
	static final int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int[] store;
	static boolean[] visited;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt(); // 부등호 정보 개수
		
		inequality = new char[k]; // 부등호 정보 담아주기
		store = new int[k+1]; // 숫자를 담을 배열 (k+1개 필요)
		visited = new boolean[10]; // num배열 방문체크
		
		for(int idx = 0; idx < k; idx++) {
			inequality[idx] = sc.next().charAt(0);
		}
		
		// 최대, 최소 담아주기
		max = 0;
		min = Long.MAX_VALUE;
	}
	
	// 순열 쓰기
	static void perm(int depth) {
		if(depth == k+1) { // 원하는 개수만큼 뽑았으면
			boolean flag = true; // 조건 맞는지 체크할 불리안
			for(int i = 0; i < k; i++) {
				if(inequality[i] == '<') { // < 부등호일 때
					if(store[i] > store[i+1]) { // > 관계이면 false
						flag = false;
						break;
					}
				} else {
					if(store[i] < store[i+1]) { // 반대 부등호도 똑같이 체크
						flag = false;
						break;
					}
				}
			}
			if(flag) { // flag가 true이면
				long tmp = 0;
				for(int i = 0; i <= k; i++) { // 배열에 들어있는 값 자릿수에 맞게 숫자로 변환
					tmp = tmp + store[i];
					if(i != k) tmp *= 10;
				}
				// 최대 최소값 갱신
				max = Math.max(max, tmp);
				min = Math.min(min, tmp);
			}
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			if(visited[i]) continue; // 방문했으면 넘김
			
			store[depth] = num[i]; // 숫자 저장
			
			visited[i] = true; // 방문체크
			
			perm(depth+1); // 재귀호출
			
			visited[i] = false; // 방문해제
		}
		
	}
	
	public static void main(String[] args) {
		input();
		perm(0);
		// 계산한 최대 최소를 문자열로 바꿔주기
		String strMax = String.valueOf(max);
		String strMin = String.valueOf(min);
		
		if(strMax.length() != strMin.length()) { // 만약 최소값의 길이가 짧으면 0이 맨 앞에 왔다는 소리..
			strMin = "0" + strMin; // 맨 앞에 0을 더해준다.
		}
		
		// 출력
		System.out.println(strMax);
		System.out.println(strMin);
		
	}
}