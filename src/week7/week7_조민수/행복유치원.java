package week7.week7_조민수;
	import java.io.*;
	import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class 행복유치원 {
	 
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String []st=br.readLine().split(" ");
			int N=Integer.parseInt(st[0]);
			int K=Integer.parseInt(st[1]);
			int []diff=new int[N];//각 n값끼리의 차이를 저장
			int result=0;
			st=br.readLine().split(" ");
			
			for(int i=1;i<N;i++) {
				diff[i]=Integer.parseInt(st[i])-Integer.parseInt(st[i-1]);
			}
			Arrays.sort(diff);
			for(int i=0;i<=N-K;i++) {
				result+=diff[i];
			}
			System.out.println(result);
		}
	 
}
