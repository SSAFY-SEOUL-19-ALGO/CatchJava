package week11.week11_박건우;

import java.io.*;

public class BJ16918_봄버맨 {
    static int R, C, N;
    static int[] block;
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};    // 상 하 좌 우

    static char[][] map;
    static int[][] tMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // br
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw
        String[] ipt;   // string array to get input
        StringBuilder sb;
        String getChar;
        ipt = br.readLine().split(" ");
        R = Integer.parseInt(ipt[0]);
        C = Integer.parseInt(ipt[1]);
        N = Integer.parseInt(ipt[2]);

        map = new char[R][C];
        tMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            getChar = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = getChar.charAt(j);
                if(map[i][j] == 'O'){
                    tMap[i][j] = 3;
                }
            }
        }

        int time = 0;
        while(time++ < N){
            if(time % 2 == 0){
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if(map[i][j] == '.'){
                            map[i][j] = 'O';
                            tMap[i][j] = time + 3;
                        }
                    }
                }
            } else if(time % 2 == 1){
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if(tMap[i][j] == time){
                            map[i][j] = '.';
                            for(int d = 0; d < 4; d++){
                                int ni = i + dx[d];
                                int nj = j + dy[d];

                                if(ni < 0 || nj < 0 || ni >= R || nj >= C) continue;

                                if(map[ni][nj] == 'O' && tMap[ni][nj] != time){
                                    map[ni][nj] = '.';
                                    tMap[ni][nj] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(map[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
