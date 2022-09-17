package week5.week5_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2156_포도주시식 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] grape = new int[N];

		for (int i = 0; i < N; i++) {
			grape[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N];
		dp[0] = grape[0];

		for (int i = 1; i < N; i++) {
			if (i == 1) {
				dp[1] = grape[0]+grape[1];
				continue;
			}
			if (i == 2) {
				dp[2] = Math.max(dp[1], Math.max(grape[0] +grape[2], grape[1]+ grape[2]));
				continue;
			}
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+grape[i], dp[i-3]+grape[i-1]+grape[i]));
		}
		System.out.println(dp[N-1]);
	}
	
	/* 메모리초과
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] grape = new int[N];
		for(int i = 0; i<N; i++) {
			grape[i]=Integer.parseInt(br.readLine());
		}
		
		c(N, grape, 0,0, new boolean[N]);
		System.out.println(answer);
	}
	static int answer = 0;
	static void c(int N,int[] grape, int cnt, int start, boolean[] selected) {
		if(cnt==N) {
			System.out.println(Arrays.toString(selected));
			int sum = 0;
			for(int i = 0; i<N; i++) {
				if(selected[i]) {
					sum+=grape[i];
				}
			}
			answer=Math.max(answer, sum);
			return;
		}
		
//		selected[cnt]=true;
//		c(N,grape,cnt+1,start,selected);
//		selected[cnt]=false;
//		c(N,grape,cnt+1,start,selected);
		
//		if(cnt-3<0||(!selected[cnt-1]||!selected[cnt-2])) {
//			selected[cnt]=true;
//			c(N,grape,cnt+1,start,selected);
//			selected[cnt]=false;
//			c(N,grape,cnt+1,start,selected);
//		}
		
		if(start!=2) {
			selected[cnt]=true;
			start++;
			c(N,grape,cnt+1,start,selected);
		}
			selected[cnt]=false;
			start=0;
			c(N,grape,cnt+1,start,selected);
		
		
//		for(int i = start; i<N; i++) {
//			if(selected[i]) {
//				if(cnt-2<0||(cnt-2>=0&&!selected[cnt-2])){
//					selected[cnt]=true;
//					c(N,grape,cnt+1,i+1,selected);
//				}
//				
//			}
//		}
	}*/

}
