package week5_박건우;

import java.util.ArrayDeque;
import java.util.Queue;

public class P67259_경주로건설 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tc = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(sol.solution(tc));
    }

}

class Solution {
    // 우하좌상
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][][] visited;
    int N;

    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N][4]; // N * N과 방향을 나타냄, 한 위치에서 방향이 달라지므로 방향까지 3차원
        return bfs(board);
    }


    public int bfs(int[][] board) {
        int nx, ny, nc;
        Queue<Node> q = new ArrayDeque<>();
        visited[0][0][0] = visited[0][0][1] = visited[0][0][2] = visited[0][0][3];
        q.add(new Node(0, 0, -1, 0));

        int minc = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == N - 1 && cur.y == N - 1) {
                minc = Math.min(minc, cur.cost);
            }
            for (int i = 0; i < 4; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] != 1) {    // 다음 좌표가 맵을 초과하거나, 장애물의 위치가 아니라면
                    nc = 0;
                    if (cur.dir == i || cur.dir == -1) nc = cur.cost + 100;  //지금 방향이  직선 도로면 100원 더 든다
                    else nc = cur.cost + 600;   // 곡선이면 600원 더 든다

                    if (!visited[nx][ny][i] || board[nx][ny] >= nc) {
                        q.add(new Node(nx, ny, i, nc));
                        visited[nx][ny][i] = true;
                        board[nx][ny] = nc;
                    }
                }
            }
        }
        return minc;
    }

    public static class Node {
        int x;
        int y;
        int dir;
        int cost;    // 좌표와 방향, 비용 값을 각 선으로 표현

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}