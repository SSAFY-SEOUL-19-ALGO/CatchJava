package week9.week9_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1303_전쟁전투 {
    static final int[] dx = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dy = {1, 0, -1, 0};  // 우, 하, 좌, 상
    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    static class Point {
        int x, y, cnt;  // 위치와 인원수
        char color; // 옷 색

        public Point(int x, int y, int cnt, char color) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.color = color;
        }
    }

    static void dfs(int x, int y, Point p) {
        p.cnt++;    // 인원수 증가

        for(int i=0; i<4; i++) {    // 우, 하, 좌, 상 반복
            int nextX = x + dx[i];  // 다음 행위치
            int nextY = y + dy[i];  // 다음 열위치
            if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N   // 다음 위치가 범위 내이고
                && !visited[nextX][nextY] && map[nextX][nextY] == p.color) {    // 방문하지 않았으며 같은 색의 병사라면
                visited[nextX][nextY] = true;   // 방문처리
                dfs(nextX, nextY, p);   // 그 위치로 다시 dfs 수행
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);    // 전쟁터 열크기
        M = Integer.parseInt(st[1]);    // 전쟁터 행크기
        map = new char[M][N];   // 전쟁터 지도 배열
        visited = new boolean[M][N];    // 방문처리 배열

        for(int i=0; i<M; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int pW = 0; // 아군의 전력
        int pB = 0; // 적군의 전력
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {    // 아직 방문하지 않은 곳이면
                    visited[i][j] = true;   // 방문처리
                    Point p = new Point(i, j, 0, map[i][j]); // 현재 위치에 대한 정보로 클래스 생성
                    dfs(i, j, p);   // dfs 수행
                    if(map[i][j] == 'W') {  // 현재 위치에 있는게 아군이었다면
                        pW += p.cnt * p.cnt;    // 아군 전력 계산
                    } else if(map[i][j] == 'B') {   // 현재 위치에 있는게 적군이었다면
                        pB += p.cnt * p.cnt;    // 적군 전력 계산
                    }
                }
            }
        }

        System.out.println(pW + " " + pB);
    }
}
