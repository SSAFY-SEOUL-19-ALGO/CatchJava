package week5.week5_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2183_이친수 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 입력
		
		long[] dp = new long[N+1]; // 1 부터 90 까지 범위 > int 범위 넘을 수 있ㅇ다 ..
		dp[0] = 0; // 0 자리 수 라는건 없어 ..
		dp[1] = 1; // 한 자리 수 이친수 1

		// 두 자리 수 이친수 10
		// 세 자리 이친수 100 101
		// 네 자리 이친수 1000 1010 1001 .. 앞선 수의 0 이나 1을 붙여가며 만든다
		for(int i=2; i<=N;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
		
	}

}
