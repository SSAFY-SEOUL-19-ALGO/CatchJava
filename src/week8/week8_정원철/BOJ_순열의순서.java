package week8.week8_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_순열의순서 {
	static boolean []chk;
	static long point,result;
	static int N, select;
	static long [] fact;
	static int arr[];
	
	// K번째수열
	static void perm1(long point) {
		arr = new int[N];
		for(int i=0 ; i<N ; i++) {
			for(int j=1; j<=N; j++) {
				if(chk[j] == true) continue;
				if(fact[N-i-1] < point) {
					point -= fact[N-i-1];
				}else {
					arr[i] = j;
					chk[j] = true;
					break;
				}
			}
		}
		for(int i=0; i<N; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//몇번째 수열
	static void perm2(int arr[]){
		result = 0;
		for(int i=0; i<N; i++) {
			for(int j=1; j<arr[i]; j++) {
				if(chk[j] == false) {
					result += fact[N-i-1];
				}
			}
			chk[arr[i]] = true;
		}
		System.out.println(result+1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String st[]=br.readLine().split(" ");
		select = Integer.parseInt(st[0]);
		
		fact = new long[N+1];
		chk = new boolean[N+1];
		
		fact[0] = 1;
		for(int i=1; i<=N; i++) fact[i] = fact[i-1]*i;
		
		
		if(select == 1) {
		point = Integer.parseInt(st[1]);
		perm1(point);
		}else{
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st[i+1]);
		perm2(arr);
		}
	}

}
