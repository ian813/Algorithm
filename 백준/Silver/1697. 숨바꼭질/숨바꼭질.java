import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int K, ans; // 도착점, 걸린 시간, K와 N중에 큰값
	static Point start; // 시작점
	static boolean[] visited; // 방문체크
	
	// 현재 위치와 걸린 시간을 저장할 포인트 클래스
	static class Point {
		int N, time;
		
		Point(int N, int time) {
			this.N = N;
			this.time = time;
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		start = new Point(sc.nextInt(), 0); // 시작점 정보 입력
	
		K = sc.nextInt(); // 도착점
		
		visited = new boolean[100001]; // 방문체크
		
		visited[start.N] = true; // 시작위치는 방문체크
		
		sc.close();
	}
	
	static int BFS() {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(start); // 시작점 큐에 넣기
		
		while(!queue.isEmpty()) { // 큐가 빌 때까지 실행
			
			Point tmp = queue.poll();
			
			if(tmp.N == K) { // 도착하면 시간값 저장하고 멈추기
				ans = tmp.time;
				return ans;
			}
			
			if(tmp.N-1 >= 0 && tmp.N-1 <= 100000 && !visited[tmp.N-1]) {
				// N-1이 범위 안이고 방문 안했으면 큐에 넣어주고 방문체크
				queue.add(new Point(tmp.N-1, tmp.time+1));
				visited[tmp.N-1] = true;
			}
			
			if(tmp.N+1 <= 100000 && tmp.N+1 >= 0 && !visited[tmp.N+1]) {
				// N+1이 범위 안이고 방문 안했으면 큐에 넣어주고 방문체크
				queue.add(new Point(tmp.N+1, tmp.time+1));
				visited[tmp.N+1] = true;
			}
			
			if(tmp.N * 2 <= 100000 && tmp.N * 2 >= 0 && !visited[tmp.N * 2]) {
				// N*2가 범위 안이고 방문 안했으면 큐에 넣어주고 방문체크
				queue.add(new Point(tmp.N * 2, tmp.time+1));
				visited[tmp.N * 2] = true;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		input();
		BFS();
		System.out.println(ans);
	}
}
