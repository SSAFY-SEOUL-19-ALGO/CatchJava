package week5_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1904
public class BJ2193_이친수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//long.............
	
		int N =Integer.parseInt(br.readLine());
		
		long dp[] = new long[N+1];//?????
		dp[0]=0;
		dp[1]=1;
		for(int i = 2; i<=N; i++) {
			dp[i]=dp[i-2]+dp[i-1];
		}
		System.out.println(dp[N]);
		
	}
}
