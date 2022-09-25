package week7.week7_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class 유기농배추 {
	static int m,n,cnt,worm;//가로 세로 배추개수
	static int[][]map;//지도
	static boolean[][]visited;
	static int[] dx= {-1,1,0,0};//상하좌우
	static int[] dy= {0,0,-1,1};
	
	static void bfs(int i,int j) {
		if(map[i][j]==0) {//0이면 볼 필요 X
			visited[i][j]=true;
			return;
		}
		worm++;
		ArrayDeque<int[]> Q=new ArrayDeque<>();//bfs용 큐
		Q.add(new int[]{i,j});
 		while(!Q.isEmpty()) {
			int []xy=Q.poll();
			int x=xy[0];
			int y=xy[1];
			visited[x][y]=true;
			for (int l = 0; l < 4; l++) {
				
				if (0<=x+dx[l]&&x+dx[l]<m&&0<=y+dy[l]&&y+dy[l]<n&&!visited[x+dx[l]][y+dy[l]]) {//갈 수 있는 범위고 안간 자리이다.
					if(map[x+dx[l]][y+dy[l]]==1) {
						visited[x+dx[l]][y+dy[l]]=true;
						Q.add(new int[] {x+dx[l],y+dy[l]});
					}
				}	
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());//테스트 케이스 수
		
		for(int t=0;t<tc;t++) {
			String [] st= br.readLine().split(" ");
			m=Integer.parseInt(st[0]);
			n=Integer.parseInt(st[1]);
			cnt=Integer.parseInt(st[2]);
			worm=0;
			map=new int[m][n];
			visited=new boolean[m][n];
			for(int i=0;i<cnt;i++) {
				st= br.readLine().split(" ");
				int x=Integer.parseInt(st[0]);
				int y=Integer.parseInt(st[1]);
				map[x][y]=1;//배추자리 저장
			}
	
			//bfs로 탐색하며 배추 뭉탱이 찾기
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(!visited[i][j]) {//방문 안한애만 방문
						bfs(i,j);
					}
					
				}
			}
			System.out.println(worm);
		}		
	}
}

