import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static int testCase = sc.nextInt(); // 테스트케이스
	static int N; // 문서 개수
	static int M; // 큐에서의 위치 (0부터 시작)
	
	static Queue<int[]> queue; // 문서 정보를 담을 큐
	
	static int cnt; // 몇 번째로 인쇄되는지 세줄 변수
	
	static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		// 매 시행마다 큐 초기화
		queue = new LinkedList<>();
		
		for(int idx = 0; idx < N; idx++) {
			int[] temp = new int[2];
			// 문서의 번호와 중요도를 담아서
			temp[0] = idx;
			temp[1] = sc.nextInt();
			// 큐에 저장
			queue.offer(temp);
		}
	}
	
	static void solve() {
		input();
		// 몇 번 뽑아냈는지 세 줄 변수
		cnt = 0;
		
		while(true) {
			// 타깃 문서를 찾을 배열
			int[] print = null;
			// 중요도가 최대인지 판단하는 불리안
			boolean isMax = false;
			
			while(!isMax) {
				isMax = true;
				// 임시로 큐에서 뽑은 배열을 저장
				int[] tmp = queue.poll();
				
				for(int idx = 0; idx < queue.size(); idx++) {
					if(tmp[1] < ((LinkedList<int[]>) queue).get(idx)[1]) {
						// 중요도가 더 높은 문서가 있으면 tmp를 큐에 넣어준다.
						queue.offer(tmp);
						// 중요도가 가장 높은 문서를 찾을 때까지 반복해야 하므로
						// 다시 false로 바꿔준다.
						isMax = false;
						break;
					}
				}
				// 현재 문서를 타깃 문서 값에 저장
				print = tmp;
			}
			// 와일문을 빠져 나오면
			// 큐에 있었던 가장 중요도 높은 문서가
			// poll된 것이므로
			// 카운트 해주기
			cnt++;
			
			// 타깃 문서가 맞으면
			// 스트링빌더에 담고 반복문 종료
			if(print[0] == M) {
				sb.append(cnt).append("\n");
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// 테케만큼 실행
		for(int tc = 1; tc <= testCase; tc++) {
			solve();
		}
		// 출력
		System.out.println(sb);
	}
}
