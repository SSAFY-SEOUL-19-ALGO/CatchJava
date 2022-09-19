package week7.week7_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_퇴사 {
	static int N,price;
	static int[][] schedule;
	static int max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		N=Integer.parseInt(br.readLine());
		schedule=new int[N+1][2];
		
		for(int i=1;i<=N;i++)
		{	String st[]=br.readLine().split(" ");
			schedule[i][0]=Integer.parseInt(st[0]);
			schedule[i][1]=Integer.parseInt(st[1]);
		}
		
		
		for(int i=1;i<=N;i++) {
			
			if(schedule[i][0]+i-1<=N) {
				price=0;
				dfs(price,i-1);
			}
		}
		System.out.println(max);
	}
	

	static void dfs(int price, int day) {
		if(day>N) return;
		
		if(max<price) max=price;
		
		for(int j=day+1;j<=N;j++) {
			int check=day+schedule[j][0];
			if(check<=N) dfs(price+schedule[j][1],day+schedule[j][0]);
			day++;
		}
		
	}

}
