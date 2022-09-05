package week5_채예진;

import java.util.Scanner;

// 3가지 경우 
// dp[i - 1] (현재 값 제외)
// dp[i - 2] + 현재 (이전 값 제외)
// dp[i - 3] + 이전 값 + 현재 (-2값을 제외한다는 뜻) 
public class 포도주_시식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 포도주 잔의 개수 
		
		int[] input = new int[N];
		for (int n = 0; n < N; n++) {
			input[n] = sc.nextInt();
		}
		
		int[] d = new int[N];
		
		d[0] = input[0];
		if (N >= 2) d[1] = input[0] + input[1];
		if (N >= 3) {
			d[2] = Math.max(d[1], Math.max(input[0] + input[2], input[1] + input[2])); 
		}
		
		for (int i = 3; i < N; i++) {
			d[i] = Math.max(d[i - 1], Math.max(d[i - 2] + input[i], d[i - 3] + input[i - 1] + input[i]));
		}
		System.out.println(d[N - 1]);
	}

}
