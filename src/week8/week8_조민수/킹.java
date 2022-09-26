package week8.week8_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 킹 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char []row= {'8','7','6','5','4','3','2','1'};
		char[]col= {'A','B','C','D','E','F','G','H'};
		//int board[][]=new int[8][8];
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String []st=br.readLine().split(" ");//일단 띄어쓰기로 잘라서 받는다.
		int[] king=new int[2];//[0] row [1]col
		int[] stone= new int[2];//[0] row [1]col
		String [] st2=st[0].split("");//킹 위치부터 문자랑 숫자 분리
		int c=st2[0].charAt(0);
		int r=st2[1].charAt(0);
		for(int i=0;i<8;i++) {
			if(c==col[i])king[1]=i;	
			if(r==row[i])king[0]=i;
		}
		st2=st[1].split("");//킹 위치부터 문자랑 숫자 분리
		c=st2[0].charAt(0);
		r=st2[1].charAt(0);
		for(int i=0;i<8;i++) {
			if(c==col[i])stone[1]=i;	
			if(r==row[i])stone[0]=i;
		}
		
		int tc=Integer.parseInt(st[2]);
		for(int i=0;i<tc;i++) {
			String move=br.readLine();
			switch(move) {
				case "R"://우->col++
					if(king[1]+1<8)//범위 체크
					{
						//돌이 밀리는지도 확인
						if(king[0]==stone[0]&&king[1]+1==stone[1]) {//이동하면 돌 자리다.
							if(stone[1]+1<8) {//돌도 이동 가능한지 체크
								//가능하면 둘다 이동
								king[1]++;
								stone[1]++;
							}
							else//돌이 움직이면 범위를 벗어남 -> 동작 X
								break;
						}
						else {//이동이 돌에 영향이 없다. -> king만 이동
							king[1]++;
						}
					}
					break;
				case "L"://좌->col--
					if(king[1]-1>=0)//범위 체크
					{
						//돌이 밀리는지도 확인
						if(king[0]==stone[0]&&king[1]-1==stone[1]) {//이동하면 돌 자리다.
							if(stone[1]-1>=0) {//돌도 이동 가능한지 체크
								//가능하면 둘다 이동
								king[1]--;
								stone[1]--;
							}
							else//돌이 움직이면 범위를 벗어남 -> 동작 X
								break;
						}
						else {//이동이 돌에 영향이 없다. -> king만 이동
							king[1]--;
						}
					}
					break;
				case "B"://하->row++
					if(king[0]+1<8)//범위 체크
					{
						//돌이 밀리는지도 확인
						if(king[1]==stone[1]&&king[0]+1==stone[0]) {//이동하면 돌 자리다.
							if(stone[0]+1<8) {//돌도 이동 가능한지 체크
								//가능하면 둘다 이동
								king[0]++;
								stone[0]++;
							}
							else//돌이 움직이면 범위를 벗어남 -> 동작 X
								break;
						}
						else {//이동이 돌에 영향이 없다. -> king만 이동
							king[0]++;
						}
					}
					break;
				case "T"://상->row--
					if(king[0]-1>=0)//범위 체크
					{
						//돌이 밀리는지도 확인
						if(king[1]==stone[1]&&king[0]-1==stone[0]) {//이동하면 돌 자리다.
							if(stone[0]-1>=0) {//돌도 이동 가능한지 체크
								//가능하면 둘다 이동
								king[0]--;
								stone[0]--;
							}
							else//돌이 움직이면 범위를 벗어남 -> 동작 X
								break;
						}
						else {//이동이 돌에 영향이 없다. -> king만 이동
							king[0]--;
						}
					}
					break;
				case "RT"://우상->row-- col++
					if(king[1]+1<8&&king[0]-1>=0)//범위 체크!우측 상측 둘다
					{
						//돌이 밀리는지도 확인
						if(king[0]-1==stone[0]&&king[1]+1==stone[1]) {//이동하면 돌 자리다.
							if(stone[1]+1<8&&stone[0]-1>=0) {//돌도 이동 가능한지 체크
								//가능하면 둘다 이동
								king[0]--;
								king[1]++;
								stone[0]--;
								stone[1]++;
							}
							else//돌이 움직이면 범위를 벗어남 -> 동작 X
								break;
						}
						else {//이동이 돌에 영향이 없다. -> king만 이동
							king[0]--;
							king[1]++;
						}
					}
					break;
				case "LT"://좌상->row-- col--
					if(king[1]-1>=0&&king[0]-1>=0)//범위 체크!우측 상측 둘다
					{
						//돌이 밀리는지도 확인
						if(king[0]-1==stone[0]&&king[1]-1==stone[1]) {//이동하면 돌 자리다.
							if(stone[1]-1>=0&&stone[0]-1>=0) {//돌도 이동 가능한지 체크
								//가능하면 둘다 이동
								king[0]--;
								king[1]--;
								stone[0]--;
								stone[1]--;
							}
							else//돌이 움직이면 범위를 벗어남 -> 동작 X
								break;
						}
						else {//이동이 돌에 영향이 없다. -> king만 이동
							king[0]--;
							king[1]--;
						}
					}
					break;
				case "RB"://우하->row++ col++
					if(king[1]+1<8&&king[0]+1<8)//범위 체크!우측 상측 둘다
					{
						//돌이 밀리는지도 확인
						if(king[0]+1==stone[0]&&king[1]+1==stone[1]) {//이동하면 돌 자리다.
							if(stone[1]+1<8&&stone[0]+1<8) {//돌도 이동 가능한지 체크
								//가능하면 둘다 이동
								king[0]++;
								king[1]++;
								stone[0]++;
								stone[1]++;
							}
							else//돌이 움직이면 범위를 벗어남 -> 동작 X
								break;
						}
						else {//이동이 돌에 영향이 없다. -> king만 이동
							king[0]++;
							king[1]++;
						}
					}
					break;
				case "LB"://좌하->row++ col--
					if(king[1]-1>=0&&king[0]+1<8)//범위 체크!우측 상측 둘다
					{
						//돌이 밀리는지도 확인
						if(king[0]+1==stone[0]&&king[1]-1==stone[1]) {//이동하면 돌 자리다.
							if(stone[1]-1>=0&&stone[0]+1<8) {//돌도 이동 가능한지 체크
								//가능하면 둘다 이동
								king[0]++;
								king[1]--;
								stone[0]++;
								stone[1]--;
							}
							else//돌이 움직이면 범위를 벗어남 -> 동작 X
								break;
						}
						else {//이동이 돌에 영향이 없다. -> king만 이동
							king[0]++;
							king[1]--;
						}
					}
					break;
			}
		}
		System.out.println(col[king[1]]+""+row[king[0]]+"\n"+col[stone[1]]+""+row[stone[0]]);
		
		
	}		
}
