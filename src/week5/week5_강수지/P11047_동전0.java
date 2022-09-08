package week5.week5_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		int N = Integer.parseInt(s[0]); // 동전의 종류
		int K = Integer.parseInt(s[1]); // 가치의 합
		
		// 오름차순으로 동전의 가치가 주어진다
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(bf.readLine());
		} // 입력완료
		
		int ans = 0; // 동전의 개수
		for (int i = N-1; i >= 0; i--) { // 동전의 개수가 최소여야하므로 큰 동전부터 ..
			if(K<coin[i]) continue; // 더 크면 못만들지
			
			ans += K/coin[i]; // 큰 동전의 개수부터 세어주고
			K %= coin[i]; // 세고 남은 금액으로 다시 !
		}
		System.out.println(ans);
	}

}