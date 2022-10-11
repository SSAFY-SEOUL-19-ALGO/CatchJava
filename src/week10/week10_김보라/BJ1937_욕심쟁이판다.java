package week10.week10_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ1937_욕심쟁이판다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String[] s= br.readLine().split(" ");
			for(int j = 0; j<n; j++) {
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
//				if(visited[i][j]!=0)
					answer=Math.max(answer, go(i,j));
			}
		}
		System.out.println(answer);
	}
	static int n;
	static int map[][];
	static int visited[][];
	static int answer = 0;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int go(int x,int y) {
		if(visited[x][y]!=0)
			return visited[x][y];
		
		visited[x][y]=1;
		for(int d = 0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(map[x][y]<map[nx][ny]) {
					visited[x][y]=Math.max(visited[x][y], go(nx,ny)+1);
				}
			}
				
		}

		return visited[x][y];
		
		
	}
/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String[] s= br.readLine().split(" ");
			for(int j = 0; j<n; j++) {
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i = 0; i<n*n; i++) {
			int newMap[][]=new int[n][n];
			copyMap(map,newMap);
			go(i,newMap);
		}
	}
	static int n;
	static void copyMap(int[][]map, int[][] newMap) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				newMap[i][j]=map[i][j];
			}
		}
	}
	static void go(int xy,int[][]map) {
		int x = xy/n;
		int y = xy%n;
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {x,y});
		map[x][y]=0;
	}*/
}
