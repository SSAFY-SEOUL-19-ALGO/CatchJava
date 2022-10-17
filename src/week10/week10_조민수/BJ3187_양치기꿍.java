package week10.week10_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ3187_양치기꿍 {
	static char [][]map;
	static boolean[][]visited;
	static int r,c,wolf,sheep;
	static ArrayDeque<int[]> q;
	static int []dr= {0,1,-1,0};
	static int []dc= {1,0,0,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String []st =br.readLine().split(" ");
		r=Integer.parseInt(st[0]);
		c=Integer.parseInt(st[1]);
		sheep=0;
		wolf=0;
		map=new char[r][c];
		visited= new boolean[r][c];
		for(int i=0;i<r;i++) {
			st =br.readLine().split("");
			for(int j=0;j<c;j++) {
				map[i][j]=st[j].charAt(0);
				if(map[i][j]=='v') {
					wolf++;
				}
				else if(map[i][j]=='k') {
					sheep++;
				}
			}
		}
		q=new ArrayDeque<>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]!='#'&&!visited[i][j]) {
					q.add(new int[]{i,j});
					int cSheep=0;//현재 울타리 내의 양
					int cWolf=0;//현재 울타리 내의 늑대
					while(!q.isEmpty()) {
						int []cur=q.poll();
						int x=cur[0];
						int y=cur[1];
						visited[x][y]=true;
						if(map[x][y]=='v') {
							cWolf++;
							
						}
						else if(map[x][y]=='k') {
							cSheep++;
							
						}
						for(int d=0;d<4;d++) {
							if(0<=x+dr[d]&&x+dr[d]<r&&0<=y+dc[d]&&y+dc[d]<c&&map[x+dr[d]][y+dc[d]]!='#'&&!visited[x+dr[d]][y+dc[d]]) {
								visited[x+dr[d]][y+dc[d]]=true;//방문 체크
								q.add(new int[] {x+dr[d],y+dc[d]});
								
							}
						}
					}
					//탐색을 끝내면 양 늑대 수 비교해서 삭제
					if(cSheep>cWolf) {//양이 많으면 늑대가 죽는다
						wolf-=cWolf;
					}
					else {
						sheep-=cSheep;
					}
				}
			}
		}
		System.out.println(sheep+" "+wolf);
		
	}

}
