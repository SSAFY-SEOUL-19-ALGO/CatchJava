package week7_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ13164_행복유치원 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s= br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		String[] st = br.readLine().split(" ");
		
		int[] d = new int[N-1];
		for(int i = 0; i<N-1; i++) {
			d[i]=Integer.parseInt(st[i+1])-Integer.parseInt(st[i]);
		}
		Arrays.sort(d);
		
		int answer = 0;
		for(int i = 0; i<N-K; i++) {
			answer+=d[i];
		}
		System.out.println(answer);
		
	}
	/*시간초과
	static int N;
	static int K;
	static int[] per;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		per = new int[N];

		String[] st = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			per[i] = Integer.parseInt(st[i]);
		}
		int tmp[] = new int[K+1];
		tmp[0]=0;
		tmp[K]=N;
		c(1,1,tmp);
		System.out.println(answer);

	}
	static int answer = Integer.MAX_VALUE;
	static void c(int cnt, int start, int[] num) {
		if(cnt==K) {
			int sum = 0;
			for(int i = 0; i<K; i++) {
				sum+=per[num[i+1]-1]-per[num[i]];
			}
			if(sum<answer) {
				answer=sum;;
			}
			return;
		}
		
		for(int i = start; i<N; i++) {
				num[cnt]=i;
				c(cnt+1,i+1, num);
		}
	}
	*/
}
