package week6.week6_박건우;

import java.util.ArrayDeque;
import java.util.Queue;

public class P42898_등굣길 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] pud = {{2, 2}};
        System.out.println(sol.solution(4, 3, pud));
    }
}

class Solution_dp {
    // 상 하 좌 우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int[][] map;
    int[][][] dp;
    boolean[][] visited;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map=  new int[m+1][n+1];
        dp = new int[m+1][n+1][2];  // dp[x][y][0]은 x, y까지의 최단 거리, dp[x][y][1]은 x, y까지의 최단거리 개수
        visited =  new boolean[m+1][n+1];

        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = 1;
        }

        bfs(m, n);
        return dp[m][n][1] % 1000000007;
    }

    public void bfs(int m, int n){
        int nx, ny;
        visited[1][1] = true;
        dp[1][1][0] = 0;
        dp[1][1][1] = 1;

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(1, 1));

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x == m && cur.y == n){
                return;
            }
            for(int i = 0; i < 4; i++){
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if(1 <= nx && nx <= m && 1 <= ny && ny <= n){   // 유효성 검사
                    if(map[nx][ny] == 0) {    // 웅덩이가 아니면
                        if(!visited[nx][ny]){  // 최초 방문이라면
                            visited[nx][ny] = true; // 방문 체크
                            dp[nx][ny][0] = dp[cur.x][cur.y][0] % 1000000007 + 1;   // 거리는 1 추가,
                            dp[nx][ny][1] = dp[cur.x][cur.y][1] % 1000000007;   // 최단 경로 개수는 유지
                            q.offer(new Point(nx, ny));
                        } else {    // 이미 방문한 노드라면
                            // 현재까지의 최단 거리보다 짧으면 새로운 최단 거리를 부여함
                            if(dp[nx][ny][0] == 0 || dp[nx][ny][0] % 1000000007 > dp[cur.x][cur.y][0] % 1000000007 + 1){
                                dp[nx][ny][0] = dp[cur.x][cur.y][0] % 1000000007 + 1;   // 거리는 1 추가,
                                dp[nx][ny][1] = dp[cur.x][cur.y][1] % 1000000007;   // 최단 경로 개수는 유지
                            } else if(dp[nx][ny][0] == dp[cur.x][cur.y][0] % 1000000007 + 1){    // 현재까지의 최단 거리와 같으면
                                dp[nx][ny][1] += dp[cur.x][cur.y][1] % 1000000007;
                            }
                        }
                    }
                }
            }
        }
        return;
    }

    public static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/* dp로 접근하여 해결한 코드
*  현 위치를 기준으로 좌측과 위쪽의 가능한 경로의 값을 합치면 됨
*  좌측과 위쪽인 이유는 문제의 이동 조건이 아래측 아니면 우측이라서*/
class Solution{
    public int solution(int m, int n, int[][] puddles){
        int[][] map =  new int[m+1][n+1];
        int[][] dp =  new int[m+1][n+1];
        dp[1][1] = 1;

        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = 1;
        }

        for(int i=  1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if((i == 1 && j == 1) || map[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] % 1000000007 + dp[i][j-1] % 1000000007;
            }
        }

        return dp[m][n] % 1000000007;
    }
}
