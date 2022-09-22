package week8.week8_채예진;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제 제대로 읽기...!! 돌이 위치한 '방향'으로 가는 줄 알고 엄청 헤맸다... 하지만 그냥 돌과의 위치가 같을 경우 이동이었음...
public class 킹 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] row = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		
		int[] dx = {0, 0, -1, 1, 1, 1, -1, -1}; // R, L, B, T, RT, LT, RB, LB
		int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
		
		String[] s = br.readLine().split(" ");
		
		String[] king = s[0].split("");
		int kY = king[0].charAt(0) - 'A';
		int kX = Integer.parseInt(king[1]);
		
		String[] rock = s[1].split("");
		int rY = rock[0].charAt(0) - 'A';
		int rX = Integer.parseInt(rock[1]);
		
		int N = Integer.parseInt(s[2]);
		
		for (int i = 0; i < N; i++) {
			
			int d = -1;
			switch(br.readLine()) {
			case "R":
				d = 0;
				break;
			case "L":
				d = 1;
				break;
			case "B":
				d = 2;
				break;
			case "T":
				d = 3;
				break;
			case "RT":
				d = 4;
				break;
			case "LT":
				d = 5;
				break;
			case "RB":
				d = 6;
				break;
			case "LB":
				d = 7;
				break;
			}
			
			int nx = kX + dx[d];
			int ny = kY + dy[d];
		
			if (nx < 1 || nx > 8 || ny < 0 || ny >= 8) continue;
			
			if (nx == rX && ny == rY) {
				int rnx = rX + dx[d];
				int rny = rY + dy[d];
				
				if (rnx < 1 || rnx > 8 || rny < 0 || rny >= 8) continue;
				
				kX = nx;
				kY = ny;
				rX = rnx;
				rY = rny;
			} else {
				kX = nx;
				kY = ny;
			}
		}
		
		System.out.println(row[kY] + "" + kX);
		System.out.println(row[rY] + "" + rX);
	}

}
