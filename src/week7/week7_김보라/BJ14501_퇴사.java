package week7.week7_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14501_퇴사 {
	
	static int N;
	static int T[];
	static int P[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		for(int n = 0; n<N; n++) {
			String s[] = br.readLine().split(" ");
			
			T[n]=Integer.parseInt(s[0]);
			P[n]=Integer.parseInt(s[1]);
			if(n+T[n]>N) {
				P[n]=0;
			}
		}
		
		c(0,new boolean [N]);
		
		System.out.println(answer);
		
	}
	static int answer = 0;
	static void c(int cnt, boolean selected[]) {
		if(cnt>=N) {
			int sum = 0;
			for(int i = 0 ; i<N; i++) {
				if(selected[i]) {
					sum+=P[i];
				}
			}
			answer=Math.max(sum, answer);
			return;
		}
		
		selected[cnt]= true;
		c(cnt+T[cnt], selected);
		selected[cnt]=false;
		c(cnt+1, selected);
	}

}
