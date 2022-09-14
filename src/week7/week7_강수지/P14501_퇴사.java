package week7.week7_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14501_퇴사 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); // 일 수
		int[] T = new int[N]; // 상담 소요일 수
		int[] P = new int[N]; // 상담 수익
		for (int i = 0; i < N; i++) {
			String[] s = bf.readLine().split(" ");
			T[i] = Integer.parseInt(s[0]);
			P[i] = Integer.parseInt(s[1]);
		} // 입력 완료
		
		int[] dp = new int[N+1];
		// 주어진 일 수만큼 반복
		for (int i = 0; i < N; i++) {
			int day = i + T[i];
			// 지금의 이익과 기존 이익 + 얻을 이익 비교
			if(day<=N) {
				dp[day] = Math.max(dp[day], dp[i]+P[i]);
			}
			// 지금까지 최대 이익
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		
		System.out.println(dp[N]);
	}

}
