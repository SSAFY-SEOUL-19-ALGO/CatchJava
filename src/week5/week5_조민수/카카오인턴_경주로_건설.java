package week5.week5_조민수;
import java.util.*;

public class 카카오인턴_경주로_건설 {
	int[] dx= {0, 0, -1, 1}; 
	int[] dy= {-1, 1, 0, 0};//좌우상하
    public int solution(int[][] board) {
      
        int N = board.length;
        int min=Integer.MAX_VALUE;
        int[][][] cost = new int[N][N][4];//좌표 x, y + 방향값(상하좌우 어디서 왔는지)
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1});//우측으로 가는 start
        queue.add(new int[]{0, 0, 0, 3});//아래로 가는 start
        //각 방향으로 가는 경우를 넣은 뒤에 BFS ㄱㄱ
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];
                int c = cur[2] + (cur[3] == k ? 100 : 600);//현재 값 + 방향이 바꼈으면 600 직진이면 100->현재 나랑 방향값이 다르면 다 코너로 취급

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 1 || cost[ny][nx][k] <= c) {
                	continue;
                }
                cost[ny][nx][k] = c;
                if(ny==N-1&&nx==N-1&&c<min) {//마지막칸이면 비교
                	min=c;
                }
                queue.add(new int[]{ny, nx, c, k});
            }
        }
        //다돌고 나오면 [n-1][n-1]칸의 4방향중 최소값찾기
        
        return min; //4방향에서 온 값중에서 최소값을 찾아 반환 
    }
}
