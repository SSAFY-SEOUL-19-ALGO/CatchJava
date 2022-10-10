package week10.week10_박건우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1937_욕심쟁이판다 {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static int[][] dp;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        ans = 0;
        map = new int[N][N];
        dp = new int[N][N];

        // 맵 정보 입력
        for(int r = 0 ; r < N ; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 테이블 갱신과 동시에 최댓값 갱신
        // DP 테이블은 해당 지역에서 이동할 수 있는 최댓값이다.
        for(int r = 0 ; r < N ; ++r) {
            for(int c = 0 ; c < N ; ++c) {
                int way = dfs(r, c);
                ans = way > ans ? way : ans;
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int r, int c) {
        // 이미 갱신된 지역은 바로 그 값을 리턴한다.
        if(dp[r][c] != 0) return dp[r][c];

        // 1로 초기화
        dp[r][c] = 1;

        // 해당 지점 기준 4방 탐색
        for(int d = 0 ; d < 4 ; ++d) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;

            // 다음 지역은 이전 지역보다 커야한다.
            if(map[nr][nc] > map[r][c]) {
                // 기존의 값과 새로 탐색한 값 중에 최댓값으로 갱신
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
            }
        }

        return dp[r][c];
    }
}
