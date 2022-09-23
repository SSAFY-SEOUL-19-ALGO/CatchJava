package week8.week8_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 구슬_탈출2 {

	static class Ball {
		int redX, redY, blueX, blueY, cnt;

		public Ball(int redX, int redY, int blueX, int blueY, int cnt) {
			super();
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] red = new int[2];
		int[] blue = new int[2];
		char[][] arr = new char[N][M];
		boolean[][][][] visited = new boolean[N][M][N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				
				if (arr[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
				} else if (arr[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
				}
			}
		}
		
		// bfs
		int[] dx = {-1, 1, 0, 0}; // 상하좌우 
		int[] dy = {0, 0, -1, 1};
		
		Queue<Ball> q = new ArrayDeque<>();
		q.offer(new Ball(red[0], red[1], blue[0], blue[1], 1));
		visited[red[0]][red[1]][blue[0]][blue[1]] = true;
		
		while(!q.isEmpty()) {
			Ball cur = q.poll();
			
			if (cur.cnt > 10) {
				System.out.println(-1);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nrx = cur.redX;
				int nry = cur.redY;
				int nbx = cur.blueX;
				int nby = cur.blueY;
				
				boolean redHole = false;
				boolean blueHole = false;
				
				// 빨간 구슬이 움직이지 않을 때까지 기울이기 
				while (arr[nrx + dx[d]][nry + dy[d]] != '#') {
					nrx += dx[d];
					nry += dy[d];
					
					// 구멍을 만났을 경우 
					if (arr[nrx][nry] == 'O') {
						redHole = true;
						break;
					}
				}

				while (arr[nbx + dx[d]][nby + dy[d]] != '#') {
					nbx = nbx + dx[d];
					nby = nby + dy[d];
					
					// 구멍을 만났을 경우 
					if (arr[nbx][nby] == 'O') {
						blueHole = true;
						break;
					}
				}
				
				// 다른 방향으로 이동하기 
				if (blueHole) continue;
				
				// 답을 찾았을 경우 
				if (redHole && !blueHole) {
					System.out.println(cur.cnt);
					return;
				}
				
				// 이동할 위치가 같을 경우 
				if (nrx == nbx && nry == nby) {
					if(d == 0) { // 상  
						if(cur.redX > cur.blueX) nrx -= dx[d]; 
						else nbx -= dx[d];
					} else if(d == 1) { // 하 
						if(cur.redX < cur.blueX) nrx -= dx[d]; 
						else nbx -= dx[d];
					} else if(d == 2) { // 좌 
						if(cur.redY > cur.blueY) nry -= dy[d]; 
						else nby -= dy[d];	
					} else { // 우 
						if(cur.redY < cur.blueY) nry -= dy[d];
						else nby -= dy[d];	
					}
				}
				
				if (!visited[nrx][nry][nbx][nby]) {
					visited[nrx][nry][nbx][nby] = true;
					q.offer(new Ball(nrx, nry, nbx, nby, cur.cnt + 1));
				}
			}
		}
		
		System.out.println(-1);
	}

}
