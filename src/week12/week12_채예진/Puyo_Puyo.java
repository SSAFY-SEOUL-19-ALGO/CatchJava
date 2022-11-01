package week12.week12_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Puyo_Puyo {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[12][6];
		
		for (int i = 0; i < 12; i++) {
			String input = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		int answer = 0;
		
		while(true) {
			boolean isFinished = true;
			boolean[][] visited = new boolean[12][6]; // 한 턴 당 방문 확인 
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] == '.') continue;
					if (visited[i][j]) continue;
					else { 
						List<int[]> list = new ArrayList<>(); // 이후에 지울 거 
						Queue<int[]> q = new ArrayDeque<>();
						q.offer(new int[] {i, j});
						list.add(new int[] {i, j});
						
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							visited[cur[0]][cur[1]] = true;
							
							for (int d = 0; d < 4; d++) {
								int nr = cur[0] + dr[d];
								int nc = cur[1] + dc[d];
								
								if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6) continue;
								if (visited[nr][nc]) continue;
								if (map[cur[0]][cur[1]] == map[nr][nc]) {
									list.add(new int[] {nr, nc});
									q.offer(new int[] {nr, nc}); // 색깔이 같을 경우에만 
								}
							}
						}
						
						if (list.size() >= 4) {
							isFinished = false; // 더 탐색 필요 
							for (int[] cur: list) { // 삭제 
								map[cur[0]][cur[1]] = '.';
							}
						}
					}
				}
			}
			if (isFinished) break;
			// 중력 효과 
			for (int i = 0; i < 6; i++) {
				for (int j = 11; j > 0; j--) {
					if (map[j][i] == '.') { // 위에 것 내리기 
						for (int k = j - 1; k >= 0; k--) {
							if (map[k][i] != '.') {
								map[j][i] = map[k][i];
								map[k][i] = '.';
								break;
							}
						}
					}
				}
			}
			answer++;
		}
		
		System.out.println(answer);
	}

}
