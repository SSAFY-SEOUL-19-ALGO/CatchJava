package week11.week11_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ16918_봄버맨 {
    static final int[] dr = {0, 1, 0, -1};  // 우, 하, 상, 죄
    static final int[] dc = {1, 0, -1, 0};  // 우, 하, 상, 좌

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] st = br.readLine().split(" ");
        int R = Integer.parseInt(st[0]);    // 행 크기
        int C = Integer.parseInt(st[1]);    // 열 크기
        int N = Integer.parseInt(st[2]);    // 시간
        int[][] map = new int[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                if(s.charAt(j) == '.') {    // 빈칸이면
                    map[i][j] = -1; // -1로
                }
            }
        }

        for(int t=2; t<=N; t++) {   // 1초까진 초기상태과 같으므로 2초부터 N초까지
            if(t % 2 == 0) {    // 짝수 초일 경우
                for(int i=0; i<R; i++) {
                    for(int j=0; j<C; j++) {
                        if(map[i][j] == -1) {   // 빈칸을
                            map[i][j] = t;  // 그 시간의 폭탄으로 채움
                        }
                    }
                }
            } else {    // 홀수 초일 경우
                for(int i=0; i<R; i++) {
                    for(int j=0; j<C; j++) {
                        if(map[i][j] == t-3) {  // 3초전의 폭탄이라면
                            map[i][j] = -1; // 터트리고 빈칸으로
                            for(int k=0; k<4; k++) {    // 지금 폭탄 기분 사방탐색
                                int nextR = i + dr[k];  // 다음 행 위치
                                int nextC = j + dc[k];  // 다음 열 위치
                                if(nextR >= 0 && nextR < R && nextC >= 0 && nextC < C   // 범위 내이고
                                    && map[nextR][nextC] != t-3) {  // 3초전의 폭탄이 아니라면
                                    map[nextR][nextC] = -1; // 같이 터트리고 빈칸으로
                                }
                            }
                        }
                    }
                }
            }
        }

        // map을 분석하여 출력물 저장
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == -1) {   // 빈칸은
                    sb.append("."); // '.'을 채움
                } else {    // 폭탄이 있으면
                    sb.append("O"); // 'O'를 채움
                }
            }
            sb.append("\n");    // 줄 바꿈
        }

        System.out.println(sb); // 최종 출력
    }
}
