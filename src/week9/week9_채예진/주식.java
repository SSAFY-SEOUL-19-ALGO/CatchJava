package week9.week9_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// long으로 풀것!!!!!! 
public class 주식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			
			long answer = 0;
			// dp 방식으로 뒤에서부터 풀기 
			long max = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < max) answer += (max - arr[i]);
				else max = arr[i];
			}
			
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
	}

}
