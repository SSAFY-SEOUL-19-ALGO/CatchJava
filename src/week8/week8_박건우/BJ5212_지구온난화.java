package week8.week8_박건우;

import java.io.*;

public class BJ5212_지구온난화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");

        int R = Integer.parseInt(ipt[0]);
        int C = Integer.parseInt(ipt[1]);

        char[][] map = new char[R][C];
        char[][] res = new char[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int minR = 10, maxR = 0;
        int minC = 10, maxC = 0;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++) {
                if (map[i][j] == 'X'){
                    int cnt = 0;
                    for(int k = 0; k < 4; k++){
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if((x == -1 || y == -1 || x == R || y == C) || map[x][y] == '.'){
                            cnt++;
                        }
                    }
                    if(cnt < 3){
                        res[i][j] = 'X';

                        minR = Math.min(minR, i);
                        minC = Math.min(minC, j);
                        maxR = Math.max(maxR,i);
                        maxC = Math.max(maxC, j);
                    } else {
                        res[i][j] = '.';
                    }
                } else{
                    res[i][j] = '.';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = minR; i <= maxR; i++){
            for(int j = minC; j <= maxC; j++) {
                sb.append(res[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

