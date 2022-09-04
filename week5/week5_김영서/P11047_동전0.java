package week5_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 동전의 종류
		int[]nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = nk[0];
		int k = nk[1];
		int cnt = Integer.parseInt(br.readLine());
		
		// 동전들의 가치
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] =Integer.parseInt(br.readLine());
		}

		// 가장 높은 가치의 동전부터 탐색
		for (int i = n - 1; i >= 0; i--) {
			// 해당 가치가 k보다 작을 경우,
			if (a[i] <= k) {
				// 나눈 값이 해당 동전의 개수가 되고
				cnt += k / a[i];
				// 나머지를 다시 k로 대입하면 된다.
				k %= a[i];
			}
		}

		System.out.println(cnt);
	}

}