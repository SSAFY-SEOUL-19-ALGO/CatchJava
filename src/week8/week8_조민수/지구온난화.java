package week8.week8_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 지구온난화 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//문제가 너무 슬퍼요...
		int []dr= {-1,1,0,0};//상하좌우
		int []dc= {0,0,-1,1};
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] st=br.readLine().split(" ");
		int r=Integer.parseInt(st[0]);
		int c=Integer.parseInt(st[1]);
		char map[][]=new char[r][c];
		for(int i=0;i<r;i++) {
			st=br.readLine().split("");
			for(int j=0;j<c;j++) {
				map[i][j]=st[j].charAt(0);//문자 입력받기
			}
		}

		//가라앉는 섬을 찾자+출력때 쓸 범위도 같이 구하자 ->row min~row max &col min~col max
		int rowMin=r;
		int rowMax=0;
		int colMin=c;
		int colMax=0;
		ArrayDeque<int[]>delete=new ArrayDeque<int[]>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='X') {//섬이면 주변에 섬이 2개이상 있는지 확인
					int cnt=0;
					for(int k=0;k<4;k++) {
						if(r>i+dr[k]&&i+dr[k]>=0&&c>j+dc[k]&j+dc[k]>=0) {//범위내이고
							if(map[i+dr[k]][j+dc[k]]=='X') {
								cnt++;
							}
						}
					}
					if(cnt<2) {//이웃한 섬이 2개 미만이면
						delete.add(new int[]{i,j});
					}
					else {
						if(i>rowMax)rowMax=i;
						if(i<rowMin)rowMin=i;
						if(j>colMax)colMax=j;
						if(j<colMin)colMin=j;
					}
				}
			}
		}
		
		while(!delete.isEmpty()) {
			int[] del=delete.poll();
			map[del[0]][del[1]]='.';
		}
		
		
		for(int i=rowMin;i<=rowMax;i++) {
			for(int j=colMin;j<=colMax;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}

}
