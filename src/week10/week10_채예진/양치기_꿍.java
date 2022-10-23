package week10.week10_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 양치기_꿍 {

	static int R, C, wolfCnt, sheepCnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]); // 세로 
		C = Integer.parseInt(input[1]); // 가로 
		
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++) { // 입력받기 
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		int wolves = 0, sheeps = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (!visited[r][c] && map[r][c] != '#') { // 방문하지 않았고, 울타리 안일 경우 탐색 
					// 한 울타리 당 늑대와 양 수 세기 
					wolfCnt = 0;
					sheepCnt = 0;
					
					dfs(r, c);
					
					if (sheepCnt > wolfCnt) sheeps += sheepCnt; // 양이 늑대보다 많을 경우 양의 수 증가 
					else wolves += wolfCnt; 
				}
			}
		}
		
		System.out.println(sheeps + " " + wolves);
	}

	static void dfs(int r, int c) { // 행, 열
		
		visited[r][c] = true; // 방문체크
		
		if (map[r][c] == 'v') wolfCnt++;
		else if (map[r][c] == 'k') sheepCnt++;
		
		for (int d = 0; d < 4; d++) { // 사방 탐색 
			int nr = r + dr[d]; // 행 
			int nc = c + dc[d]; // 열 
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue; // 범위 밖 
			if (visited[nr][nc]) continue; // 탐색 했을 경우 
			if (map[nr][nc] == '#') continue; // 울타리일 경우 
			
			dfs(nr, nc); // 다음 위치 탐색 
		}
	}
}
