package week8_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1722_순열의순서 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] factorial = new long[21];
		factorial[0] = 1;
		for (int i = 1; i < 21; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		boolean selected[] = new boolean[21];

		String s[] = br.readLine().split(" ");
		if (Integer.parseInt(s[0]) == 1) {
			long K = Long.parseLong(s[1]);
			int[] answer = new int[N];
			for(int i = 0; i<N; i++) {
				for(int j =1; j<=N; j++) {
					if(!selected[j]) {
						if(factorial[N-1-i]<K) {
							K-=factorial[N-1-i];
						}else {
							answer[i]=j;
							selected[j]=true;
							break;
						}
					}
				}
			}
			for(int i = 0; i<N; i++) {
				System.out.print(answer[i]+" ");
			}System.out.println();
		} else {
			int[] arr = new int[N];
			for (int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(s[n + 1]);
			}

			long answer = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < arr[i]; j++) {
					if (!selected[j]) {
						answer += factorial[N - 1 - i];
					}
				}
				selected[arr[i]] = true;
			}
			System.out.println(answer);

		}
	}

}
