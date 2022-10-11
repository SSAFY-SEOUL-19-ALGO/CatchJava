package week10.week10_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class P3187_양치기꿍 {
	static class node{
		int x, y;

		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int w, s;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s1[] = bf.readLine().split(" ");
		R = Integer.parseInt(s1[0]); // 세로
		C = Integer.parseInt(s1[1]); // 가로
		
		map = new char[R][C];
		visited = new boolean[R][C];
		ArrayList<node> list = new ArrayList<>();
		
 		s = 0; // sheep
 		w = 0; // wolf
 		
 		for (int i = 0; i < R; i++) {
			String s2 = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s2.charAt(j);
				
				if(map[i][j]=='#') { // 울타리 기준으로 bfs !
					list.add(new node(i,j));
				}
				if(map[i][j]=='k') s++; // 양
				if(map[i][j]=='v') w++; // 늑대
 			}
		} // 입력 완료
		
 		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			
			if(!visited[x][y]) bfs(x, y);
		}
 		
 		System.out.println(s+" "+w);
	}

	private static void bfs(int x, int y) {
		Queue<node> q = new ArrayDeque<>();
		
		q.offer(new node(x, y));
		visited[x][y] = true;
		
		int sheep = 0;
		int wolf = 0;
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			int tmpx = cur.x;
			int tmpy = cur.y; 
			
			// 양인 경우 // 늑대인경우
			if(map[tmpx][tmpy]=='k') sheep++;
			if(map[tmpx][tmpy]=='v') wolf++;
			
			for (int d = 0; d < 4; d++) {
				int nx = tmpx + dx[d];
				int ny = tmpy + dy[d];
				
				if(nx<0 || ny<0 || nx >=R || ny >= C) continue; // 범위를 벗어나는 경우
				
				if(map[nx][ny]=='#') continue; // 울타리인 경우
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new node(nx, ny));
				}
			}
		}
		
		if(wolf >= sheep) 
			s -= sheep;
		else 
			w-= wolf;
		
	}

}
