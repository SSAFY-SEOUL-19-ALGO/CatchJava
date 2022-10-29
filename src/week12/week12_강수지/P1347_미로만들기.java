package week12.week12_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1347_미로만들기 {
	// 북 동 남 서
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine()); // 홍준이가 적은 내용
		
		int[][] map = new int[101][101]; // 배열의 크기를 최대로 
		
		// 시작점은 중심점
		int x = 50;
		int y = 50;
		
		// 직사각형을 그리기 위한 오른쪽 아래
		int maxx = 50;
		int maxy = 50;
		// 직사각형을 그리기 위한 왼쪽 위
		int minx = 50;
		int miny = 50;
		
		// 시작 방향의 인덱스부터
		int dir = 2;
		map[x][y] = 1; // 1 : '.', 2 : '#'
		
		String s2 = bf.readLine(); // 홍준이 노트 내용
		
		for (int i = 0; i < N; i++) {
			if(s2.charAt(i) == 'F') { // 앞으로 한칸 움직이는 경우
				// 최대와 최소의 범위를 체크해준다
				x += dx[dir];
				y += dy[dir];
				
				maxx = Math.max(maxx, x);
				maxy = Math.max(maxy, y);
				minx = Math.min(minx, x);
				miny = Math.min(miny, y);
				map[x][y] = 1;
				
			}
			else if(s2.charAt(i) == 'L') { // 반시계방향 회전만 , 위치 변화 x
				dir -= 1;
				if(dir == -1) dir = 3;
			}
			else if(s2.charAt(i) == 'R'){ // 시계방향 회전만 , 위치 변화 x
				dir = (dir+1) % 4;
			}
		}
		
		for (int i = minx; i <= maxx; i++) {
			for (int j = miny; j <= maxy; j++) {
				if(map[i][j]==1) sb.append(".");
				else sb.append("#");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
