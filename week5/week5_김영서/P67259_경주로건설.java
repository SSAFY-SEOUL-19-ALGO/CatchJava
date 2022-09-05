package week5_김영서;

import java.util.LinkedList;
import java.util.Queue;

public class P67259_경주로건설 {
    private static int n;
    private static int[][] map;
    private static boolean[][] visit;

    private static int[] dx = {-1, 0, 1, 0}; //상우하좌
    private static int[] dy = {0, 1, 0 ,-1};

    private static int cost = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;

        map = board;
        visit = new boolean[n][n];

        bfs(0,0,-1,0);

        answer = cost;

        return answer;
    }

    private static void bfs(int x, int y, int dir, int price) {

        Queue<Road> q = new LinkedList();
        q.add(new Road(x,y,dir,price));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Road road = q.remove();

            int qx = road.x;
            int qy = road.y;
            int qDir = road.dir;
            int qPrice = road.cost;

            if (qx == n-1 && qy == n-1) {
                cost = Math.min(cost, qPrice);
            }

            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                int nDir = i;
                int nPrice = qPrice;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 1) {
                    continue;
                }

                if (qDir == -1) {
                    //처음엔 직선
                    nPrice += 100;
                } else if (qDir == nDir) {
                    //방향 같을 때
                    nPrice += 100;
                } else {
                    //방향 다를 때
                    nPrice += 600;
                }

                if (!visit[nx][ny] || map[nx][ny] >= nPrice) {
                    //방문 x, 이전 값이 더 클 경우 작은값을 넣어준다.
                    visit[nx][ny] = true;
                    map[nx][ny] = nPrice;
                    q.add(new Road(nx, ny, nDir, nPrice));
                }

            }
        }

    }

}


class Road {
    int x, y, dir, cost;

    Road(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}