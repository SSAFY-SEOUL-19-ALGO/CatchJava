package week6.week6_강수지;

class P42898_등굣길  {
    public int solution(int m, int n, int[][] puddles) {
        // dp
        int[][] dp = new int[n+1][m+1];
        // 물 웅덩이 -1
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        dp[1][1] = 1; // 출발

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                // 물 웅덩이인 경우
                if(dp[i][j]==-1){
                    continue;
                }
                // 하단으로 이동
                if(dp[i][j-1]!=-1 && j-1>0) dp[i][j] += dp[i][j-1] % 1000000007;
                // 우측으로 이동
                if(dp[i-1][j]!=-1 && i-1>0) dp[i][j] += dp[i-1][j] % 1000000007;
            }
        }

        return dp[n][m] % 1000000007;
    }
}