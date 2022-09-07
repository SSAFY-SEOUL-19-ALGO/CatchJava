package week5.week5_박윤환;

import java.util.ArrayDeque;
import java.util.Queue;

public class P67259_경주로건설 {
    static final int[] dx = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dy = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static int N;

    // 너비 우선 탐색 메소드
    static int bfs(int[][] board, int dir) {
        int[][] dp = new int[N][N]; // 각 지점까지의 최소 건설비용 기록
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, dir, 0});  // 시작 지점의 위치, 방향, 비용을 저장
        dp[0][0] = -1;  // 첫 지점 건설비용을 0이 아닌 값으로

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();   // 현재 위치에서의 정보
            int x = cur[0]; // 행 위치
            int y = cur[1]; // 열 위치
            int d = cur[2]; // 방향
            int cost = cur[3];  // 비용

            for(int i=0; i<4; i++) {    // 우, 하, 좌, 상 탐색
                int nextX = x + dx[i];  // 다음 행 위치
                int nextY = y + dy[i];  // 다음 열 위치
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {    // 범위를 벗어나지 않을 경우
                    if(board[nextX][nextY] == 0) {  // 다음 위치가 건설 가능 지역이면
                        int next;   // 다음 위치까지 건설 비용
                        if(d == i) {    // 같은 방향이라면
                            next = cost + 100;  // 직선도로 비용 100만 추가
                        } else {    // 다른 방향이라면
                            next = cost + 600;  // 코너 비용 500을 더 추가
                        }
                        // 다음 위치까지의 건설비용이 0이거나 지금 루트가 더 저렴할 경우
                        if(dp[nextX][nextY] == 0 || next < dp[nextX][nextY]) {
                            dp[nextX][nextY] = next;    // 다음 위치까지의 건설 비용 갱신
                            queue.offer(new int[]{nextX, nextY, i, next});  // 그 위치를 다음 방문 위치로
                        }
                    }
                }
            }
        }

        return dp[N-1][N-1];    // 최종 건설비용 반환
    }

    public int solution(int[][] board) {
        int answer;
        N = board.length;   // 도면의 크기

        // 처음을 오른쪽으로 가기 시작 했을때와 아래쪽으로 가기 시작했을때 2가지 경우 중 최소
        answer = bfs(board, 0); // 오른쪽으로 갔을 경우
        answer = Math.min(answer, bfs(board, 1));   // 아래쪽으로 갔을 경우

        return answer;
    }

    public static void main(String[] args) {
        P67259_경주로건설 sol = new P67259_경주로건설();

        int[][] a = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        int[][] b = {
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,1},
                {0,0,1,0,0,0,1,0},
                {0,1,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,0}
        };
        int[][] c = {
                {0,0,1,0},
                {0,0,0,0},
                {0,1,0,1},
                {1,0,0,0}
        };
        int[][] d = {
                {0,0,0,0,0,0},
                {0,1,1,1,1,0},
                {0,0,1,0,0,0},
                {1,0,0,1,0,1},
                {0,1,0,0,0,1},
                {0,0,0,0,0,0}
        };

        System.out.println(sol.solution(a));
        System.out.println(sol.solution(b));
        System.out.println(sol.solution(c));
        System.out.println(sol.solution(d));
    }
}
