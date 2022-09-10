package week6_정원철;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PRO_여행경로 {
	
	static boolean[] visited;
	static ArrayList<String> paths=new ArrayList<>();
	
	static String[] solution(String[][] tickets){
        visited = new boolean[tickets.length];
        String[] answer = {};
        dfs(tickets,"ICN","ICN",0);
        Collections.sort(paths);
        answer = paths.get(0).split(" ");
        return answer;
    }
	
    static void dfs(String[][] tickets,String start,String path,int cnt){
        if(tickets.length == cnt){
            paths.add(path);
            return;
        }
        for(int i = 0; i< tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                dfs(tickets,tickets[i][1],path + " " + tickets[i][1],cnt+1);
                visited[i] = false;
            }
        }
    }
	

	public static void main(String[] args) {
	
		String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
		System.out.println(Arrays.toString(solution(tickets)));
	}

}
