package week12.week12_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.Type;

public class BOJ_미로만들기 {

	static char[][] map;
	static String state[]= {"nam", "dong","seo","book"};
	static String chkState;
	static int dx,dy,LidxMin,RidxMax,topIdx,bottomIdx ;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 넉넉하게 계속해서 직진하는 경우만 생각해서 2N+1
		map = new char[2 * N +1][2 * N +1];
		int startX = N ;
		int startY = N ;
		// 시작 좌표는 중간부터 시작
		dx=startX;
		dy=startY;
		// 기본 방향은 남향
		chkState="nam";
		// 시작은 찍고시작
		map[startX][startY]='.';
		String cmd = br.readLine();
		for (int i = 0; i < N; i++) {
			char selectCmd = cmd.charAt(i);

			switch (selectCmd) {
			// 방향 설정
			case 'R':
				if(chkState=="nam") {
					chkState="seo";
				}else if(chkState=="seo") {
					chkState="book";
				}else if(chkState=="book") {
					chkState="dong";
				}else if(chkState=="dong") {
					chkState="nam";
				}
				
				break;
			case 'L':
				
				if(chkState=="nam") {
					chkState="dong";
				}else if(chkState=="seo") {
					chkState="nam";
				}else if(chkState=="book") {
					chkState="seo";
				}else if(chkState=="dong") {
					chkState="book";
				}
				break;
			case 'F':
				
				if(chkState=="nam") {
					dx+=1;
					map[dx][dy]='.';	
				}else if(chkState=="seo") {
					dy-=1;
					map[dx][dy]='.';
				}else if(chkState=="book") {
					dx-=1;
					map[dx][dy]='.';
				}else if(chkState=="dong") {
					dy+=1;
					map[dx][dy]='.';
				}
				break;

			}

		}
		
		// 좌우 위아래 가장 작고 큰인덱스 체크해서 뽑아낼 범위 지정
		LidxMin=Integer.MAX_VALUE;
		RidxMax=Integer.MIN_VALUE;
		
		topIdx=Integer.MAX_VALUE;
		bottomIdx=Integer.MIN_VALUE;
		
		for(int i=0; i<2*N+1; i++){
			for(int j=0; j<2*N +1; j++){
				if(map[i][j]=='.') {
					LidxMin=Math.min(LidxMin, j);
					RidxMax=Math.max(RidxMax, j);
					
					topIdx=Math.min(topIdx, i);
					bottomIdx=Math.max(bottomIdx, i);
				}
			}
		
		}
		
		
		// 해당 범위내 인덱스에서 정답을 뽑아냄
		for(int i=topIdx; i<=bottomIdx; i++){
			for(int j=LidxMin; j<=RidxMax; j++){
				if(map[i][j]=='.') {
					System.out.print('.');
				}else {
					System.out.print('#');
				}
			}
			System.out.println();
		
		}
		

	}

}
