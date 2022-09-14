package week6.week6_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ20115_에너지드링크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer arr[] = new Integer[N];
		String s[] = br.readLine().split(" ");
		for(int i = 0; i<N; i++) {
			arr[i]=Integer.parseInt(s[i]);
		}
		
		Arrays.sort(arr,Comparator.reverseOrder());
		double answer=0.0;
		
		answer+=arr[0];
		for(int i = 1; i<N; i++) {
			answer+=(double)arr[i]/2;
		}
		
		System.out.println(answer);
		
	}

}
