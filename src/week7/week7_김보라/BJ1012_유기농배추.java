package week7_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1012_유기농배추 {

	static int M;
	static int N;
	static boolean map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			String s[] = br.readLine().split(" ");
			
			M = Integer.parseInt(s[0]);
			N = Integer.parseInt(s[1]);
			int K = Integer.parseInt(s[2]);
			
			map = new boolean[M][N];
			for(int k = 0; k<K; k++) {
				String st[] = br.readLine().split(" ");
				map[Integer.parseInt(st[0])][Integer.parseInt(st[1])]=true;
			}
			int cnt = 0;
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		map[r][c]=false;
		q.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			
			for(int i = 0 ; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<M&&nx>=0&&ny<N&&ny>=0&&map[nx][ny]) {
					map[nx][ny]=false;
					q.add(new int[] {nx,ny});
				}
			}
			
		}
		
	}

}
