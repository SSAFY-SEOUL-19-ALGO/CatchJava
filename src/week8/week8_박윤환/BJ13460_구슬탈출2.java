package week8.week8_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ13460_구슬탈출2 {
    static final int[] dx = {1, 0, -1, 0};  // 하, 우, 상, 좌
    static final int[] dy = {0, 1, 0, -1};  // 하, 우, 상, 좌

    static class Bead {
        int rx, ry, bx, by, cnt;

        public Bead(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        char[][] board = new char[N][M];
        boolean[][][][] visited = new boolean[N][M][N][M];
        Queue<Bead> queue = new ArrayDeque<>();

        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if(board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        int cnt = -1;
        queue.offer(new Bead(rx, ry, bx, by, 1));
        visited[rx][ry][bx][by] = true;
        Loop:
        while(!queue.isEmpty()) {
            Bead cur = queue.poll();

            if(cur.cnt > 10) {
                break;
            }

            for(int i=0; i<4; i++) {
                int nextRx = cur.rx;
                int nextRy = cur.ry;
                int nextBx = cur.bx;
                int nextBy = cur.by;

                boolean redHole = false;
                boolean blueHole = false;

                // 빨간 구슬 이동
                while(board[nextRx + dx[i]][nextRy + dy[i]] != '#') {
                    nextRx += dx[i];
                    nextRy += dy[i];
                    if(board[nextRx][nextRy] == 'O') {
                        redHole = true;
                        break;
                    }
                }
                // 파란 구슬 이동
                while(board[nextBx + dx[i]][nextBy + dy[i]] != '#') {
                    nextBx += dx[i];
                    nextBy += dy[i];
                    if(board[nextBx][nextBy] == 'O') {
                        blueHole = true;
                        break;
                    }
                }

                if(blueHole) {
                    continue;
                }

                if(redHole) {
                    cnt = cur.cnt;
                    break Loop;
                }

                if(nextRx == nextBx && nextRy == nextBy) {
                    // 하, 우, 상, 좌에 따라 두 구슬이 겹쳤을때 다르게 조정
                    switch(i) {
                        case 0:
                            if(cur.rx > cur.bx) {
                                nextBx -= dx[i];
                            } else {
                                nextRx -= dx[i];
                            }
                            break;
                        case 1:
                            if(cur.ry > cur.by) {
                                nextBy -= dy[i];
                            } else {
                                nextRy -= dy[i];
                            }
                            break;
                        case 2:
                            if(cur.rx > cur.bx) {
                                nextRx -= dx[i];
                            } else {
                                nextBx -= dx[i];
                            }
                            break;
                        case 3:
                            if(cur.ry > cur.by) {
                                nextRy -= dy[i];
                            } else {
                                nextBy -= dy[i];
                            }
                            break;
                    }
                }
                if(!visited[nextRx][nextRy][nextBx][nextBy]) {
                    visited[nextRx][nextRy][nextBx][nextBy] = true;
                    queue.offer(new Bead(nextRx, nextRy, nextBx, nextBy, cur.cnt+1));
                }
            }
        }

        System.out.println(cnt);
    }
}
