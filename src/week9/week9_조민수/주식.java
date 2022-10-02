package week9.week9_조민수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 주식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for( int tc = 1 ; tc <= T ; tc++ ) {
			int N = Integer.parseInt(br.readLine());
			long ans=0;
			long stock[] = new long[N];
			String []st=br.readLine().split(" ");
			for( int i = 0 ; i < N ; i++ ) {
				stock[i] = Integer.parseInt(st[i]);
			}
			
			long max = 0;
			for( int i = N-1 ; i >= 0 ; i-- ) {
				if(stock[i] > max) {	
					max = stock[i];
				}else {
					ans += max - stock[i];	
				}
			}
			System.out.println(ans);
			
		}
		
	}

}

