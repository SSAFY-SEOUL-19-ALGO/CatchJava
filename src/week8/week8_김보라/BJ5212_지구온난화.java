package week8.week8_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ5212_지구온난화 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		map = new char[R][C];
		year = new char[R][C];
		
		for(int r = 0; r<R; r++) {
			String st = br.readLine();
			for(int c = 0; c<C; c++) {
				map[r][c]=st.charAt(c);
				year[r][c]=st.charAt(c);
			}
		}
		
		int minR=10,minC=10,maxR=0,maxC=0;
		for(int r = 0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				if(map[r][c]=='X'&&find(r,c)>=3) {
					year[r][c]='.';
				}
				if(year[r][c]=='X') {
					minR=Math.min(r, minR);
					minC=Math.min(c, minC);
					maxR=Math.max(r, maxR);
					maxC=Math.max(c, maxC);
				}
			}
		}
		
		for(int r = minR; r<=maxR; r++) {
			for(int c = minC; c<=maxC; c++) {
				System.out.print(year[r][c]);
			}System.out.println();
		}

	}
	static int R,C;
	static char[][] map,year;
	static int find(int x, int y) {
		int cnt = 0;
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0||ny<0||nx>=R||ny>=C||map[nx][ny]=='.') {
				cnt++;
			}
		}
		return cnt;
	}

}
