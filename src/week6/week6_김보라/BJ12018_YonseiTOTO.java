package week6_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ12018_YonseiTOTO {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int subject[]=new int[N];
		for(int i = 0; i<N; i++) {
			s=br.readLine().split(" ");
			int P=Integer.parseInt(s[0]);
			int L = Integer.parseInt(s[1]);
			
			String st[] = br.readLine().split(" ");
			
			Integer person[] = new Integer[P];
			for(int j = 0; j<P; j++) {
				person[j]=Integer.parseInt(st[j]);
			}
			if(P<L) {
				subject[i]=1;
			}else {
				Arrays.sort(person,Comparator.reverseOrder());
				subject[i]=person[L-1];
			}
		}
		
		Arrays.sort(subject);
		int answer = 0;
		int sum = 0;
		for(int i = 0; i<N; i++) {
			if(sum+subject[i]>M) {
				break;
			}else {
				sum+=subject[i];
				answer++;
			}
		}
		System.out.println(answer);
		
	}

}
