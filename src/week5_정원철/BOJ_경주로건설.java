package week5_정원철;

import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_경주로건설 {
	static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
	
	
    static class Node{
        int x, y, dir ,cost;

        Node(int x, int y,int dir,int cost){
            this.x= x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    static public int solution(int[][] board) {
    	int answer=0;
        int N = board.length;
        int[][] costs = new int[N][N];

        Queue<Node> que = new ArrayDeque();
        que.add(new Node(0,0,-1,0));
        while(!que.isEmpty()){
            Node pol = que.poll();

            for(int i = 0; i<4;i++){
                int nx = pol.x + dx[i];
                int ny = pol.y + dy[i];

                
                if (!chkFor(nx,ny,N)){
                    continue;
                }
                if(board[nx][ny]==1) continue;
                int cost = 0;
                
                if(pol.dir == i || pol.dir == -1){
                    cost = pol.cost + 100;
                }else{
                    cost = pol.cost + 600;
                }

                if(costs[nx][ny] != 0){
                    if(cost <= costs[nx][ny]){
                        que.add(new Node(nx,ny,i,cost));
                        costs[nx][ny] =cost;
                    }
                }else {
                    costs[nx][ny] = cost;
                    que.add(new Node(nx, ny, i,cost));


                }
            }
        }
      
        answer=costs[N-1][N-1];
        return answer;
    }

    static boolean chkFor(int x, int y, int N){
        return x>=0&&y>=0&&x<N&&y<N;
    }
    
    
    public static void main(String[] args) {
        int[][] board = new int[][]{{0,0,0}, {0,0,0},{0,0,0}};
        System.out.println(solution(board));
    }
}