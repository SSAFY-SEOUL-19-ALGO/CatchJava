package week8.week8_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P13460_구슬탈출2 {
	static class Node{ 
		int rx, ry, bx, by; // 빨강 공 , 파랑 공 좌표
		int cnt; // 움직인 횟수
		public Node(int rx, int ry, int bx, int by, int cnt) {
			super();
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	static int[] dx = {0,0,-1,1}; // 공은 4 방향으로 이동
	static int[] dy = {-1,1,0,0};

	static boolean [][][][] visited;
	static char[][] map;
	static int N,M;
	static int rsx, rsy, bsx, bsy; // 빨강공 시작 좌표, 파란공 시작 좌표

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s[] = bf.readLine().split(" ");
		N = Integer.parseInt(s[0]); //세로
		M = Integer.parseInt(s[1]); //가로
		
		rsx = 0; // 빨강공 시작 좌표
		rsy = 0;
		bsx = 0; // 파란공 시작 좌표
		bsy = 0;
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='R') {
					rsx = i;
					rsy = j;
				}else if(map[i][j]=='B') {
					bsx = i;
					bsy = j;
				}
			}
		} // 입력 완료
		
		visited = new boolean[N][M][N][M]; // 방문 여부 저장 ( 빨강공 좌표, 파란공 좌표 )
		
		System.out.println(bfs());
	}// main end
		
		
	private static int bfs() {
		// bfs
		Queue<Node> q = new LinkedList<>();
		
		visited[rsx][rsy][bsx][bsy] = true;
		q.offer(new Node(rsx, rsy, bsx, bsy, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.cnt > 10) { // 10번 이하로 움직이지 못한 경우
				return -1;
			}
			
			// 파란공이 빠지는 경우 실패
			if(map[cur.bx][cur.by]== 'O') {
				continue;
			} 
			// 파란공이 빠지지 않고 빨강공이 구멍에 들어가는 경우 !
			else if (map[cur.rx][cur.ry]== 'O' && map[cur.bx][cur.by] != 'O') {
				return cur.cnt;
			}
			
			for (int d = 0; d < 4; d++) { // 4 방향 확인
				// 빨강공 이동
				int rnx = cur.rx;
				int rny = cur.ry;
				
				while(true) {
					rnx += dx[d];
					rny += dy[d];
					// 구멍에 빠지거나 벽을 만나면 
					if(map[rnx][rny]== 'O' || map[rnx][rny] =='#') break;
				}
				
				if(map[rnx][rny]=='#') { // 벽을 만나는 경우  뒤로 이동
					rnx -= dx[d];
					rny -= dy[d];
				}
				
				// 파란공 이동
				int bnx = cur.bx;
				int bny = cur.by;
				
				while(true) {
					bnx += dx[d];
					bny += dy[d];
					// 구멍에 빠지거나 벽을 만나면 
					if(map[bnx][bny]== 'O' || map[bnx][bny] =='#') break;
				}
				
				if(map[bnx][bny]=='#') { // 벽을 만나는 경우  뒤로 이동
					bnx -= dx[d];
					bny -= dy[d];
				}
				
				// 빨강공과 파란공이 같은 칸에 위치하는 경우 !
				if(rnx==bnx && rny==bny && map[rnx][rny] != 'O') {
					// 각 공의 거리를 계산
					int red = Math.abs(rnx-cur.rx) + Math.abs(rny-cur.ry);
					int blue = Math.abs(bnx-cur.bx) + Math.abs(bny-cur.by);
					
					// 더 먼 쪽이 뒤로간다 
					if(red>blue) {
						rnx -= dx[d];
						rny -= dy[d];
					}else {
						bnx -= dx[d];
						bny -= dy[d];
					}
				}
				
				// 아직 방문하지 않은 경우 !
				if(!visited[rnx][rny][bnx][bny]) {
					// 방문처리 , 이동횟수 증가
					visited[rnx][rny][bnx][bny] = true;
					q.offer(new Node(rnx, rny, bnx, bny, cur.cnt+1));
				}
			}
		}
		return -1;
	} // bfs end

}
