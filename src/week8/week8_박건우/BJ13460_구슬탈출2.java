package week8.week8_박건우;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ13460_구슬탈출2 {
    static int n,m;
    static int[][] map;
    static boolean[][][][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        int num;

        n = Integer.parseInt(ipt[0]);
        m = Integer.parseInt(ipt[1]);
        map = new int[n][m];
        visited = new boolean[n][m][n][m];

        int rx = 0, ry = 0;
        int bx = 0, by = 0;

        for(int i = 0; i < n; i++){
            ipt = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                num = ipt[j].charAt(0) - '0' + 13;
                map[i][j] = num;
                if(num == 47){
                    rx = i; ry = j;
                } else if (num == 31) {
                    bx = i; by = j;
                }
            }
        }
        bfs(rx, ry, bx, by, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void bfs(int rx, int ry, int bx, int by, int cnt){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {rx, ry, bx, by, cnt});
        visited[rx][ry][bx][by] = true;

        int pCnt, nrx, nry, nbx, nby;
        int rm, bm;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            pCnt = cur[4];

            if(pCnt >= 10) return;

            for(int i = 0; i < 4; i++){
                nrx = cur[0];
                nry = cur[1];
                nbx = cur[2];
                nby = cur[3];

                while(map[nrx+dx[i]][nry+dy[i]] != 0){
                    nrx += dx[i];
                    nry += dy[i];
                    if(map[nrx][nry] == 44) break;
                }

                while(map[nbx+dx[i]][nby+dy[i]] != 0){
                    nbx += dx[i];
                    nby += dy[i];
                    if(map[nbx][nby] == 44) break;
                }

                if(map[nbx][nby] == 44) continue;

                if(map[nrx][nry] == 44){
                    min = Math.min(min, pCnt + 1);
                    return;
                }

                if(nrx == nbx && nry == nby && map[nrx][nry] != 44) {
                    rm = Math.abs(nrx-cur[0]) + Math.abs(nry-cur[1]);
                    bm = Math.abs(nbx-cur[2]) + Math.abs(nby-cur[3]);


                    if(rm > bm) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    }else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                if(!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new int[] {nrx, nry, nbx, nby, pCnt+1});
                }
            }
        }
    }
}
