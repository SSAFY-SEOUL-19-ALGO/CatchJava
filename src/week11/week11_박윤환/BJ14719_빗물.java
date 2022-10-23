package week11.week11_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14719_빗물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int H = Integer.parseInt(st[0]);    // 높이
        int W = Integer.parseInt(st[1]);    // 너비
        int[][] map = new int[H][W];    // 지형

        st = br.readLine().split(" ");
        for(int j=0; j<W; j++) {
            int cur = Integer.parseInt(st[j]);
            for(int i=H-cur; i<H; i++) {
                map[i][j] = 1;  // 블록은 1로 표기
            }
        }

        int result = 0; // 고이는 빗물 양
        for(int i=0; i<H; i++) {    // 위쪽부터 한층씩 탐색
            int start = -1; // 블록 시작 위치
            int end = -1;   // 블록 끝 위치
            for(int j=0; j<W; j++) {    // 왼쪽부터 탐색
                if(map[i][j] == 1) {    // 블록이 있으면
                    start = j;  // 해당위치를 시작위치로 기록
                    break;  // 왼쪽 탐색 끝
                }
            }
            if(start == -1) continue;   // 블록이 없었다면 다음층으로
            for(int j=W-1; j>=0; j--) { // 오른쪽부터 탐색
                if(map[i][j] == 1) {    // 블록이 있으면
                    end = j;    // 끝 블록 위치로 기록
                    break;  // 오른쪽 탐색 끝
                }
            }
            if(start == end) continue;  // 시작위치와 끝위치와 같으면 블록이 1개이므로 다음 층으로
            for(int j=start+1; j<end; j++) {    // 시작위치 다음부터 끝위치 전까지
                if(map[i][j] == 0) result++;    // 블록이 없는 곳은 전부 빗물이 고이므로 카운트한다
            }
        }

        System.out.println(result);
    }
}
