package week10.week10_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ3187_양치기꿍 {
    static final int[] dr = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dc = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static int R, C, sheep, wolves, sheepCnt, wolvesCnt;
    static char[][] map;
    static boolean[][] visited;

    // dfs 수행 메소드
    static void dfs(int r, int c) {
        if(map[r][c] == 'v') wolves++;  // 현재 위치가 늑대면 늑대 수 증가
        if(map[r][c] == 'k') sheep++;   // 현재 위치가 양이면 양 수 증가

        for(int i=0; i<4; i++) {    // 사방 탐색
            int nextR = r + dr[i];  // 다음 행 위치
            int nextC = c + dc[i];  // 다음 열 위치
            if(nextR >= 0 && nextR < R && nextC >= 0 && nextC < C   // 범위 내이고
                && !visited[nextR][nextC]) {    // 방문하지 않았으면
                visited[nextR][nextC] = true;   // 방문처리
                dfs(nextR, nextC);  // 다음 위치에서 dfs 수행
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '#') {  // 울타리 부분이라면
                    visited[i][j] = true;   // 미리 방문 처리
                }
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {    // 모든 위치 탐색
                if(!visited[i][j]) {    // 방문하지 않았다면
                    sheep = 0;  // 양 수 초기화
                    wolves = 0; // 늑대 수 초기화
                    visited[i][j] = true;   // 현재 위치 방문처리
                    dfs(i, j);  // 현재 위치로부터 dfs 수행
                    if(sheep > wolves) {    // 현재 영역에서 양의 수가 늑대보다 많으면
                        sheepCnt += sheep;  // 전체 카운트에 양의 수만 추가
                    } else {    // 늑대 수가 같거나 더 많으면
                        wolvesCnt += wolves;    // 전체 카운트에 늑대 수만 추가
                    }
                }
            }
        }

        System.out.println(sheepCnt + " " + wolvesCnt);
    }
}
