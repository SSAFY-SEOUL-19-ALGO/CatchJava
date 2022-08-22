package week3_김영서;

import java.util.LinkedList;
import java.util.Queue;

public class p1844_게임맵최단거리 {
	int[]dx = {1,0,-1,0};
	int[]dy = {0,1,0,-1};
	
	public void bfs(int[][]maps, int[][]visited) {
		int x =0;
		int y =0;
		visited[x][y] =1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			int cX= cur[0];
			int cY= cur[1];
			
			//사방으로 이동하기
			for(int i=0;i<4;i++) {
				int nX= cX + dx[i];
				int nY= cY + dy[i];
				if(nX<0 || nX>maps.length-1 || nY<0 || nY>maps[0].length-1) {
					continue;
				}
				if(visited[nX][nY] ==0 && maps[nX][nY]==1) {
					visited[nX][nY] = visited[cX][cY]+1;
					q.add(new int[] {nX,nY});
				}
			}
		}
	}
	
	public int solution(int[][] maps) {
		int answer = 0;
		
		int[][]visited = new int[maps.length][maps[0].length];
		

		
		bfs(maps,visited);
		answer = visited[maps.length-1][maps[0].length-1];
		
		
        if(answer == 0){
            answer = -1;
        }
        
		return answer;
	}
}