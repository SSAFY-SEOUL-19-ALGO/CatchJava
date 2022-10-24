package week11.week11_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ16918_봄버맨 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		N = Integer.parseInt(s[2]);
		
		map = new int[R][C];
		
		for(int r = 0; r<R; r++) {
			String st = br.readLine();
			for(int c = 0; c<C; c++) {
				if(st.charAt(c)=='O') {
					map[r][c] = 3;
				}else {
					map[r][c] = -1;
				}
			}
		}
		int n = 1;
		time();
		
		while(n<N) {
			n++;
			time();
			setBomb();
			if(n>=N)
				break;
			n++;
			time();
			boom();
			if(n>=N)
				break;
			
		}
		
		printmap();
		
		
	}
	static int R,C,N;
	static int[][] map;
	static void time() {
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]>=0)
					map[i][j]-=1;
			}
		}
	}
	static void setBomb() {
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]<0) {
					map[i][j]=3;
				}
			}
		}
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static void boom() {
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]==0) {
					map[i][j]=-1;
					for(int d = 0; d<4; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						if(nx>=0&&nx<R&&ny>=0&&ny<C&&map[nx][ny]!=0) {
							map[nx][ny]=-1;
						}
					}
				}
			}
		}
	}
	static void printmap() {
		for(int r = 0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				System.out.print(map[r][c]>0?'O':'.');
			}System.out.println();
		}
	}

}
