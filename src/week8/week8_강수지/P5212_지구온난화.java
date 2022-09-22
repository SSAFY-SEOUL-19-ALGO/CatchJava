 package week8.week8_강수지;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5212_지구온난화 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = bf.readLine().toCharArray();
		}//배열 입력 완료
		
		char[][] ans = new char[R][C]; // 출력
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int minx = 10;
		int miny = 10;
		int maxx = 0;
		int maxy = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++){
				if(map[i][j] =='X') { // 땅이라면
					int cnt = 0; // 주변 바다
					for (int d = 0; d < 4; d++) {
						int nx = i +dx[d];
						int ny = j +dy[d];
						
						// 범위를 벗어나면 바다 or 바다인 경우
						if ((nx == -1 || ny == -1 || nx == R || ny == C) || map[nx][ny] == '.') {
							cnt ++;
						}
					}
					
					if(cnt<3) { // 바다가 3개 미만인 경우 땅
						ans[i][j] = 'X';
						// 지도 출력 범위 
						minx = Math.min(minx, i);
						miny = Math.min(miny, j);
						maxx = Math.max(maxx, i);
						maxy = Math.max(maxy, j);
					}else {
						// 바다가 3개 이상인 경우 바다로
						ans[i][j]='.';
					}
				} else{ // 바다라면
					ans[i][j] = '.';
				}
			}
		}
		
		StringBuilder answer = new StringBuilder(); // 출력
		for (int i = minx; i <= maxx; i++) {
			for (int j = miny; j <= maxy; j++) {
				answer.append(ans[i][j]);
			}
			answer.append("\n");
		}
		
		System.out.println(answer);
	}
}
