package week8.week8_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ13460_구슬탈출2 {
	/*
	 * public static void main(String[] args) throws Exception { BufferedReader br =
	 * new BufferedReader(new InputStreamReader(System.in));
	 * 
	 * String s[] = br.readLine().split(" ");
	 * 
	 * int N = Integer.parseInt(s[0]); int M = Integer.parseInt(s[1]);
	 * 
	 * board = new char[N][M];
	 * 
	 * visitedR = new boolean[N][M]; visitedB = new boolean[N][M];
	 * 
	 * for (int n = 0; n < N; n++) { String st = br.readLine(); for (int m = 0; m <
	 * M; m++) { if (st.charAt(m) == 'B') { blueX = n; blueY = m; } else if
	 * (st.charAt(m) == 'R') { redX = n; redY = m; } else if (st.charAt(m) == 'O') {
	 * goalX = n; goalY = m; } board[n][m] = st.charAt(m); } }
	 * System.out.println(bfs());
	 * 
	 * }
	 * 
	 * static int goalX, goalY, redX, redY, blueX, blueY; static boolean
	 * visitedR[][], visitedB[][]; static char board[][];
	 * 
	 * static int bfs() { int dx[] = { -1, 0, 1, 0 }; int dy[] = { 0, 1, 0, -1 };
	 * 
	 * Queue<int[]> redQ = new LinkedList<>(); Queue<int[]> blueQ = new
	 * LinkedList<>();
	 * 
	 * redQ.add(new int[] { redX, redY }); blueQ.add(new int[] { blueX, blueY });
	 * 
	 * visitedR[redX][redY] = true; visitedB[blueX][blueY] = true;
	 * 
	 * int cnt = 0;
	 * 
	 * while (!redQ.isEmpty() && !blueQ.isEmpty()) { int size = redQ.size();
	 * 
	 * for (int s = 0; s < size; s++) { int nredX = redQ.peek()[0]; int nredY =
	 * redQ.poll()[1];
	 * 
	 * int nblueX = blueQ.peek()[0]; int nblueY = blueQ.poll()[1];
	 * 
	 * for (int d = 0; d < 4; d++) { int dredX = nredX; int dredY = nredY;
	 * 
	 * boolean redGoal = false; System.out.println(board[dredX][dredY]); while
	 * (board[dredX][dredY] != '#') { if (dredX == goalX && dredY == goalY) {
	 * redGoal = true; break; } dredX += dx[d]; dredY += dy[d]; } dredX-=dx[d];
	 * dredY-=dy[d];
	 * 
	 * System.out.println(dredX+" "+dredY);
	 * 
	 * int dblueX = nblueX; int dblueY = nblueY;
	 * 
	 * boolean blueGoal = false; while (board[dblueX][dblueY] != '#') { if (dblueX
	 * == goalX && dblueY == goalY) { blueGoal = true; break; } dblueX += dx[d];
	 * dblueY += dy[d]; } dblueX-=dx[d]; dblueY-=dy[d];
	 * 
	 * 
	 * // 이동끝 if (blueGoal) { continue; } if (redGoal && !blueGoal) { return cnt; }
	 * 
	 * if (dredX == dblueX && dredY == dblueY) { switch (d) { case 0: if (nredX >
	 * nblueX) { dredX++; } else { dblueX++; } break; case 1: if (nredY < nblueY) {
	 * dredY--; } else { dblueY--; } break; case 2: if (nredX < nblueX) { dredX--; }
	 * else { dblueX--; } break; case 3: if (nredY > nblueY) { dredY++; } else {
	 * dblueY++; } break; } }
	 * System.out.println(dredX+" "+dredY+" "+dblueX+" "+dblueY); if
	 * (!visitedR[dredX][dredY] && !visitedB[dblueX][dblueY]) {
	 * visitedR[dredX][dredY] = true; visitedB[dblueX][dblueY] = true; redQ.add(new
	 * int[] { dredX, dredY }); blueQ.add(new int[] { dblueX, dblueY }); }
	 * 
	 * } } cnt++; if (cnt > 10) { return -1; } } return cnt; }
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s[] = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		board = new char[N][M];
		visited = new boolean[N][M][N][M];

		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = st.charAt(j);

				if (board[i][j] == 'O') {
					hole = new int[] { i, j };
				} else if (board[i][j] == 'B') {
					blue = new int[] { i, j };
				} else if (board[i][j] == 'R') {
					red = new int[] { i, j };
				}
			}
		}

		System.out.println(bfs());

	}

	static int N, M;
	static char[][] board;
	static boolean[][][][] visited;
	static int[] hole, blue, red;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { red[0], red[1], blue[0], blue[1], 1 });
		visited[red[0]][red[1]][blue[0]][blue[1]] = true;

		while (!queue.isEmpty()) {

			int nredX = queue.peek()[0];
			int nredY = queue.peek()[1];
			int nblueX = queue.peek()[2];
			int nblueY = queue.peek()[3];
			int cnt = queue.poll()[4];

			if (cnt > 10) {
				return -1;
			}

			for (int i = 0; i < 4; i++) {
				int dredX = nredX;
				int dredY = nredY;
				boolean redGoal = false;

				while (board[dredX + dx[i]][dredY + dy[i]] != '#') {
					dredX += dx[i];
					dredY += dy[i];

					if (dredX == hole[0] && dredY == hole[1]) {
						redGoal = true;
						break;
					}
				}

				int dblueX = nblueX;
				int dblueY = nblueY;
				boolean blueGoal = false;

				while (board[dblueX + dx[i]][dblueY + dy[i]] != '#') {
					dblueX += dx[i];
					dblueY += dy[i];

					if (dblueX == hole[0] && dblueY == hole[1]) {
						blueGoal = true;
						break;
					}
				}

				if (blueGoal) {
					continue;
				}

				if (redGoal && !blueGoal) {
					return cnt;
				}

				if (dredX == dblueX && dredY == dblueY) {
					if (i == 0) {
						if (nredX > nblueX)
							dredX++;
						else
							dblueX++;
					} else if (i == 1) {
						if (nredY < nblueY)
							dredY--;
						else
							dblueY--;
					} else if (i == 2) {
						if (nredX < nblueX)
							dredX--;
						else
							dblueX--;
					} else {
						if (nredY > nblueY)
							dredY++;
						else
							dblueY++;
					}
				}

				if (!visited[dredX][dredY][dblueX][dblueY]) {
					visited[dredX][dredY][dblueX][dblueY] = true;
					queue.add(new int[] { dredX, dredY, dblueX, dblueY, cnt + 1 });
				}
			}
		}

		return -1;
	}

}
