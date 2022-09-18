package week6_김영서;

import java.util.*;

public class B16234_인구이동 {
	static int n, l, r;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Node> list;

	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();

		q.offer(new Node(x, y));
		list.add(new Node(x, y));
		visited[x][y] = true;

		int sum = board[x][y];
		while (!q.isEmpty()) {
			Node current = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
					int diff = Math.abs(board[current.x][current.y] - board[nx][ny]);
					if (l <= diff && diff <= r) {
						q.offer(new Node(nx, ny));
						list.add(new Node(nx, ny));
						sum += board[nx][ny];
						visited[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	}

	public static void changePopulation(int sum) {
		int avg = sum / list.size();
		for (Node n : list) {
			board[n.x][n.y] = avg;
		}
	}

	public static int move() {
		int result = 0;
		while (true) {
			boolean isMove = false;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						int sum = bfs(i, j);
						if (list.size() > 1) {
							changePopulation(sum);
							isMove = true;
						}
					}
				}
			}
			if (!isMove)
				return result;
			;
			result++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();

		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		System.out.println(move());
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
