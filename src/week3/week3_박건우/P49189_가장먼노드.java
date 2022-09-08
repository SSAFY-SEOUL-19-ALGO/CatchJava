package week3.week3_박건우;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class P49189_가장먼노드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class Solution_49189 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        int answer;
        
        for(int i = 0; i <= n; i++) {
        	graph.add(i, new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++) {
        	graph.get(edge[i][0]).add(edge[i][1]);
        	graph.get(edge[i][1]).add(edge[i][0]);
        }
        answer = bfs();
        return answer;
    }
    
    public static int bfs() {
    	Deque<Integer> q = new ArrayDeque<Integer>();
    	q.add(1);
    	visited[1] = true;
    	
    	int cnt = 0;
    	while(true) {
    		Deque<Integer> temp = new ArrayDeque<Integer>();
    		
    		while(q.isEmpty() == false) {
    			int cur = q.poll();
    			for(int adj : graph.get(cur)) {
    				if(visited[adj] == false) {
    					temp.add(adj);
    					visited[adj] = true;
    				}
    			}
    		}
    		
    		if(temp.isEmpty()) break;
    		q.addAll(temp);
    		cnt = temp.size();
    	}
    	
    	return cnt;
    }
}
