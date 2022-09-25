package week7.week7_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2578_빙고 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] bingo = new int[5][5];
		for(int i = 0 ; i<5; i++) {
			String s [] = br.readLine().split(" ");
			for(int j = 0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		boolean[][] check = new boolean[5][5];
		int cnt = 0;
		for(int n = 0; n<5; n++) {
			String st[] = br.readLine().split(" ");
			for(int k = 0; k<5; k++) {
				for(int i = 0 ; i<5; i++) {
					for(int j = 0 ; j<5; j++) {
						if(bingo[i][j]==Integer.parseInt(st[k])) {
							check[i][j] = true;
							cnt++;
							if(c(check)>=3) {
								System.out.println(cnt);
								return;
							}
							
						}
					}
				}
			}
		}
		
		
	}
	static int c(boolean[][] check) {
		int cnt = 0;
		for(int i = 0 ; i<5; i++) {
			if(check[i][0]) {
				for(int j = 1; j<5; j++) {
					if(!check[i][j])
						break;
					if(j==4)
						cnt++;
				}
			}
		}
		for(int j = 0; j<5; j++) {
			if(check[0][j]) {
				for(int i = 1 ; i<5; i++) {
					if(!check[i][j])
						break;
					if(i==4)
						cnt++;
				}
			}
		}
		for(int i = 0; i<5; i++) {
			if(!check[i][i])
				break;
			if(i==4)
				cnt++;
		}
		for(int i = 0, j = 4; i<5; i++,j--) {
			if(!check[i][j])
				break;
			if(i==4)
				cnt++;
		}
		
		return cnt;
	}

}
