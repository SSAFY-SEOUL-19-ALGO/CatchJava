package week8.week8_조민수;

import java.io.*;
import java.util.*;

public class 구슬탈출2 {
	static int n,m;
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static char[][]map;
	//두 구슬 위치에서 시작한 적이 있는지 체크
	static ArrayList<int[]>vistied;
	//bfs
	static int bfs(int rx,int ry,int bx,int by) {
		int cnt=0;
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {rx,ry,bx,by});
		vistied.add(new int[] {rx,ry,bx,by});
		while(!q.isEmpty()) {
			cnt++;
			if(cnt>10)return -1;
			for(int i=0,size=q.size();i<size;i++) {
				int[]temp=q.poll();
				for(int d=0;d<4;d++) {
					int nrx=temp[0];
					int nry=temp[1];
					int nbx=temp[2];
					int nby=temp[3];
					//각 구슬이 홀에 들어갔는지 여부
					boolean holeR=false,holeB=false;
					//각 구슬이 몇번 움직였는지 카운팅
					int moveR=0,moveB=0;
					//홀에 들어가거나 벽을 만날 때 까지 빨간 구슬 이동
					while(true) {
						moveR++;
						nrx+=dx[d];
						nry+=dy[d];
						if(map[nrx][nry]=='O') {
							holeR=true;
							break;
						}
						if(map[nrx][nry]=='#') {
							nrx-=dx[d];
							nry-=dy[d];
							break;
						}
					}
					//홀에 들어가거나 벽을 만날 때 까지 파란 구슬 이동
					while(true) {
						moveB++;
						nbx+=dx[d];
						nby+=dy[d];
						if(map[nbx][nby]=='O') {
							holeB=true;
							break;
						}
						if(map[nbx][nby]=='#') {
							nbx-=dx[d];
							nby-=dy[d];
							break;
						}
					}
					//파란 구슬이 들어갔으면 다음 탐색X
					if(holeB)continue;
					//빨간 구슬만 들어갔으면 종료 후 몇번 움직였는지 리턴
					if(holeR)return cnt;
					//두 구슬이 같은 위치인 경우 더 많이 이동한 구슬이 늦게 도착했으므로 그 구슬을 반대 방향으로 한 칸이동
					if(nbx==nrx&&nby==nry) {
						if(moveB>moveR) {
							nbx-=dx[d];
							nby-=dy[d];
						}
						else {
							nrx-=dx[d];
							nry-=dy[d];
						}
					}
					//이동된 위치에서 시작된 적이 없으면 q에 삽입
					if(check(nrx, nry, nbx, nby)) {
						q.add(new int[] {nrx, nry, nbx, nby});
						vistied.add(new int[] {nrx, nry, nbx, nby});
					}
				}
			}
		}
		return -1;
	}
	//방문 여부 체크
	static boolean check(int rx,int ry,int bx,int by) {
		for(int[]a:vistied) {
			if(a[0]==rx&&a[1]==ry&&a[2]==bx&&a[3]==by)return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new char[n][m];
		int redX=0,redY=0,blueX=0,blueY=0;
		for(int i=0;i<n;i++) {
			char[]temp=br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j]=temp[j];
				//두 구슬의 위치 저장 -> bfs 시작 위치
				if(map[i][j]=='B') {
					blueX=i;
					blueY=j;
				}
				if(map[i][j]=='R') {
					redX=i;
					redY=j;
				}
			}
		}
		vistied=new ArrayList<>();
		System.out.println(bfs(redX, redY, blueX, blueY));
	}
}