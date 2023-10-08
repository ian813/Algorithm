import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> list;
    int country;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        int cnt = 0;
        
        country = tickets.length;
        
        visited = new boolean[country];
        
        list = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, cnt);
        
        // 알파벳 순으로 정렬
        Collections.sort(list);
        
        // 첫 번째 루트를 선택
        answer = list.get(0).split(" ");
        
        return answer;
    }
    
        public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == country){
            list.add(route);
            return;
        }
        
        for(int i = 0; i < country; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}