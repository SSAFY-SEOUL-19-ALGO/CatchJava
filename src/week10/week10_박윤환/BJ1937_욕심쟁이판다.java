package week10.week10_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1937_욕심쟁이판다 {
    static final int[] dr = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dc = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static int n;
    static int[][] map, dp;

    // dfs 수행 메소드
    static int dfs(int r, int c) {
        if(dp[r][c] == 0) { // dp가 0이라면
            dp[r][c] = 1;   // 초기값 1로 저장

            for(int i=0; i<4; i++) {    // 사방 탐색
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {    // 범위 내이고
                    if(map[r][c] < map[nextR][nextC]) { // 다음 위치가 대나무가 더 많으면
                        // 현재 위치의 dp값과 다음 위치에서 dfs 수행후의 dp값+1 중 큰 값을 저장
                        dp[r][c] = Math.max(dp[r][c], dfs(nextR, nextC) + 1);
                    }
                }
            }
        }
        return dp[r][c];    // 현재의 dp값 반환
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n]; // 현재 위치에서 가능한 이동 횟수를 나타냄
        for(int i=0; i<n; i++) {
            String[] st = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }
        int max = 0;    // 최대 이동수
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {    // 모든 위치 탐색
                max = Math.max(max, dfs(i, j)); // dfs 수행하여 최대 이동수 갱신
            }
        }

        System.out.println(max);
    }
}
