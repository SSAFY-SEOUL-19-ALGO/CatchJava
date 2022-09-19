package week7.week7_박건우;

import java.io.*;
import java.util.Scanner;

public class BJ2578_빙고 {
    static int[][] board;
    static int cnt = 0;
    static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        String[] ipt;

        board = new int[5][5];
        checked = new boolean[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for(int n = 1; n <= 25; n++) {
            int Fnum = sc.nextInt();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == Fnum) {
                        board[i][j] = 0;
                    }
                }
            }
            rc();
            cc();
            lcc();
            rcc();

            if(cnt >= 3){
                System.out.println(n);
                break;
            }
            cnt = 0;
        }
    }

    static void rc(){   // 가로 행 체크
        for(int i = 0; i < 5; i++){
            int zc = 0;
            for(int j = 0; j < 5; j++){
                if(board[i][j] == 0) zc++;
            }
            if(zc == 5) cnt++;
        }
    }

    static void cc(){   // 세로 열 체크
        for(int i = 0; i < 5; i++){
            int zc = 0;
            for(int j = 0; j < 5; j++){
                if(board[j][i] == 0) zc++;
            }
            if(zc == 5) cnt++;
        }
    }

    static void lcc(){  // 좌하 대각선 체크
        int zc = 0;
        for(int i = 0; i < 5; i++){
            if(board[i][i] == 0) zc++;
        }
        if(zc == 5) cnt++;
    }

    static void rcc(){  // 우상 대각선 체크
        int zc = 0;
        for(int i = 0; i < 5; i++){
            if(board[4-i][i] == 0) zc++;
        }
        if(zc == 5) cnt++;
    }

}
