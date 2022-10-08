package week9.week9_박건우;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ1303_전쟁전투 {
    static char[][] map;
    static boolean[][] visited;
    static int friend, foe, n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        n = Integer.parseInt(ipt[0]);
        m = Integer.parseInt(ipt[1]);

        map = new char[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            map[i] = br.readLine().toCharArray();
        }

        friend = bfs('W');
        foe = bfs('B');

        bw.write(friend + " " + foe);
        bw.flush();
    }

    public static int bfs(char finder){
        Queue<Point> q = new ArrayDeque<>();
        int x, y, nx, ny, cnt;
        Point cur;
        int score = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                cnt = 0;
                if(!visited[i][j] && map[i][j] == finder){
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    cnt++;
                }

                while(!q.isEmpty()){
                    cur = q.poll();
                    for(int d = 0; d < 4; d++){
                        nx = cur.x + dx[d];
                        ny = cur.y + dy[d];

                        if(0 <= nx && nx < m && 0 <= ny && ny < n && !visited[nx][ny]){
                            if(map[nx][ny] == finder) {
//                                System.out.println(map[nx][ny] + ":"+ finder);
                                q.offer(new Point(nx, ny));
                                visited[nx][ny] = true;
                                cnt++;
                            }
                        }
                    }
                }
                score += cnt * cnt;
            }
        }
        return score;
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
