package week7.week7_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// dfs로 풀어보기~ 이런 문제 주로 시간초과 때문에 bfs로 풀었는데.. 개수가 dfs도 될 것 같길래 해봄. 
public class 유기농_배추 {

	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우 
	static int[] dy = {0, 0, -1, 1};
	
	static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue; // 범위 밖일 경우 
			if(visited[nx][ny]) continue; // 이미 방문했을 경우 
			if(!map[nx][ny]) continue; // 배추가 아닌 경우 
			
			visited[nx][ny] = true; // 방문 처리 
			dfs(nx, ny); // 그 다음 배추로 이동 
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split(" ");
			int M = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[1]);
			int K = Integer.parseInt(s[2]);
			
			// 초기화 
			map = new boolean[M][N];
			visited = new boolean[M][N];
			
			for (int k = 0; k < K; k++) {
				s = br.readLine().split(" ");
				map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true;
			}
			
			int answer = 0; // 필요한 지렁이 수 
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]) { // 방문 안 했으며, 배추밭인 경우 탐색 
						dfs(i, j);
						answer++; // 탐색이 가능한 경우 지렁이수 증가 
					}
				}
			}
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
	}

}
