package week11.week11_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16918_봄버맨 {
	static class node{
		int x, y;

		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int R,C,time;
	static char[][] map;
	static int[][] booming;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s[] = bf.readLine().split(" ");
		
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		int N = Integer.parseInt(s[2]);
		
		map = new char[R][C];
		booming = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String s2 = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s2.charAt(j);
				
				if(map[i][j]=='O') {
					booming[i][j] = 3; // 폭탄이 터지는 시간 ( 폭탄 놓은 시간 + 3 )
				}
			}
		} // 입력 완료
		
		time = 0;
				
		while(time++ <N) { // 주어진 시간동안
			if (time%2==0) {
				// 짝수 시간 : 폭탄을 놓는다
				Insert();
			} else if (time%2==1) {
				// 홀수 시간 : 시간이 다 된 폭탄을 터뜨린다
				Boom();
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		
	}

	private static void Boom() {
		// 시간이 다 된 폭탄을 터뜨린다 
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(booming[i][j] == time) {
					map[i][j] ='.'; // 터뜨리고 난 후
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(nx<0 || ny<0 ||nx >=R||ny>=C) continue;
						
						if(map[nx][ny]=='O' && booming[nx][ny] !=time) {
							map[nx][ny] ='.';
							booming[nx][ny] = 0;
						}
					}
				}
			}
		}
	}
		
	private static void Insert() {
		// 비어 있는 모든 칸에 폭탄을 설치한다
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='.') {
					map[i][j] ='O';
					booming[i][j] = time + 3;
				}
			}
		}
	}
}