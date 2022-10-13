package week10.week10_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_양치기꿍 {

	static int R,C, goatCnt=0, wolfCnt=0, resultWolf=0, resultGoat=0;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st[]=br.readLine().split(" ");
		
		R= Integer.parseInt(st[0]);
		C= Integer.parseInt(st[1]);
		
		map=new char[R][C];
		for(int i=0; i<R; i++) {
			String str=br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=str.charAt(j);
			}	
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='v'||map[i][j]=='k') {
					dfs(i,j);
					if(wolfCnt>=goatCnt) {
						resultWolf+=wolfCnt;
					}else if(wolfCnt<goatCnt) {
						resultGoat+=goatCnt;
					}
					goatCnt=0;
					wolfCnt=0;	
				}
			}	
		}
		System.out.println(resultGoat+" "+resultWolf);
	}
	
	public static void dfs(int x, int y) {
		if(x<0|| y<0|| x>=R||y>=C) return;
	
			if(map[x][y]=='v') {
				map[x][y]='x';
				wolfCnt++;
				dfs(x-1, y);
			    dfs(x, y-1);
			    dfs(x+1, y);
			    dfs(x, y+1);
			}else if (map[x][y]=='k') {
				map[x][y]='x';
				goatCnt++;
				dfs(x-1, y);
			    dfs(x, y-1);
			    dfs(x+1, y);
			    dfs(x, y+1);
			}else if(map[x][y]=='.') {
				map[x][y]='x';
				dfs(x-1, y);
			    dfs(x, y-1);
			    dfs(x+1, y);
			    dfs(x, y+1);
			}

	}

}