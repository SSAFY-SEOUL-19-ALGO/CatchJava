package week12.week12_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 소문난_칠공주 {

	static char[][] map;
	static boolean[] numbers;
	static int[] selected;
	static int answer;
	static int[] dr = {-1, 1, 0, 0}; 
	static int[] dc = {0, 0, -1, 1}; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 2차원 배열을 1차원으로 계산
		numbers = new boolean[25];
		// 칠공주로 선택된 visited 배열 index
		selected = new int[7];
		
		// 조합 -> 연결되어 있는지 확인 
		comb(0, 0, 0); // visited idx, 7개 선택됐는지, 도연이 수 
		
		System.out.println(answer);
	}
	
	static void comb(int idx, int cnt, int cntY) {
		if (cntY >= 4) return;
		if (cnt == 7) { // 이미 도연이 4개 이상은 탈락됐으므로 무조건 칠공주 가능한 도연의 수.
			// 인접 확인 
			if (bfs()) answer++;
			return;
		}
		
		for (int i = idx; i < 25; i++) {
			numbers[i] = true;
			selected[cnt] = i;
			if (map[i / 5][i % 5] == 'Y') comb(i + 1, cnt + 1, cntY + 1);
			else comb(i + 1, cnt + 1, cntY);
			numbers[i] = false;
		}
	}
	
	static boolean bfs() {
		int cnt = 1; // 7개 연결되어 있는지 확인하기 위함 
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[25];
		q.add(selected[0]);
		visited[selected[0]] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur / 5 + dr[d];
				int nc = cur % 5 + dc[d];
				
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue; // 범위 밖 
				if (visited[nr * 5 + nc]) continue; // 이미 방문했다면 
				if (!numbers[nr * 5 + nc]) continue; // 인접해있지만 조합으로 뽑은 것이 아니라면 
				
				cnt++;
				visited[nr * 5 + nc] = true;
				q.add(nr * 5 + nc);
			}
		}
		
		if (cnt == 7) return true;
		else return false;
	}
}

/* 원하는 숫자가 안 나옴... T와 같은 것이 안 나옴.!!!!!!
public class 소문난_칠공주 {

	static class Point {
		int r, c, sum, yeon;

		public Point(int r, int c, int sum, int yeon) {
			super();
			this.r = r;
			this.c = c;
			this.sum = sum;
			this.yeon = yeon;
		}
		
	}
	
	static char[][] map;
	
	// 한 번 방문한 곳은 방문하지 않도록, 우하만 방문 
	static int[] dr = {1, 0}; // 하 우 
	static int[] dc = {0, 1}; // 하 우 
	
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bfs(i, j);
			}
		}
		System.out.println(cnt);
	}
	
	static void bfs(int i, int j) {
		// bfs
		Queue<Point> q = new ArrayDeque<>();
		if (map[i][j] == 'Y') q.offer(new Point(i, j, 1, 1));
		else q.offer(new Point(i, j, 1, 0));

		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.yeon >= 4) continue; // 다연이가 4이상이면 자르기 
			if (cur.sum == 7) { // 칠공주 결성 
				if (cur.yeon < 4) { // 다연이가 4이하면 통과 
					cnt++;
				}
				continue;
			}
			
			for (int d = 0; d < 2; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if (nr >= 5 || nc >= 5) continue;
				if (i == 1 && j == 0) System.out.println(nr + " " + nc);
				if (map[nr][nc] == 'Y') q.offer(new Point(nr, nc, cur.sum + 1, cur.yeon + 1));
				else q.offer(new Point(nr, nc, cur.sum + 1, cur.yeon));
			}
		}
	}

}
*/
