package week7.week7_박건우;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ1012_유기농배추 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] checked;
    static int cnt;
    static int w, h, m, n, k;    // 가로 세로 배추 위치 개수
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;

        int N = Integer.parseInt(br.readLine());

        for(int rpt = 0; rpt < N; rpt++){
            cnt = 0;
            ipt = br.readLine().split(" ");
            w = Integer.parseInt(ipt[0]);
            h = Integer.parseInt(ipt[1]);
            k = Integer.parseInt(ipt[2]);

            map = new int[w][h];
            checked = new boolean[w][h];

            for(int r = 0; r < k; r++){
                ipt = br.readLine().split(" ");
                m = Integer.parseInt(ipt[0]);
                n = Integer.parseInt(ipt[1]);
                map[m][n] = 1;
            }

            for(int i = 0; i < w; i++){
                for(int j = 0; j < h; j++){
                    if(!checked[i][j] && map[i][j] == 1){
                        bfs(i, j);  //구역 덩어리를 탐색함
                        cnt++;  // 구역 덩어리 하나 추가함
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int stx, int sty){  //startX, startY
        queue = new ArrayDeque<>();
        int nx, ny;
        int[] cur;
        queue.offer(new int[] {stx, sty});
        checked[stx][sty] = true;

        while(!queue.isEmpty()){
            cur = queue.poll();

            for(int i = 0; i < 4; i++){
                nx = cur[0] + dx[i];
                ny = cur[1] + dy[i];

                if(0 > nx || nx >= w || 0 > ny || ny >= h){   // 유효성 검사
                    continue;
                }

                if(map[nx][ny] == 1 && !checked[nx][ny]){   // 유효성 통과하고, 배추 있는 지역에다 방문 안 한 지역이라면
                    queue.offer(new int[] {nx, ny});
                    checked[nx][ny] = true;
                }
            }
        }
    }
}
