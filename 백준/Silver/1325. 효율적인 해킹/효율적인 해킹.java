import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static List<Integer>[] edges;
    static int[] count;
    static boolean[][] visited;
    static StringBuilder answer = new StringBuilder();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        edges = new List[n + 1];
        count = new int[n + 1];
        visited = new boolean[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            edges[i] = new ArrayList<>();
            count[i] = 0;
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            edges[b].add(a);
        }
        
         PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                
                return b[1] - a[1];
            }
        });
        for(int i = 1; i < n + 1; i++){
            visited[i][i] = true;
            dfs(i, i);
            for(int j = 1; j < n + 1; j++){
                if(visited[i][j]){
                    count[i]++;
                }
            }
            pq.offer(new int[]{i, count[i]});
        }

        int maxCnt = 0;
        int[] maxNode = pq.peek();
        maxCnt = maxNode[1];
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1] == maxCnt){
                answer.append(cur[0]).append(" ");
            }else{
                break;
            }
        }
        
        System.out.println(answer);
    }
    
    public static void dfs(int start, int node){
        if(count[node] > 0){
            for(int i = 1; i < n + 1; i++){
                if(visited[node][i]){
                    visited[start][i] = true;
                }
            }
            return;
        }
        
        for(int next : edges[node]){
            if(!visited[start][next]){
                visited[start][next] = true;
                dfs(start, next);
            }
        }
    }
}