package week12.week12_박건우;

import java.io.*;
import java.util.ArrayList;

public class BJ1347_미로만들기 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // br
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw
        String[] ipt;   // string array to get input
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int r = 1, c = 1;
        char map[][] = new char[101][101];  // 최대 50인데 가운데에 있어야 하므로 50 * 2 + 1
        int sx, sy, minX, minY, maxX, maxY;
        sx = sy = minX = minY = maxX = maxY = 50;   // 시작은 가운데
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#';    // 벽으로 채우기
            }
        }

        int dir = 2;
        map[sx][sy] = '.';

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'F'){
                sx += dx[dir];
                sy += dy[dir];
                map[sx][sy] = '.';
                maxX = Math.max(maxX, sx);
                maxY = Math.max(maxY, sy);
                minX = Math.min(minX, sx);
                minY = Math.min(minY, sy);
            } else if(str.charAt(i) == 'L'){
                dir--;
                if(dir < 0) dir = 3;
            } else {    // str.charAt(i) == 'R'
                dir++;
                if(dir > 3) dir = 0;
            }
        }

        for (int i = minX; i <= maxX; i++) {
            sb = new StringBuilder();
            for (int j = minY; j <= maxY; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }
}
