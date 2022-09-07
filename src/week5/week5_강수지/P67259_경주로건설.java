package week5.week5_강수지;

import java.util.LinkedList;
import java.util.Queue;

public class P67259_경주로건설 {
	// 같은 방향으로 가지 않으면 직선 100 + 코너 500 = 600 원
	static int[] dx = {-1,0,0,1}; // 상 좌 우 하
	static int[] dy = {0,-1,1,0};
	static boolean[][] visited;
	static int[][] boards;
	static int N;
	static int answer;
	
	public static class Node{ // x y 좌표, 방향, 비용
		int x; 
		int y;
		int dir;
		int cost;
		
		public Node(int x, int y, int dir, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        boards = board;
        
        N = board.length;
        visited = new boolean[N][N];

        // 출발 두가지 : 오른쪽 방향으로 가는 경우, 아래쪽 방향으로 가는 경우
        bfs(0, 0, 2, 0);
        bfs(0, 0, 3, 0);

        return answer;
    }
    
    public static void bfs(int x, int y, int dir, int cost) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y,dir,cost));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.x==N-1 && cur.y==N-1) { // 도착지점
				answer = Math.min(answer, cur.cost);
			}
			
			for(int d=0;d<4;d++) { // 4 방향으로 이동
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				int ndir = d; // 현재 위치
				int ncost = cur.cost; // 현재 비용
				
				// 범위를 벗어나거나 벽인 경우 
				if(nx<0||nx>=N||ny<0||ny>=N||boards[nx][ny]==1) continue;
				
				// 방향이 같은 경우 , 직선 도로 100원
				if(ndir == cur.dir) {
					ncost += 100;
				}else { // 코너 끼면 추가 500원
					ncost += 600;
				}

				if(!visited[nx][ny] || boards[nx][ny] >= ncost) {
					visited[nx][ny] = true;
					boards[nx][ny] = ncost;
					q.offer(new Node(nx, ny, ndir, ncost));
				}
			}
		}
	}
}
