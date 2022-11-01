package week12.week12_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class BJ11559_PuyoPuyo {
    static final int[] dx = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dy = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static boolean[][] visited;
    static char[][] map;
    static Queue<int[]> queue;
    static Deque<Character> stack;
    static boolean boom;

    // dfs탐색
    static void dfs(int x, int y, char color) {
        queue.offer(new int[] {x, y});  // 현재 위치를 큐에 추가

        for(int i=0; i<4; i++) {    // 사방 탐색
            int nextX = x + dx[i];  // 다음 행 위치
            int nextY = y + dy[i];  // 다음 열 위치
            if(nextX >= 0 && nextX < 12 && nextY >= 0 && nextY < 6) {   // 다음 위치가 범위내이고
                if(map[nextX][nextY] == color && !visited[nextX][nextY]) {  // 같은 색이고 방문하지 않았다면
                    visited[nextX][nextY] = true;   // 방문처리
                    dfs(nextX, nextY, color);   // 다음 위치 dfs 탐색
                }
            }
        }
    }

    // 뿌요가 터지는 메소드
    static void explode() {
        for (boolean[] v :
                visited) {
            Arrays.fill(v, false);  // 방문배열 초기화
        }
        // 모든 칸 반복
        for(int i=0; i<12; i++) {
            for(int j=0; j<6; j++) {
                if(map[i][j] != '.' && !visited[i][j]) {    // 빈칸이 아니고 방문하지 않았다면
                    visited[i][j] = true;   // 방문처리
                    dfs(i, j, map[i][j]);   // dfs 탐색
                    if(queue.size() >= 4) { // 큐에 저장된 뿌요가 4개이상이면 터질수 있음
                        boom = true;    // 터졌다는 flag 설정
                        while(!queue.isEmpty()) {   // 큐가 빌때까지 반복
                            int[] p = queue.poll();
                            map[p[0]][p[1]] = '.';  // 전부 빈칸으로
                        }
                    }
                    queue.clear();  // 안터졌을경우에 큐에 데이터가 남아있으므로 큐 클리어
                }
            }
        }
    }

    // 아래쪽으로 떨어지는 메소드
    static void down() {
        // 모든칸 반복
        for(int j=0; j<6; j++) {
            for(int i=0; i<12; i++) {
                if(map[i][j] != '.') {  // 빈칸이 아니면
                    stack.push(map[i][j]);  // 스택에 저장
                    map[i][j] = '.';    // 빈칸으로 변경
                }
            }
            int r = 11; // 행의 마지막 인덱스
            while(!stack.isEmpty()) {   // 스택이 빌때까지 반복
                map[r--][j] = stack.pop();  // 마지막부터 스택에 저장된 뿌요 채움
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];  // 12x6 크기의 게임판
        visited = new boolean[12][6];   // 방문배열
        queue = new ArrayDeque<>(); // 터트릴 뿌요 위치를 저장할 큐
        stack = new ArrayDeque<>(); // 아래로 떨어뜨릴 뿌요를 저장할 큐

        for(int i=0; i<12; i++) {
            String s = br.readLine();
            for(int j=0; j<6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;    // 연쇄 개수
        while(true) {   // 무한반복
            boom = false;   // 터짐 flag 초기화
            explode();  // 터짐
            down(); // 아래로 떨어짐
            if(boom) {  // 터진 뿌요가 있다면
                cnt++;  // 연쇄 증가
            } else {    // 없다면
                break;  // 반복 종료
            }
        }

        System.out.println(cnt);    // 연쇄 개수 출력
    }
}
