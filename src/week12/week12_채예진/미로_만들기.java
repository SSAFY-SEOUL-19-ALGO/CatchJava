package week12.week12_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 뒤로 가기도 됨.. 즉, 시작을 50으로 해야함 
public class 미로_만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		char[][] map = new char[101][101];
		
		int startx = 50, starty = 50, endx = 50, endy = 50;
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				map[i][j] = '#'; // 벽으로 채워두기 
			}
		}
		
		map[50][50] = '.';
		
		int[] dx = {0, -1, 0, 1}; // 시작 남쪽  
		int[] dy = {1, 0, -1, 0};
		
		int nx = 50, ny = 50;
		int d = 0; // 초기 방향 남 
		for (int n = 0; n < N; n++) {
			char c = str.charAt(n);
			
			switch(c) {
			case 'F':
				nx += dx[d];
				ny += dy[d];
				map[ny][nx] = '.';
				
				startx = Math.min(nx, startx); // 계산 시작점 x
				starty = Math.min(ny, starty); // 계산 시작점 y
				endx = Math.max(nx, endx); // 계산 끝점 x
				endy = Math.max(ny, endy); // 계산 끝점 y

				break;
			case 'L':
				if (d == 0) d = 3;
				else d--;
				break;
			case 'R':
				if (d == 3) d = 0;
				else d++;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int y = starty; y <= endy; y++) {
			for (int x = startx; x <= endx; x++) {
				sb.append(map[y][x]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}