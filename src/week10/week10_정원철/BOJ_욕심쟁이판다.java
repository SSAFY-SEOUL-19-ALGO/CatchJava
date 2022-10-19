package week10.week10_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_욕심쟁이판다 {
	
	
	// dp배열의 의 값이 0이 아닌 곳은 그냥 반환하면서 모든 지점을 방문가능
	// 방문한 값은 버리는 방식으로 풀이 참고
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	N=Integer.parseInt(br.readLine());
    	map=new int[N][N];
        for (int i = 0; i < N; i++) {
        	String st[]=br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
            	map[i][j] = Integer.parseInt(st[j]);
            }
        }
        
        dp = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                max = Math.max(dfs(i,j), max);
            }
        }
        System.out.println(max);
    }
    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(map[nx][ny] > map[x][y])
                    dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);
            }
        }
        return dp[x][y];
    }
}
	
	

// 시간초과 (100만 곱하기 100만은 안될거알면서도 해봣음)
//	static int N,sx,sy, cnt=0,turn=0, max=Integer.MIN_VALUE;
//	
//	static int [][] map;
//	static int [][] check;
//	static int realMax=Integer.MIN_VALUE;
//	static boolean [][] visited;
//	static int dx[]= {-1,1,0,0};
//	static int dy[]= {0,0,-1,1};
//	
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		N=Integer.parseInt(br.readLine());
//		
//		map=new int[N][N];
//		check=new int[N][N];
//
//		for(int i=0; i<N;i++) {
//			String st[]=br.readLine().split(" ");
//			for(int j=0; j<N;j++) {
//				map[i][j]=Integer.parseInt(st[j]);
//			}	
//		}
//		
//		for(int i=0; i<N;i++) {
//			for(int j=0; j<N;j++) {
//				visited=new boolean[N][N];
//				sx=i;
//				sy=j;
//				dfs(i,j);
//				check[i][j]=max;
//				max=0;
//			}	
//		}
//		for(int i=0; i<N;i++) {
//			for(int j=0; j<N;j++) {
//				if(check[i][j]>realMax) realMax=check[i][j];
//			}
//		}
//		System.out.println(realMax);
//	}
//
//	public static void dfs(int x, int y) {
//		
//		if(cnt>=4) return;
//		cnt=0;
//		for(int j=0; j<4; j++) {
//				int originX=sx;
//				int originY=sy;
//				turn=0;
//			for(int i=0; i<4; i++) {
//				int nx=originX+dx[i];
//				int ny=originY+dy[i];
//				if(nx>=N||ny>=N|| nx<0||ny<0) {
//					cnt++;
//					continue;
//				}
//				
//				if(map[x][y]>=map[nx][ny] ||check[nx][ny]==1||visited[nx][ny]==true) {
//					cnt++;
//					continue;
//				}
//				turn++;
//				visited[nx][ny]=true;
//				dfs(nx,ny);
//				visited[nx][ny]=false;
//			}
//			if(max<turn) max=turn;
//		}
//	}


