package week10.week10_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// dfs로만 풀면 시간초과.. dp도 같이 사용해서 이미 계산된 값 써야 함.
// 현재 칸보다 더 큰 값으로만 가기 때문에 방문 체크 필요 없음 
public class 욕심쟁이_판다 {

	static int[][] map, dp;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int dfs(int x, int y) {
		if (dp[x][y] != 0) return dp[x][y] + 1; // 현재 나의 위치도 더하기, 이거 없으면 시간 초과 남 
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue; // 범위 초과 
			if (map[nx][ny] > map[x][y]) { // 다음 지역이 이전 지역보다 커야 한다. 
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)); // 현재까지 계산된 값과 새로운 값 비교 
			}
		}
		
		return dp[x][y] + 1; // 갈 수 있는 곳들 + 현재 나의 위치 
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		
		for (int n = 0; n < N; n++) { // 입력받기 
			map[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, dfs(i, j)); // 전체 탐색 
			}
		}
		
		System.out.println(max);
	}

}
