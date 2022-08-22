package week3_정원철;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lv3_네트워크 {
	
	static int [][]computers;
	static int n;
	static public int solution(int n, int[][] computers) {
		int answer = 0;
    	boolean[] visited = new boolean[n]; // 방문체크 
    	
    	for(int i = 0; i <n; i++) {
    		boolean chk = true; 
    		
    		if(visited[i]) continue; // 방문한 노드는 패스
    		visited[i] = true;
    		
    		for(int j = 0; j < n; j++) {
    	    	if(computers[i][j] == 0) continue;
    	    	if(visited[j]) continue;
    	    	
                // 노드가 연결이 됐으면 순회
    	    	Queue<Integer> que = new ArrayDeque<Integer>();
    	    	que.offer(j);
    	    	
    	    	visited[j] = true;
    	    	
    	    	while(!que.isEmpty()) {
    	    		int node = que.poll();
    	    		
    	    		for(int end = 0; end < n; end++) {
    	    			if(visited[end]) 
    	    				continue;
    	    			if(computers[node][end] == 1) {
    	    				que.offer(end); // 연결된 모든 노드 방문
    	    				visited[end] = true; 
    	    			}
    	    		}
    	    	}
    	    	chk = false;
    	    	answer++;
    		}
    		
            // 연결이 안된경우
    		if(chk) 
    			answer++;
    	}
    	
    	
        return answer;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n=3;
		computers= new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n, computers));
	}

}
