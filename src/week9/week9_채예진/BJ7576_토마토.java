package week9.week9_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ7576_토마토 {

	static class Point {
		int x, y, day;

		public Point(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]); // 가로 
		int N = Integer.parseInt(input[1]); // 세로 
		
		Queue<Point> q = new ArrayDeque<>();
		
		int[][] tomatoes = new int[N][M];
		for (int n = 0; n < N; n++) {
			input = br.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				tomatoes[n][m] = Integer.parseInt(input[m]);
				if (tomatoes[n][m] == 1) {
					q.offer(new Point(m, n, 0));
				}
			}
		}
		
		// 처음부터 다 익은 경우 
		if (q.size() == N * M) {
			System.out.println(0);
			return;
		}
		
		int answer = -1;
		
		int[] dx = {1, 0, -1, 0}; // 우하좌상
		int[] dy = {0, 1, 0, -1};
		
		// bfs
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				
				if (tomatoes[ny][nx] == 0) {
					tomatoes[ny][nx] = 1;
					q.offer(new Point(nx, ny, cur.day + 1));
				}
			}
			
			answer = cur.day;
		}
		
		// 익을 만큼 다 익었는데도 여전히 안 익은 부분이 있다면 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoes[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
	}

}
