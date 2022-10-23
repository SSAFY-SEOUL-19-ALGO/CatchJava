package week9.week9_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1303_전쟁전투 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

		String s[] = br.readLine().split(" ");

		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);

		war = new int[N][M];
		visited = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			String st = br.readLine();
			for (int m = 0; m < M; m++) {
				if(st.charAt(m)=='W')
					war[n][m] = 0;
				else
					war[n][m] = 1;
			}
		}
		int powerB = 0, powerW = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(!visited[n][m]) {
					if(war[n][m]==0) {
						powerW+=Math.pow(bfs(n,m), 2);
					}else {
						powerB+=Math.pow(bfs(n,m), 2);
					}
				}
			}
		}
		
		System.out.println(powerW+ " "+powerB);

	}

	static int N, M;
	static int[][] war;
	static boolean[][] visited;

	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };

		q.add(new int[] { x, y });
		visited[x][y] = true;
		int cnt = 1;
		while (!q.isEmpty()) {

			int cx = q.peek()[0];
			int cy = q.poll()[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]&&war[nx][ny]==war[cx][cy]) {
					visited[nx][ny]=true;
					q.add(new int[] { nx, ny });
					cnt++;
				}
			}

		}
		return cnt;
	}
}
