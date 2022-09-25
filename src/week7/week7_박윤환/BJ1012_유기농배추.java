package week7.week7_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1012_유기농배추 {
    static final int[] dx = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dy = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static int M, N, K;
    static int[][] field;

    // 배추위치에서 dfs 탐색하여 0으로 바꾸는 메소드
    static void dfs(int x, int y) {
        field[x][y] = 0;    // 배추 위치를 0으로 바꿈

        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];  // 다음 행 위치
            int nextY = y + dy[i];  // 다음 열 위치
            if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N   // 다음 위치가 범위 내이면서
                    && field[nextX][nextY] == 1) {  // 배추가 있다면
                dfs(nextX, nextY);  // 그 위치에서 다시 dfs탐색
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수

        for(int tc=1; tc<=T; tc++) {    // 테스트케이스 반복
            String[] st = br.readLine().split(" ");
            M = Integer.parseInt(st[0]);
            N = Integer.parseInt(st[1]);
            K = Integer.parseInt(st[2]);
            field = new int[M][N];
            for(int i=0; i<K; i++) {
                st = br.readLine().split(" ");
                int x = Integer.parseInt(st[0]);
                int y = Integer.parseInt(st[1]);
                field[x][y] = 1;    // 배추의 위치는 1로 표시
            }

            int cnt = 0;
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {    // 밭의 모든 위치 탐색
                    if(field[i][j] == 1) {  // 배추가 있다면
                        dfs(i, j);  // dfs 실행
                        cnt++;  // 배추흰지렁이 개수 증가
                    }
                }
            }
            sb.append(cnt).append("\n");    // 결과물 출력 저장
        }
        System.out.println(sb); // 결과물 출력
    }
}
