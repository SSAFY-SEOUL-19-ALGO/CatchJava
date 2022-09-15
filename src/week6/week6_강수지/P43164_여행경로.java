package week6.week6_강수지;

import java.util.*;

public class P43164_여행경로 {
    boolean[] visited;
    ArrayList<String> routes;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        
        visited = new boolean[tickets.length];
        routes = new ArrayList<>();
        
        dfs("ICN","ICN", tickets, cnt);
        
        // 정렬 후 첫번째 문자열을 ..
        Collections.sort(routes);
        answer = routes.get(0).split(" ");
        
        return answer;
    }
    
    //dfs
    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt==tickets.length){
            routes.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            // start 와 같고 방문하지 않은 경우 ..
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false; // 모든 경로를 탐색하기 위해
            }
        }
    }
}
