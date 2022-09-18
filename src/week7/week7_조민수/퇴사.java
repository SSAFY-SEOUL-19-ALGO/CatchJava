package week7.week7_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퇴사 {
	static int [][]meeting;
	static int day;
	static boolean[] selected;
	static int max=0;
	static void subset(int index) {
		
		if(index>=day) {//다왔으면
			if(index==day&&meeting[day][0]==1) {//마지막자리가 1일짜리면 일하고 퇴사 가능..
				selected[index]=true;
			}
			int sum=0;
			for(int i=1;i<=day;i++) {
				if(selected[i])sum+=meeting[i][1];
			}
			if(sum>max)max=sum;
			selected[day]=false;
			return;
		}
		
		if(index+meeting[index][0]-1<=day) {//선택할 수 있으면 선택하고 아니면 패스
			selected[index]=true;
			subset(index+meeting[index][0]);
			
		}
		selected[index]=false;
		subset(index+1);
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		day=Integer.parseInt(br.readLine());
		meeting=new int[day+1][2];
		selected=new boolean[day+1];
		for(int i=1;i<=day;i++) {
			String []st=br.readLine().split(" ");
			meeting[i][0]=Integer.parseInt(st[0]);
			meeting[i][1]=Integer.parseInt(st[1]);
		}
		subset(1);
		System.out.println(max);
	}

}
