package week9.week9_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 전쟁_전투 {

	static int N, M;
	static int Wcnt, Bcnt;
	static int group;
	static String[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 가로 
		M = Integer.parseInt(input[1]); // 세로 
		
		arr = new String[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			arr[i] = br.readLine().split("");
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue; // 방문했다면 
				group = 1; // 본인 값 
				visited[i][j] = true; // 방문체크 
				dfs(j, i, arr[i][j]); // 세로, 가로, 현재 값 
				if ("W".equals(arr[i][j])) Wcnt += group * group;
				else Bcnt += group * group;
			}
		}
		
		System.out.println(Wcnt + " " + Bcnt);
	}

	private static void dfs(int x, int y, String e) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위 밖 
			if (visited[ny][nx]) continue; // 이미 방문한 곳 
			if (!e.equals(arr[ny][nx])) continue; // 색이 같지 않다면 
			
			visited[ny][nx] = true; // 방문체크 
			group++; // 같은 그룹 개수 증가 
			dfs(nx, ny, e);
		}
	}

}
