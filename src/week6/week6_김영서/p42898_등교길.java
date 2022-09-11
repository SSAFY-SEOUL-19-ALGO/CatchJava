public class p42898_등교길 {
	class Solution {
		public int solution(int m, int n, int[][] puddles) {
			// (1,1 부터 시작이여서 덜 햇갈리개 +1해서 배열크기 생성함)
			int[][] dp = new int[n + 1][m + 1]; // [Row, Col] = 경우의 수(이떄 -1은 웅덩이로 취급)
			for (int i = 0; i < puddles.length; i++) {
				dp[puddles[i][1]][puddles[i][0]] = -1;
			}
			dp[1][1] = 1;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (dp[i][j] == -1) {
						continue;
					}
					if (j - 1 > 0 && dp[i][j - 1] != -1)
						dp[i][j] += dp[i][j - 1] % 1000000007; // 하단 이동
					if (i - 1 > 0 && dp[i - 1][j] != -1)
						dp[i][j] += dp[i - 1][j] % 1000000007; // 우측 이동
				}
			}
			return dp[n][m] % 1000000007;
		}
	}
}
