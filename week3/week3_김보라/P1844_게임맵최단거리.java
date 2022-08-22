package week3_김보라;

import java.util.LinkedList;
import java.util.Queue;

public class P1844_게임맵최단거리 {

	static int maps[][]={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
	
	public static void main(String[] args) {
		//뭔가 큐를 사용하고 싶은 문제야
		//bfs
		
//		boolean visited[][] = new boolean[maps.length][maps[0].length];
		int visited[][] = new int[maps.length][maps[0].length];//메모이제이션할랭
		
		int x=0, y = 0;
		visited[x][y]=1;//지나가요~
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			//사방탐색
			if(cur[0]+1<maps.length) {
//				if(visited[cur[0]+1][cur[1]]==false&&maps[cur[0]+1][cur[1]]==1) {
//					visited[cur[0]+1][cur[1]]=true;
				if(visited[cur[0]+1][cur[1]]==0&&maps[cur[0]+1][cur[1]]==1) {
					visited[cur[0]+1][cur[1]]=visited[cur[0]][cur[1]]+1;
					q.add(new int[] {cur[0]+1,cur[1]});
				}
			}
			if(cur[1]+1<maps[0].length) {
				if(visited[cur[0]][cur[1]+1]==0&&maps[cur[0]][cur[1]+1]==1) {
					visited[cur[0]][cur[1]+1]=visited[cur[0]][cur[1]]+1;
					q.add(new int[] {cur[0],cur[1]+1});
				}
			}
			if(cur[0]-1>=0) {
				if(visited[cur[0]-1][cur[1]]==0&&maps[cur[0]-1][cur[1]]==1) {
					visited[cur[0]-1][cur[1]]=visited[cur[0]][cur[1]]+1;
					q.add(new int[] {cur[0]-1,cur[1]});
				}
			}
			if(cur[1]-1>=0) {
				if(visited[cur[0]][cur[1]-1]==0&&maps[cur[0]][cur[1]-1]==1) {
					visited[cur[0]][cur[1]-1]=visited[cur[0]][cur[1]]+1;
					q.add(new int[] {cur[0],cur[1]-1});
				}
			}
			
		}//while종료
		
		int answer= visited[maps.length-1][maps[0].length-1]; //마지막
		if(answer==0)
			answer=-1;	//도달하지 못함
		
		System.out.println(answer);
	}//main종료

}
