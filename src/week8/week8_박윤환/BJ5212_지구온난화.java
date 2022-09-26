package week8.week8_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ5212_지구온난화 {
    static final int[] dr = {1, 0, -1, 0};  // 하, 우, 상, 좌
    static final int[] dc = {0, 1, 0, -1};  // 하, 우, 상, 좌

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int R = Integer.parseInt(st[0]);
        int C = Integer.parseInt(st[1]);
        char[][] map = new char[R][];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<int[]> queue = new ArrayDeque<>();    // 물에 잠기는 위치 저장
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == 'X') {  // 땅인 위치에서
                    int cnt = 0;
                    // 상하좌우 주변의 땅의 개수를 구함
                    for(int k=0; k<4; k++) {
                        int nextR = i + dr[k];
                        int nextC = j + dc[k];
                        if(nextR >= 0 && nextR < R && nextC >= 0 && nextC < C) {
                            if(map[nextR][nextC] == 'X') {
                                cnt++;
                            }
                        }
                    }
                    // 상하좌우 주변에 땅이 없거나 1개라면 물에 잠기는 위치
                    if(cnt < 2) {
                        queue.offer(new int[] {i, j});
                    }
                }
            }
        }
        while(!queue.isEmpty()) {   // 물에 잠기는 위치 반복
            int[] p = queue.poll();
            int r = p[0];
            int c = p[1];
            map[r][c] = '.';    // 물에 잠김
        }

        // 최소 섬이 포함되는 위쪽 행 위치를 구함
        int top = 0;
        for(int i=0; i<R; i++) {
            int cnt = 0;
            for(int j=0; j<C; j++) {
                if(map[i][j] == '.') {
                    cnt++;
                }
            }
            if(cnt != C) {
                top = i;
                break;
            }
        }

        // 최소 섬이 포함 되는 아래쪽 행 위치를 구함
        int bottom = 0;
        for(int i=R-1; i>=0; i--) {
            int cnt = 0;
            for(int j=0; j<C; j++) {
                if(map[i][j] == '.') {
                    cnt++;
                }
            }
            if(cnt != C) {
                bottom = i;
                break;
            }
        }

        // 최소 섬이 포함되는 왼쪽 열 위치를 구함
        int left = 0;
        for(int j=0; j<C; j++) {
            int cnt=0;
            for(int i=0; i<R; i++) {
                if(map[i][j] == '.') {
                    cnt++;
                }
            }
            if(cnt != R) {
                left = j;
                break;
            }
        }

        // 최소 섬이 포함되는 오른쪽 열 위치를 구함
        int right = 0;
        for(int j=C-1; j>=0; j--) {
            int cnt=0;
            for(int i=0; i<R; i++) {
                if(map[i][j] == '.') {
                    cnt++;
                }
            }
            if(cnt != R) {
                right = j;
                break;
            }
        }

        // 구한 범위 내의 위치만 출력
        for(int i=top; i<=bottom; i++) {
            for(int j=left; j<=right; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
