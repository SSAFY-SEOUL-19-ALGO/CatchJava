package week6.week6_박윤환;

public class P42898_등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1]; // 2차원 배열에 맞게 n과 m을 뒤집어서 인덱스 1부터 사용
        dp[0][1] = 1;   // 집 위치를 1로 만들기 위해
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; // 현재 위치까지의 경로 개수는 좌위치와 상위치의 경로개수 합
                for (int[] p :
                        puddles) {
                    if(p[1] == i && p[0] == j) {    // 만약 물에 잠긴 곳이면
                        dp[i][j] = 0;   // 경로 개수를 0으로
                        break;
                    }
                }
                if(dp[i][j] > 1_000_000_007) {  // 1,000,000,007 보다 커지면
                    dp[i][j] %= 1_000_000_007;  // 나눈 나머지로 저장
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        P42898_등굣길 sol = new P42898_등굣길();
        System.out.println(sol.solution(4, 3, new int[][] {{2, 2}}));
    }
}