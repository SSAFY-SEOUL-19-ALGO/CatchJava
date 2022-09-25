package week8.week8_박건우;

import java.io.*;

public class BJ1063_킹 {
    static int[][] map = new int[9][9];
    static int[] dx = new int[] {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = new int[] {1, -1, 0, 0, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        String com;
        StringBuilder sb = new StringBuilder();
        int nx, ny, move;
        int kx, ky, sx, sy; // king loc, stone loc
        int knx, kny, snx, sny;
        String king = ipt[0];   // 1
        String stone = ipt[1];  // 2
        int N = Integer.parseInt(ipt[2]);

        kx = 8-(king.charAt(1) - '0');  // 알파벳
        ky = king.charAt(0) - 'A';

        sx = 8-(stone.charAt(1) -'0');  // 알파벳
        sy = stone.charAt(0) - 'A';


        for(int i =0; i < N; i++){
            com = br.readLine();

            nx = kx + dx[move(com)];
            ny = ky + dy[move(com)];

            if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {   // 유효성 체크를 불통과 시에는
                continue;
            }

            knx = nx;
            kny = ny;

            if (knx == sx && kny == sy) { // 킹 자리에 돌이 있으면 돌도 이동
                nx = sx + dx[move(com)];
                ny = sy + dy[move(com)];
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;   // 돌 유효성 검사, 판 벗어나면 안 움직임
                else{
                    kx = knx;
                    ky = kny;
                    sx = nx;
                    sy = ny;
                }
            }
            kx = knx;
            ky = kny;
        }

        sb.append((char)(ky+'A'));
        sb.append((char)(8-kx+'0'));
        System.out.println(sb.toString());
        sb.setLength(0);

        sb.append((char)(sy+'A'));
        sb.append((char)(8-sx+'0'));
        System.out.println(sb.toString());
    }

    public static int move(String com){
        if(com.equals("R")){
            return 0;
        } else if(com.equals("L")){
            return 1;
        } else if(com.equals("B")){
            return 2;
        } else if(com.equals("T")){
            return 3;
        } else if(com.equals("RT")){
            return 4;
        } else if(com.equals("LT")){
            return 5;
        } else if(com.equals("RB")){
            return 6;
        } else if(com.equals("LB")){
            return 7;
        }
        return -1;
    }
}
