package week8.week8_김영서;

import java.io.FileInputStream;
import java.util.Scanner;

public class B5212_지구온난화 {

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int[][] arr;
	static int[][] afterArr;
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		afterArr = new int[n][m];

		String tmp = "";
		for (int i = 0; i < n; i++) {
			tmp = sc.next();
			for (int j = 0; j < m; j++) {
				if (tmp.charAt(j) == '.') {
					arr[i][j] = 0;
				} else if (tmp.charAt(j) == 'X') {
					arr[i][j] = 1;
					afterArr[i][j] = 1;
				}
			}
		}

		go();

		printMinMap();
	}

	public static void go() {
		int ny = 0;
		int nx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int seaCnt = 0;
				for (int idx = 0; idx < 4; idx++) {
					ny = i + dy[idx];
					nx = j + dx[idx];
					if (ny >= n || ny < 0 || nx >= m || nx < 0) {
						seaCnt++;
						continue;
					}
					if (arr[ny][nx] == 0)
						seaCnt++;
				}
				if (seaCnt > 2)
					afterArr[i][j] = 0;
			}
		}
	}

	public static void printMinMap() {
		int minY = -1;
		int maxY = -1;
		int minX = -1;
		int maxX = -1;
		for (int i = 0; i < n; i++) { // minY 구하는 loop
			if (minY != -1)
				break;
			for (int j = 0; j < m; j++) {
				if (afterArr[i][j] == 1) {
					minY = i;
					break;
				}
			}
		}

		for (int i = 0; i < m; i++) { // minX 구하는 loop
			if (minX != -1)
				break;
			for (int j = 0; j < n; j++) {
				if (afterArr[j][i] == 1) {
					minX = i;
					break;
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) { // maxY 구하는 loop
			if (maxY != -1)
				break;
			for (int j = 0; j < m; j++) {
				if (afterArr[i][j] == 1) {
					maxY = i;
					break;
				}
			}
		}

		for (int i = m - 1; i >= 0; i--) {
			if (maxX != -1)
				break;
			for (int j = 0; j < n; j++) { // maxX 구하는 loop
				if (afterArr[j][i] == 1) {
					maxX = i;
					break;
				}
			}
		}
		for (int i = minY; i <= maxY; i++) {
			for (int j = minX; j <= maxX; j++) {
				System.out.print(afterArr[i][j] == 0 ? '.' : 'X');
			}
			System.out.println();
		}
	}
}