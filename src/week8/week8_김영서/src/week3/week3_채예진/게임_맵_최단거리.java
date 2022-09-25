package week3.week3_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 게임_맵_최단거리 {

    public static int solution(int[][] maps) {
    	
    	Deque<int[]> queue = new ArrayDeque<>();
    	
    	int r = maps.length;
    	int c = maps[0].length;
    	
    	int[][] visited = new int[r][c];
    	
    	int[] dx = new int[] {1, -1, 0, 0}; // 동서남북 
    	int[] dy = new int[] {0, 0, 1, -1}; // 동서남북 
    	
    	queue.offer(new int[]{0, 0});
    	
    	visited[0][0] = 1;
    	
    	while(!queue.isEmpty()) {
    		int[] point = queue.poll(); // 위치 담는 배열 하나 뽑기 
    		int x = point[0];
    		int y = point[1];
    		
    		for (int i = 0; i < 4; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			
    			if (nx < 0 || nx > r - 1 || ny < 0 || ny > c - 1) continue; // 범위 밖일 경우 
    			
    			if (visited[nx][ny] == 0 && maps[nx][ny] == 1) { // 범위 안이고, 방문하지 않았고, 방문 가능한 곳이라면, 
    				visited[nx][ny] = visited[x][y] + 1; // 칸의 개수 최솟값 
    				queue.add(new int[] {nx, ny}); // queue에 넣기 
    			}
    		}
    	}
    	
        int answer = visited[r - 1][c - 1]; // 끝에 도달했을 때 
        
        if (answer == 0) { // 탐색 실패 
        	answer = -1;
        }
        
        return answer;
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] maps = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				maps[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		System.out.println(solution(maps));
	}

}
