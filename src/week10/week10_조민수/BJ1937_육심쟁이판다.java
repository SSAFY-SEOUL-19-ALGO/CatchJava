package week10.week10_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1937_육심쟁이판다 {
	static int size, cur, max;
	static int[][] map, dp;
	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		dp = new int[size][size];
		max = 0;
		for (int i = 0; i < size; i++) {
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cur = dfs(i, j);;
				if (cur > max)
					max = cur;

			}
		}
		System.out.println(max + 1);
	}

	private static int dfs(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		for (int d = 0; d < 4; d++) {
			if (0 <= x + dr[d] && x + dr[d] < size && 0 <= y + dc[d] && y + dc[d] < size
					&& map[x + dr[d]][y + dc[d]] > map[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(x + dr[d],y + dc[d]) + 1);
			}
		}
		return dp[x][y];
	}

}
