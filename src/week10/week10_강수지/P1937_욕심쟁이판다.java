package week10.week10_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P1937_욕심쟁이판다 { // dfs 그냥 돌면 .. 안되네
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int N;
	static int[][] map, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine()); //  대나무 숲의 크기
		map = new int[N][N];
		dp = new int[N][N]; // 최대를 저장하기 위한 배열
		
		for (int i = 0; i < N; i++) {
			String[] s = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		} // 입력 완료
		
		int max = Integer.MIN_VALUE; // 최대로 이동할 수 있는 칸을 구하기 위해 !
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, dfs(i,j));
			}
		}
		
		System.out.println(max);
	}

	private static int dfs(int i, int j) {
		if(dp[i][j] != 0) { // 이미 계산한 곳이라면
			return dp[i][j];
		}
		
		int cnt = 1;
		for (int d = 0; d < 4; d++) {
			int nx = i +  dx[d];
			int ny = j + dy[d];
			
			if(nx<0 || ny <0 || nx>=N || ny>=N) continue; // 범위를 벗어나는 경우
			if(map[i][j] < map[nx][ny]) { //전 지역보다 더 많은 나무를 가지고 있는 경우에만 이동 !
				cnt = Math.max(cnt, dfs(nx,ny)+1);
				dp[i][j] = cnt;
			}
		}
		return cnt;
	}
	
}
