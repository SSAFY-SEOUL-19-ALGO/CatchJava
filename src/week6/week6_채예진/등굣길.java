package week6.week6_채예진;

public class 등굣길 {

    public static int solution(int m, int n, int[][] puddles) {
        // dp로 해야지 시간초과 안 남
        int[][] dp = new int[m + 1][n + 1];

        for (int[] puddle : puddles) { // 물웅덩이일경우
            dp[puddle[0]][puddle[1]] = -1;
        }

        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) { // 물 웅덩이 만날 경우
                    dp[i][j] = 0; // 계산을 위해 0으로 바꾸기
                    continue;
                }
                // i, j 체크 안 하면 틀림, % 안 하면 효율성 실패 뜸
                if (i != 1) dp[i][j] += dp[i - 1][j] % 1000000007;
                if (j != 1) dp[i][j] += dp[i][j - 1] % 1000000007;
            }
        }

        return dp[m][n] % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }
}

/* 정확성 전부 통과, 효율성 시간 초과
    static class Point {
        int x, y, depth;
        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int depth = -1;
        int[] dx = {1, 0}; // 아래쪽, 오른쪽
        int[] dy = {0, 1};
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(1, 1, 0));
        // bfs
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == m && cur.y == n) {
                if (depth == -1) {
                    answer++;
                    depth = cur.depth;
                } else if (depth == cur.depth) {
                    answer++;
                } else {
                    break;
                }
            }
            for (int i = 0; i < 2; i ++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                boolean check = false;
                if (nx < 1 || nx > m || ny < 1 || ny > n) continue;
                for (int[] puddle : puddles) {
                    if (nx == puddle[0] && ny == puddle[1]) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    q.offer(new Point(nx, ny, cur.depth + 1));
                }
            }
        }
        return answer % 1000000007;
    }
 */