package week5.week5_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156_포도주시식 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 포도주 잔의 개수
		int[] podo = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i <N; i++) { // 포도주의 양 입력 받기
			podo[i] = Integer.parseInt(bf.readLine());
		}
		
		if(N<3) { // 만약에 3잔 이하면 그냥 다 마시는게 최대
			int max = 0;
			for (int i = 0; i < N; i++) {
				max += podo[i];
			}
			System.out.println(max);
			return; // runtime error ..
		}
		
		// 최대로 마실 수 있는 포도주의 양을 구해라
		dp[0] = podo[0]; // 한 잔일때 최대의 경우
		dp[1] = podo[0]+podo[1]; // 두 잔일때 최대의 경우
		// 세잔인 경우 : 이전 두잔을 마신 경우, 현재의 포도주와 바로 이전을 마신 경우, 현재의 포도주와 처음 포도주를 마신 경우
		dp[2] = Math.max(dp[1], Math.max(podo[1]+podo[2], dp[0]+podo[2]));
		
		for (int i = 3; i <N; i++) { // 마시고 안마시고 마시고 마시고 , 마시고 안마시고 마시고 ..
			dp[i] = Math.max(podo[i]+podo[i-1]+dp[i-3], podo[i]+dp[i-2]);
			// 현재 잔을 마신 것과 안마신 것 중 최대를 골라 ..
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		
		System.out.println(dp[N-1]);
	}

}
