package week5_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11047_동전0 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int check = 0;
		
		int[] coin = new int[N];
		for(int i = 0; i<N; i++) {
			coin[i]=Integer.parseInt(br.readLine());
			if(K/coin[i]!=0) {
				check=i;
			}
		}
		int need = 0;
		for(; check>=0; check--) {
			need+=K/coin[check];
			K%=coin[check];
			if(K==0)
				break;
		}
		
		System.out.println(need);
		
		
	}

}
