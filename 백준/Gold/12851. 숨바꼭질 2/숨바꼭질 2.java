import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] time = new int[100001];
    static int minTime = 987654321;
    static int count = 0;
    
    static void input() {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	sc.close();
    }
    
    static void bfs() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	q.add(N);
    	time[N] = 1;
    	
    	while (!q.isEmpty()) {
    		int now = q.poll();
    		
    		// now 방문 시간이 최소 시간보다 크면 뒤는 더 볼 필요 없음
    		if (minTime < time[now]) return;
    		
    		for (int i=0; i<3; i++) {
    			int next;
    			
    			if (i == 0)         next = now + 1;
    			else if (i == 1)    next = now - 1;
    			else                next = now * 2;
    			
    			if (next < 0 || next > 100000) continue;
    			
    			if (next == K) {
    				minTime = time[now];
    				count++;
    			}
    			
    			// 첫 방문이거나 (time[next] == 0)
    			// 이미 방문한 곳이어도 같은 시간에 방문했다면 (time[next] == time[now] + 1)
    			// 경우의 수에 추가될 수 있기 때문에 Queue 에 한번 더 넣어줌
    			if (time[next] == 0 || time[next] == time[now] + 1) {
    				q.add(next);
    				time[next] = time[now] + 1;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
        input();
    	
    	if (N >= K) {
            System.out.println((N-K) + "\n" + 1);
        } else {        	
        	bfs();
        	System.out.println(minTime + "\n" + count);
        }

    }

}