package week6.week6_박건우;

import java.util.ArrayList;
import java.util.Collections;

public class P43164_여행경로 {
    public static void main(String[] args) {

    }
}

class Solution_travel {
    boolean[] visited;
    ArrayList<String> allRoute;
    public String[] solution(String[][] tickets) {
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        return allRoute.get(0).split(" ");
    }

    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            allRoute.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+ " " + tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}