package week10.week10_박건우;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ3187_양치기꿍 {
    static int N, M;    // 각각 세로와 가로
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;
        int wolf = 0, sheep = 0, w, s;
        Point cur;
        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            ipt = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = ipt.charAt(j);
                if(map[i][j] == '#') visited[i][j] = true;
            }
        }

        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                w = 0;
                s = 0;
                Queue<Point> q = new ArrayDeque<>();
                if(!visited[i][j]) q.offer(new Point(i, j));
                while(!q.isEmpty()){
                    cur = q.poll();
                    if(map[cur.x][cur.y] == 'v'){   // 'v'가 늑대
                        w += 1;
                    } else if(map[cur.x][cur.y] == 'k'){    // 'k'가 양
                        s += 1;
                    }

                    visited[cur.x][cur.y] = true;

                    for(int d = 0; d < 4; d++){
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];

                        if(check(nx, ny) && !visited[nx][ny]){
                            q.offer(new Point(nx, ny));
                            visited[nx][ny] = true; // 추가한 위치는 중복 큐잉을 피하기 위해 방문 처리
                        }
                    }
                }

                if(w < s){  // 양이 늑대 수보다 더 많으면
                    sheep += s; // 양만 살아남는다
                } else {
                    wolf += w;
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    public static boolean check(int x, int y){
        if(0 <= x && x < N && 0 <= y && y < M)
            return true;
        else
            return false;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
