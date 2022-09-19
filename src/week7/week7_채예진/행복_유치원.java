package week7.week7_채예진;

import java.util.Arrays;
import java.util.Scanner;

// a[y] - a[x] = a[y] - a[y - 1] + a[y - 1] - a[y - 2] + a[y - 2] + ... - a[x + 1] + a[x + 1] - a[x]
public class 행복_유치원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] diff = new int[N - 1];
		
		int before = sc.nextInt();
		for (int n = 0; n < N - 1; n++) {
			int after = sc.nextInt();
			diff[n] = after - before;
			before = after;
		}
		
		Arrays.sort(diff); // 차이 정렬 
		
		int result = 0;
		
		// (N - 1) - (K - 1)
		for (int i = 0; i < N - K; i++) {
			result += diff[i];
		}
		
		System.out.println(result);
	}

}
