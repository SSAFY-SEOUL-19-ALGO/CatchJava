package week6.week6_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ16234_인구이동 {

    static final int[] dx = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dy = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static int N, L, R, totalCnt, sum;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> list;

    // dfs 메소드
    static void dfs(int x, int y) {
        for(int i=0; i<4; i++) {    // 우, 하, 좌, 상 반복
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {  // 다음위치가 범위 내이면서
                int diff = Math.abs(map[x][y] - map[nextX][nextY]); // 다음 위치와의 인구 차이
                if(diff >= L && diff <= R) {    // 인구차이가 L이상 R이하이면
                    visited[nextX][nextY] = true;   // 방문처리
                    list.add(new int[] {nextX, nextY}); // 다음 위치를 리스트에 추가
                    sum += map[nextX][nextY];   // 그룹 인구수 합에 더함
                    dfs(nextX, nextY);  // 다음 위치 dfs
                }
            }
        }
    }

    // 인구이동 메소드
    static boolean move() {
        for (boolean[] v :
                visited) {
            Arrays.fill(v, false);  // 방문기록 초기화
        }
        boolean isMove = false;    // 인구이동이 있었는지 확인
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {    // 모든 지역 확인
                if (!visited[i][j]) {   // 방문하지 않았으면
                    sum = map[i][j];    // 그룹 합을 현재 인구수로 초기화
                    visited[i][j] = true;   // 현재 지역 방문처리
                    list.add(new int[] {i, j}); // 현재 지역 좌표 리스트에 저장
                    dfs(i, j);  // dfs 시작
                    int size = list.size(); // 그룹 좌표 리스트 크기
                    if(size > 1) {  // 리스트의 내용이 시작지역 1개보다 많다면
                        for (int[] p :
                                list) { // 리스트 좌표 반복
                            int x = p[0];
                            int y = p[1];
                            map[x][y] = sum / size; // 그룹에 속하는 지역의 인구수를 모두 똑같게
                        }
                        isMove = true;  // 인구이동이 있었으므로 인구이동 여부를 true로
                    }
                    list.clear();   // 그룹 리스트 초기화
                }
            }
        }
        return isMove;  // 인구이동 여부 반환
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        N = Integer.parseInt(st[0]);
        L = Integer.parseInt(st[1]);
        R = Integer.parseInt(st[2]);

        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }

        list = new ArrayList<>();
        while(move()) { // 인구이동이 있는 동안 반복
            totalCnt++; // 인구이동 카운트 증가
        }

        System.out.println(totalCnt);
    }
}