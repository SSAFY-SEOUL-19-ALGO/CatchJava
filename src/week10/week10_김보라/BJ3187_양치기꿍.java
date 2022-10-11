package week10.week10_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ3187_양치기꿍 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");
		
		R = Integer.parseInt(st[0]);
		C = Integer.parseInt(st[1]);
		map = new char[R][C];
		
		for(int r = 0; r<R; r++) {
			String s = br.readLine();
			for(int c = 0; c<C; c++) {
				map[r][c]=s.charAt(c);
			}
		}
		
		for(int r = 0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				if(map[r][c]!='0') {
					count(r,c);
				}
			}
		}
		
		System.out.println(sheep+" "+wolf);
		
	}
	static int R, C;
	static char map[][];
	static int sheep=0, wolf=0;
	
	static void count(int x, int y) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		Queue<int[]> q = new ArrayDeque<>();
		
		int cnts = 0;
		int cntw = 0;
		
		q.add(new int[] {x,y});
		map[x][y]='0';
		
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.poll()[1];
			
			for(int d = 0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx>=0&&ny>=0&&nx<R&&ny<C&&map[nx][ny]!='#'&&map[nx][ny]!='0') {
					q.add(new int[] {nx,ny});
					if(map[nx][ny]=='v') {
						cntw++;
					}else if(map[nx][ny]=='k') {
						cnts++;
					}
					map[nx][ny]='0';
					
				}
			}
		}
		if(cnts>cntw) {
			sheep+=cnts;
		}else {
			wolf+=cntw;
		}
	}
}
