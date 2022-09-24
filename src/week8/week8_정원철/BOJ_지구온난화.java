package week8.week8_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_지구온난화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String st[]=br.readLine().split(" ");
		int R=Integer.parseInt(st[0]);
		int C=Integer.parseInt(st[1]);
		
		// 범위 체크를 하지 않기위해 그냥 넉넉하게 사이즈 2씩 추가
		String [][] map= new String[R+2][C+2];

		// 그냥 선언하면 null로 초기화되는데 계산과정에서 널포인터 뜰수있음 그냥 임의의수로 초기화
		for (int i=0; i<R+2; i++) {
			for (int j=0; j<C+2; j++) {
				map[i][j]="1";
			}
		}
		for (int i=1; i<=R; i++) {
			String str=br.readLine();
			for (int j=1; j<=C; j++) {
				map[i][j]=String.valueOf(str.charAt(j-1));
			}
		}

		for (int i=1; i<=R; i++) {
			int iCnt=0;	
			for (int j=1; j<=C; j++) {
					//섬 일때
					if(map[i][j].equals("X")) {
						//상
						if(map[i-1][j].equals(".") || "1".equals(map[i-1][j])) iCnt++;
						//하
						if(map[i+1][j].equals(".") || "1".equals(map[i+1][j])) iCnt++;
						//좌
						if(map[i][j-1].equals(".") || "1".equals(map[i][j-1])) iCnt++;						
						//우
						if(map[i][j+1].equals(".") || "1".equals(map[i][j+1])) iCnt++;
						// 바다 개수 체크, 이후 중복 체크를 막기위해 해당 섬에 chk를 넣어줌
						if(iCnt>=3) map[i][j]="chk";
							
						iCnt=0;
					}
			}
		}
		
		int Rmin=Integer.MAX_VALUE;
		int Rmax=-1;
		
		int Cmin=Integer.MAX_VALUE;
		int Cmax=-1;
		
		// 따로 배열을 만들거나하지 않고 그냥 x가 위치한 행과 열의 최소 최대를구해서 필요한 부분만 반복문으로 뽑아냄
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(map[i][j].equals("X")) {
					if(Rmin>i)	Rmin=i;
					if(Cmin>j) Cmin=j;
					if(Rmax<i) 	Rmax=i;
					if(Cmax<j) Cmax=j;
				}
			}
		}
		
		for(int i=Rmin; i<=Rmax; i++) {
			for(int j=Cmin; j<=Cmax; j++) {
				if(map[i][j].equals("chk")) System.out.print(".");
				else System.out.print(map[i][j]);
			}
			System.out.println();
			
		}
	}

}
