package week7.week7_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 퇴사 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		int[] calander = new int[N + 1];
		
		for (int n = 0; n < N; n++) {
			String[] s = br.readLine().split(" ");
			arr[n][0] = Integer.parseInt(s[0]);
			arr[n][1] = Integer.parseInt(s[1]);
		}
		
		for (int i = N - 1; i >= 0; i--) {
			if (i + arr[i][0] > N) { // 날짜가 넘어가면 
				calander[i] = calander[i + 1];
				continue;
			}
			calander[i] = Math.max(calander[i + 1], calander[i + arr[i][0]] + arr[i][1]);
		}
		
		System.out.println(calander[0]);
	}

}
