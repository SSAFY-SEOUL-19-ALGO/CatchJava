package week8.week8_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_구슬탈출2 {
	static int minCnt = Integer.MAX_VALUE;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N, M;
	static String[][] board;
	static boolean[][][][] visited;
//DFS 사용
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");

		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);

		board = new String[N][M];
		visited = new boolean[N][M][N][M];

		int R_X = 0;
		int R_Y = 0;
		int B_X = 0;
		int B_Y = 0;

		for (int i = 0; i < N; i++) {
			String ln = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = String.valueOf(ln.charAt(j));
				if (ln.charAt(j) == 'R') {
					R_X = i;
					R_Y = j;
				} else if (ln.charAt(j)=='B') {
					B_X = i;
					B_Y = j;
				}
			}
		}

		dfs(R_X, R_Y, B_X, B_Y, 0);

		if(minCnt!=Integer.MAX_VALUE) System.out.println(minCnt);
		else System.out.println(-1); // 민 값이 변화가 없다면 -1 출력
	}

	static void dfs(int R_X, int R_Y, int B_X, int B_Y, int cnt) {
		if (cnt > 10)
			return;

		// 파랭이가 홀인
		if (board[B_X][B_Y].equals("O"))
			return;
		// 빨갱이가 홀인
		if (board[R_X][R_Y].equals("O") ) {
			minCnt = Math.min(minCnt, cnt); // 값 비교
			return;
		}

		visited[R_X][R_Y][B_X][B_Y] = true;
		for (int i = 0; i < 4; i++) {
			int n_rx = R_X;
			int n_ry = R_Y;
			int n_bx = B_X;
			int n_by = B_Y;

			// 빨갱이 이동
			while (!board[n_rx + dx[i]][n_ry + dy[i]].equals("#")) { // '#' 벽에 부딪히면 종료
				n_rx += dx[i];
				n_ry += dy[i];
				if (board[n_rx][n_ry].equals("O"))
					break; // 목표 구멍에 들어가면 종료
			}

			// 파랭이 이동
			while (!board[n_bx + dx[i]][n_by + dy[i]].equals("#")) { // '#" 벽에 부딪히면 종료
				n_bx += dx[i];
				n_by += dy[i];
				if (board[n_bx][n_by].equals("O"))
					break; // 목표 구멍에 들어가면 종료
			}

			// 빨파가 서로 겹치게 되는구간
			if (n_rx == n_bx && n_ry == n_by && !board[n_rx][n_ry].equals("O")) {
				int r_m = Math.abs(n_rx - R_X) + Math.abs(n_ry - R_Y);
				int b_m = Math.abs(n_bx - B_X) + Math.abs(n_by - B_Y);

				// 빨강이 더 가까워 버릴떄
				if (r_m > b_m) {
					n_rx -= dx[i];
					n_ry -= dy[i];
				} else { // 파랭이가이 더 가까워 버릴떄
					n_bx -= dx[i];
					n_by -= dy[i];
				}
			}

			if (!visited[n_rx][n_ry][n_bx][n_by]) {
				dfs(n_rx, n_ry, n_bx, n_by, cnt + 1);
			}

		}
		visited[R_X][R_Y][B_X][B_Y] = false;
	}

}
