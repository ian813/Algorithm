import java.util.*;

class Solution {
    
    int cnt = 1;

    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int num = computers.length;
        
        int[] network = new int[num];
        
        for(int i = 0; i < num; i++) {
            if(network[i] == 0) {
                network[i] = cnt;
                bfs(computers, network, i);
                cnt++;
            }
        }
        
        answer = cnt - 1;
        
        return answer;
    }
    
    public void bfs(int[][] computers, int[] network, int cur) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(cur);
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            
            for(int i = 0; i < computers[tmp].length; i++) {
                if(computers[tmp][i] == 1 && network[i] == 0) {
                    network[i] = cnt;
                    queue.add(i);
                }
            }
            
        }
        
    }
    

    
}