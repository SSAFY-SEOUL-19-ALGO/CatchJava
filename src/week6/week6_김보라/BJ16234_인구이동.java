package week6.week6_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ16234_인구이동 {

	public static void main(String[] args) throws Exception{
		//우엥 누가봐도 귀찮은 문제자나....
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		
		int[][] po=new int[N][N];
		for(int i = 0; i<N; i++) {
			String st[] = br.readLine().split(" ");
			for(int j = 0; j<N; j++) {
				po[i][j]=Integer.parseInt(st[j]);
			}
		}
		
		int dx[] = {0,0,-1,1};
		int dy[] = {-1,1,0,0};
		
		int answer = 0;
		while(true) {
			boolean isEnd=true;
			boolean[][] visited=new boolean[N][N];
			
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					
					if(!visited[r][c]) {
						Queue<int[]> q = new LinkedList<>();
						Queue<int[]> set = new LinkedList<>();
						
						int sum = po[r][c];
						visited[r][c]=true;
						int cnt = 1;
						q.add(new int[] {r,c});
						set.add(new int[] {r,c});
						
						while(!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.poll()[1];
							
							for(int i = 0; i<4; i++) {
								int nx = x+dx[i];
								int ny = y+dy[i];
								if(nx<N&&nx>=0&&ny<N&&ny>=0&&!visited[nx][ny]) {
									if(Math.abs(po[x][y]-po[nx][ny])<=R&&Math.abs(po[x][y]-po[nx][ny])>=L) {
										q.add(new int[] {nx,ny});
										sum+=po[nx][ny];
										visited[nx][ny]=true;
										set.add(new int[] {nx,ny});
										cnt++;
									}
								}
							}
						}//탐색끝
						
						if(cnt!=1) {
							int tmp = sum/cnt;
							while(!set.isEmpty()) {
								po[set.peek()[0]][set.poll()[1]]=tmp;
							}
							isEnd=false;
						}//값 세팅
						
						
					}
					
				}
			}//이게 한번이잖아..........ㅇ아.........
			//이씨.. 이럴거였으면 함수로 나눌걸
			if(isEnd) {
				System.out.println(answer);
				return;
			}else {
				answer++;
			}
			
		}
		
	}

}//메모리 미친듯이 잡아먹는데......? 제한없어서 다행이다..ㅎㅎ........
