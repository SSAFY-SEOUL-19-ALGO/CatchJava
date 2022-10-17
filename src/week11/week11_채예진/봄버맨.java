package week11.week11_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 봄버맨 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int N = Integer.parseInt(input[2]);
		
		char[][] map = new char[R][C];
		int[][] bomb = new int[R][C];
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c] == 'O'){
                    bomb[r][c] = 3; // 폭탄이 터질 시간
                }
			}
		}
		
		int time = 0;
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		
		while (time++ < N) {	
			if (time % 2 == 0) { // 2초 : 폭탄 세팅 
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if(map[r][c] == '.'){
							map[r][c] = 'O'; // 폭탄 새로 설치 
		                    bomb[r][c] = time + 3; // 폭탄이 터질 시간
		                }
					}
				}
			} else { // 1초 : 폭탄 터트리기 
				boolean[][] flag = new boolean[R][C];
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if (bomb[r][c] == time) {
							flag[r][c] = true;
							for (int d = 0; d < 4; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								
								if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
								
								flag[nr][nc] = true;
							}
						}
					}
				}
				
				// 동시다발적으로 터트리기 
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if (flag[r][c]) {
							map[r][c] = '.';
							bomb[r][c] = 0;
						}
					}
				}
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int N = Integer.parseInt(input[2]);
		
		char[][] map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		if (N % 2 == 1) {
			char[][] map2 = new char[R][C];
			for (int n = 1; n < N; n++) {
				// 1초 : 다른 곳 채우기 
				if (n % 2 == 1) {
					map2 = new char[R][C];
					for (int r = 0; r < R; r++) {
						for (int c = 0; c < C; c++) {
							if (map[r][c] == '.') map2[r][c] = 'O';
							else map2[r][c] = '.';
						}
					}
				} else if (n % 2 == 0) { // 2초 : 처음 세팅한 거 폭발 
					for (int r = 0; r < R; r++) {
						for (int c = 0; c < C; c++) {
							if (map[r][c] == 'O') {
								if (r - 1 >= 0) map2[r - 1][c] = '.';
								if (r + 1 < R) map2[r + 1][c] = '.';
								if (c - 1 >= 0) map2[r][c - 1] = '.';
								if (c + 1 < C) map2[r][c + 1] = '.';
								map2[r][c] = '.';
							}
						}
					}
					map = map2;
				}
			}
			
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					sb.append(map[r][c]);
				}
				sb.append("\n");
			}
		} else {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					sb.append(0);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
	*/
}
