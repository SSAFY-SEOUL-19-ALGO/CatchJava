package week9.week9_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 전쟁 {

	static char [][]map;
	static boolean[][] visited;
	static int N,M;
	static int W,B;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static void bfs(int x, int y, char who) {
		int n=1;
		ArrayDeque<int[]> q=new ArrayDeque<int[]>();
		q.add(new int[] {x,y});
		if(who=='W') {
			while(!q.isEmpty()) {
				int[]now=q.poll();
				x=now[0];
				y=now[1];
				for(int i=0;i<4;i++) {
					if(0<=x+dx[i]&&x+dx[i]<N&&0<=y+dy[i]&&y+dy[i]<M
							&&map[x+dx[i]][y+dy[i]]=='W'&&!visited[x+dx[i]][y+dy[i]]) {
						visited[x+dx[i]][y+dy[i]]=true;
						n++;
						q.add(new int[] {x+dx[i],y+dy[i]});
					}
				}
			}
			W+=n*n;
			return;
		}
		else {
			while(!q.isEmpty()) {
				int[]now=q.poll();
				x=now[0];
				y=now[1];
				for(int i=0;i<4;i++) {
					if(0<=x+dx[i]&&x+dx[i]<N&&0<=y+dy[i]&&y+dy[i]<M
							&&map[x+dx[i]][y+dy[i]]=='B'&&!visited[x+dx[i]][y+dy[i]]) {
						visited[x+dx[i]][y+dy[i]]=true;
						n++;
						q.add(new int[] {x+dx[i],y+dy[i]});
					}
				}
			}
			B+=n*n;
			return;
		}
		
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []st=br.readLine().split(" ");
		M=Integer.parseInt(st[0]);
		N=Integer.parseInt(st[1]);
		map=new char[N][M];
		visited=new boolean[N][M];
		W=0;
		B=0;
		for(int i=0;i<N;i++) {
			st=br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j]=st[j].charAt(0);
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]) {//방문안한자리면
					visited[i][j]=true;
					bfs(i,j,map[i][j]);
				}
			}
		}
		System.out.println(W+" "+B);

	}

}
