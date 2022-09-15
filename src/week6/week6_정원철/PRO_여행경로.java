package week6.week6_정원철;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PRO_여행경로 {
	
//	모든 공항은 알파벳 대문자 3글자로 이루어집니다.
//	주어진 공항 수는 3개 이상 10,000개 이하입니다.
//	tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
//	주어진 항공권은 모두 사용해야 합니다.
//	만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
//	모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
	
	
// 문자열 리스트 -> 오름차순 -> 제일 앞 -> start end dfs
	
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
