package week5_채예진;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class 경주로_건설 {
    static int[][][] price;
    static int N;
    static int[][] move = { {-1,0}, {1,0}, {0,-1}, {0,1} }; // 상하좌우

	static class Road {
		int x, y, direction;

		public Road(int x, int y, int direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
		
	}
	
    static int solution(int[][] board) {
        N = board.length;
        price = new int[4][N][N]; // 방향, 행, 열
        
        for (int i = 0; i < board.length; i++) {
        	Arrays.fill(price[0][i], Integer.MAX_VALUE);
        	Arrays.fill(price[1][i], Integer.MAX_VALUE);
        	Arrays.fill(price[2][i], Integer.MAX_VALUE);
        	Arrays.fill(price[3][i], Integer.MAX_VALUE);
        }
        
        Queue<Road> q = new ArrayDeque<>();

        if(board[1][0]==0){ // 오른쪽이 갈 수 있다면 
        	price[1][1][0] = 100;
        	q.offer(new Road(1, 0, 1));
        }
        if(board[0][1]==0){ // 왼쪽 갈 수 있다면 
        	price[3][0][1] = 100;
        	q.offer(new Road(0, 1, 3));
        }
        
        while(!q.isEmpty()){
            Road cur = q.poll(); // 현재 
            int x = cur.x;  
            int y = cur.y;  
            int d = cur.direction;

            for(int i = 0; i < 4; i++){
            	// 움직일 곳 
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 배열 넘어가면 
        		if (board[nx][ny] == 1) continue; // 갈 수 없는 곳 = 벽
        		
        		// 가격 계산 
        		int cost = price[d][x][y];

        		cost += 100;
                if(d != i) { // 방향이 달라질 경우
                	cost += 500;
                }
                if(price[i][nx][ny] >= cost) { // 업데이트 
                	q.offer(new Road(nx, ny, i));
                	price[i][nx][ny] = cost;
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < 4; i++)
            result = (result > price[i][N-1][N-1] ? price[i][N-1][N-1] : result); // 값이 제일 작은 값 
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,0,0},{0,0,0},{0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));
	}

}

/*
 * 마지막 테스트에서 계속 실패 = 검색 결과 -> 2600 + 600 = 3200, 2700 + 100 = 2800 dlfktj.
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public class 경주로_건설 {

	static int min;
	static class Road {
		int x, y, direction, cost;

		public Road(int x, int y, int direction, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.cost = cost;
		}
		
	}
	
    public static int solution(int[][] board) {
        int[][] distance = new int[board.length][board[0].length]; // 방향, 행, 열 
        
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 
        int[] dy = {0, 0, -1, 1}; // 상하좌우 
        
        min = Integer.MAX_VALUE;
        // bfs로 풀기 
        Queue<Road> q = new ArrayDeque<>();
        q.offer(new Road(0, 0, -1, 0));
        
        for (int i = 0; i < board.length; i++) {
        	Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        
        while(!q.isEmpty()) {
        	Road cur = q.poll();
        	
        	if (cur.x == board.length - 1 && cur.y == board[0].length - 1) {
        		min = Math.min(min, cur.cost);
        		continue;
        	}
        	
        	for (int i = 0; i < 4; i++) {
        		int nx = cur.x + dx[i];
        		int ny = cur.y + dy[i];
        		
        		if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue; // 배열 넘어가면 
        		if (board[nx][ny] == 1) continue; // 갈 수 없는 곳 = 벽
        		
        		int cost = cur.cost; // 새로운 포인트의 비용은, 이전 비용의 값으로 초기화  
        		if(cur.direction == -1 || cur.direction == i) { // 처음 시작(-1)이거나 방향이 같은 경우 -> +무조건 직선 도로 100 
					cost += 100; 
				} else {
					cost += 600; // +(직선 도로 100 + 코너 500)
				}
        		
        		if (distance[nx][ny] >= cost) {
        			distance[nx][ny] = cost;
        			q.offer(new Road(nx, ny, i, cost));
        		}
        	}
        }
        
        return min;
    }
    
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,0,0},{0,0,0},{0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));
		System.out.println(solution(new int[][] {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));
	}

}
*/
