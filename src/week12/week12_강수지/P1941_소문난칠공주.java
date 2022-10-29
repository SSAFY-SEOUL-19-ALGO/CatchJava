package week12.week12_강수지;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1941_소문난칠공주 {
	static char[][] map;
	static int[] x;
	static int[] y;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5]; // 25*25
		
		for (int i = 0; i < 5; i++) {
			String s = bf.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = s.charAt(j);
			}
		} // 입력 완료
		
		x = new int[25];
		y = new int[25];
		
		// 좌표를 미리 계산 .. (0,0) => 0
		for (int i = 0; i < 25; i++) {
			x[i] = i % 5;
			y[i] = i / 5;
		}
		
		ans = 0;
		comb(new int[7], 0, 0, 0); // 7명을 뽑는 조합
		System.out.println(ans);
	}

	private static void comb(int[] member, int cnt, int start, int k) {
		if(k==7) { // 7 명을 뽑은 경우 탐색 돌려 !
			bfs(member);
			return;
		}
		 
		if(start == 25) return; // 25명이다
		
		member[cnt] = start;
		// 선택한 경우
		comb(member, cnt+1, start+1, k+1);
		// 선택하지 않은 경우
		comb(member, cnt, start+1, k);
	}

	private static void bfs(int[] member) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[7];
		
		visited[0] = true;
		q.offer(member[0]);
		int cnt = 1; // 7 자리 모두 연결되어있는지 세어주기 ..
		int s = 0; // 이다솜파
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(map[x[cur]][y[cur]]=='S') s++; // 이다솜파인 경우
			
			for (int d = 0; d < 4; d++) {
				for (int i = 1; i < 7; i++) {
					if(!visited[i]) {
						if(x[cur]+dx[d] == x[member[i]] && y[cur]+dy[d] == y[member[i]]) {
							visited[i] = true;
							q.add(member[i]);
							cnt++;
						}
					}
				}
			}
		}
		
		// 7명이 이어져 있다면
		if(cnt ==7) {
			if(s>=4) { // 이다솜이파가 4명이상이면
				ans++;
			}
		}
	}

	
}
