package week6.week6_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class 인구_이동 {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, L, R;
	static int[][] country;
	static boolean[][] visited;
	static List<Point> list;
	static int[] dx = {1, -1, 0, 0}; // 하상우좌 
	static int[] dy = {0, 0, 1, -1}; // 하상우좌 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);

		country = new int[N][N];
		for (int i = 0; i < N; i++) {
			country[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int answer = 0;

		// bfs로 풀기 
		while (true) { // 인구이동이 더이상 없을 때까지 반복 
			boolean check = false; // 빠져나와야하는 상황인지 확인하기 위함 
			visited = new boolean[N][N]; // 턴마다 방문 여부 확인 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) { // 방문 안 했을 경우 
						list = new ArrayList<>(); // 인구 이동이 필요한 노드

						Point p = new Point(i, j);

						Queue<Point> q = new ArrayDeque<>();

						q.add(p);
						list.add(p);

						visited[i][j] = true;

						int sum = country[p.x][p.y];

						// bfs 탐색 
						while (!q.isEmpty()) {
							Point cur = q.poll();

							for (int d = 0; d < 4; d++) {
								int nx = cur.x + dx[d];
								int ny = cur.y + dy[d];

								if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
								if (visited[nx][ny]) continue;

								int diff = Math.abs(country[cur.x][cur.y] - country[nx][ny]);

								if (diff >= L && diff <= R) {
									q.offer(new Point(nx, ny));
									list.add(new Point(nx, ny));
									sum += country[nx][ny];
									visited[nx][ny] = true;
								}
							}
						}

						// 인구이동 시키기 
						if (list.size() > 1) { // 하나 들어있는 건 본인이기 때문에 제외 
							int cal = sum / list.size();
							for (Point point: list) {
								country[point.x][point.y] = cal;
							}
							check = true;
						}
					}
				}
			}
			// 못 움직이면 나가기
			if (!check) break;
			answer++;
		}

		System.out.println(answer);
	}
}