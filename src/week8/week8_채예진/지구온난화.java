package week8.week8_채예진;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지구온난화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");
		int R = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		
		char[][] map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		// 출력할 때 min, max 값을 바탕으로 출력하기 위함 
		int maxR = 0;
		int maxC = 0;
		int minR = 10;
		int minC = 10;
		
		char[][] after50Map = new char[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++){
				if (map[r][c] == 'X') { // 땅인 경우 
					int ocean = 0; // 주변 바다 수 
					for (int d = 0; d < 4; d++) {
						int nx = r + dx[d];
						int ny = c + dy[d];
						
						if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '.') { // 바다인 경우  
							ocean++;
						}
					}
					
					if (ocean < 3) { // 인접한 칸이 세 칸 이하일 경우 
						after50Map[r][c] = 'X';
						
						minR = Math.min(minR, r);
						minC = Math.min(minC, c);
                        maxR = Math.max(maxR, r);
                        maxC = Math.max(maxC, c);
					} else { // 인접한 칸이 세 칸, 네 칸 일경우 땅 잠기기 
						after50Map[r][c] = '.';
					}
				} else { // 원래 바다인 경우 
					after50Map[r][c] = '.';
				}
			}
		}
		
		for (int r = minR; r <= maxR; r++) {
			for (int c = minC; c <= maxC; c++) {
				sb.append(after50Map[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
