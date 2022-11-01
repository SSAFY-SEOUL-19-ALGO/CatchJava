package week12.week12_박건우;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BJ11559_puyopuyo {
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};    // 상 하 좌 우
    static ArrayList<Point> list;
    static char[][] map;
    static boolean[][] visited;
    static int r = 12, c = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // br
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw
        String[] ipt;   // string array to get input
        StringBuilder sb = new StringBuilder();
        String getChar;

        map = new char[r][c];

        for(int i = 0; i < r; i++){
            getChar = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = getChar.charAt(j);
            }
        }
        int count = 0;
        while(true){
            boolean isDone = true;
            visited = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(map[i][j] != '.'){
                        list = new ArrayList<>();
                        bfs(map[i][j], i, j);

                        if(list.size() >= 4){
                            isDone = false;
                            for(int k = 0; k < list.size(); k++){
                                map[list.get(k).x][list.get(k).y] = '.';
                            }
                        }
                    }
                }
            }
            if(isDone) break;
            down();
            count++;
        }
        sb.append(count).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }



    public static void down(){
        for(int i = 0; i < c; i++){
            for (int j = r-1; j > 0; j--) {
                if(map[j][i] == '.'){
                    for(int k = j - 1; k >= 0; k--){
                        if(map[k][i] != '.'){
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void bfs(char c, int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        list.add(new Point(x, y));
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx >= 0 && ny >= 0 && nx < r && ny < 6 && !visited[nx][ny] && map[nx][ny] == c){
                    visited[nx][ny] = true;
                    list.add(new Point(nx, ny));
                    q.offer(new Point(nx, ny));
                }
            }
        }
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
