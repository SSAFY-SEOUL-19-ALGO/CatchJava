package week11.week11_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 봄버맨 {
	static int r, c, time;
	static char[][] map;
	static int[][] memory;
	static ArrayDeque<int[]> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		r = Integer.parseInt(st[0]);
		c = Integer.parseInt(st[1]);
		time = Integer.parseInt(st[2]);
		map = new char[r][c];// 맵 사이즈와 현재 시간초를 저장하는 3차원 배열
		memory = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				map[i][j] = st[j].charAt(0);
				if (map[i][j] == 'O') {
					memory[i][j] = 1;
				}

			}
		}

		q = new ArrayDeque<int[]>();
		int cur_time=1;
		while (time >=cur_time) {
			if (cur_time % 2 == 0) {// 시간이 짝수초면 퍼트리기

				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (map[i][j] == '.') {
							map[i][j] = 'O';
						}
						memory[i][j]++;

					}
				}

				System.out.println(cur_time + "---------------------------------");
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
			} else {// 홀수초면 터트리기
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (memory[i][j] == 2) {
							q.add(new int[] { i, j });
						}
					}
				}
				while (!q.isEmpty()) {
					int[] xy = q.poll();
					int x = xy[0];
					int y = xy[1];
					map[x][y] = '.';
					memory[x][y] = 0;
					for (int i = 0; i < 4; i++) {
						if (0 <= x + dx[i] && x + dx[i] < r && 0 <= y + dy[i] && y + dy[i] < c) {
							map[x + dx[i]][y + dy[i]] = '.';
							memory[x + dx[i]][y + dy[i]] = 0;
						}
					}
				}
				System.out.println(cur_time + "---------------------------------");
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
			}
			cur_time++;
		}
		System.out.println("result" + "---------------------------------");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		// 2초가 되면 빈공간에 다 폭탄 o
		// 3초가 되면 사방폭발
	}
}
