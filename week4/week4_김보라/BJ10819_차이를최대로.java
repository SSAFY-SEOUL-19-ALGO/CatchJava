package week4_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10819_차이를최대로 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		String s[] = br.readLine().split(" ");
		
		for(int i = 0; i<N; i++) {
			num[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(num);
		perm(num,N,new boolean[N],0,new int[N]);
		
		System.out.println(max);
		
		
	}
	static int max = 0;
	static void perm(int[] num, int N, boolean[] visited, int cnt,int[]answer) {
		if(cnt==N) {
			int tmp = 0;
			for(int i = 1; i<N; i++) {
				tmp+=Math.abs(answer[i-1]-answer[i]);
			}
			
			max=Math.max(tmp, max);
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				answer[cnt]=num[i];
				visited[i]=true;
				perm(num, N, visited, cnt+1,answer);
				visited[i]=false;
			}
		}
	}
}
