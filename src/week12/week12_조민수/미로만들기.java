package week12.week12_조민수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 미로만들기 {
	static char[][] search;// 탐색에 이용할 배열
	static int N;// 입력수
	static int x, y, d;// 좌표 x,y 방향 d
	static int T, B, L, R; // 상하좌우 마지막 값을 저장 -> 이 사이즈로 맵을 자른다.
	static int[] dx = { 1, 0, -1, 0 };// 하좌상우
	static int[] dy = { 0, -1, 0, 1 };// 남동북서 //L회전

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split("");
		search = new char[200][200];// 초기 사이즈는 최대로
		x = 100;
		y = 100;// 시작점은 중앙에서 시작
		d = 0;
		T=Integer.MAX_VALUE;
		B=Integer.MIN_VALUE;
		L=Integer.MAX_VALUE;
		R=Integer.MIN_VALUE;
		//search[x][y]='.';
		for (int i = 0; i < st.length; i++) {
			char move = st[i].charAt(0);

			switch (move) {
				case 'F':
					search[x][y]='.';//현재위치 표시
					x=x+dx[d];
					y=y+dy[d];
					search[x][y]='.';//이동할 위치 표시
					break;
				case 'R':
					d=(d+1)%4;//왼쪽으로 회전
					break;
				case 'L':
					d=d-1;//오른쪽으로 회전
					if(d==-1) {
						d=3;
					}
					break;

			}
		}
		for(int i=0;i<200;i++) {
			for(int j=0;j<200;j++) {
				if(search[i][j]=='.') {
					if(i<T)T=i;
					if(i>B)B=i;
					if(j<L)L=j;
					if(j>R)R=j;
				}
			}
		}
		
		for(int i=T;i<=B;i++) {//잘라낸 위부터 아래
			for(int j=L;j<=R;j++) {//잘라낸 왼쪽부터 오른쪽
				if(search[i][j]=='.') {
					System.out.print(search[i][j]);//길이면 길 출력
				}
				else {
					System.out.print('#');//아니라면 벽 출력
				}
				
			}
			System.out.println();
		}
	}

}
