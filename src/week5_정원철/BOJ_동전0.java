package week5_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_동전0 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st[]=br.readLine().split(" ");
		int N=Integer.parseInt(st[0]);
		int K=Integer.parseInt(st[1]);
		
		int[]coin=new int[N];
		
		for (int i=0; i<N;i++) {
			int elem=Integer.parseInt(br.readLine());
			coin[N-i-1]=elem;
		}
		
		int coinFinder=0;
		int bill=0;
		// 4200
		// [50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1]
		while (K!=0){
			if(K/coin[coinFinder]<1) {
				coinFinder+=1;
				continue;
			}
			else if(K/coin[coinFinder]>=1) {
				if(K%coin[coinFinder]==0) {
					bill+=(K/coin[coinFinder]);
					K=K%coin[coinFinder];
					break;
				}
			}
			
			bill+=(int)(K/coin[coinFinder]);
			K=K%coin[coinFinder];
			coinFinder+=1;
			
		}
		
		System.out.println(bill);
	}
	
	
	
}
