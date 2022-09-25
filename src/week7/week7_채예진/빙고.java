package week7.week7_채예진;

import java.util.Scanner;

public class 빙고 {

	static int[][] bingo;
	static boolean[][] select;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		bingo = new int[5][5];
		select = new boolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		
		int i = 1;
		for (; i <= 25; i++) {
			int n = sc.nextInt();
			
			change(n);
			
			if (i >= 12) { // 빙고가 되는 최소의 경우
				int bingoCheck = 0;
				// 끝에만 확인하면 됨 
				for (int a = 0; a < 5; a++) { // 첫째줄 확인
					int cnt = 0;
					if (select[0][a]) {
						cnt++;
						for (int b = 1; b < 5; b++) { // 세로줄 확인 
							if (!select[b][a]) break;
							cnt++;
						}
						if (cnt == 5) {
							bingoCheck++;
						}
					}
				}
				
				for (int a = 0; a < 5; a++) { // 첫째열 확인
					int cnt = 0;
					if (select[a][0]) {
						cnt++;
						for (int b = 1; b < 5; b++) { // 세로줄 확인 
							if (!select[a][b]) break;
							cnt++;
						}
						if (cnt == 5) {
							bingoCheck++;
						}
					}
				}
				
				// 대각선 체크 
				if (select[0][0] && select[1][1] && select[2][2] && select[3][3] && select[4][4]) {
					bingoCheck++;
				}
				if (select[0][4] && select[1][3] && select[2][2] && select[3][1] && select[4][0]) {
					bingoCheck++;
				}
				
				if (bingoCheck >= 3) {
					break;
				}
			}
		}
		
		System.out.println(i);
	}

	static void change(int n) { // return을 사용하기 위헤서 함수로 뺌 
		
		for (int i = 0; i < 5; i++ ) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == n) {
					select[i][j] = true;
					return;
				}
			}
		}
		
	}
}
