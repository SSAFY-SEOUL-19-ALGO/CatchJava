package week7.week7_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2578_빙고 {
    static int count;
    static int[][] board;

    // 가로 빙고 체크
    static void checkRow() {
        for(int i=0; i<5; i++) {
            if(board[i][0] == 0) {  // 가로 첫번째가 0이라면
                int cnt = 0;    // 가로줄의 0 개수를 카운트
                for(int j=0; j<5; j++) {    // 가로 체크
                    if(board[i][j] != 0) break; // 0이 아니면 체크 중지
                    cnt++;  // 0 개수 카운트 증가
                }
                if(cnt == 5) count++;   // 가로가 전부 0이면 빙고 카운트 증가
            }
        }
    }

    // 세로 빙고 체크
    static void checkCol() {
        for(int j=0; j<5; j++) {
            if(board[0][j] == 0) {  // 세로 첫번째가 0이라면
                int cnt = 0;    // 세로줄의 0 개수를 카운트
                for(int i=0; i<5; i++) {    // 세로 체크
                    if(board[i][j] != 0) break; // 0이 아니면 체크 중지
                    cnt++;  // 0 개수 카운트 증가
                }
                if(cnt == 5) count++;   // 세로가 전부 0이면 빙고 카운트 증가
            }
        }
    }

    // 대각선 빙고 체크
    static void checkDia() {
        if(board[0][0] == 0) {  // 왼쪽위가 0이면
            int cnt = 0;
            for(int i=0; i<5; i++) {    // 우측 아래로 대각선 체크
                if(board[i][i] != 0) break; // 0이 아니면 체크 중지
                cnt++;  // 0 개수 카운트 증가
            }
            if(cnt == 5) count++;   // 대각선 전부 0이면 빙고 카운트 증가
        }

        if(board[0][4] == 0) {  // 오른쪽위가 0이면
            int cnt = 0;
            for(int i=0; i<5; i++) {    // 좌측 아래로 대각선 체크
                if(board[i][4-i] != 0) break;   // 0이 아니면 체크 중지
                cnt++;  // 0 개수 카운트 증가
            }
            if(cnt == 5) count++;   // 대각선 전부 0이면 빙고 카운트 증가
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];
        for(int i=0; i<5; i++) {
            String[] st = br.readLine().split(" ");
            for(int j=0; j<5; j++) {
                board[i][j] = Integer.parseInt(st[j]);
            }
        }
        int[] order = new int[25];  // 사회자가 부르는 번호 저장
        int index = 0;
        for(int i=0; i<5; i++) {
            String[] st = br.readLine().split(" ");
            for(int j=0; j<5; j++) {
                order[index++] = Integer.parseInt(st[j]);
            }
        }

        for(int k=0; k<25; k++) {   // 사회자가 부르는 번호 반복
            for(int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    if(board[i][j] == order[k]) {   // 빙고판 번호와 부른 번호가 같으면
                        board[i][j] = 0;    // 해당 자리를 0으로
                        checkRow(); // 가로줄 빙고 체크
                        checkCol(); // 세로줄 빙고 체크
                        checkDia(); // 대각선 빙고 체크
                        if(count >= 3) {    // 빙고 개수가 3개 이상이면
                            System.out.println(k+1);    // 몇번째 번호인지 출력
                            System.exit(0); // 프로그램 종료
                        }
                        count = 0;  // 빙고 카운트 0으로 초기화
                    }
                }
            }
        }
    }
}
