package week3_박건우;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1844_게임맵최단거리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_1844 {
	int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
	
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer= visited[maps.length-1][maps[0].length-1];
        
        return answer == 0 ? -1 : answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
    	int x = 0;
    	int y = 0;
    	visited[x][y] = 1;
    	Deque<int[]> q = new ArrayDeque<int[]>();
    	q.add(new int[] {x, y});
    	
    	while(q.isEmpty() == false) {
    		int[] current = q.remove();
    		int cx = current[0];
    		int cy = current[1];
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = cx + dx[i];
    			int ny = cy + dy[i];
    			
    			if(nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1)
    				continue;
    			
    			if(visited[nx][ny] == 0 && maps[nx][ny] == 1) {
    				visited[nx][ny] = visited[cx][cy] + 1;
    				q.add(new int[] {nx, ny});
    			}
    		}
    	}
    }
}