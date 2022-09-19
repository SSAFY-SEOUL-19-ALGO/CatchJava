package week7.week7_강수지;

import java.util.Scanner;

public class P2578_빙고 {
	static int[][] bingo;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 숫자 부르는 부분 input 어려워서 .. scanner .. 좋다 ~
		bingo = new int[5][5];
		cnt = 0;

		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				bingo[x][y] = sc.nextInt();
			}
		} // bingo input

		for (int i = 0; i < 25; i++) {
			int input = sc.nextInt(); // 부른 숫자

			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					if (bingo[x][y] == input) { // 부른 숫자의 위치라면
						bingo[x][y] = -1; // 해당 숫자를 -1

						if (check(x,y) >= 3) {
							System.out.println(i+1); // 해당 숫자가 몇번째 인지
							return;
						}
					}
				}
			}
		}
	} // main end

	private static int check(int r, int c) {
		int cnt = 0;
		// 가로
		for (int i = 0; i < 5; i++) {
			int rcnt = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == -1)
					rcnt++;
			}
			if (rcnt == 5)
				cnt++;
		}

		// 세로
		for (int i = 0; i < 5; i++) {
			int ccnt = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[j][i] == -1)
					ccnt++;
			}
			if (ccnt == 5)
				cnt++;
		}
		
		// 오른쪽 대각선
		int xcnt = 0;
		for (int i = 4; i >= 0; i--) {
			if (bingo[4-i][i] == -1)
				xcnt++;
			if (xcnt == 5)
				cnt++;
		}

		// 왼쪽 대각선
		xcnt = 0;
		for (int i=0; i<5; i++) {
			if (bingo[i][i] == -1 ) 
				xcnt++;
			if (xcnt == 5) 
				cnt ++;
		}
		return cnt;
	}
}