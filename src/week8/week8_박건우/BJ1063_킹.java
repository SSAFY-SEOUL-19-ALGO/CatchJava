package week8.week8_박건우;

import java.io.*;

public class BJ1063_킹 {
    static int[][] map = new int[8][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        String com;
        int nx, ny, move[];
        String king = ipt[0];   // 1
        String stone = ipt[1];  // 2
        int N = Integer.parseInt(ipt[2]);


        map[king.charAt(0) - 'A'][king.charAt(1) - 49] = 1;
        map[stone.charAt(0) - 'A'][stone.charAt(1) - 49] = 2;

        for(int i =0; i < N; i++){
            com = br.readLine();
            move = move(com);
            nx = move[0];
            ny = move[1];
        }
    }

    public static int[] move(String com){
        int[] answer = new int[] {};
        if(com.equals("R")){    // 우
            answer = new int[] {0, 1};
        }else if(com.equals("L")){  // 좌
            answer = new int[] {0, -1};
        }else if(com.equals("B")){  // 하
            answer = new int[] {1, 0};
        }else if(com.equals("T")){  // 싱
            answer = new int[] {-1, 0};
        }else if(com.equals("RT")){ // 우상
            answer = new int[] {1, 1};
        }else if(com.equals("LT")){ // 좌상
            answer = new int[] {1, -1};
        }else if(com.equals("RB")){ // 우하
            answer = new int[] {-1, 1};
        }else if(com.equals("LB")){ // 좌하
            answer = new int[] {-1, -1};
        }
        return answer;
    }
}
