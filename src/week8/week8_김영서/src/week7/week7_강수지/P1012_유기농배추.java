package week7.week7_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1012_유기농배추 {
	static int M,N,K;
	static int[][] map;
	static boolean[][] visitied;
	static int[] dx = {0,-1,0,1}; // 4방향
	static int[] dy = {1,0,-1,0};
	static int cnt;
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine()); // test case
		for (int t = 0; t < tc; t++) {
			
			String s[] = bf.readLine().split(" "); // M*N
			M = Integer.parseInt(s[0]);
			N = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]); // 배추위치의 개수
			
			map = new int[M][N];
			visitied = new boolean[M][N];
			for (int i = 0; i < K; i++) { // 배추의 위치를 저장
				String s1[] = bf.readLine().split(" ");
				int x = Integer.parseInt(s1[0]);
				int y = Integer.parseInt(s1[1]);
				map[x][y]  = 1;
			}
			
			cnt = 0;
			// 저장 된 배추의 위치를 돌면서 .. dfs 가 호출되는 횟수가 배추지렁이 마리수 !?
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !visitied[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		} // test case end
	} // main end
	
	private static void dfs(int i, int j) {	
		visitied[i][j] = true;
		
		for (int d = 0;  d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx>=0 && ny>=0 && nx < M && ny < N) {
				if(!visitied[nx][ny] && map[nx][ny]==1) {
					dfs(nx,ny);
				}
			}
			
		}
	} // dfs end

}
